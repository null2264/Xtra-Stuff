package com.xtra.stuff.block;

import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BambooBlock;
import net.minecraft.block.BambooSaplingBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CactusBlock;

public class SnadBlock extends FallingBlock
{
    public SnadBlock()
    {
        super(
            FabricBlockSettings
            .of(Material.AGGREGATE)
            .hardness(0.5f)
            .ticksRandomly()
            .sounds(BlockSoundGroup.SAND)
        );
    }

    @Override
    public boolean hasRandomTicks(BlockState state)
    {
        return true;
    }

    public boolean isPlant(Block block)
    {
        return (block instanceof SugarCaneBlock || block instanceof CactusBlock || block instanceof BambooSaplingBlock || block instanceof BambooBlock);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        super.randomTick(state, world, pos, random);

        Block blockAbove = world.getBlockState(pos.up()).getBlock();
        
        if (isPlant(blockAbove))
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
                        // TODO: Make growth speed configuration.
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
