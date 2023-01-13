package com.kmek.bobamod.block.entity.renderer;

import com.kmek.bobamod.block.WaffleIronBlock;
import com.kmek.bobamod.block.entity.WaffleIronBlockEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class WaffleIronBlockEntityRenderer implements BlockEntityRenderer<WaffleIronBlockEntity> {
    public WaffleIronBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(WaffleIronBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStack itemStack = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();

        pPoseStack.translate(0.5f, 0.125f, 0.5f);
        pPoseStack.scale(0.65f, 0.65f, 0.65f);
        pPoseStack.mulPose(Axis.XP.rotationDegrees(-90.0F));
        switch(pBlockEntity.getBlockState().getValue(WaffleIronBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(180.f));
            case EAST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(90.0F));
            case SOUTH -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(0.0F));
            case WEST -> pPoseStack.mulPose(Axis.ZP.rotationDegrees(270.0F));
        }
        pPoseStack.translate(0.0f, -0.1f, 0.0f);

        // Bottom Item
        itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.GUI,
                getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);

//        // todo if open blockstate, render second mold
        pPoseStack.mulPose(Axis.XP.rotationDegrees(270.0F));
        pPoseStack.translate(0.0d, -0.67d, 0.59d);

        // Back Item
        itemRenderer.renderStatic(itemStack, ItemTransforms.TransformType.GUI,
                getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);

        pPoseStack.popPose();
    }

    private int getLightLevel(Level level, BlockPos blockPos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, blockPos);
        int sLight = level.getBrightness(LightLayer.SKY, blockPos);
        return LightTexture.pack(bLight, sLight);
    }
}
