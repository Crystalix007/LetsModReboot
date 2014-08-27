package com.crystalix007.letsmodreboot.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInvisiGlass extends TileEntity
{
	public short red;
	public short green;
	public short blue;

	public TileEntityInvisiGlass()
	{
		super();
		red = 0;
		green = 0;
		blue = 0;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		compound.setByte("red", (byte)(red - 128));
		compound.setByte("green", (byte)(green - 128));
		compound.setByte("blue", (byte)(blue - 128));
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		red = (byte)(compound.getByte("red") + 128);
		green = (byte)(compound.getByte("green") + 128);
		blue = (byte)(compound.getByte("blue") + 128);
	}
}