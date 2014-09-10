package com.crystalix007.letsmodreboot.material;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class MaterialHidden extends Material
{

	public MaterialHidden()
	{
		super(MapColor.airColor);
	}

	public MaterialHidden(MapColor mapColor)
	{
		super(mapColor);
	}

	public boolean isToolNotRequired()
	{
		return true;
	}

	@Override
	public boolean getCanBlockGrass()
	{
		return false;
	}

	@Override
	public int getMaterialMobility()
	{
		return 0;
	}
}
