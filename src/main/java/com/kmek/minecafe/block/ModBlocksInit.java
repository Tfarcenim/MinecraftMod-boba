package com.kmek.minecafe.block;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.crop.CassavaCropBlock;
import com.kmek.minecafe.block.crop.CropTreeBottomBlock;
import com.kmek.minecafe.block.crop.CropTreeTopBlock;
import com.kmek.minecafe.block.crop.FlowerCropBlock;
import com.kmek.minecafe.fluid.ModFluids;
import com.kmek.minecafe.item.ModItemsInit;
import com.kmek.minecafe.item.registery.Fruits;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class ModBlocksInit {
    public static final DeferredRegister<Item> ITEMS = ModItemsInit.ITEMS;
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MineCafeMod.MODID);
    // Register
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // Will be rendered as cutout later
    public static final List<RegistryObject<Block>> renderAsCutout = new ArrayList<>();

    // Will be marked as compostable later
//    public static final List<RegistryObject<Block>> compostableItems = new ArrayList<>();
    // todo map with float values

    /**
     * Setup Helper Functions
     */
    // Same name block and item
    private static <T extends Block> RegistryObject<T> registerBlockItem(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }
    // Different name for block and item
    private static <T extends Block> RegistryObject<T> registerItemNameBlockItem(String blockName, String itemName, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(blockName, block);
        ITEMS.register(itemName, () -> new ItemNameBlockItem(toReturn.get(), new Item.Properties()));
        return toReturn;
    }
    // Create two block crop with seed block
    private static RegistryObject<Block> registerDoubleCropBlockItem(String cropName, String seedName, String fruitName, int resetAge) {
        RegistryObject<Block> bottom = registerItemNameBlockItem(cropName + "_crop_bottom", seedName,
                () -> new CropTreeBottomBlock(cropName + "_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
        RegistryObject<Block> top = BLOCKS.register(cropName + "_crop_top",
                () -> new CropTreeTopBlock(bottom.get(), fruitName, resetAge,
                        BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
        renderAsCutout.add(bottom);
        renderAsCutout.add(top);
        return bottom;
    }
    private static RegistryObject<Block> registerDoubleCropBlockItem(String cropName, String seedName, Item fruitItem, int resetAge) {
        RegistryObject<Block> bottom = registerItemNameBlockItem(cropName + "_crop_bottom", seedName,
                () -> new CropTreeBottomBlock(cropName + "_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
        RegistryObject<Block> top = BLOCKS.register(cropName + "_crop_top",
                () -> new CropTreeTopBlock(bottom.get(), fruitItem, resetAge,
                        BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
        renderAsCutout.add(bottom);
        renderAsCutout.add(top);
        return bottom;
    }
    // Create fruit tree blocks and seed item
    private static RegistryObject<Block> registerFruitTree(String fruitName) {
        return registerDoubleCropBlockItem(fruitName, fruitName + "_seeds", "item.minecafe." + fruitName, 5);
    }

    /**
     * Flower Crop Blocks (+ Seed Items)
     */
    public static final RegistryObject<Block> DANDELION_CROP = registerItemNameBlockItem("dandelion_crop", "dandelion_seeds",
            () -> new FlowerCropBlock("dandelion_seeds", Blocks.DANDELION, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> POPPY_CROP = registerItemNameBlockItem("poppy_crop", "poppy_seeds",
            () -> new FlowerCropBlock("poppy_seeds", Blocks.POPPY, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> BLUE_ORCHID_CROP = registerItemNameBlockItem("blue_orchid_crop", "blue_orchid_seeds",
            () -> new FlowerCropBlock("blue_orchid_seeds", Blocks.BLUE_ORCHID, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> ALLIUM_CROP = registerItemNameBlockItem("allium_crop", "allium_seeds",
            () -> new FlowerCropBlock("allium_seeds", Blocks.ALLIUM, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> AZURE_BLUET_CROP = registerItemNameBlockItem("azure_bluet_crop", "azure_bluet_seeds",
            () -> new FlowerCropBlock("azure_bluet_seeds", Blocks.AZURE_BLUET, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> RED_TULIP_CROP = registerItemNameBlockItem("red_tulip_crop", "red_tulip_seeds",
            () -> new FlowerCropBlock("red_tulip_seeds", Blocks.RED_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> ORANGE_TULIP_CROP = registerItemNameBlockItem("orange_tulip_crop", "orange_tulip_seeds",
            () -> new FlowerCropBlock("orange_tulip_seeds", Blocks.ORANGE_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> WHITE_TULIP_CROP = registerItemNameBlockItem("white_tulip_crop", "white_tulip_seeds",
            () -> new FlowerCropBlock("white_tulip_seeds", Blocks.WHITE_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> PINK_TULIP_CROP = registerItemNameBlockItem("pink_tulip_crop", "pink_tulip_seeds",
            () -> new FlowerCropBlock("pink_tulip_seeds", Blocks.PINK_TULIP, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> OXEYE_DAISY_CROP = registerItemNameBlockItem("oxeye_daisy_crop", "oxeye_daisy_seeds",
            () -> new FlowerCropBlock("oxeye_daisy_seeds", Blocks.OXEYE_DAISY, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> CORNFLOWER_CROP = registerItemNameBlockItem("cornflower_crop", "cornflower_seeds",
            () -> new FlowerCropBlock("cornflower_seeds", Blocks.CORNFLOWER, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> LILY_OF_THE_VALLEY_CROP = registerItemNameBlockItem("lily_of_the_valley_crop","lily_of_the_valley_seeds",
            () -> new FlowerCropBlock("lily_of_the_valley_seeds", Blocks.LILY_OF_THE_VALLEY, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ)));

    /**
     * Single Block Crops
     */
    // Cassava
    public static final RegistryObject<Block> CASSAVA_CROP = registerItemNameBlockItem("cassava_crop", "cassava_cutting",
            () -> new CassavaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    /**
     * Double Block Crops
     */
    //    private static final BlockBehaviour.Properties =
    public static final RegistryObject<Block> COFFEE_CROP_BOTTOM = registerDoubleCropBlockItem("coffee", "coffee_beans_unroasted", "item.minecafe.coffee_cherries", 7);
    public static final RegistryObject<Block> APPLE_CROP_BOTTOM = registerDoubleCropBlockItem("apple", "apple_seeds", Items.APPLE, 5);
    // Fruits
    public static final List<RegistryObject<Block>> FRUIT_CROPS = Arrays.stream(Fruits.values())
            .filter(fruit -> fruit != Fruits.APPLE)
            .map(fruit -> registerFruitTree(fruit.toString().toLowerCase()))
            .toList();

    /**
     * Crafting Blocks (+ Item Versions)
     */
    public static final RegistryObject<Block> WAFFLE_IRON = registerBlockItem("waffle_iron",
            () -> new WaffleIronBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> COFFEE_MACHINE = registerBlockItem("coffee_machine",
            () -> new CoffeeMachineBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> ESPRESSO_MACHINE = registerBlockItem("espresso_machine",
            () -> new EspressoMachineBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));

    /**
     * Display Blocks
     */
    public static final RegistryObject<Block> DISPLAY_CASE_CURVED = registerBlockItem("display_case_curved",
            () -> new DisplayCaseBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> CAKE_STAND = registerBlockItem("cake_stand",
            () -> new CakeStandBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> VASE = registerBlockItem("vase",
            () -> new VaseBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> CASH_REGISTER = registerBlockItem("cash_register",
            () -> new CashRegisterBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(3.5f).dynamicShape().requiresCorrectToolForDrops().noOcclusion()));

    // Wall Shelves
    public static RegistryObject<Block> registerWallShelfBlockItem(String name) {
        return registerBlockItem(name, () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    }
    public static final RegistryObject<Block> OAK_WALL_SHELF = registerWallShelfBlockItem("oak_wall_shelf");
    public static final RegistryObject<Block> SPRUCE_WALL_SHELF = registerWallShelfBlockItem("spruce_wall_shelf");
    public static final RegistryObject<Block> BIRCH_WALL_SHELF = registerWallShelfBlockItem("birch_wall_shelf");
    public static final RegistryObject<Block> JUNGLE_WALL_SHELF = registerWallShelfBlockItem("jungle_wall_shelf");
    public static final RegistryObject<Block> ACACIA_WALL_SHELF = registerWallShelfBlockItem("acacia_wall_shelf");
    public static final RegistryObject<Block> DARK_OAK_WALL_SHELF = registerWallShelfBlockItem("dark_oak_wall_shelf");
    public static final RegistryObject<Block> MANGROVE_WALL_SHELF = registerWallShelfBlockItem("mangrove_wall_shelf");
    public static final RegistryObject<Block> CRIMSON_WALL_SHELF = registerWallShelfBlockItem("crimson_wall_shelf");
    public static final RegistryObject<Block> WARPED_WALL_SHELF = registerWallShelfBlockItem("warped_wall_shelf");

    /**
     * Fluids
     */
    public static final RegistryObject<LiquidBlock> COFFEE_FLUID_BLOCK = BLOCKS.register("coffee_fluid_block",
            () -> new LiquidBlock(ModFluids.SOURCE_COFFEE_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));
}
