package com.bjm904.feyMod.init;

import com.bjm904.feyMod.help.RegisterHelper;
import com.bjm904.feyMod.items.Lectross;

import net.minecraft.item.Item;

public class ModItems {
	public static Item lectross = new Lectross().setUnlocalizedName("lectross");
    public static void init()
    {
    	RegisterHelper.registerItem(lectross);
    }
}
