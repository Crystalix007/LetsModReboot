package com.crystalix007.letsmodreboot.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInvisiGlass extends TileEntity
{
	public byte red;
	public byte green;
	public byte blue;
	public float alpha;
	public float currentAlpha;
	public boolean debug = false;

	public TileEntityInvisiGlass()
	{
		super();
		red = 0;
		green = 0;
		blue = 0;
		alpha = 0.5f;
		currentAlpha = alpha;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		compound.setByte("red", red);
		compound.setByte("green", green);
		compound.setByte("blue", blue);
		compound.setFloat("alpha", alpha);
		compound.setFloat("currentAlpha", currentAlpha);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);

		red = compound.getByte("red");
		green = compound.getByte("green");
		blue = compound.getByte("blue");
		alpha = compound.getFloat("alpha");
		currentAlpha = compound.getFloat("currentFloat");
	}

	@Override
	public boolean shouldRenderInPass(int pass)
	{
		return true;
	}
}