package com.kmek.minecafe.block.entity.renderer;

import com.kmek.minecafe.block.CakeStandBlock;
import com.kmek.minecafe.block.entity.CakeStandBlockEntity;
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

public class CakeStandBlockEntityRenderer implements BlockEntityRenderer<CakeStandBlockEntity> {
    public CakeStandBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(CakeStandBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStack itemStack = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();

        pPoseStack.translate(0.5f, 0.65f, 0.5f);
        pPoseStack.scale(0.7f, 0.7f, 0.7f);
        switch(pBlockEntity.getBlockState().getValue(CakeStandBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(180.f));
            case EAST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            case SOUTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
            case WEST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
        }

        // Bottom Item
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
