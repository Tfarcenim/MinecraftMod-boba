package com.kmek.minecafe.datagen;

import com.kmek.minecafe.MineCafeMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MineCafeMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

//    private VariantBlockStateBuilder yDirectionalBlockStates(RegistryObject<Block> block) {
//        return new VariantBlockStateBuilder();
//    }
}
