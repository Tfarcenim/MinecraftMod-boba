package com.kmek.minecafe.block.entity;

import com.kmek.minecafe.item.ModItemsInit;
import com.kmek.minecafe.screen.EspressoMachineMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class EspressoMachineBlockEntity extends CustomBaseBlockEntity {

    public static final int SLOT_WATER = 0;
    public static final int SLOT_GROUNDS = 1;
    public static final int SLOT_MILK = 2;
    public static final int SLOT_OUTPUT = 3;

    private int progress = 0;
    public static final int maxProgress = 400;

    public EspressoMachineBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(pPos, pBlockState, ModBlockEntities.ESPRESSO_MACHINE.get(), 4, 1, "Espresso Machine");
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                if (pIndex == 0) {
                    return progress;
                } else {
                    return 0;
                }
            }

            @Override
            public void set(int pIndex, int pValue) {
                if (pIndex == 0) {
                    progress = pValue;
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
        return new EspressoMachineMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    /**
     * Tick progress stuff
     */

    public static void tick(Level level, BlockPos blockPos, BlockState blockState, EspressoMachineBlockEntity entity) {
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
        } else if (entity.progress <= maxProgress && isHeating(inventory)) {
            entity.progress++;
            heat(entity);
            setChanged(level, blockPos, blockState);
        } else {
            entity.resetProgress();
            setChanged(level, blockPos, blockState);
        }
    }

    private static boolean isHeating(SimpleContainer inventory) {
        ItemStack waterStack = inventory.getItem(SLOT_WATER);
        return waterStack.getCount() == 1
                && waterStack.getItem() == Items.WATER_BUCKET
                && (inventory.getItem(SLOT_GROUNDS).getCount() >= 1
                    || inventory.getItem(SLOT_MILK).getCount() >= 1);
    }

    private static void heat(EspressoMachineBlockEntity entity) {
        if (entity.progress == maxProgress) {
            if (entity.itemHandler.getStackInSlot(SLOT_GROUNDS).getItem() == ModItemsInit.COFFEE_GROUNDS.get()
                && insertedOutputItem(entity, ModItemsInit.ESPRESSO_SHOT.get())) {
                entity.itemHandler.extractItem(SLOT_GROUNDS, 1, false);
            } else if (entity.itemHandler.getStackInSlot(SLOT_MILK).getItem() == Items.MILK_BUCKET
                    && insertedOutputItem(entity, ModItemsInit.STEAMED_MILK.get())) {
                entity.itemHandler.setStackInSlot(SLOT_MILK, new ItemStack(Items.BUCKET));
            } else if (entity.itemHandler.getStackInSlot(SLOT_MILK).getItem() == ModItemsInit.STEAMED_MILK.get()
                    && insertedOutputItem(entity, ModItemsInit.MILK_FOAM.get())) {
                entity.itemHandler.extractItem(SLOT_MILK, 1, false);
            }
            entity.itemHandler.setStackInSlot(SLOT_WATER, new ItemStack(Items.BUCKET));
        }
    }

    private static boolean insertedOutputItem(EspressoMachineBlockEntity entity, Item item) {
        ItemStack toInsert = new ItemStack(item, 1);
        ItemStack currentStack = entity.itemHandler.getStackInSlot(SLOT_OUTPUT);
        if (currentStack.isEmpty() || (currentStack.getItem() == item && currentStack.getCount() < item.getMaxStackSize(toInsert))) {
            entity.itemHandler.insertItem(SLOT_OUTPUT, toInsert, false);
            return true;
        }
        return false;
    }

    private void resetProgress() {
        this.progress = 0;
    }
}
