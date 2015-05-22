package com.bjm904.feyMod.init;

import com.bjm904.feyMod.help.RegisterHelper;
import com.bjm904.feyMod.items.GenericItem;
import com.bjm904.feyMod.items.Orbs;

import net.minecraft.item.Item;

public class ModItems {
	public static Item lectross = new GenericItem().setUnlocalizedName("lectross");
	public static Item lunar = new Orbs().setUnlocalizedName("lunar");
	public static Item solsteim = new Orbs().setUnlocalizedName("solsteim");
    public static void init()
    {
    	RegisterHelper.registerItem(lectross);
    	RegisterHelper.registerItem(solsteim);
    	RegisterHelper.registerItem(lunar);
    }
}
