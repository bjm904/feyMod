package com.bjm904.feyMod.init;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {
	public static Fluid specialWater = new Fluid("specialWater");
	public static void init(){
		FluidRegistry.registerFluid(specialWater);
	}
}
