package com.xtra.stuff.block;

import java.util.Random;
import java.util.stream.IntStream;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class CobblestoneGenerator extends Block
{
    private int TICK_SPEED = 20;

    public CobblestoneGenerator()
    {
        super
        (
            FabricBlockSettings
            .of(Material.STONE)
            .strength(3.5f, 3.5f)
            .breakByTool(FabricToolTags.PICKAXES)
            .breakByHand(false)
        );
    }

    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random)
    {
        if (!world.isClient)
        {
            Direction dir = Direction.DOWN;
            BlockPos invBlockPos = pos.offset(dir);
            BlockState invBlockState = world.getBlockState(invBlockPos);
            Block invBlock = invBlockState.getBlock();
            if (invBlock.hasBlockEntity())
            {
                BlockEntity blockEntity = world.getBlockEntity(pos.offset(dir));
                if (blockEntity instanceof HopperBlockEntity)
                {
                    Inventory inv = HopperBlockEntity.getInventoryAt(world, invBlockPos);
                    if (!isInventoryFull(inv, dir))
                    {
                        getAvailableSlots(inv, dir).anyMatch((int_i) ->{
                            ItemStack is = inv.getStack(int_i);
                            if (is.getItem() == Items.AIR) {
                                is = new ItemStack(Blocks.COBBLESTONE, 1);
                                inv.setStack(int_i, is);
                                return true;
                            } else if (is.getCount() < is.getMaxCount()) {
                                is.increment(1);
                                inv.setStack(int_i, is);
                                return true;
                            }
                            return false;
                        });
                    }
                    world.getBlockTickScheduler().schedule(pos, this, TICK_SPEED);
                }
            }
        }
    }
    
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos pos2, boolean notify)
    {
        Block block2 = world.getBlockState(pos2.up()).getBlock();
        if (block2 == this);
        {
            block = world.getBlockState(pos2).getBlock();
            if (block == Blocks.HOPPER)
            {
                world.getBlockTickScheduler().schedule(pos, this, TICK_SPEED);
            }
        }
    }
    
    private boolean isInventoryFull(Inventory inventory, Direction direction) {
        return getAvailableSlots(inventory, direction).allMatch((int_1) -> {
            ItemStack itemStack = inventory.getStack(int_1);
            return itemStack.getCount() >= itemStack.getMaxCount();
        });
    }
    
    private static IntStream getAvailableSlots(Inventory inventory, Direction direction)
    {
        return inventory instanceof SidedInventory ? IntStream.of(((SidedInventory)inventory).getAvailableSlots(direction)) : IntStream.range(0, inventory.size());
    }
    
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity entity, ItemStack itemStack)
    {
        world.getBlockTickScheduler().schedule(pos, this, TICK_SPEED);
    }

}
