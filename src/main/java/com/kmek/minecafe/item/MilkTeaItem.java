package com.kmek.minecafe.item;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

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
