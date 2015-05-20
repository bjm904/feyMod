package com.bjm904.feyMod.init;


import com.bjm904.feyMod.help.RegisterHelper;
import com.bjm904.feyMod.items.Maquahuitl;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class ModTools {
	public static Item maquahuitlWood = new Maquahuitl(ToolMaterial.WOOD).setUnlocalizedName("maquahuitlWood");
	public static Item maquahuitlStone = new Maquahuitl(ToolMaterial.STONE).setUnlocalizedName("maquahuitlStone");
	public static Item maquahuitlIron = new Maquahuitl(ToolMaterial.IRON).setUnlocalizedName("maquahuitlIron");
	public static Item maquahuitlGold = new Maquahuitl(ToolMaterial.GOLD).setUnlocalizedName("maquahuitlGold");
	public static Item maquahuitlDiamond = new Maquahuitl(ToolMaterial.EMERALD).setUnlocalizedName("maquahuitlDiamond");
    public static void init()
    {
    	RegisterHelper.registerItem(maquahuitlWood);
    	RegisterHelper.registerItem(maquahuitlStone);
    	RegisterHelper.registerItem(maquahuitlIron);
    	RegisterHelper.registerItem(maquahuitlGold);
    	RegisterHelper.registerItem(maquahuitlDiamond);
    }
}
