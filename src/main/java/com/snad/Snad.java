package com.snad;

import com.snad.registry.ModBlocks;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class Snad implements ModInitializer
{

	public static final String MOD_ID = "snad";

	public static Identifier identifier(String name)
	{
		if (name.indexOf(':') >= 0)
			return new Identifier(name);
		return new Identifier(MOD_ID, name);
	}

	@Override
	public void onInitialize()
	{
		ModBlocks.registerBlocks();
	}

}
