package com.github.talrey.createdeco.blocks;

import com.mojang.serialization.MapCodec;
import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.MultifaceSpreader;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import org.jetbrains.annotations.NotNull;

public class FacadeBlock extends MultifaceBlock implements IWrenchable, SimpleWaterloggedBlock {
  private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
  private final MultifaceSpreader spreader = new MultifaceSpreader(this);

  public static final MapCodec<FacadeBlock> CODEC = simpleCodec(FacadeBlock::new);

  public FacadeBlock(Properties properties) {
    super(properties);
    this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, false));
  }

  protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
    super.createBlockStateDefinition(builder);
    builder.add(WATERLOGGED);
  }

  public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
    if (state.getValue(WATERLOGGED)) {
      level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
    }

    return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
  }


  public FluidState getFluidState(BlockState state) {
    return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
  }

  public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
    return state.getFluidState().isEmpty();
  }

  public MultifaceSpreader getSpreader() {
    return this.spreader;
  }

  @Override
  public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
    return true;
  }

  @Override
  public boolean isValidStateForPlacement(BlockGetter level, BlockState state, BlockPos pos, Direction direction) {
    return true;
  }

  @Override
  public @NotNull MapCodec<? extends FacadeBlock> codec() {
      return CODEC;
  }
}
