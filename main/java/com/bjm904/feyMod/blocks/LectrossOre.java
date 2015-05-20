package com.bjm904.feyMod.blocks;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.tabs.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class LectrossOre extends Block{
	public LectrossOre(){
    	super(Material.rock);
    	setBlockName("lectrossOre");
    	setBlockTextureName(Reference.MODID+":"+getUnlocalizedName().substring(5));
    	setCreativeTab(ModTabs.tabFeyMod);
    	setStepSound(soundTypeStone);
		setHardness(2.5F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 3);
    }
}
