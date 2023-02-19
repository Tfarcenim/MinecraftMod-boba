package com.kmek.minecafe.item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;

public class MarshmallowStickItem extends Item {
    private final String tagKey = "minecafe.toastiness";
    private final int toastinessMax;
    private final Item nextStage;

    public MarshmallowStickItem(int toastTime, Item nextStage) {
        super(new Item.Properties().stacksTo(1)
                .food(new FoodProperties.Builder()
                        .nutrition(3)
                        .saturationMod(1.5f)
                        .build()));
        toastinessMax = toastTime;
        this.nextStage = nextStage;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide) {
            if (pLevel.nextSubTickCount() % 20 == 0) {
                if ((pIsSelected || pEntity instanceof Player && ((Player) pEntity).getOffhandItem() == pStack)) {
                    Player player = (Player) pEntity;
                    Entity camera = Minecraft.getInstance().getCameraEntity();
                    if (camera == null) return;

                    HitResult targetBlock = camera.pick(2.5D, 0.0F, false);
                    if (targetBlock.getType() == HitResult.Type.BLOCK) {
                        BlockPos blockpos = ((BlockHitResult) targetBlock).getBlockPos();
                        BlockState bState = pLevel.getBlockState(blockpos);
                        Block block = bState.getBlock();
                        if (block instanceof CampfireBlock && pStack.hasTag()) {
                            int toastiness = pStack.getTag().getInt(tagKey);
                            if (toastiness >= toastinessMax) {
                                player.getInventory().removeItem(pSlotId, 1);
                                player.getInventory().add(pSlotId, new ItemStack(nextStage));
                            } else {
                                setToastinessTag(pStack, toastiness + 1);
                            }
                        } else {
                            setToastinessTag(pStack, 0);
                        }
                    }
                } else {
                    setToastinessTag(pStack, 0);
                }
            }
        }
    }

    private void setToastinessTag(ItemStack pStack, int toastiness) {
        CompoundTag tag = new CompoundTag();
        tag.putInt(tagKey, toastiness);
        pStack.setTag(tag);
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        setToastinessTag(stack, 0);
        return stack;
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }
}
