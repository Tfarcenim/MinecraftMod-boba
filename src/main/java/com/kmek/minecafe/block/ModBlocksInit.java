package com.kmek.minecafe.block;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.crop.CassavaCropBlock;
import com.kmek.minecafe.block.crop.CropTreeBottomBlock;
import com.kmek.minecafe.block.crop.CropTreeTopBlock;
import com.kmek.minecafe.block.crop.FlowerCropBlock;
import com.kmek.minecafe.fluid.ModFluids;
import com.kmek.minecafe.item.ModItemsInit;
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

import java.util.function.Supplier;

public class ModBlocksInit {
    public static final DeferredRegister<Item> ITEMS = ModItemsInit.ITEMS;
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MineCafeMod.MODID);

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
     * Crop Blocks
     */
//    private static final BlockBehaviour.Properties =
    // Cassava
    public static final RegistryObject<Block> CASSAVA_CROP = registerItemNameBlockItem("cassava_crop", "cassava_cutting",
            () -> new CassavaCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    // Coffee
    public static final RegistryObject<Block> COFFEE_CROP_BOTTOM = registerItemNameBlockItem("coffee_crop_bottom", "coffee_beans_unroasted",
            () -> new CropTreeBottomBlock("coffee_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> COFFEE_CROP_TOP = BLOCKS.register("coffee_crop_top",
            () -> new CropTreeTopBlock(COFFEE_CROP_BOTTOM.get(), "item.minecafe.coffee_cherries", 7,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Apple
    public static final RegistryObject<Block> APPLE_CROP_BOTTOM = registerItemNameBlockItem("apple_crop_bottom", "apple_seeds",
            () -> new CropTreeBottomBlock("apple_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> APPLE_CROP_TOP = BLOCKS.register("apple_crop_top",
            () -> new CropTreeTopBlock(APPLE_CROP_BOTTOM.get(), Items.APPLE, 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Orange
    public static final RegistryObject<Block> ORANGE_CROP_BOTTOM = registerItemNameBlockItem("orange_crop_bottom", "orange_seeds",
            () -> new CropTreeBottomBlock("orange_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> ORANGE_CROP_TOP = BLOCKS.register("orange_crop_top",
            () -> new CropTreeTopBlock(ORANGE_CROP_BOTTOM.get(), "item.minecafe.orange", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Lemon
    public static final RegistryObject<Block> LEMON_CROP_BOTTOM = registerItemNameBlockItem("lemon_crop_bottom", "lemon_seeds",
            () -> new CropTreeBottomBlock("lemon_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> LEMON_CROP_TOP = BLOCKS.register("lemon_crop_top",
            () -> new CropTreeTopBlock(LEMON_CROP_BOTTOM.get(), "item.minecafe.lemon", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Lime
    public static final RegistryObject<Block> LIME_CROP_BOTTOM = registerItemNameBlockItem("lime_crop_bottom", "lime_seeds",
            () -> new CropTreeBottomBlock("lime_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> LIME_CROP_TOP = BLOCKS.register("lime_crop_top",
            () -> new CropTreeTopBlock(LEMON_CROP_BOTTOM.get(), "item.minecafe.lime", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Avocado
    public static final RegistryObject<Block> AVOCADO_CROP_BOTTOM = registerItemNameBlockItem("avocado_crop_bottom", "avocado_seeds",
            () -> new CropTreeBottomBlock("avocado_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> AVOCADO_CROP_TOP = BLOCKS.register("avocado_crop_top",
            () -> new CropTreeTopBlock(AVOCADO_CROP_BOTTOM.get(), "item.minecafe.avocado", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Lychee
    public static final RegistryObject<Block> LYCHEE_CROP_BOTTOM = registerItemNameBlockItem("lychee_crop_bottom", "lychee_seeds",
            () -> new CropTreeBottomBlock("lychee_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> LYCHEE_CROP_TOP = BLOCKS.register("lychee_crop_top",
            () -> new CropTreeTopBlock(LYCHEE_CROP_BOTTOM.get(), "item.minecafe.lychee", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Banana
    public static final RegistryObject<Block> BANANA_CROP_BOTTOM = registerItemNameBlockItem("banana_crop_bottom", "banana_seeds",
            () -> new CropTreeBottomBlock("banana_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> BANANA_CROP_TOP = BLOCKS.register("banana_crop_top",
            () -> new CropTreeTopBlock(BANANA_CROP_BOTTOM.get(), "item.minecafe.banana", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Mango
    public static final RegistryObject<Block> MANGO_CROP_BOTTOM = registerItemNameBlockItem("mango_crop_bottom","mango_seeds",
            () -> new CropTreeBottomBlock("mango_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MANGO_CROP_TOP = BLOCKS.register("mango_crop_top",
            () -> new CropTreeTopBlock(MANGO_CROP_BOTTOM.get(), "item.minecafe.mango", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Cherry
    public static final RegistryObject<Block> CHERRY_CROP_BOTTOM = registerItemNameBlockItem("cherry_crop_bottom", "cherry_seeds",
            () -> new CropTreeBottomBlock("cherry_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> CHERRY_CROP_TOP = BLOCKS.register("cherry_crop_top",
            () -> new CropTreeTopBlock(CHERRY_CROP_BOTTOM.get(), "item.minecafe.cherry", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Peach
    public static final RegistryObject<Block> PEACH_CROP_BOTTOM = registerItemNameBlockItem("peach_crop_bottom", "peach_seeds",
            () -> new CropTreeBottomBlock("peach_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PEACH_CROP_TOP = BLOCKS.register("peach_crop_top",
            () -> new CropTreeTopBlock(PEACH_CROP_BOTTOM.get(), "item.minecafe.peach", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Pear
    public static final RegistryObject<Block> PEAR_CROP_BOTTOM = registerItemNameBlockItem("pear_crop_bottom", "pear_seeds",
            () -> new CropTreeBottomBlock("pear_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PEAR_CROP_TOP = BLOCKS.register("pear_crop_top",
            () -> new CropTreeTopBlock(PEAR_CROP_BOTTOM.get(), "item.minecafe.pear", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Plum
    public static final RegistryObject<Block> PLUM_CROP_BOTTOM = registerItemNameBlockItem("plum_crop_bottom", "plum_seeds",
            () -> new CropTreeBottomBlock("plum_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> PLUM_CROP_TOP = BLOCKS.register("plum_crop_top",
            () -> new CropTreeTopBlock(PLUM_CROP_BOTTOM.get(), "item.minecafe.plum", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    // Fig
    public static final RegistryObject<Block> FIG_CROP_BOTTOM = registerItemNameBlockItem("fig_crop_bottom", "fig_seeds",
            () -> new CropTreeBottomBlock("fig_crop_top", BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> FIG_CROP_TOP = BLOCKS.register("fig_crop_top",
            () -> new CropTreeTopBlock(FIG_CROP_BOTTOM.get(), "item.minecafe.fig", 5,
                    BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.GRASS)));

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
    public static final RegistryObject<Block> OAK_WALL_SHELF = registerBlockItem("oak_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> SPRUCE_WALL_SHELF = registerBlockItem("spruce_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> BIRCH_WALL_SHELF = registerBlockItem("birch_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> JUNGLE_WALL_SHELF = registerBlockItem("jungle_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> ACACIA_WALL_SHELF = registerBlockItem("acacia_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> DARK_OAK_WALL_SHELF = registerBlockItem("dark_oak_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> MANGROVE_WALL_SHELF = registerBlockItem("mangrove_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> CRIMSON_WALL_SHELF = registerBlockItem("crimson_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));
    public static final RegistryObject<Block> WARPED_WALL_SHELF = registerBlockItem("warped_wall_shelf",
            () -> new WallShelfBlock(BlockBehaviour.Properties.of(Material.WOOD).destroyTime(0.75f).dynamicShape().noOcclusion()));

    /**
     * Fluids
     */
    public static final RegistryObject<LiquidBlock> COFFEE_FLUID_BLOCK = BLOCKS.register("coffee_fluid_block",
            () -> new LiquidBlock(ModFluids.SOURCE_COFFEE_FLUID, BlockBehaviour.Properties.copy(Blocks.WATER)));

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

    /**
     * Registering the event bus
     */
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
