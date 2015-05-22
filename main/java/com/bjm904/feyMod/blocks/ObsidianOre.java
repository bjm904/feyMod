package com.bjm904.feyMod.blocks;

import java.util.ArrayList;
import java.util.Random;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.tabs.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ObsidianOre extends Block{

	public static Item drop;
	public ObsidianOre(Item drop, String name) {
		super(Material.rock);
		this.drop=drop;
		setBlockName(name);
		setBlockTextureName(Reference.MODID+":"+getUnlocalizedName().substring(5));
    	setCreativeTab(ModTabs.tabFeyMod);
    	setStepSound(Blocks.obsidian.stepSound);
		setHardness(50F);
		setResistance(200F);
		setHarvestLevel(Blocks.obsidian.getHarvestTool(0), Blocks.obsidian.getHarvestLevel(0));
	}

    public Item getItemDropped(int p_149650_1_, Random random, int p_149650_3_)
    {
        return Items.diamond;
    }
    
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        ret.add(new ItemStack(drop, 1, 0));
        ret.add(new ItemStack(Blocks.obsidian, 1, 0));
        
        /*int count = quantityDropped(metadata, fortune, world.rand);
        for(int i = 0; i < count; i++)
        {
            Item item = getItemDropped(metadata, world.rand, fortune);
            if (item != null)
            {
                ret.add(new ItemStack(item, 1, damageDropped(metadata)));
            }
        }*/
        return ret;
    }
}
