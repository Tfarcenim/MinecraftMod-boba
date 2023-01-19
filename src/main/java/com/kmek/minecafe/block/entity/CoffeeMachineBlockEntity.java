package com.kmek.minecafe.block.entity;

import com.kmek.minecafe.item.ModItemsInit;
import com.kmek.minecafe.networking.ModMessages;
import com.kmek.minecafe.networking.packet.ItemStackSyncS2CPacket;
import com.kmek.minecafe.screen.CoffeeMachineMenu;
import com.kmek.minecafe.tags.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CoffeeMachineBlockEntity  extends BlockEntity implements MenuProvider {
    public static final int menuSlotCount = 4;
    public static final int dataFieldsCount = 2;

    private static final int SLOT_WATER = 0;
    private static final int SLOT_GROUNDS = 1;
    private static final int SLOT_FILTER = 2;
    private static final int SLOT_OUTPUT = 3;

    private final ItemStackHandler itemHandler = new ItemStackHandler(menuSlotCount) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide) {
                ModMessages.sendToClients(new ItemStackSyncS2CPacket(this, worldPosition));
            }
        }
    };

    // Update block entity render on world load
    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;

    private int progress = 0;
    public static final int waterTime = 400;
    public static final int brewTime = 500;
//    private int fuelLeft = 0;
//    public static final int maxFuel = 420;

    public CoffeeMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.COFFEE_MACHINE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> CoffeeMachineBlockEntity.this.progress;
//                    case 1 -> CoffeeMachineBlockEntity.this.fuelLeft;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex) {
                    case 0 -> CoffeeMachineBlockEntity.this.progress = pValue;
//                    case 1 -> CoffeeMachineBlockEntity.this.fuelLeft = pValue;
                }
            }

            @Override
            public int getCount() {
                return 1; //2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Coffee Machine");
    }

    // For block entity rendering
    public ItemStackHandler getRenderStack() {
        return itemHandler;
    }
    public void setHandler(ItemStackHandler itemStackHandler) {
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, itemStackHandler.getStackInSlot(i));
        }
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CoffeeMachineMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
    }

    // Spills the inventory of the block
    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    /**
     * Tick progress stuff
     */

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, CoffeeMachineBlockEntity entity) {
        if (level.isClientSide) {
            return;
        }

        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        if (entity.progress == 0) {
            if (isHeating(inventory)) {
                entity.progress++;
                setChanged(level, blockPos, blockState);
            }
        } else if (entity.progress <= waterTime && isHeating(inventory)) {
            entity.progress++;
            heat(entity);
            setChanged(level, blockPos, blockState);
        } else if (isBrewing(inventory)) {
            entity.progress++;
            brew(entity);
            setChanged(level, blockPos, blockState);
        } else {
            entity.resetProgress();
            setChanged(level, blockPos, blockState);
        }
    }

    private static boolean isHeating(SimpleContainer inventory) {
        ItemStack waterStack = inventory.getItem(SLOT_WATER);
        return waterStack.getCount() == 1
                && waterStack.getItem() == Items.WATER_BUCKET;
    }

    private static void heat(CoffeeMachineBlockEntity entity) {
        if (entity.progress == waterTime) {
            entity.itemHandler.setStackInSlot(SLOT_WATER, new ItemStack(Items.BUCKET));
        }
    }

    private static boolean isBrewing(SimpleContainer inventory) {
        ItemStack groundsStack = inventory.getItem(SLOT_GROUNDS);
        ItemStack filterStack = inventory.getItem(SLOT_FILTER);
        ItemStack outputStack = inventory.getItem(SLOT_OUTPUT);
        return groundsStack.getCount() == 1
                && groundsStack.is(ModTags.Items.COFFEE_GROUNDS)
                && filterStack.getCount() == 1
                && filterStack.getItem() == ModItemsInit.COFFEE_FILTER.get()
                && outputStack.getCount() == 1
                && outputStack.getItem() == ModItemsInit.COFFEE_POT.get();
    }

    private static void brew(CoffeeMachineBlockEntity entity) {
        if (entity.progress == waterTime + brewTime) {
            ItemStack grounds = entity.itemHandler.extractItem(SLOT_GROUNDS, 1, false);
            entity.itemHandler.setStackInSlot(SLOT_FILTER, new ItemStack(ModItemsInit.COFFEE_FILTER_USED.get()));
            ItemStack coffee = new ItemStack(ModItemsInit.COFFEE_POT_LIGHT.get()); // todo fix for all 3 types
            entity.itemHandler.setStackInSlot(SLOT_OUTPUT, coffee);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
