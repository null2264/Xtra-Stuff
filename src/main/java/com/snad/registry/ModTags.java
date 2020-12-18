package com.snad.registry;

import com.snad.Snad;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class ModTags {
    
    public static final Tag<Block> SNAD = TagRegistry.block(Snad.identifier("snad"));
    
}
