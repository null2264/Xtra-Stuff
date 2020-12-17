package com.snad;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Snad implements ModInitializer
{

	public static final FallingBlock SNAD = new FallingBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC).hardness(0.5f));
	
	@Override
	public void onInitialize()
	{
		Registry.register(Registry.BLOCK, new Identifier("snad", "snad"), SNAD);
		Registry.register(Registry.ITEM, new Identifier("snad", "snad"), new BlockItem(SNAD, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
		System.out.println("Hello Fabric world!");
	}

}
