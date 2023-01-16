package com.kmek.bobamod.block.entity;

import com.kmek.bobamod.networking.ModMessages;
import com.kmek.bobamod.networking.packet.ItemStackSyncS2CPacket;
import com.kmek.bobamod.screen.CakeStandMenu;
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
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CakeStandBlockEntity extends BlockEntity implements MenuProvider {
    public static final int menuSlotCount = 1;
    public static final int dataFieldsCount = 2;

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

    public CakeStandBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CAKE_STAND.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
//                    case 0 -> WaffleIronBlockEntity.this.progress;
//                    case 1 -> WaffleIronBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex) {
//                    case 0 -> WaffleIronBlockEntity.this.progress = pValue;
//                    case 1 -> WaffleIronBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
//                return 2;
                return 0;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Cake Stand");
    }

    // For block entity rendering
    public ItemStack getRenderStack() {
        return itemHandler.getStackInSlot(0);
    }
    public void setHandler(ItemStackHandler itemStackHandler) {
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            itemHandler.setStackInSlot(i, itemStackHandler.getStackInSlot(i));
        }
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CakeStandMenu(pContainerId, pPlayerInventory, this, this.data);
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
}
