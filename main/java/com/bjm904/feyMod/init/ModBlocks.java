package com.bjm904.feyMod.init;

import com.bjm904.feyMod.blocks.LectrossOre;
import com.bjm904.feyMod.help.RegisterHelper;

import net.minecraft.block.Block;

public class ModBlocks {
	public static Block titaniumOre = new LectrossOre();
    public static void init(){
    	RegisterHelper.registerBlock(titaniumOre);
    }
}
