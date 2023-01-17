package com.kmek.minecafe.block.entity.renderer;

import com.kmek.minecafe.block.DisplayCaseBlock;
import com.kmek.minecafe.block.entity.DisplayCaseBlockEntity;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraftforge.items.ItemStackHandler;

public class DisplayCaseBlockEntityRenderer implements BlockEntityRenderer<DisplayCaseBlockEntity> {
    public DisplayCaseBlockEntityRenderer(BlockEntityRendererProvider.Context context) {

    }

    @Override
    public void render(DisplayCaseBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();

        ItemStackHandler items = pBlockEntity.getRenderStack();
        pPoseStack.pushPose();

        pPoseStack.translate(0.5f, 1.1f, 0.5f);
        pPoseStack.scale(0.2f, 0.2f, 0.2f);
        switch(pBlockEntity.getBlockState().getValue(DisplayCaseBlock.FACING)) {
            case NORTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(180.f));
            case EAST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(90.0F));
            case SOUTH -> pPoseStack.mulPose(Axis.YP.rotationDegrees(0.0F));
            case WEST -> pPoseStack.mulPose(Axis.YP.rotationDegrees(270.0F));
        }

        pPoseStack.translate(0f, 0f, -1f);

        // Render rows of 4
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 0);
        pPoseStack.translate(0.0f, -2.15f, 0f);
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 4);
        pPoseStack.translate(0.0f, -1.3f, 0.8f);
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 8);
        pPoseStack.translate(0.0f, -1.2f, 1.25f);
        renderRowOf4Slots(itemRenderer, pPoseStack, items, pBlockEntity, pBufferSource, 12);

        pPoseStack.popPose();
    }

    private void renderRowOf4Slots(ItemRenderer itemRenderer, PoseStack pPoseStack, ItemStackHandler items,
                                   DisplayCaseBlockEntity pBlockEntity, MultiBufferSource pBufferSource, int slotStart) {
        pPoseStack.translate(-1.5f, 0f, 0f);
        for (int i = 0; i < 4; i++) {
            itemRenderer.renderStatic(items.getStackInSlot(i + slotStart), ItemTransforms.TransformType.GUI,
                    getLightLevel(pBlockEntity.getLevel(), pBlockEntity.getBlockPos()),
                    OverlayTexture.NO_OVERLAY, pPoseStack, pBufferSource, 1);
                pPoseStack.translate(1.0f, 0f, 0f);
        }
        pPoseStack.translate(-2.5f, 0f, 0f);
    }

    private int getLightLevel(Level level, BlockPos blockPos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, blockPos);
        int sLight = level.getBrightness(LightLayer.SKY, blockPos);
        return LightTexture.pack(bLight, sLight);
    }
}
