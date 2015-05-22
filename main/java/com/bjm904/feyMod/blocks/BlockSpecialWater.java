package com.bjm904.feyMod.blocks;

import java.io.IOException;
import java.util.Random;

import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.init.ModBlocks;
import com.bjm904.feyMod.init.ModFluids;
import com.bjm904.feyMod.tabs.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSpecialWater extends BlockFluidClassic {

    @SideOnly(Side.CLIENT)
    protected IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    protected IIcon flowingIcon;
    
    public BlockSpecialWater(Fluid fluid, Material material) {
            super(fluid, material);
            setCreativeTab(ModTabs.tabFeyMod);
    }
    
    @Override
    public IIcon getIcon(int side, int meta) {
            return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }
    
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
            stillIcon = register.registerIcon(Reference.MODID+":"+getUnlocalizedName().substring(5)+"_still");
            flowingIcon = register.registerIcon(Reference.MODID+":"+getUnlocalizedName().substring(5)+"_flow");
    }
    
    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.canDisplace(world, x, y, z);
    }
    
    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
            if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
            return super.displaceIfPossible(world, x, y, z);
    }
    
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        this.func_149805_n(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_);
    }

    private void func_149805_n(World p_149805_1_, int p_149805_2_, int p_149805_3_, int p_149805_4_)
    {
        if (p_149805_1_.getBlock(p_149805_2_, p_149805_3_, p_149805_4_) == this)
        {
                boolean flag = false;

                if (flag || p_149805_1_.getBlock(p_149805_2_, p_149805_3_, p_149805_4_ - 1).getMaterial() == Material.lava)
                {
                    flag = true;
                }

                if (flag || p_149805_1_.getBlock(p_149805_2_, p_149805_3_, p_149805_4_ + 1).getMaterial() == Material.lava)
                {
                    flag = true;
                }

                if (flag || p_149805_1_.getBlock(p_149805_2_ - 1, p_149805_3_, p_149805_4_).getMaterial() == Material.lava)
                {
                    flag = true;
                }

                if (flag || p_149805_1_.getBlock(p_149805_2_ + 1, p_149805_3_, p_149805_4_).getMaterial() == Material.lava)
                {
                    flag = true;
                }

                if (flag || p_149805_1_.getBlock(p_149805_2_, p_149805_3_ + 1, p_149805_4_).getMaterial() == Material.lava)
                {
                    flag = true;
                }

                if (flag)
                {
                    int l = p_149805_1_.getBlockMetadata(p_149805_2_, p_149805_3_, p_149805_4_);

                    if (l == 0)
                    {
                    	Random r = new Random();
                    	float chance = r.nextFloat();
                    	if (chance <= 0.10f) p_149805_1_.setBlock(p_149805_2_, p_149805_3_, p_149805_4_, ModBlocks.obsidianDiamondOre);
                    	else p_149805_1_.setBlock(p_149805_2_, p_149805_3_, p_149805_4_, ModBlocks.obsidianLectrossOre);
                        
                    }
                    else if (l <= 4)
                    {
                        //p_149805_1_.setBlock(p_149805_2_, p_149805_3_, p_149805_4_, Blocks.cobblestone);
                    }

                    this.func_149799_m(p_149805_1_, p_149805_2_, p_149805_3_, p_149805_4_);
                }
        }
    }
    
    protected void func_149799_m(World p_149799_1_, int p_149799_2_, int p_149799_3_, int p_149799_4_)
    {
        p_149799_1_.playSoundEffect((double)((float)p_149799_2_ + 0.5F), (double)((float)p_149799_3_ + 0.5F), (double)((float)p_149799_4_ + 0.5F), "random.fizz", 0.5F, 2.6F + (p_149799_1_.rand.nextFloat() - p_149799_1_.rand.nextFloat()) * 0.8F);

        for (int l = 0; l < 8; ++l)
        {
            p_149799_1_.spawnParticle("largesmoke", (double)p_149799_2_ + Math.random(), (double)p_149799_3_ + 1.2D, (double)p_149799_4_ + Math.random(), 0.0D, 0.0D, 0.0D);
        }
    }
}