package com.xtra.stuff.registry;

import com.xtra.stuff.XtraStuff;
import com.xtra.stuff.block.*;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks 
{
	public static final SnadBlock SNAD = new SnadBlock();
	public static final SnadBlock RED_SNAD = new SnadBlock();
	public static final RedstoneClockBlock REDSTONE_CLOCK = new RedstoneClockBlock();
	public static final DetectorBlock DETECTOR_BLOCK = new DetectorBlock();
	public static final BreakerBlock BREAKER_BLOCK = new BreakerBlock();
	
	public static void registerBlocks()
	{
		Registry.register(Registry.BLOCK, new Identifier(XtraStuff.MOD_ID, "snad"), SNAD);
		Registry.register(Registry.BLOCK, new Identifier(XtraStuff.MOD_ID, "red_snad"), RED_SNAD);
		Registry.register(Registry.BLOCK, new Identifier(XtraStuff.MOD_ID, "redstone_clock"), REDSTONE_CLOCK);
		Registry.register(Registry.BLOCK, new Identifier(XtraStuff.MOD_ID, "detector_block"), DETECTOR_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(XtraStuff.MOD_ID, "breaker_block"), BREAKER_BLOCK);
	}
}
