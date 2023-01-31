package com.kmek.minecafe.item;

import com.kmek.minecafe.MineCafeMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModCreativeTabInit {
    public static CreativeModeTab bobaTab;

    /**
     * Registering the event bus
     */
    public void register(IEventBus modEventBus) {
        modEventBus.addListener(this::registerCustomCreativeTab);
    }

    private void registerCustomCreativeTab(CreativeModeTabEvent.Register event) {
        bobaTab = event.registerCreativeModeTab(new ResourceLocation(MineCafeMod.MODID, "minecafe"), builder -> builder
            .title(Component.translatable("itemGroup.minecafe"))
            .icon(() -> new ItemStack(ModItemsInit.BROWN_SUGAR_MILK_TEA.get()))
            .displayItems((featureFlags, output, hasOp) -> {
                // Blocks
                acceptBlocks(output);

                // Gardening / Some Ingredients
                acceptCropsAndSeeds(output);

                // Ingredients
                acceptJams(output);
                acceptCreams(output);
                acceptCoffeeIngredients(output);
                acceptMiscIngredients(output);

                // Dishes
                acceptDishes(output);

                // Specialty Foods
                acceptWaffles(output);
                acceptMiscFoodItems(output);

                // Specialty Drinks
                acceptCoffeeDrinks(output);
                acceptMilkTeaDrinks(output);
            })
        );
    }

    private void acceptBlocks(CreativeModeTab.Output output) {
        // Decorative blocks
        output.accept(ModItemsInit.CAKE_STAND_ITEM.get());
        output.accept(ModItemsInit.VASE_ITEM.get());
        output.accept(ModItemsInit.DISPLAY_CASE_CURVED_ITEM.get());
        output.accept(ModItemsInit.CASH_REGISTER_ITEM.get());
        // Wall Shelves
        output.accept(ModItemsInit.OAK_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.SPRUCE_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.BIRCH_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.JUNGLE_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.ACACIA_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.DARK_OAK_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.MANGROVE_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.CRIMSON_WALL_SHELF_ITEM.get());
        output.accept(ModItemsInit.WARPED_WALL_SHELF_ITEM.get());

        // Crafting bench blocks
        output.accept(ModItemsInit.WAFFLE_IRON_ITEM.get());
        output.accept(ModItemsInit.COFFEE_MACHINE_ITEM.get());
        output.accept(ModItemsInit.ESPRESSO_MACHINE_ITEM.get());

        // Fun Blocks
        output.accept(ModItemsInit.COFFEE_BUCKET.get());
    }

    private void acceptCropsAndSeeds(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.CROP_INSPECTOR_ITEM.get());

        acceptFlowerSeeds(output);

        // Seeds
        output.accept(ModItemsInit.CASSAVA_CUTTING.get());
        output.accept(ModItemsInit.COFFEE_BEANS_UNROASTED.get());
        output.accept(ModItemsInit.APPLE_SEEDS.get());
        output.accept(ModItemsInit.ORANGE_SEEDS.get());
        output.accept(ModItemsInit.LEMON_SEEDS.get());
        output.accept(ModItemsInit.LIME_SEEDS.get());
        output.accept(ModItemsInit.AVOCADO_SEEDS.get());
        output.accept(ModItemsInit.LYCHEE_SEEDS.get());
        output.accept(ModItemsInit.BANANA_SEEDS.get());
        output.accept(ModItemsInit.MANGO_SEEDS.get());
        output.accept(ModItemsInit.CHERRY_SEEDS.get());
        output.accept(ModItemsInit.PEACH_SEEDS.get());
        output.accept(ModItemsInit.PEAR_SEEDS.get());
        output.accept(ModItemsInit.PLUM_SEEDS.get());
        output.accept(ModItemsInit.FIG_SEEDS.get());

        // Fruit
        output.accept(ModItemsInit.CASSAVA.get());
        output.accept(ModItemsInit.COFFEE_CHERRIES.get());
        output.accept(ModItemsInit.ORANGE.get());
        output.accept(ModItemsInit.LEMON.get());
        output.accept(ModItemsInit.LIME.get());
        output.accept(ModItemsInit.AVOCADO.get());
        output.accept(ModItemsInit.LYCHEE.get());
        output.accept(ModItemsInit.BANANA.get());
        output.accept(ModItemsInit.MANGO.get());
        output.accept(ModItemsInit.CHERRY.get());
        output.accept(ModItemsInit.PEACH.get());
        output.accept(ModItemsInit.PEAR.get());
        output.accept(ModItemsInit.PLUM.get());
        output.accept(ModItemsInit.FIG.get());
    }
    private void acceptFlowerSeeds(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.DANDELION_SEEDS.get());
        output.accept(ModItemsInit.POPPY_SEEDS.get());
        output.accept(ModItemsInit.BLUE_ORCHID_SEEDS.get());
        output.accept(ModItemsInit.ALLIUM_SEEDS.get());
        output.accept(ModItemsInit.AZURE_BLUET_SEEDS.get());
        output.accept(ModItemsInit.RED_TULIP_SEEDS.get());
        output.accept(ModItemsInit.ORANGE_TULIP_SEEDS.get());
        output.accept(ModItemsInit.WHITE_TULIP_SEEDS.get());
        output.accept(ModItemsInit.PINK_TULIP_SEEDS.get());
        output.accept(ModItemsInit.OXEYE_DAISY_SEEDS.get());
        output.accept(ModItemsInit.CORNFLOWER_SEEDS.get());
        output.accept(ModItemsInit.LILY_OF_THE_VALLEY_SEEDS.get());
    }

    private void acceptJams(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.APPLE_JAM.get());
        output.accept(ModItemsInit.CHORUS_FRUIT_JAM.get());
        output.accept(ModItemsInit.GLOW_BERRY_JAM.get());
        output.accept(ModItemsInit.SWEET_BERRY_JAM.get());
        output.accept(ModItemsInit.WATERMELON_JAM.get());
    }

    private void acceptCreams(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.CREAM.get());
        output.accept(ModItemsInit.WHIPPED_CREAM.get());
        output.accept(ModItemsInit.CHOCOLATE_CREAM.get());
        output.accept(ModItemsInit.VANILLA_CREAM.get());
        output.accept(ModItemsInit.COFFEE_CREAM.get());
        output.accept(ModItemsInit.MATCHA_CREAM.get());
        output.accept(ModItemsInit.HONEY_CREAM.get());
        output.accept(ModItemsInit.ROSE_CREAM.get());

        output.accept(ModItemsInit.MARSHMALLOW.get());
        output.accept(ModItemsInit.MARSHMALLOWS.get());

        output.accept(ModItemsInit.CUSTARD.get());

        output.accept(ModItemsInit.BUTTER.get());

        output.accept(ModItemsInit.CHOCOLATE.get());
    }

    private void acceptMiscIngredients(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.BOBA_PEARLS.get());
        output.accept(ModItemsInit.MATCHA_POWDER.get());
        output.accept(ModItemsInit.RAW_WAFFLE_BATTER.get());
        output.accept(ModItemsInit.BATTER_MESS.get());
        output.accept(ModItemsInit.BURNT_CRISP.get());
    }

    private void acceptDishes(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.COFFEE_POT.get());
        output.accept(ModItemsInit.MUG.get());
        output.accept(ModItemsInit.CLEAR_CUP.get());
        // output.accept(ModItemsInit.PAPER_CUP.get());
        // output.accept(ModItemsInit.PASTRY_BAG.get());
        output.accept(ModItemsInit.TAIYAKI_MOLD.get());
        output.accept(ModItemsInit.EGG_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.PAW_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.HEART_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.CLASSIC_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.PUMPKIN_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.MUSHROOM_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.FLOWER_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.CREEPER_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.DIAMOND_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.PICKAXE_WAFFLE_MOLD.get());
        output.accept(ModItemsInit.SWORD_WAFFLE_MOLD.get());
    }

    private void acceptWaffles(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.TAIYAKI.get());
        output.accept(ModItemsInit.EGG_WAFFLE.get());
        output.accept(ModItemsInit.PAW_WAFFLE.get());
        output.accept(ModItemsInit.HEART_WAFFLE.get());
        output.accept(ModItemsInit.CLASSIC_WAFFLE.get());
        output.accept(ModItemsInit.PUMPKIN_WAFFLE.get());
        output.accept(ModItemsInit.MUSHROOM_WAFFLE.get());
        output.accept(ModItemsInit.FLOWER_WAFFLE.get());
        output.accept(ModItemsInit.CREEPER_WAFFLE.get());
        output.accept(ModItemsInit.DIAMOND_WAFFLE.get());
        output.accept(ModItemsInit.PICKAXE_WAFFLE.get());
        output.accept(ModItemsInit.SWORD_WAFFLE.get());
    }

    private void acceptMiscFoodItems(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.CASSAVA_BIBINGKA.get());
        output.accept(ModItemsInit.TAPIOCA_PUDDING.get());
        /*
        Brownies
        Cannoli
        Cookies
        Croissants
        Whoopie pie
         */
    }

    private void acceptMilkTeaDrinks(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.MATCHA_TEA.get());

        output.accept(ModItemsInit.BROWN_SUGAR_MILK_TEA.get());
        output.accept(ModItemsInit.TIGER_MILK_TEA.get());
        output.accept(ModItemsInit.HONEY_MILK_TEA.get());
        output.accept(ModItemsInit.CHOCOLATE_MILK_TEA.get());
        output.accept(ModItemsInit.VANILLA_MILK_TEA.get());
        output.accept(ModItemsInit.EGG_CUSTARD_MILK_TEA.get());
        output.accept(ModItemsInit.COOKIE_MILK_TEA.get());
        output.accept(ModItemsInit.CAKE_MILK_TEA.get());
        output.accept(ModItemsInit.PUMPKIN_SPICE_MILK_TEA.get());
        output.accept(ModItemsInit.APPLE_MILK_TEA.get());
        output.accept(ModItemsInit.SWEET_BERRY_MILK_TEA.get());
        output.accept(ModItemsInit.WATERMELON_MILK_TEA.get());
        output.accept(ModItemsInit.GLOW_BERRY_MILK_TEA.get());
        output.accept(ModItemsInit.CHORUS_FRUIT_MILK_TEA.get());
        output.accept(ModItemsInit.ROSE_MILK_TEA.get());
        output.accept(ModItemsInit.BUTTERFLY_PEA_FLOWER_MILK_TEA.get());
        output.accept(ModItemsInit.MATCHA_MILK_TEA.get());
        output.accept(ModItemsInit.LAVENDER_MILK_TEA.get());
        output.accept(ModItemsInit.THAI_MILK_TEA.get());
        output.accept(ModItemsInit.BEETROOT_MILK_TEA.get());
        output.accept(ModItemsInit.CARROT_MILK_TEA.get());
        output.accept(ModItemsInit.KELP_MILK_TEA.get());
        output.accept(ModItemsInit.PHANTOM_MILK_TEA.get());
        output.accept(ModItemsInit.BLAZING_MILK_TEA.get());
        output.accept(ModItemsInit.DARKSIDE_MILK_TEA.get());
        output.accept(ModItemsInit.WET_MILK_TEA.get());
        output.accept(ModItemsInit.IMAGINARY_MILK_TEA.get());
    }

    private void acceptCoffeeIngredients(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.COFFEE_BEANS_ROASTED.get());
        output.accept(ModItemsInit.COFFEE_GROUNDS.get());
        output.accept(ModItemsInit.COFFEE_POT_FULL.get());
        output.accept(ModItemsInit.COFFEE_FILTER.get());
        output.accept(ModItemsInit.COFFEE_FILTER_USED.get());
        output.accept(ModItemsInit.ESPRESSO_SHOT.get());
        output.accept(ModItemsInit.STEAMED_MILK.get());
        output.accept(ModItemsInit.MILK_FOAM.get());
        output.accept(ModItemsInit.ICE_CUBES.get());
    }

    private void acceptCoffeeDrinks(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.HOT_COCOA.get());
        output.accept(ModItemsInit.COFFEE.get());
        output.accept(ModItemsInit.BUTTER_COFFEE.get());
        output.accept(ModItemsInit.ESPRESSO.get());
        output.accept(ModItemsInit.RED_EYE_COFFEE.get());
        output.accept(ModItemsInit.BLACK_EYE_COFFEE.get());
        output.accept(ModItemsInit.DEAD_EYE_COFFEE.get());
        output.accept(ModItemsInit.AMERICANO.get());
        output.accept(ModItemsInit.MACCHIATO.get());
        output.accept(ModItemsInit.MOCHA.get());
        output.accept(ModItemsInit.CAFE_AU_LAIT.get());
        output.accept(ModItemsInit.FLAT_WHITE.get());
        output.accept(ModItemsInit.CAPPUCCINO.get());
        output.accept(ModItemsInit.LATTE.get());
        output.accept(ModItemsInit.FRAPPE_COFFEE.get());
        output.accept(ModItemsInit.WHIPPED_COFFEE.get());
        output.accept(ModItemsInit.ICED_COFFEE.get());
    }
}
