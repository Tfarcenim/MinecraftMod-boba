package com.kmek.minecafe.block;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.crop.CassavaCropBlock;
import com.kmek.minecafe.block.crop.CropTreeBottomBlock;
import com.kmek.minecafe.block.crop.CropTreeTopBlock;
import com.kmek.minecafe.block.crop.FlowerCropBlock;
import com.kmek.minecafe.fluid.ModFluids;
import com.kmek.minecafe.item.ModItemsInit;
import com.kmek.minecafe.item.registery.Fruits;
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

import java.util.*;
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
    public static RegistryObject<Block> asCutout(RegistryObject<Block> reg) {
        renderAsCutout.add(reg);
        return reg;
    }

    // Will be rendered as translucent later
    public static final List<RegistryObject<Block>> renderAsTranslucent = new ArrayList<>();
    public static RegistryObject<Block> asTranslucent(RegistryObject<Block> reg) {
        renderAsTranslucent.add(reg);
        return reg;
    }

    // Will be marked as compostable later
    public static final Map<RegistryObject<Block>, Float> compostableItems = new HashMap<>();
    public static RegistryObject<Block> compostable(float rate, RegistryObject<Block> reg) {
        compostableItems.put(reg, rate);
        return reg;
    }

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
        return bottom;
    }
    private static RegistryObject<Block> registerDoubleCropBlockItem(String cropName, String seedName, Item fruitItem, int resetAge) {
        RegistryObject<Block> bottom = registerItemNameBlockItem(cropName + "_crop_bottom", seedName,
                () -> new CropTreeBottomBlock(cropName + "_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
        RegistryObject<Block> top = BLOCKS.register(cropName + "_crop_top",
                () -> new CropTreeTopBlock(bottom.get(), fruitItem, resetAge,
                        BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
        return bottom;
    }
    // Create fruit tree blocks and seed item
    private static RegistryObject<Block> registerFruitTree(String fruitName) {
        return registerDoubleCropBlockItem(fruitName, fruitName + "_seeds", "item.minecafe." + fruitName, 5);
    }

    /**
     * Flower Crop Blocks (+ Seed Items)
     */
    public static final List<RegistryObject<Block>> FLOWER_CROPS = Arrays.stream(new Block[]{Blocks.DANDELION,
                    Blocks.POPPY, Blocks.BLUE_ORCHID, Blocks.ALLIUM, Blocks.AZURE_BLUET, Blocks.RED_TULIP, Blocks.ORANGE_TULIP,
                    Blocks.WHITE_TULIP, Blocks.PINK_TULIP, Blocks.OXEYE_DAISY, Blocks.CORNFLOWER, Blocks.LILY_OF_THE_VALLEY})
            .map(block -> {
                String flowerName = block.getDescriptionId().split("minecraft")[1].substring(1);
                RegistryObject<Block> flowerCropBlock = compostable(0.6F, registerItemNameBlockItem(flowerName + "_crop", flowerName + "_seeds",
                        () -> new FlowerCropBlock(flowerName + "_seeds", block, BlockBehaviour.Properties.copy(Blocks.WHEAT).offsetType(BlockBehaviour.OffsetType.XZ))));
                return flowerCropBlock;
            }).toList();

    /**
     * Single Block Crops
     */
    // Cassava
    public static final RegistryObject<Block> CASSAVA_CROP = compostable(0.5F, registerItemNameBlockItem("cassava_crop", "cassava_cutting",
            () -> new CassavaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT))));
    /**
     * Double Block Crops
     */
    public static final RegistryObject<Block> COFFEE_CROP_BOTTOM = compostable(0.5F,
            registerDoubleCropBlockItem("coffee", "coffee_beans_unroasted", "item.minecafe.coffee_cherries", 7));
    // Fruits
    public static final RegistryObject<Block> APPLE_CROP_BOTTOM = compostable(0.5F, registerDoubleCropBlockItem("apple", "apple_seeds", Items.APPLE, 5));
    public static final List<RegistryObject<Block>> FRUIT_CROPS = Arrays.stream(Fruits.treeCrops)
            .filter(fruit -> fruit != Fruits.APPLE)
            .map(fruit -> compostable(0.65F, registerFruitTree(fruit.toString().toLowerCase())))
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
    public static final RegistryObject<Block> DISPLAY_CASE_CURVED = asTranslucent(registerBlockItem("display_case_curved",
            () -> new DisplayCaseBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion())));
    public static final RegistryObject<Block> CAKE_STAND = registerBlockItem("cake_stand",
            () -> new CakeStandBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> VASE = asTranslucent(registerBlockItem("vase",
            () -> new VaseBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(0.5f).dynamicShape().noOcclusion())));
    public static final RegistryObject<Block> CASH_REGISTER = asTranslucent(registerBlockItem("cash_register",
            () -> new CashRegisterBlock(BlockBehaviour.Properties.of(Material.DIRT).destroyTime(3.5f).dynamicShape().requiresCorrectToolForDrops().noOcclusion())));

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
