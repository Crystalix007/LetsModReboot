package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.tileentities.TileEntityFrame;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFrame extends BlockLMRB implements ITileEntityProvider
{
	public BlockFrame()
	{
		super();
		this.setBlockName("blockFrame");
		this.isBlockContainer = true;

		float pixelSize = 1.f/16.f;
		float minSize = 2.f * pixelSize;
		float maxSize = 1.f - minSize;

		this.setBlockBounds(minSize, minSize, minSize, maxSize, maxSize, maxSize);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
	{
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityFrame();
	}

	public boolean hasTileEntity(int metadata)
	{
		return true;
	}

	@Override //Makes it able to be walked through
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		float pixel = 1.f / 16.f;
		float min = 5.f * pixel;
		float max = 1.f - min;
		return AxisAlignedBB.getBoundingBox(x + min, y, z + min, x + max, y + 1, z + max);
	}
}
