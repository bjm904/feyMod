package com.bjm904.feyMod;

import com.bjm904.feyMod.init.ModBlocks;
import com.bjm904.feyMod.init.ModFluids;
import com.bjm904.feyMod.init.ModItems;
import com.bjm904.feyMod.init.ModTools;
import com.bjm904.feyMod.crafting.Recipies;
import com.bjm904.feyMod.help.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class feyMod {
	
	@SidedProxy(clientSide = "com.bjm904.feyMod.ClientProxy", serverSide = "com.bjm904.feyMod.ServerProxy")
	public static ServerProxy proxy;
	
	@Instance(Reference.MODID)
	public static feyMod modInstance;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModFluids.init();
		ModItems.init();
		ModTools.init();
		ModBlocks.init();
		Recipies.init();
		proxy.registerTileEntites();
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		proxy.registerNetworkStuff();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
