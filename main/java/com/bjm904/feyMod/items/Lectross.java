package com.bjm904.feyMod.items;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Lectross extends Item{
	public Lectross(){
		super();
		setCreativeTab(ModTabs.tabFeyMod);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister){
		itemIcon=par1IconRegister.registerIcon(Reference.MODID+":"+getUnlocalizedName().substring(5));
	}
}
