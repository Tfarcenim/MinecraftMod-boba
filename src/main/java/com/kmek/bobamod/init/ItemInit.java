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
    // todo honey
    // todo chocolate
    // todo vanilla
    // todo egg pudding
    // todo cookie
    // todo cake
    public static final RegistryObject<Item> PUMPKIN_SPICE_MILK_TEA = ITEMS.register("pumpkin_spice_milk_tea", () -> new MilkTeaItem(4, 2f));
    // Fruit teas
    public static final RegistryObject<Item> APPLE_MILK_TEA = ITEMS.register("apple_milk_tea", () -> new MilkTeaItem(4, 2f));
    // todo sweet berry
    public static final RegistryObject<Item> WATERMELON_MILK_TEA = ITEMS.register("watermelon_milk_tea", () -> new MilkTeaItem(4, 2f));
    // todo glow berry
    // todo chorus fruit
    // Floral
    public static final RegistryObject<Item> ROSE_MILK_TEA = ITEMS.register("rose_milk_tea", () -> new MilkTeaItem(4, 2f));
    // todo butterfly pea flower
    // todo matcha
    // todo lavender
    // Misc
    // todo thai
    // todo taro
    // todo beetroot
    // todo carrot
    // todo kelp
}
