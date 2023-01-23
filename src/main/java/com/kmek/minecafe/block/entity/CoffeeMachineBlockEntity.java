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

public class CoffeeMachineBlockEntity extends CustomBaseBlockEntity {
    private static final int SLOT_WATER = 0;
    private static final int SLOT_GROUNDS = 1;
    private static final int SLOT_FILTER = 2;
    private static final int SLOT_OUTPUT = 3;

    private int progress = 0;
    public static final int waterTime = 400;
    public static final int brewTime = 500;

    public CoffeeMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState, ModBlockEntities.COFFEE_MACHINE.get(), 4, 1, "Coffee Machine");
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                if (pIndex == 0) {
                    return CoffeeMachineBlockEntity.this.progress;
                } else {
                    return 0;
                }
            }

            @Override
            public void set(int pIndex, int pValue) {
                if (pIndex == 0) {
                    CoffeeMachineBlockEntity.this.progress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CoffeeMachineMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    // For block entity rendering
    @Override
    public ItemStack getRenderStack() {
        return itemHandler.getStackInSlot(SLOT_OUTPUT);
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
                && groundsStack.getItem() == ModItemsInit.COFFEE_GROUNDS.get()
                && filterStack.getCount() == 1
                && filterStack.getItem() == ModItemsInit.COFFEE_FILTER.get()
                && outputStack.getCount() == 1
                && outputStack.getItem() == ModItemsInit.COFFEE_POT.get();
    }

    private static void brew(CoffeeMachineBlockEntity entity) {
        if (entity.progress == waterTime + brewTime) {
            ItemStack grounds = entity.itemHandler.extractItem(SLOT_GROUNDS, 1, false);
            entity.itemHandler.setStackInSlot(SLOT_FILTER, new ItemStack(ModItemsInit.COFFEE_FILTER_USED.get()));
            ItemStack coffee = new ItemStack(ModItemsInit.COFFEE_POT_FULL.get());
            entity.itemHandler.setStackInSlot(SLOT_OUTPUT, coffee);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
