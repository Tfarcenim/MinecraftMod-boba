package com.kmek.minecafe.item.custom;

import com.kmek.minecafe.item.ModItemsInit;
import com.kmek.minecafe.item.custom.CustomDrinkItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

public class MilkTeaItem extends CustomDrinkItem {
    public MilkTeaItem(Item.Properties properties) {
        super(properties);
        this.toReturnAfterUse = ModItemsInit.CLEAR_CUP.get();
    }

    public MilkTeaItem(Item.Properties properties, Component tooltip) {
        super(properties, tooltip);
        this.toReturnAfterUse = ModItemsInit.CLEAR_CUP.get();
    }

    public MilkTeaItem(int nutrition, float saturation) {
        super(nutrition, saturation);
        this.toReturnAfterUse = ModItemsInit.CLEAR_CUP.get();
    }

    public MilkTeaItem(int nutrition, float saturation, Component tooltip) {
        super(nutrition, saturation, tooltip);
        this.toReturnAfterUse = ModItemsInit.CLEAR_CUP.get();
    }

    // todo future idea: cure all harmful potions the same way milk does
}
