package com.bjm904.feyMod.gui;

import org.lwjgl.opengl.GL11;

import com.bjm904.feyMod.container.ContainerPolarityChanger;
import com.bjm904.feyMod.help.Reference;
import com.bjm904.feyMod.tileEntities.TileEntityPolarityChanger;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiPolarityChanger extends GuiContainer{
	
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(Reference.MODID, "textures/gui/polarityChanger.png");
	private TileEntityPolarityChanger tileFurnace;

	public GuiPolarityChanger(InventoryPlayer invPlayer, TileEntityPolarityChanger tile) {
		super(new ContainerPolarityChanger(invPlayer, tile));
		this.tileFurnace = tile;
		
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		String string = this.tileFurnace.hasCustomInventoryName() ? this.tileFurnace.getInventoryName() : I18n.format(this.tileFurnace.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(string, this.xSize / 2 - this.fontRendererObj.getStringWidth(string)/2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	        int i1;

	        if (this.tileFurnace.isBurning()){
	           // i1 = this.tileFurnace.getBurnTimeRemainingScaled(32);
	           // this.drawTexturedModalRect(k + 21, l + 35 + 31 - i1, 176, 31 + 31 - i1, 16, i1 + 2);
	        }
	        //int amt=tileFurnace.getBurnTimeRemainingScaled(51);
	        int amt=tileFurnace.furnaceBurnTime;
	        if(amt>0){
		        for(int i = 0; i < amt; ++i){
		        	int row=0;
		        	int rem=i;
		        	if(i>=5){
		        		row=1;
		        		rem=i-5;
		        	}
		        	if(i>=10){
		        		row=2;
		        		rem=i-10;
		        	}
		        	if(i>=15){
		        		row=3;
		        		rem=i-15;
		        	}
		        	if(i>=20){
		        		row=4;
		        		rem=i-20;
		        	}
		        	if(i>=25){
		        		row=5;
		        		rem=i-25;
		        	}
		        	if(i>=30){
		        		row=6;
		        		rem=i-30;
		        	}
		        	if(i>=35){
		        		row=7;
		        		rem=i-35;
		        	}
		        	if(i>=40){
		        		row=8;
		        		rem=i-40;
		        	}
		        	if(i>=45){
		        		row=9;
		        		rem=i-45;
		        	}
		        	
		        	int col=4;
		        	if(rem==0) col=4;
		        	if(rem==1) col=3;
		        	if(rem==2) col=2;
		        	if(rem==3) col=1;
		        	if(rem==4) col=0;
		        	this.drawTexturedModalRect(k + 21 + (col*3+1), l + 35 + 31 - (row*3+3), 177, 32, 2, 2);
		        }
	        }

	        i1 = this.tileFurnace.getCookProgressScaled(24);
	        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}
}
