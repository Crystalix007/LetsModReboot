package com.crystalix007.letsmodreboot.tileentity;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityLockdown extends TileEntity
{
	protected Block subBlock;
	protected int metadata;
	protected TileEntity tileEntity;
	protected boolean isTop = false;

	public void setSubBlock(Block theBlock)
	{
		subBlock = theBlock;
		tileEntity = null;
	}

	public void setSubBlock(Block theBlock, TileEntity theTileEntity)
	{
		subBlock = theBlock;
		tileEntity = theTileEntity;
	}

	public void setSubBlock(Block theBlock, boolean isTopBlock)
	{
		subBlock = theBlock;
		tileEntity = null;
		isTop = isTopBlock;
	}

	public void setSubBlock(Block theBlock, TileEntity theTileEntity, boolean isTopBlock)
	{
		subBlock = theBlock;
		tileEntity = theTileEntity;
		isTop = isTopBlock;
	}

	public Block getSubBlock()
	{
		return subBlock;
	}

	public TileEntity getTileEntity()
	{
		return tileEntity;
	}

	public void replaceBlock()
	{
		if (subBlock != null)
			worldObj.setBlock(xCoord, yCoord - 1, zCoord, getSubBlock());

		if (tileEntity != null)
			worldObj.setTileEntity(xCoord, yCoord - 1, zCoord, getTileEntity());
	}

	public boolean isTop()
	{
		return isTop;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		//ClientProxy.printMessageToPlayer("TE at " + String.valueOf(xCoord) + ", " + String.valueOf(yCoord) + ", " + String.valueOf(zCoord) + " just read NBT");

		isTop = compound.getBoolean("isTop");
		subBlock = Block.getBlockFromItem(ItemStack.loadItemStackFromNBT(compound).getItem());

		//ClientProxy.printMessageToPlayer("TE at " + String.valueOf(xCoord) + ", " + String.valueOf(yCoord) + ", " + String.valueOf(zCoord) + " " + (subBlock == null ? "contains" : "doesn't contain") + " a null block");

		tileEntity = TileEntity.createAndLoadEntity(compound);
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		compound.setBoolean("isTop", isTop);

		if (subBlock != null) {
			ItemStack blockStack = new ItemStack(subBlock);
			blockStack.writeToNBT(compound);
		}

		if (tileEntity != null)
			tileEntity.writeToNBT(compound);
	}
}
