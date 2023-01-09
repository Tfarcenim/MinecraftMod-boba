package com.kmek.bobamod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WaffleIronBlock extends Block {
    private static final VoxelShape SHAPE = makeShape();

    public WaffleIronBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public static VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0.0625, 0.0625, 0.875, 0.125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.125, 0.25, 0.0625, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0.125, 0.8125, 0.0625, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.6875, 0.25, 0.0625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0.6875, 0.8125, 0.0625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 0.125, 0.0625, 0.875, 0.1875, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.125, 0.0625, 0.1875, 0.1875, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.125, 0.75, 0.8125, 0.1875, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.125, 0.0625, 0.8125, 0.1875, 0.125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.09375, 0, 0.625, 0.1875, 0.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.125, 0.8125, 0.375, 0.1875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.125, 0.8125, 0.6875, 0.1875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.09375, 0.046875, 0.25, 0.15625, 0.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.1875, 0.8125, 0.875, 0.9375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 0.1875, 0.75, 0.875, 0.9375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.1875, 0.75, 0.1875, 0.9375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.1875, 0.75, 0.8125, 0.25, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.875, 0.75, 0.8125, 0.9375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.9375, 0.75, 0.625, 1, 0.84375), BooleanOp.OR);
        return shape;
    }
}
