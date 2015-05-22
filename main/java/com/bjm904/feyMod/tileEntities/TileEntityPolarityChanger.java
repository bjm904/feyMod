package com.bjm904.feyMod.tileEntities;

import com.bjm904.feyMod.blocks.PolarityChanger;
import com.bjm904.feyMod.crafting.PolarityChangerRecipies;
import com.bjm904.feyMod.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityPolarityChanger extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    /** The ItemStacks that hold the items currently being used in the furnace */
    private ItemStack[] polarityChangerItemStacks = new ItemStack[3];
    /** The number of ticks that the furnace will keep burning */
    public int furnaceBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    public int currentItemBurnTime;
    /** The number of ticks that the current item has been cooking for */
    public int furnaceCookTime;
    private String furnaceName;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory(){
        return this.polarityChangerItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int slot){
        return this.polarityChangerItemStacks[slot];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2){
        if (this.polarityChangerItemStacks[par1] != null){
            ItemStack itemstack;

            if (this.polarityChangerItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.polarityChangerItemStacks[par1];
                this.polarityChangerItemStacks[par1] = null;
                return itemstack;
            }
            else{
                itemstack = this.polarityChangerItemStacks[par1].splitStack(par2);

                if (this.polarityChangerItemStacks[par1].stackSize == 0){
                    this.polarityChangerItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else{
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1){
        if (this.polarityChangerItemStacks[par1] != null){
            ItemStack itemstack = this.polarityChangerItemStacks[par1];
            this.polarityChangerItemStacks[par1] = null;
            return itemstack;
        }
        else{
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int slot, ItemStack itemstack){
        this.polarityChangerItemStacks[slot] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
        	itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName(){
        return this.hasCustomInventoryName() ? this.furnaceName : "container.polarityChanger";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName(){
        return this.furnaceName != null && this.furnaceName.length() > 0;
    }

    public void furnaceName(String p_145951_1_){
        this.furnaceName = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound tagCompound){
        super.readFromNBT(tagCompound);
        NBTTagList nbttaglist = tagCompound.getTagList("Items", 10);
        this.polarityChangerItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i){
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.polarityChangerItemStacks.length){
                this.polarityChangerItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.furnaceBurnTime = tagCompound.getShort("BurnTime");
        this.furnaceCookTime = tagCompound.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.polarityChangerItemStacks[1]);

        if (tagCompound.hasKey("CustomName", 8)){
            this.furnaceName = tagCompound.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound tagCompound){
        super.writeToNBT(tagCompound);
        tagCompound.setShort("BurnTime", (short)this.furnaceBurnTime);
        tagCompound.setShort("CookTime", (short)this.furnaceCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.polarityChangerItemStacks.length; ++i){
            if (this.polarityChangerItemStacks[i] != null){
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.polarityChangerItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        tagCompound.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName()){
            tagCompound.setString("CustomName", this.furnaceName);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit(){
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int par1){
        return this.furnaceCookTime * par1 / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int par1){
        if (this.currentItemBurnTime == 0){
            this.currentItemBurnTime = 200;
        }
        return this.furnaceBurnTime * par1 / this.currentItemBurnTime;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning(){
        return this.furnaceCookTime > 0;
    }

    public void updateEntity(){
        boolean flag = this.furnaceBurnTime > 0;
        boolean flag1 = false;

        if (!this.worldObj.isRemote){
        	if (this.polarityChangerItemStacks[1] != null && this.furnaceBurnTime < 50){
        		int burn = getItemBurnTime(polarityChangerItemStacks[1]);
        		if(burn>0){
	        		if(this.polarityChangerItemStacks[1].getItem()==Items.blaze_rod) this.polarityChangerItemStacks[1].stackSize=this.polarityChangerItemStacks[1].stackSize-5;
	        		else --this.polarityChangerItemStacks[1].stackSize;
	                this.furnaceBurnTime+=burn;
        		}
                if (this.polarityChangerItemStacks[1].stackSize == 0){
                    this.polarityChangerItemStacks[1] = polarityChangerItemStacks[1].getItem().getContainerItem(polarityChangerItemStacks[1]);
                }
            }
        	
            if (this.furnaceBurnTime != 0 || this.polarityChangerItemStacks[1] != null && this.polarityChangerItemStacks[0] != null){
                if (this.furnaceBurnTime == 0 && this.canSmelt()){
                    this.currentItemBurnTime = getItemBurnTime(this.polarityChangerItemStacks[1]);

                    if (this.furnaceBurnTime > 0){
                        flag1 = true;
                    }
                }

                if (this.furnaceBurnTime>0 && this.canSmelt()){
                    ++this.furnaceCookTime;
                    if ((furnaceCookTime==0 || furnaceCookTime%40==0) && this.furnaceBurnTime > 0){
                        this.furnaceBurnTime-=1;
                    }
                    if (this.furnaceCookTime == 200){
                        this.furnaceCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                } else{
                    this.furnaceCookTime = 0;
                }
            }

            if (flag != this.furnaceBurnTime > 0){
                flag1 = true;
                PolarityChanger.updateBlockState(this.isBurning(), this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1){
            this.markDirty();
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt(){
        if (this.polarityChangerItemStacks[0] == null){
            return false;
        } else{
            ItemStack itemstack = PolarityChangerRecipies.smelting().getSmeltingResult(this.polarityChangerItemStacks[0]);
            if (itemstack == null) return false;
            if (this.polarityChangerItemStacks[2] == null) return true;
            if (!this.polarityChangerItemStacks[2].isItemEqual(itemstack)) return false;
            int result = polarityChangerItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.polarityChangerItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem(){
        if (this.canSmelt()){
            ItemStack itemstack = PolarityChangerRecipies.smelting().getSmeltingResult(this.polarityChangerItemStacks[0]);

            if (this.polarityChangerItemStacks[2] == null){
                this.polarityChangerItemStacks[2] = itemstack.copy();
            } else if (this.polarityChangerItemStacks[2].getItem() == itemstack.getItem()){
                this.polarityChangerItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.polarityChangerItemStacks[0].stackSize;

            if (this.polarityChangerItemStacks[0].stackSize <= 0){
                this.polarityChangerItemStacks[0] = null;
            }
            
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack itemstack){
        if (itemstack == null){
            return 0;
        } else{
            Item item = itemstack.getItem();
            /*if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){//Use this if you need to burn blocks
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab){
                    return 150;
                }

                if (block.getMaterial() == Material.wood){
                    return 300;
                }

                if (block == Blocks.coal_block){
                    return 16000;
                }
            }*/

            //if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;//Use if you want all of a type
            if (item == ModItems.lectross) return 1;
            
            if (item == Items.blaze_rod){
            	if(itemstack.stackSize>4) return 1;
            }
            return 0;
        }
    }

    public static boolean isItemFuel(ItemStack itemstack){
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(itemstack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player){
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {
    	
    }

    public void closeInventory() {
    	
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int par1, ItemStack itemstack){
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(itemstack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int par1){
        return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int par1, ItemStack itemstack, int par3){
        return this.isItemValidForSlot(par1, itemstack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int par1, ItemStack itemstack, int par3){
        return par3 != 0 || par1 != 1 || itemstack.getItem() == Items.bucket;//Can remove bucket unless using liquid as fuel
    }
}