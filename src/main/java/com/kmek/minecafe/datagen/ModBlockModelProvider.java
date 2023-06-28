package com.kmek.minecafe.datagen;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.ModBlocksInit;
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
        ModBlocksInit.CAKE_BLOCKS.forEach(reg -> cakeModels(reg.getId().getPath(), "block/cake/"));
        ModBlocksInit.LUNCHBOXES.forEach(reg -> lunchboxModels(reg.getId().getPath(), "block/lunchbox/"));
    }

    private BlockModelBuilder cakeModelSingleFile(String name, String appendFileName, String textureFolder, String parent) {
        return withExistingParent("block/cake/" + name + appendFileName, new ResourceLocation(MineCafeMod.MODID, parent))
                .texture("bottom", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_bottom"))
                .texture("top", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_top"))
                .texture("side", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_side"))
                .texture("inner", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_inner"));
    }

    private void cakeModels(String name, String textureFolder) {
        cakeModelSingleFile(name, "", textureFolder, "block/cake/cake");
        cakeModelSingleFile(name, "_slice1", textureFolder, "block/cake/cake_slice1");
        cakeModelSingleFile(name, "_slice2", textureFolder, "block/cake/cake_slice2");
        cakeModelSingleFile(name, "_slice3", textureFolder, "block/cake/cake_slice3");
        cakeModelSingleFile(name, "_slice4", textureFolder, "block/cake/cake_slice4");
        cakeModelSingleFile(name, "_slice5", textureFolder, "block/cake/cake_slice5");
        cakeModelSingleFile(name, "_slice6", textureFolder, "block/cake/cake_slice6");
    }

    private void lunchboxModels(String name, String textureFolder) {
        withExistingParent("block/lunchbox/" + name,
                new ResourceLocation(MineCafeMod.MODID, "block/lunchbox/lunchbox"))
                .texture("outer", new ResourceLocation(MineCafeMod.MODID, textureFolder + name));
        withExistingParent("block/lunchbox/" + name + "_open",
                new ResourceLocation(MineCafeMod.MODID, "block/lunchbox/lunchbox_open"))
                .texture("outer", new ResourceLocation(MineCafeMod.MODID, textureFolder + name + "_open"));
    }
}
