package com.bjm904.feyMod.init;

import com.bjm904.feyMod.feyMod;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModGen {
	public static void init(){
		GameRegistry.registerWorldGenerator(feyMod.genore, 1);
	}
}
