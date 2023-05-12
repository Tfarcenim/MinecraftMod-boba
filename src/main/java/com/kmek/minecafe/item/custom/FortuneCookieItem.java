package com.kmek.minecafe.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FortuneCookieItem extends Item {
    public FortuneCookieItem() {
        super(new Item.Properties().food(
                new FoodProperties.Builder()
                        .nutrition(3)
                        .saturationMod(1.5F)
                        .build()));
    }

    private final List<String> fortunes = List.of("Fortune will find you in the mines",
            "Crops will receive fine rain in the coming days",
            "Fine diamonds are in your future",
            "Buried treasure lies under the beach sands",
            "Lock your doors, for a creeper might be in your future",
            "Travel due north for new biomes",
            "Travel due south for new biomes",
            "Travel due east for new biomes",
            "Travel due west for new biomes",
            "Seek out the tallest tree for a fresh apple"
    );

    private final List<ChatFormatting> colors = List.of(ChatFormatting.LIGHT_PURPLE,
            ChatFormatting.BLUE,
            ChatFormatting.DARK_PURPLE,
            ChatFormatting.GREEN,
            ChatFormatting.YELLOW
    );

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        if (livingEntity instanceof Player player) {
            ItemStack stack = new ItemStack(Items.PAPER);
            stack.setHoverName(Component
                    .literal(fortunes.get(level.random.nextInt(0, fortunes.size())))
                    .withStyle(colors.get(level.random.nextInt(0, colors.size()))));
            player.addItem(stack);
        }

        return livingEntity.eat(level, itemStack);
    }
}
