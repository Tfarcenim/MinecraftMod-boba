package com.kmek.minecafe.item;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.ModBlocksInit;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModCreativeTabInit {
    public static CreativeModeTab minecafeTab;

    /**
     * Registering the event bus
     */
    public void register(IEventBus modEventBus) {
        modEventBus.addListener(this::registerCustomCreativeTab);
    }

    private void registerCustomCreativeTab(CreativeModeTabEvent.Register event) {
        minecafeTab = event.registerCreativeModeTab(new ResourceLocation(MineCafeMod.MODID, "minecafe_tab1"), builder -> builder
            .title(Component.translatable("itemGroup.minecafe_blocks"))
            .icon(() -> new ItemStack(ModBlocksInit.ESPRESSO_MACHINE.get()))
            .displayItems((featureFlags, output, hasOp) -> {
                // Add categories
                acceptBlocks(output);
                acceptCropsAndSeeds(output);
            })
            .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MineCafeMod.MODID, "minecafe_tab2"), builder -> builder
                .title(Component.translatable("itemGroup.minecafe_ingredients"))
                .icon(() -> new ItemStack(ModItemsInit.BUTTER.get()))
                .displayItems((featureFlags, output, hasOp) -> {
                    // Add categories
                    acceptIngredients(output);
                    acceptDishes(output);
                })
                .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MineCafeMod.MODID, "minecafe_tab3"), builder -> builder
                .title(Component.translatable("itemGroup.minecafe_food"))
                .icon(() -> new ItemStack(ModItemsInit.CROISSANT.get()))
                .displayItems((featureFlags, output, hasOp) -> {
                    // Add categories
                    acceptFoods(output);
                })
                .build()
        );
        event.registerCreativeModeTab(new ResourceLocation(MineCafeMod.MODID, "minecafe_tab4"), builder -> builder
                .title(Component.translatable("itemGroup.minecafe_drinks"))
                .icon(() -> new ItemStack(ModItemsInit.BROWN_SUGAR_MILK_TEA.get()))
                .displayItems((featureFlags, output, hasOp) -> {
                    // Add categories
                    acceptDrinks(output);
                })
                .build()
        );
    }

    /*****************************************************************************************************************
     * Blocks
     *****************************************************************************************************************/

    private void acceptBlocks(CreativeModeTab.Output output) {
        // Decorative blocks
        output.accept(ModBlocksInit.CAKE_STAND.get());
        output.accept(ModBlocksInit.VASE.get());
        output.accept(ModBlocksInit.DISPLAY_CASE_CURVED.get());
        output.accept(ModBlocksInit.CASH_REGISTER.get());
        // Wall Shelves
        output.accept(ModBlocksInit.OAK_WALL_SHELF.get());
        output.accept(ModBlocksInit.SPRUCE_WALL_SHELF.get());
        output.accept(ModBlocksInit.BIRCH_WALL_SHELF.get());
        output.accept(ModBlocksInit.JUNGLE_WALL_SHELF.get());
        output.accept(ModBlocksInit.ACACIA_WALL_SHELF.get());
        output.accept(ModBlocksInit.DARK_OAK_WALL_SHELF.get());
        output.accept(ModBlocksInit.MANGROVE_WALL_SHELF.get());
        output.accept(ModBlocksInit.CRIMSON_WALL_SHELF.get());
        output.accept(ModBlocksInit.WARPED_WALL_SHELF.get());

        // Crafting bench blocks
        output.accept(ModBlocksInit.WAFFLE_IRON.get());
        output.accept(ModBlocksInit.COFFEE_MACHINE.get());
        output.accept(ModBlocksInit.ESPRESSO_MACHINE.get());
        output.accept(ModBlocksInit.JUICER.get());

        // Fun Blocks
        output.accept(ModItemsInit.COFFEE_BUCKET.get());
    }

    private void acceptCropsAndSeeds(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.CROP_INSPECTOR_ITEM.get());

        acceptFlowerSeeds(output);

        // Seeds
        output.accept(ModBlocksInit.APPLE_CROP_BOTTOM.get());
        ModBlocksInit.FRUIT_TREE_CROPS.stream().forEach(reg -> output.accept(reg.get()));
        ModBlocksInit.FRUIT_BUSH_CROPS.stream().forEach(reg -> output.accept(reg.get()));
        output.accept(ModBlocksInit.CASSAVA_CROP.get());
        ModBlocksInit.TILLED_CROPS.stream().forEach(reg -> output.accept(reg.get()));
        output.accept(ModBlocksInit.COFFEE_CROP_BOTTOM.get());
    }
    private void acceptFlowerSeeds(CreativeModeTab.Output output) {
        ModBlocksInit.FLOWER_CROPS.forEach(reg -> output.accept(reg.get()));
    }

    /*****************************************************************************************************************
     * Ingredients
     *****************************************************************************************************************/

    private void acceptIngredients(CreativeModeTab.Output output) {
        acceptFruit(output);

        acceptCoreIngreidents(output);

        acceptCreams(output);
        acceptMarshmallows(output);
        acceptJams(output);
        acceptCoffeeIngredients(output);
        acceptMiscIngredients(output);
    }

    private void acceptFruit(CreativeModeTab.Output output) {
        // Fruit
        ModItemsInit.FRUIT_ITEMS.forEach(reg -> output.accept(reg.get()));

        // Other Crop Drops
        output.accept(ModItemsInit.CASSAVA.get());
        output.accept(ModItemsInit.COFFEE_CHERRIES.get());
    }

    private void acceptCoreIngreidents(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.MONKFRUIT_SWEETENER.get());
        output.accept(ModItemsInit.CREAM.get());
        output.accept(ModItemsInit.BUTTER.get());

        output.accept(ModItemsInit.CUSTARD.get());

        output.accept(ModItemsInit.CHOCOLATE.get());
        output.accept(ModItemsInit.VANILLA.get());
        output.accept(ModItemsInit.CARAMEL.get());
        output.accept(ModItemsInit.CINNAMON.get());

        output.accept(ModItemsInit.GRAHAM_CRACKER.get());
        output.accept(ModItemsInit.PIE_CRUST.get());
    }

    private void acceptJams(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.APPLE_JAM.get());
        output.accept(ModItemsInit.CHORUS_FRUIT_JAM.get());
        output.accept(ModItemsInit.GLOW_BERRY_JAM.get());
        output.accept(ModItemsInit.SWEET_BERRY_JAM.get());
        output.accept(ModItemsInit.WATERMELON_JAM.get());
    }

    private void acceptCreams(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.WHIPPED_CREAM.get());
        ModItemsInit.CREAMS.forEach(reg -> output.accept(reg.get()));
    }

    private void acceptMarshmallows(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.MARSHMALLOW.get());
        output.accept(ModItemsInit.MARSHMALLOWS.get());
        output.accept(ModItemsInit.MARSHMALLOW_PUFF.get());

        output.accept(ModItemsInit.MARSHMALLOW_ON_STICK.get());
        output.accept(ModItemsInit.MARSHMALLOW_ON_STICK_WARM.get());
        output.accept(ModItemsInit.MARSHMALLOW_ON_STICK_TOASTED.get());
        output.accept(ModItemsInit.MARSHMALLOW_ON_STICK_GOLDEN.get());
        output.accept(ModItemsInit.MARSHMALLOW_ON_STICK_WELL_DONE.get());
        output.accept(ModItemsInit.MARSHMALLOW_ON_STICK_BURNT.get());
        output.accept(ModItemsInit.MARSHMALLOW_ON_STICK_SCORCHED.get());
    }

    private void acceptMiscIngredients(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.BOBA_PEARLS.get());
        output.accept(ModItemsInit.MATCHA_POWDER.get());
        output.accept(ModItemsInit.RAW_WAFFLE_BATTER.get());
        output.accept(ModItemsInit.BATTER_MESS.get());
        output.accept(ModItemsInit.BURNT_CRISP.get());
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

    private void acceptDishes(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.COFFEE_POT.get());

        output.accept(ModItemsInit.MUG.get());
        output.accept(ModItemsInit.CLEAR_CUP.get());

        output.accept(ModItemsInit.ICE_TRAY.get());
        output.accept(ModItemsInit.ICE_TRAY_WATER.get());
        output.accept(ModItemsInit.ICE_TRAY_ICE.get());

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

    /*****************************************************************************************************************
     * Foods
     *****************************************************************************************************************/

    private void acceptFoods(CreativeModeTab.Output output) {
        acceptBreads(output);
        acceptWaffles(output);
        acceptCake(output);
        acceptPie(output);
        acceptPudding(output);
        acceptMiscFoodItems(output);
        acceptCandy(output);
        acceptSmores(output);
    }

    private void acceptBreads(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.CROISSANT.get());
        output.accept(ModItemsInit.BAGUETTE.get());
        // Accept buns
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

    private void acceptCake(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.CASSAVA_BIBINGKA.get());
        acceptCheesecake(output);
    }

    private void acceptCheesecake(CreativeModeTab.Output output) {
        ModItemsInit.CHEESECAKES.forEach(reg -> output.accept(reg.get()));
    }

    private void acceptPie(CreativeModeTab.Output output) {
        ModItemsInit.PIES.forEach(reg -> output.accept(reg.get()));
    }

    private void acceptPudding(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.TAPIOCA_PUDDING.get());
        output.accept(ModItemsInit.FIGGY_PUDDING.get());
        output.accept(ModItemsInit.FLAN.get());
    }

    private void acceptMiscFoodItems(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.BROWNIE.get());
        output.accept(ModItemsInit.FIG_NEWTON.get());
    }

    private void acceptCandy(CreativeModeTab.Output output) {
        output.accept(ModItemsInit.STRAWBERRY_CHOCOLATE.get());
        output.accept(ModItemsInit.WHITE_STRAWBERRY_CHOCOLATE.get());
        output.accept(ModItemsInit.CARAMEL_APPLE.get());
        output.accept(ModItemsInit.PEEPS.get());
    }

    private void acceptSmores(CreativeModeTab.Output output) {
        ModItemsInit.SMORES.forEach(reg -> output.accept(reg.get()));
    }

    /*****************************************************************************************************************
     * Drinks
     *****************************************************************************************************************/

    private void acceptDrinks(CreativeModeTab.Output output) {
        acceptFruitDrinks(output);
        acceptCoffeeDrinks(output);
        acceptMilkTeaDrinks(output);
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

    private void acceptFruitDrinks(CreativeModeTab.Output output) {
        ModItemsInit.FRUIT_JUICES.forEach(reg -> output.accept(reg.get()));
        ModItemsInit.LEMONADES.forEach(reg -> output.accept(reg.get()));
    }
}
