package com.bjm904.feyMod.init;

import com.bjm904.feyMod.help.RegisterHelper;
import com.bjm904.feyMod.items.GenericItem;

import net.minecraft.item.Item;

public class ModItems {
	public static Item lectross = new GenericItem().setUnlocalizedName("lectross");
	public static Item solsteim = new GenericItem().setUnlocalizedName("solsteim");
	public static Item lunar = new GenericItem().setUnlocalizedName("lunar");
    public static void init()
    {
    	RegisterHelper.registerItem(lectross);
    	RegisterHelper.registerItem(solsteim);
    	RegisterHelper.registerItem(lunar);
    }
}
