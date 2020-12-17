package com.snad.mixin;

import java.util.Iterator;

import com.snad.block.ModBlocks;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.CactusBlock;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.WorldView;

@Mixin(CactusBlock.class)
public class CactusMixin extends Block {
    public CactusMixin(Settings settings) {
        super(settings);
    }
    
    @Overwrite
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        System.out.println("test");
        Iterator<Direction> var4 = Direction.Type.HORIZONTAL.iterator();

        Direction direction;
        Material material;
        do {
            if (!var4.hasNext()) {
                BlockState blockState2 = world.getBlockState(pos.down());
                System.out.println("test2");
                return (blockState2.isOf(Blocks.CACTUS) || blockState2.isIn(BlockTags.SAND) || blockState2.isIn(ModBlocks.TAG_SNAD)) && !world.getBlockState(pos.up()).getMaterial().isLiquid();
            }

            direction = (Direction)var4.next();
            BlockState blockState = world.getBlockState(pos.offset(direction));
            material = blockState.getMaterial();
        } while(!material.isSolid() && !world.getFluidState(pos.offset(direction)).isIn(FluidTags.LAVA));

        return false;
    }
}