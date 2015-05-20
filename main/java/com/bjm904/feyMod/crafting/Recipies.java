package com.bjm904.feyMod.crafting;

import com.bjm904.feyMod.init.ModItems;
import com.bjm904.feyMod.init.ModTools;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipies {
	public static void init(){
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModTools.maquahuitlWood, 1), new Object[] {"OOO", "OWO", " P ", 'O', Blocks.obsidian, 'W', "logWood", 'P', "plankWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModTools.maquahuitlStone, 1), new Object[] {"OOO", "OWO", " P ", 'O', Blocks.obsidian, 'W', "stone", 'P', "plankWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModTools.maquahuitlIron, 1), new Object[] {"OOO", "OWO", " P ", 'O', Blocks.obsidian, 'W', "blockIron", 'P', "plankWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModTools.maquahuitlGold, 1), new Object[] {"OOO", "OWO", " P ", 'O', Blocks.obsidian, 'W', "blockGold", 'P', "plankWood"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModTools.maquahuitlDiamond, 1), new Object[] {"OOO", "OWO", " P ", 'O', Blocks.obsidian, 'W', "blockDiamond", 'P', "plankWood"}));
	}
}