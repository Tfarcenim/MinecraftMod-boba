package com.kmek.bobamod.event;

import com.kmek.bobamod.BobaMod;
import com.kmek.bobamod.block.entity.ModBlockEntities;
import com.kmek.bobamod.block.entity.renderer.CakeStandBlockEntityRenderer;
import com.kmek.bobamod.block.entity.renderer.DisplayCaseBlockEntityRenderer;
import com.kmek.bobamod.block.entity.renderer.WaffleIronBlockEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = BobaMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.WAFFLE_IRON.get(), WaffleIronBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.CAKE_STAND.get(), CakeStandBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.DISPLAY_CASE.get(), DisplayCaseBlockEntityRenderer::new);
        }
    }
}
