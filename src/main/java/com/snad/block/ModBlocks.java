package com.snad.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks 
{
	public static final SnadBlock SNAD = new SnadBlock(
		FabricBlockSettings
		.of(Material.AGGREGATE)
		.hardness(0.5f)
		.ticksRandomly()
        .sounds(BlockSoundGroup.SAND)
    );
}
