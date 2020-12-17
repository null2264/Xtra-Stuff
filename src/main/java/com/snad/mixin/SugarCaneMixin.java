package com.snad.mixin;

import java.util.Iterator;

import com.snad.block.ModBlocks;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SugarCaneBlock;
import net.minecraft.fluid.FluidState;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;
import net.minecraft.tag.RequiredTagList;
import net.minecraft.tag.RequiredTagListRegistry;
import net.minecraft.tag.Tag;
import net.minecraft.tag.TagManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;

@Mixin(SugarCaneBlock.class)
public class SugarCaneMixin extends Block {
    public SugarCaneMixin(Settings settings) {
        super(settings);
    }
    
    @Overwrite
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos.down());
        if (blockState.getBlock() == this) {
            return true;
        } else {
            // if (blockState.isOf(Blocks.GRASS_BLOCK) || blockState.isOf(Blocks.DIRT) || blockState.isOf(Blocks.COARSE_DIRT) || blockState.isOf(Blocks.PODZOL) || blockState.isOf(Blocks.SAND) || blockState.isOf(Blocks.RED_SAND) || blockState.isOf(ModBlocks.SNAD)) {
            if (blockState.isOf(Blocks.GRASS_BLOCK) || blockState.isOf(Blocks.DIRT) || blockState.isOf(Blocks.COARSE_DIRT) || blockState.isOf(Blocks.PODZOL) || blockState.isIn(BlockTags.SAND) || blockState.isOf(ModBlocks.SNAD)) {
                BlockPos blockPos = pos.down();
                Iterator var6 = Direction.Type.HORIZONTAL.iterator();

                while(var6.hasNext()) {
                    Direction direction = (Direction)var6.next();
                    BlockState blockState2 = world.getBlockState(blockPos.offset(direction));
                    FluidState fluidState = world.getFluidState(blockPos.offset(direction));
                    if (fluidState.isIn(FluidTags.WATER) || blockState2.isOf(Blocks.FROSTED_ICE)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}