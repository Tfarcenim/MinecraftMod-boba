package com.kmek.minecafe.block;

import com.kmek.minecafe.block.entity.DisplayCaseBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class DisplayCaseBlock extends CustomMenuEntityBlock<DisplayCaseBlockEntity> {
    public DisplayCaseBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    /**
     * Block Entity Stuff
     */

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new DisplayCaseBlockEntity(pos, state);
    }

    @Override
    protected boolean isBlockEntity(BlockEntity blockEntity) {
        return blockEntity instanceof DisplayCaseBlockEntity;
    }
}
