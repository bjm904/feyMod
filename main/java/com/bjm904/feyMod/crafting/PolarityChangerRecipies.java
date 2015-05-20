package com.bjm904.feyMod.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.bjm904.feyMod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PolarityChangerRecipies{
    private static final PolarityChangerRecipies smeltingBase = new PolarityChangerRecipies();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static PolarityChangerRecipies smelting(){
        return smeltingBase;
    }

    private PolarityChangerRecipies(){
        //this.addRecipie(Blocks.sand, new ItemStack(Blocks.glass), 0.1F); //Use for blocks
        this.addLists(ModItems.solsteim, new ItemStack(ModItems.lunar), 0.35F);
        this.addLists(ModItems.lunar, new ItemStack(ModItems.solsteim), 0.35F);
    }

    public void addRecipie(Block block, ItemStack itemstack, float experience)
    {
        this.addLists(Item.getItemFromBlock(block), itemstack, experience);
    }

    public void addLists(Item item, ItemStack itemstack, float experience)
    {
        this.putLists(new ItemStack(item, 1, 32767), itemstack, experience);
    }

    public void putLists(ItemStack itemstack, ItemStack itemstack2, float experience)
    {
        this.smeltingList.put(itemstack, itemstack2);
        this.experienceList.put(itemstack2, Float.valueOf(experience));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack itemstack){
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do{
            if (!iterator.hasNext()){
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.canBeSmelted(itemstack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean canBeSmelted(ItemStack itemstack, ItemStack itemstack2){
        return itemstack2.getItem() == itemstack.getItem() && (itemstack2.getItemDamage() == 32767 || itemstack2.getItemDamage() == itemstack.getItemDamage());
    }

    public Map getSmeltingList(){
        return this.smeltingList;
    }

    public float giveExperience(ItemStack itemstack){
        float ret = itemstack.getItem().getSmeltingExperience(itemstack);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do{
            if (!iterator.hasNext()){
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.canBeSmelted(itemstack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}