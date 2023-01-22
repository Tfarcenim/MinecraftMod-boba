package com.kmek.minecafe.event;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.entity.ModBlockEntities;
import com.kmek.minecafe.block.entity.renderer.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = MineCafeMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(ModBlockEntities.WAFFLE_IRON.get(), WaffleIronBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.CAKE_STAND.get(), CakeStandBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.DISPLAY_CASE.get(), DisplayCaseBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.WALL_SHELF.get(), WallShelfBlockEntityRenderer::new);
            event.registerBlockEntityRenderer(ModBlockEntities.COFFEE_MACHINE.get(), CoffeeMachineBlockEntityRenderer::new);
        }
    }
}
