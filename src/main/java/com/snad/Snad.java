package com.snad;

import com.snad.block.ModBlocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Snad implements ModInitializer
{

	public static final String MOD_ID = "snad";

	@Override
	public void onInitialize()
	{
		Registry.register
		(
			Registry.BLOCK, 
			new Identifier(MOD_ID, "snad"), ModBlocks.SNAD
		);

		Registry.register
		(
			Registry.ITEM,
			new Identifier(MOD_ID, "snad"), 
			new BlockItem(ModBlocks.SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS))
		);

	}

}
