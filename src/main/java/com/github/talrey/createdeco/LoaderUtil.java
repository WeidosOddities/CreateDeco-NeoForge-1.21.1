package com.github.talrey.createdeco;

import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.item.ItemHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;

public class LoaderUtil {
    public static int getSignal(IBE<?> be, BlockState pState, Level pLevel, BlockPos pPos) {
        return be.getBlockEntityOptional(pLevel, pPos)
                .map(blockEntity -> {
                    if (blockEntity instanceof Container container) {
                        return ItemHelper.calcRedstoneFromInventory((IItemHandler) container);
                    }
                    return 0;
                })
                .orElse(0);
    }

    public static boolean checkPlacingNbt (BlockPlaceContext ctx) {
        return true;
    }
}
