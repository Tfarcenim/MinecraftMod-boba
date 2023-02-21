package com.kmek.minecafe.block.custom.crop;

import com.kmek.minecafe.block.ModBlocksInit;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class CassavaCropBlock extends CropBlock {
    private static final int maxAge = 7;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, maxAge);

    public CassavaCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModBlocksInit.CASSAVA_CROP.get().asItem();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return maxAge;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
