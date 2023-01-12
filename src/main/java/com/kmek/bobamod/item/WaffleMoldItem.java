package com.kmek.bobamod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WaffleMoldItem extends Item {
    private final Item waffle;

    public WaffleMoldItem(Item waffle) {
        super(new Item.Properties().stacksTo(1));
        this.waffle = waffle;
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        return itemStack.getCount() == 1 ? itemStack.copy() : itemStack.copyWithCount(1);
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }

    public Item getWaffle() {
        return waffle;
    }
}
