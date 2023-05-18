package com.kmek.minecafe.datagen;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.ModBlocksInit;
import com.kmek.minecafe.item.ModItemsInit;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, MineCafeMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItemsInit.CROP_INSPECTOR_ITEM, "tools/");
        handheldItem(ModItemsInit.GOLDEN_FORTUNE_COOKIE_PICKAXE, "tools/");
        // todo cookbook

        ModItemsInit.CROP_ITEMS.forEach(e -> simpleItem(e, "crops/"));
        ModItemsInit.NUTS.forEach(e -> simpleItem(e, "nuts/"));
        ModItemsInit.CREAMS.forEach(e -> simpleItem(e, "creams/"));
        ModItemsInit.JAMS.forEach(e -> simpleItem(e, "jams/"));
        ModItemsInit.BREADS.forEach(e -> simpleItem(e, "breads/"));
        ModItemsInit.CAKES.forEach(e -> simpleItem(e, "cakes/"));
        ModItemsInit.PIES.forEach(e -> simpleItem(e, "pies/"));
        ModItemsInit.PUDDINGS.forEach(e -> simpleItem(e, "puddings/"));
        ModItemsInit.CANDY.forEach(e -> simpleItem(e, "candy/"));
        ModItemsInit.BROWNIES.forEach(e -> simpleItem(e, "baked_goods/"));
        ModItemsInit.SMORES.forEach(e -> simpleItem(e, "marshmallows/"));
        ModItemsInit.CANNOLIS.forEach(e -> simpleItem(e, "cannolis/"));
        ModItemsInit.MUFFINS.forEach(e -> simpleItem(e, "baked_goods/"));
        ModItemsInit.COOKIES.forEach(e -> simpleItem(e, "cookies/"));
        ModItemsInit.YOGURTS.forEach(e -> simpleItem(e, "yogurts/"));
        ModItemsInit.BOBA_MILK_TEAS.forEach(e -> simpleItem(e, "milk_teas/"));
        ModItemsInit.COFFEES.forEach(e -> simpleItem(e, "coffees/"));
        ModItemsInit.FRUIT_JUICES.forEach(e -> simpleItem(e, "juices/"));
        ModItemsInit.INGREDIENTS.forEach(e -> simpleItem(e, "ingredients/"));
        ModItemsInit.WAFFLE_MOLDS.forEach(e -> simpleItem(e, "waffles/"));
        ModItemsInit.WAFFLES.forEach(e -> simpleItem(e, "waffles/"));

//        ModBlocksInit.FLOWER_CROPS.forEach(e -> simpleItem(e, ""));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String textureFolder) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(MineCafeMod.MODID,"item/" + textureFolder + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item, String textureFolder) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(MineCafeMod.MODID,"item/" + textureFolder + item.getId().getPath()));
    }
}
