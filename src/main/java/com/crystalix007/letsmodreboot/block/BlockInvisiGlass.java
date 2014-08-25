package com.crystalix007.letsmodreboot.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class BlockInvisiGlass extends BlockGlassLMRB
{

	public BlockInvisiGlass()
	{
		super("invisiGlass");
		this.setBlockName("invisiGlass");
	}

	/*@Override //Makes it able to be walked through
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}*/

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
	}
}
