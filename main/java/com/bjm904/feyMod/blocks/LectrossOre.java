package com.bjm904.feyMod.blocks;

import java.util.Random;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.init.ModBlocks;
import com.bjm904.feyMod.init.ModItems;
import com.bjm904.feyMod.tabs.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class LectrossOre extends Block{
	public LectrossOre(){
    	super(Material.rock);
    	setBlockName("lectrossOre");
    	setBlockTextureName(Reference.MODID+":"+getUnlocalizedName().substring(5));
    	setCreativeTab(ModTabs.tabFeyMod);
    	setStepSound(soundTypeStone);
		setHardness(3.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 3);
    }
    public int quantityDropped(Random random)
    {
    	Random r = new Random();
    	float chance = r.nextFloat();
    	if (chance <= 0.25f) return 2;
    	else return 1;
    	
    }

    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return ModItems.lectross;
    }
}
