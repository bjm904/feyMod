package com.bjm904.feyMod;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.tileEntities.TileEntityPolarityChanger;

import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy {
	public void registerTileEntites(){
		GameRegistry.registerTileEntity(TileEntityPolarityChanger.class, Reference.MODID + "TileEntityPolarityChanger");
	}
}
