package com.bjm904.feyMod.blocks;

import com.bjm904.feyMod.help.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class LectrossOre extends Block{
	public LectrossOre(){
    	super(Material.rock);
    	setBlockName("lectrossOre");
    	setBlockTextureName(Reference.MODID+":"+getUnlocalizedName().substring(5));
    	setCreativeTab(CreativeTabs.tabBlock);
    }
}
