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

public class MilkTeaItem extends Item {
    private Component tooltip = null;

    public MilkTeaItem(Item.Properties properties) {
        super(properties);
    }

    public MilkTeaItem(Item.Properties properties, Component tooltip) {
        super(properties);
        this.tooltip = tooltip;
    }

    public MilkTeaItem(int nutrition, float saturation) {
        super(new Item.Properties().food(
                new FoodProperties.Builder()
                        .nutrition(nutrition)
                        .saturationMod(saturation)
                        .build()));
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
//        if (Screen.hasShiftDown()) { // different tooltip on shift
//            components.add(Component.literal("shifted").withStyle(ChatFormatting.WHITE));
//            components.add(Component.literal("more info").withStyle(ChatFormatting.GREEN));
//        } else {
            if (tooltip != null) {
                components.add(tooltip);
            }
//        }

        super.appendHoverText(stack, level, components, flag);
    }

    // Eat item and then return cup
    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            player.addItem(new ItemStack(ModItemsInit.MILK_TEA_CUP.get()));
        }

        return livingEntity.eat(level, itemStack);
    }

    // todo future idea: cure all harmful potions the same way milk does

    @Override
    public @NotNull UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }
}
