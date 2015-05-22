package com.bjm904.feyMod.items;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.init.ModItems;
import com.bjm904.feyMod.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Orbs extends Item{
	public Orbs(){
		super();
		setCreativeTab(ModTabs.tabFeyMod);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister){
		itemIcon=par1IconRegister.registerIcon(Reference.MODID+":"+getUnlocalizedName().substring(5));
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player){
		if (itemstack.getItem()==ModItems.solsteim) world.setWorldTime(1800);
		else world.setWorldTime(13000);
		itemstack=itemstack.splitStack(itemstack.stackSize-1);
		player.knockBack(player, 10, 1, 1);
		return itemstack;
	}
}
