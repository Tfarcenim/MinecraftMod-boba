package com.kmek.bobamod.block;

import com.kmek.bobamod.BobaMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumMap;
import java.util.Map;

public class WaffleIronBlock extends HorizontalDirectionalBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    private static final Map<Direction, VoxelShape> SHAPES = new EnumMap<>(Direction.class);
    private static final VoxelShape SHAPE = makeShape();

    public static VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0.0625, 0.0625, 0.875, 0.1875, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.125, 0.25, 0.0625, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.6875, 0.25, 0.0625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0.125, 0.8125, 0.0625, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0, 0.6875, 0.8125, 0.0625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.09375, 0, 0.625, 0.1875, 0.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.125, 0.8125, 0.375, 0.1875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 0.125, 0.8125, 0.6875, 0.1875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.09375, 0.046875, 0.25, 0.15625, 0.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.9375, 0.75, 0.625, 1, 0.84375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 0.1875, 0.75, 0.875, 0.9375, 0.875), BooleanOp.OR);
        return shape;
    }

    public WaffleIronBlock(BlockBehaviour.Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
        if (SHAPES.size() == 0)
            runCalculation(SHAPE);
    }

    protected void runCalculation(VoxelShape shape) {
        for (Direction direction : Direction.values())
            SHAPES.put(direction, BobaMod.calculateShapes(direction, shape));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }
}
