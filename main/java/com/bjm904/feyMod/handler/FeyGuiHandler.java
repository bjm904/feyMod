package com.bjm904.feyMod.handler;

import com.bjm904.feyMod.container.ContainerPolarityChanger;
import com.bjm904.feyMod.gui.GuiPolarityChanger;
import com.bjm904.feyMod.tileEntities.TileEntityPolarityChanger;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class FeyGuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID==0){
			TileEntityPolarityChanger tileentitypolaritychanger = (TileEntityPolarityChanger) world.getTileEntity(x, y, z);
			return new ContainerPolarityChanger(player.inventory, tileentitypolaritychanger);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID==0){
			TileEntityPolarityChanger tileentitypolaritychanger = (TileEntityPolarityChanger) world.getTileEntity(x, y, z);
			return new GuiPolarityChanger(player.inventory, tileentitypolaritychanger);
		}
		return null;
	}

}
