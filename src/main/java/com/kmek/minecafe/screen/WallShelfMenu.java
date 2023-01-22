package com.kmek.minecafe.screen;

import com.kmek.minecafe.block.ModBlocksInit;
import com.kmek.minecafe.block.entity.WallShelfBlockEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.IItemHandler;

public class WallShelfMenu extends CustomBaseMenu {
    public WallShelfMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
        this(id, inv, inv.player.level.getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(/*WallShelfBlockEntity.dataFieldsCount*/0));
    }

    public WallShelfMenu(int id, Inventory inv, BlockEntity entity, ContainerData data) {
        super(id, inv, (WallShelfBlockEntity) entity, data, ModBlocksInit.OAK_WALL_SHELF.get(), ModMenuTypes.WALL_SHELF_MENU.get());
    }

    @Override
    protected void addSlots(IItemHandler handler) {
        add8Slots(handler, 0, 17, 17);
        add8Slots(handler, 8, 17, 35);
        add8Slots(handler, 16, 17, 53);
    }
}
