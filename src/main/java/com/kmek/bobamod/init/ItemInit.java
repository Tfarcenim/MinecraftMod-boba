package com.kmek.bobamod.init;

import com.kmek.bobamod.BobaMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BobaMod.MODID);

    public static final RegistryObject<Item> TAPIOCA_BALLS = ITEMS.register("tapioca_balls", () -> new Item(new Item.Properties()));
}
