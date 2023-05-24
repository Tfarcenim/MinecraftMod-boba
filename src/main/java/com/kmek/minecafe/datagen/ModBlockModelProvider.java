package com.kmek.minecafe.datagen;

import com.kmek.minecafe.MineCafeMod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockModelProvider extends BlockModelProvider {
    public ModBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MineCafeMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        cakeModels("carrot", "block/cake/");
    }

    private BlockModelBuilder cakeModelSingleFile(String name, String appendFileName, String textureFolder, String parent) {
        return withExistingParent("block/cake/" + name + appendFileName, new ResourceLocation(MineCafeMod.MODID, parent))
                .texture("bottom", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_cake_bottom"))
                .texture("top", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_cake_top"))
                .texture("side", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_cake_side"))
                .texture("inner", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_cake_inner"));
    }

    private void cakeModels(String name, String textureFolder) {
        cakeModelSingleFile(name, "_cake", textureFolder, "block/cake/cake");
        cakeModelSingleFile(name, "_cake_slice1", textureFolder, "block/cake/cake_slice1");
        cakeModelSingleFile(name, "_cake_slice2", textureFolder, "block/cake/cake_slice2");
        cakeModelSingleFile(name, "_cake_slice3", textureFolder, "block/cake/cake_slice3");
        cakeModelSingleFile(name, "_cake_slice4", textureFolder, "block/cake/cake_slice4");
        cakeModelSingleFile(name, "_cake_slice5", textureFolder, "block/cake/cake_slice5");
        cakeModelSingleFile(name, "_cake_slice6", textureFolder, "block/cake/cake_slice6");
    }
}
