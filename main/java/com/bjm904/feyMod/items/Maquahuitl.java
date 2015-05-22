package com.bjm904.feyMod.items;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.tabs.ModTabs;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemSword;

public class Maquahuitl extends ItemSword{
	
	private float field_150934_a;
	public final ToolMaterial toolMaterial;
	
	public Maquahuitl(ToolMaterial EnumToolMaterial) {
		super(EnumToolMaterial);
		toolMaterial = EnumToolMaterial;
		this.field_150934_a = 12.0F + toolMaterial.getDamageVsEntity();
		setCreativeTab(ModTabs.tabFeyMod);
	}
	
    public Multimap getItemAttributeModifiers(){
    	Multimap multimap = HashMultimap.create();
	    multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.field_150934_a, 0));
	    return multimap;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister){
		this.itemIcon=par1IconRegister.registerIcon(Reference.MODID+":"+getUnlocalizedName().substring(5));
	}
}
