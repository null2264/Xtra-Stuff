package com.snad.block;

import net.minecraft.block.FallingBlock;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;

public class SnadBlock extends FallingBlock
{
    public SnadBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public boolean hasRandomTicks(BlockState state)
    {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        super.randomTick(state, world, pos, random);

        Block blockAbove = world.getBlockState(pos.up()).getBlock();

        if (blockAbove instanceof SugarCaneBlock || blockAbove instanceof CactusBlock)
        {
            boolean isSameBlockType = true;
            int height = 1;

            while (isSameBlockType)
            {
                if (world.getBlockState(pos.up(height)).getBlock() != Blocks.AIR)
                {
                    Block nextPlantBlock = world.getBlockState(pos.up(height)).getBlock();
                    if (nextPlantBlock.getClass() == blockAbove.getClass())
                    {
                        for (int growthAttempts = 0; growthAttempts < 2; growthAttempts++)
                        {
                            if (growthAttempts == 0 | nextPlantBlock.canPlaceAt(state, world, pos.up()))
                            {
                                nextPlantBlock.randomTick(world.getBlockState(pos.up(height)), world, pos.up(height), random);
                            }
                        }
                        height++;
                    } else {
                        isSameBlockType = false;
                    }
                } else {
                    isSameBlockType = false;
                }
            }
        }
    }

}
