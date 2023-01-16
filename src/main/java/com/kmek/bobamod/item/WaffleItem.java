package com.kmek.bobamod.item;

import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class WaffleItem extends Item {
    public WaffleItem(Properties pProperties) {
        super(pProperties);
    }

    WaffleItem(int nut, float sat) {
        super(new Item.Properties().food(new FoodProperties.Builder().nutrition(nut).saturationMod(sat).build()));
    }

    // Erases tag
    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if(pPlayer.getItemInHand(pUsedHand).hasTag()) {
            pPlayer.getItemInHand(pUsedHand).setTag(new CompoundTag());
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    // Don't stack tagged waffle items
    @Override
    public int getMaxStackSize(ItemStack stack) {
        return stack.hasTag() ? 1 : 64;
    }

    // Add tag
    public ItemStack addNbtDataFillingToItemStack(String filling) {
        ItemStack stack = new ItemStack(this, 1);
        CompoundTag nbtData = new CompoundTag();
        nbtData.putString("bobamod.filling", filling);
        stack.setTag(nbtData);
        return stack;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if (stack.hasTag()) {
            // Read tag data
            String filling = stack.getTag().getString("bobamod.filling");
            components.add(Component.literal(filling).withStyle(ChatFormatting.GRAY));
        }
        super.appendHoverText(stack, level, components, flag);
    }

//    // Enchantment glitter
//    @Override
//    public boolean isFoil(ItemStack pStack) {
//        return pStack.hasTag();
//    }
}
