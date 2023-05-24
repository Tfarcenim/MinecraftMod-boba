package com.kmek.minecafe.datagen;

import com.kmek.minecafe.MineCafeMod;
import com.kmek.minecafe.block.ModBlocksInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MineCafeMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        cakeBlockState(ModBlocksInit.CARROT_CAKE_BLOCK);
    }

    private VariantBlockStateBuilder cakeBlockState(RegistryObject<Block> block) {
        VariantBlockStateBuilder builder = getVariantBuilder(block.get());
        return builder.forAllStates(state -> {
            int bites = state.getValue(BlockStateProperties.BITES);
            String modelName = "block/cake/" + block.getId().getPath(); // block/cake/chocolate_cake
            if (bites > 0) { modelName += "_slice" + bites; }
            return ConfiguredModel.builder()
                .modelFile(models().getExistingFile(modLoc(modelName)))
                .build();
        });
//        return builder.partialState()
//            .with(BlockStateProperties.BITES, 0)
//                .modelForState()
//                .modelFile(models().getExistingFile(modLoc("block/cake/" + block.getId().getPath())))
//                .addModel();
    }
}
