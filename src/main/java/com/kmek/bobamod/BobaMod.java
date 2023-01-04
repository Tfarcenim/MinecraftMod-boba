package com.kmek.bobamod;

import com.kmek.bobamod.init.ItemInit;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
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
    private static final Logger LOGGER = LogUtils.getLogger();

    CreativeModeTab bobaTab;

    public BobaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemInit.ITEMS.register(modEventBus);

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
                .icon(() -> new ItemStack(ItemInit.BROWN_SUGAR_MILK_TEA.get()))
                .displayItems((featureFlags, output, hasOp) -> {
                    output.accept(ItemInit.TAPIOCA_BALLS.get());
                    output.accept(ItemInit.MILK_TEA_CUP.get());
                    output.accept(ItemInit.BROWN_SUGAR_MILK_TEA.get());
                    output.accept(ItemInit.HONEY_MILK_TEA.get());
                    output.accept(ItemInit.CHOCOLATE_MILK_TEA.get());
                    output.accept(ItemInit.VANILLA_MILK_TEA.get());
                    output.accept(ItemInit.PUMPKIN_SPICE_MILK_TEA.get());
                    output.accept(ItemInit.APPLE_MILK_TEA.get());
                    output.accept(ItemInit.WATERMELON_MILK_TEA.get());
                    output.accept(ItemInit.ROSE_MILK_TEA.get());
                })
        );
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ItemInit.BROWN_SUGAR_MILK_TEA);
            event.accept(ItemInit.HONEY_MILK_TEA);
            event.accept(ItemInit.CHOCOLATE_MILK_TEA);
            event.accept(ItemInit.VANILLA_MILK_TEA);
            event.accept(ItemInit.PUMPKIN_SPICE_MILK_TEA);
            event.accept(ItemInit.APPLE_MILK_TEA);
            event.accept(ItemInit.WATERMELON_MILK_TEA);
            event.accept(ItemInit.ROSE_MILK_TEA);
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
        }
    }
}
