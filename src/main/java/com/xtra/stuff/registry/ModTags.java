package com.xtra.stuff.registry;

import com.xtra.stuff.XtraStuff;

import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;

public class ModTags {
    
    public static final Tag<Block> SNAD = TagRegistry.block(XtraStuff.identifier("snad"));
    
}
