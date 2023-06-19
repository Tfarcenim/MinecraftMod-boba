package com.kmek.minecafe.block.custom;

import com.kmek.minecafe.block.CustomVoxelMenuEntityBlock;
import com.kmek.minecafe.block.entity.LunchboxBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class LunchboxBlock extends CustomVoxelMenuEntityBlock<LunchboxBlockEntity> {
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public LunchboxBlock(BlockBehaviour.Properties properties) {
        super(properties, true);
        registerDefaultState(defaultBlockState().setValue(OPEN, false));
    }

    @Override
    public VoxelShape makeShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0, 0.1875, 0.875, 0.3125, 0.8125), BooleanOp.OR);
        return shape;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
    }

    /**
     * Block Entity Stuff
     */

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new LunchboxBlockEntity(pos, state);
    }

    @Override
    protected boolean isBlockEntity(BlockEntity blockEntity) {
        return blockEntity instanceof LunchboxBlockEntity;
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide() && Minecraft.getInstance().options.keyShift.isDown()) {
//            pPlayer.sendSystemMessage(Component.literal("crouch down"));
            BlockState updated = pState.cycle(OPEN);
            pLevel.setBlock(pPos, updated, 3);
        } else if (!pLevel.isClientSide() && Minecraft.getInstance().options.keySprint.isDown()) {
//            pPlayer.sendSystemMessage(Component.literal("sprint down"));
            // todo idea eventually pick up lunchbox as item
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }
}
