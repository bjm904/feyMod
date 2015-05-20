package com.bjm904.feyMod.tabs;

import com.bjm904.feyMod.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class FeyModTab extends CreativeTabs{
	String name;
	
	public FeyModTab(int par1, String par2Str){
		super(par1, par2Str);
		this.name = par2Str;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem(){
		if (this.name == "tabFeyMod"){
			return ModItems.lectross;
		} /*else if (this.name == "tabAscensionTest"){
			return ModStructureItems.spawnAbandonedHouse;
		}*/
		return null;
	}
}
