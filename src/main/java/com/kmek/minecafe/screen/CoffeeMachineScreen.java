package com.kmek.minecafe.screen;

import com.kmek.minecafe.MineCafeMod;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class CoffeeMachineScreen extends AbstractContainerScreen<CoffeeMachineMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(MineCafeMod.MODID, "textures/gui/coffee_machine_gui.png");

    public CoffeeMachineScreen(CoffeeMachineMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight + 2);

        renderProgressArrow(pPoseStack, x, y);
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            int k = menu.getScaledProgressWater();
            blit(pPoseStack, x + 38, y + 35 + 14 - k, 177, 14 - k, 18, k + 1);

//            k = menu.getScaledProgressWater();
//            blit(pPoseStack, x + 58, y + 24, 187, 28, k, 13);

            k = menu.getScaledProgressFilter();
            blit(pPoseStack, x + 99, y + 25, 177, 17, 5, k);
        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
