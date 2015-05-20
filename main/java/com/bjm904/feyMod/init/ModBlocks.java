package com.bjm904.feyMod.init;

import com.bjm904.feyMod.blocks.LectrossOre;
import com.bjm904.feyMod.blocks.PolarityChanger;
import com.bjm904.feyMod.help.RegisterHelper;

import net.minecraft.block.Block;

public class ModBlocks {
	public static Block lectrossOre = new LectrossOre();
	public static Block polarityChanger = new PolarityChanger(false).setBlockName("polarityChanger");;
	public static Block polarityChangerOn = new PolarityChanger(true).setBlockName("polarityChangerOn");;
    public static void init(){
    	RegisterHelper.registerBlock(lectrossOre);
    	RegisterHelper.registerBlock(polarityChanger);
    	RegisterHelper.registerBlock(polarityChangerOn);
    }
}
