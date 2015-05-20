package com.bjm904.feyMod;

import com.bjm904.feyMod.handler.FeyGuiHandler;
import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.tileEntities.TileEntityPolarityChanger;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	public void registerNetworkStuff(){
		NetworkRegistry.INSTANCE.registerGuiHandler(feyMod.modInstance, new FeyGuiHandler());
	}
	
	public void registerTileEntites(){
		GameRegistry.registerTileEntity(TileEntityPolarityChanger.class, Reference.MODID + "TileEntityPolarityChanger");
	}
}
