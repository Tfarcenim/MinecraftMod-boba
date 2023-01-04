package com.kmek.bobamod.food;

import com.kmek.bobamod.init.ItemInit;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MilkTeaItem extends Item {
    public MilkTeaItem(int nutrition, float saturation) {
        super(new Item.Properties().food(
                new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .build()));
    }

    // Eat item and then return cup
    @Override
    public ItemStack finishUsingItem(ItemStack p_42923_, Level p_42924_, LivingEntity p_42925_) {
        if (p_42925_ instanceof Player player) {
            player.addItem(new ItemStack(ItemInit.MILK_TEA_CUP.get()));
        }

        return p_42925_.eat(p_42924_, p_42923_);
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
