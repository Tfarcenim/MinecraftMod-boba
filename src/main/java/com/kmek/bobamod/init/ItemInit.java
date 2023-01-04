package com.kmek.bobamod.init;

import com.kmek.bobamod.BobaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BobaMod.MODID);

    // Crafting Ingredients
    public static final RegistryObject<Item> TAPIOCA_BALLS = ITEMS.register("tapioca_balls", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MILK_TEA_CUP = ITEMS.register("milk_tea_cup", () -> new Item(new Item.Properties()));

    // Bubble Milk Teas
    public static final RegistryObject<Item> BROWN_SUGAR_MILK_TEA = ITEMS.register("brown_sugar_milk_tea", () -> new Item(new Item.Properties()));
}
