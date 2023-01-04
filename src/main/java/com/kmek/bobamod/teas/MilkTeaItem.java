package com.kmek.bobamod.teas;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import org.jetbrains.annotations.NotNull;

public class MilkTeaItem extends Item {
    public MilkTeaItem(int nutrition, float saturation) {
        super(new Item.Properties().food(
                new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .build()));
    }

    // todo future idea: cure all harmful potions the same way milk does

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack p_42931_) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
}
