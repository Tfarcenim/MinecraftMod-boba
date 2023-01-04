package com.kmek.bobamod.init;

import com.kmek.bobamod.BobaMod;
import com.kmek.bobamod.food.MilkTeaItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    /**
     * Registry
     */
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BobaMod.MODID);

    /**
     * Crafting Ingredients
     */
    public static final RegistryObject<Item> TAPIOCA_BALLS = ITEMS.register("tapioca_balls", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MILK_TEA_CUP = ITEMS.register("milk_tea_cup", () -> new Item(new Item.Properties()));

    /**
     * Bubble Milk Teas
     */
    // Very sweet
    public static final RegistryObject<Item> BROWN_SUGAR_MILK_TEA = ITEMS.register("brown_sugar_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> TIGER_MILK_TEA = ITEMS.register("tiger_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> HONEY_MILK_TEA = ITEMS.register("honey_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> CHOCOLATE_MILK_TEA = ITEMS.register("chocolate_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> VANILLA_MILK_TEA = ITEMS.register("vanilla_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> EGG_CUSTARD_MILK_TEA = ITEMS.register("egg_custard_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> COOKIE_MILK_TEA = ITEMS.register("cookie_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> CAKE_MILK_TEA = ITEMS.register("cake_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> PUMPKIN_SPICE_MILK_TEA = ITEMS.register("pumpkin_spice_milk_tea", () -> new MilkTeaItem(4, 2f));
    // Fruit teas
    public static final RegistryObject<Item> APPLE_MILK_TEA = ITEMS.register("apple_milk_tea", () -> new MilkTeaItem(4, 2f));
    // todo sweet berry
    public static final RegistryObject<Item> WATERMELON_MILK_TEA = ITEMS.register("watermelon_milk_tea", () -> new MilkTeaItem(4, 2f));
    public static final RegistryObject<Item> GLOW_BERRY_MILK_TEA = ITEMS.register("glow_berry_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> CHORUS_FRUIT_MILK_TEA = ITEMS.register("chorus_fruit_milk_tea", () -> new MilkTeaItem(4, 2f));
    // Floral
    public static final RegistryObject<Item> ROSE_MILK_TEA = ITEMS.register("rose_milk_tea", () -> new MilkTeaItem(4, 2f));
    public static final RegistryObject<Item> BUTTERFLY_PEA_FLOWER_MILK_TEA = ITEMS.register("butterfly_pea_flower_milk_tea", () -> new MilkTeaItem(4, 2f));
    public static final RegistryObject<Item> MATCHA_MILK_TEA = ITEMS.register("matcha_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    public static final RegistryObject<Item> LAVENDER_MILK_TEA = ITEMS.register("lavender_milk_tea", () -> new MilkTeaItem(2, 0.5f));
    // Misc
    public static final RegistryObject<Item> THAI_MILK_TEA = ITEMS.register("thai_milk_tea", () -> new MilkTeaItem(4, 2f));
    // todo beetroot
    // todo carrot
    public static final RegistryObject<Item> KELP_MILK_TEA = ITEMS.register("kelp_milk_tea", () -> new MilkTeaItem(4, 2f));
}
