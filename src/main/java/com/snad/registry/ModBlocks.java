package com.snad.registry;

import com.snad.Snad;
import com.snad.block.SnadBlock;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks 
{
	public static final SnadBlock SNAD = new SnadBlock();
	public static final SnadBlock RED_SNAD = new SnadBlock();

	
	public static void registerBlocks()
	{
		// Blocks
		Registry.register(Registry.BLOCK, new Identifier(Snad.MOD_ID, "snad"), SNAD);
		Registry.register(Registry.BLOCK, new Identifier(Snad.MOD_ID, "red_snad"), RED_SNAD);
		
		// Items
        Registry.register(Registry.ITEM, new Identifier(Snad.MOD_ID, "snad"), new BlockItem(SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
        Registry.register(Registry.ITEM, new Identifier(Snad.MOD_ID, "red_snad"), new BlockItem(RED_SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	}
}
