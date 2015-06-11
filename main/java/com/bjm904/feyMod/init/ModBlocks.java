package com.bjm904.feyMod.init;

import com.bjm904.feyMod.blocks.BlockSpecialWater;
import com.bjm904.feyMod.blocks.LectrossOre;
import com.bjm904.feyMod.blocks.ObsidianOre;
import com.bjm904.feyMod.blocks.PolarityChanger;
import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.help.RegisterHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public class ModBlocks {
	public static Block lectrossOre = new LectrossOre();;
	public static Block polarityChanger = new PolarityChanger(false).setBlockName("polarityChanger");
	public static Block polarityChangerOn = new PolarityChanger(true).setBlockName("polarityChangerOn");
	public static Block specialWaterBlock = new BlockSpecialWater(ModFluids.specialWater, Material.water).setBlockName("specialwater");
	public static Block obsidianDiamondOre = new ObsidianOre(Items.diamond, "obsidianDiamondOre");
	public static Block obsidianLectrossOre = new ObsidianOre(ModItems.lectross, "obsidianLectrossOre");
    public static void init(){
    	RegisterHelper.registerBlock(lectrossOre);
    	OreDictionary.registerOre("lectrossOre", lectrossOre);
    	RegisterHelper.registerBlock(polarityChanger);
    	RegisterHelper.registerBlock(polarityChangerOn);
    	RegisterHelper.registerBlock(specialWaterBlock);
    	RegisterHelper.registerBlock(obsidianDiamondOre);
    	RegisterHelper.registerBlock(obsidianLectrossOre);
    	ModFluids.specialWater.setUnlocalizedName(specialWaterBlock.getUnlocalizedName());
    }
}
