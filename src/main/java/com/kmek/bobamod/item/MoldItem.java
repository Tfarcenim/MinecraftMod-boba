package com.kmek.bobamod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class MoldItem extends Item {
    public MoldItem() {
        super(new Item.Properties());
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack.getCount() == 1 ? itemStack.copy() : itemStack.copyWithCount(1);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
}
