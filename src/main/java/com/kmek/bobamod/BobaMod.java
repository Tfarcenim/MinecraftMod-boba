package com.kmek.bobamod;

import com.kmek.bobamod.block.ModBlocksInit;
import com.kmek.bobamod.item.ModItemInit;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BobaMod.MODID)
public class BobaMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "bobamod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    CreativeModeTab bobaTab;

    public BobaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItemInit.register(modEventBus);
        ModBlocksInit.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        modEventBus.addListener(this::registerTabs);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // todo bug: this tab has no title
    private void registerTabs(CreativeModeTabEvent.Register event) {
         bobaTab = event.registerCreativeModeTab(new ResourceLocation(MODID, "bobamod"), builder -> builder
                .icon(() -> new ItemStack(ModItemInit.BROWN_SUGAR_MILK_TEA.get()))
                .displayItems((featureFlags, output, hasOp) -> {
                    output.accept(ModItemInit.CASSAVA_CUTTING.get());
                    output.accept(ModItemInit.CASSAVA.get());
                    output.accept(ModItemInit.TAPIOCA_BALLS.get());
                    output.accept(ModItemInit.MILK_TEA_CUP.get());
                    output.accept(ModItemInit.BROWN_SUGAR_MILK_TEA.get());
                    output.accept(ModItemInit.TIGER_MILK_TEA.get());
                    output.accept(ModItemInit.HONEY_MILK_TEA.get());
                    output.accept(ModItemInit.CHOCOLATE_MILK_TEA.get());
                    output.accept(ModItemInit.VANILLA_MILK_TEA.get());
                    output.accept(ModItemInit.EGG_CUSTARD_MILK_TEA.get());
                    output.accept(ModItemInit.COOKIE_MILK_TEA.get());
                    output.accept(ModItemInit.CAKE_MILK_TEA.get());
                    output.accept(ModItemInit.PUMPKIN_SPICE_MILK_TEA.get());
                    output.accept(ModItemInit.APPLE_MILK_TEA.get());
                    output.accept(ModItemInit.SWEET_BERRY_MILK_TEA.get());
                    output.accept(ModItemInit.WATERMELON_MILK_TEA.get());
                    output.accept(ModItemInit.GLOW_BERRY_MILK_TEA.get());
                    output.accept(ModItemInit.CHORUS_FRUIT_MILK_TEA.get());
                    output.accept(ModItemInit.ROSE_MILK_TEA.get());
                    output.accept(ModItemInit.BUTTERFLY_PEA_FLOWER_MILK_TEA.get());
                    output.accept(ModItemInit.MATCHA_MILK_TEA.get());
                    output.accept(ModItemInit.LAVENDER_MILK_TEA.get());
                    output.accept(ModItemInit.THAI_MILK_TEA.get());
                    output.accept(ModItemInit.BEETROOT_MILK_TEA.get());
                    output.accept(ModItemInit.CARROT_MILK_TEA.get());
                    output.accept(ModItemInit.KELP_MILK_TEA.get());
                    output.accept(ModItemInit.TAIYAKI_MOLD.get());
                    output.accept(ModItemInit.TAIYAKI.get());
                })
        );
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItemInit.BROWN_SUGAR_MILK_TEA);
            event.accept(ModItemInit.TIGER_MILK_TEA);
            event.accept(ModItemInit.HONEY_MILK_TEA);
            event.accept(ModItemInit.CHOCOLATE_MILK_TEA);
            event.accept(ModItemInit.VANILLA_MILK_TEA);
            event.accept(ModItemInit.EGG_CUSTARD_MILK_TEA);
            event.accept(ModItemInit.COOKIE_MILK_TEA);
            event.accept(ModItemInit.CAKE_MILK_TEA);
            event.accept(ModItemInit.PUMPKIN_SPICE_MILK_TEA);
            event.accept(ModItemInit.APPLE_MILK_TEA);
            event.accept(ModItemInit.SWEET_BERRY_MILK_TEA);
            event.accept(ModItemInit.WATERMELON_MILK_TEA);
            event.accept(ModItemInit.GLOW_BERRY_MILK_TEA);
            event.accept(ModItemInit.CHORUS_FRUIT_MILK_TEA);
            event.accept(ModItemInit.ROSE_MILK_TEA);
            event.accept(ModItemInit.BUTTERFLY_PEA_FLOWER_MILK_TEA);
            event.accept(ModItemInit.MATCHA_MILK_TEA);
            event.accept(ModItemInit.LAVENDER_MILK_TEA);
            event.accept(ModItemInit.THAI_MILK_TEA);
            event.accept(ModItemInit.BEETROOT_MILK_TEA);
            event.accept(ModItemInit.CARROT_MILK_TEA);
            event.accept(ModItemInit.KELP_MILK_TEA);
            event.accept(ModItemInit.TAIYAKI);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
            ItemBlockRenderTypes.setRenderLayer(ModBlocksInit.CASSAVA_CROP.get(), RenderType.cutout());
        }
    }
}
