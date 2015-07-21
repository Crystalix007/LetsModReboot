package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.tileentity.TileEntityRamp;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.List;

public class BlockRamp extends BlockLMRB implements ITileEntityProvider
{
	public BlockRamp()
	{
		super();
		this.setBlockName("blockRamp");
		this.setBlockTextureName("blockRamp");
	}

	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAlignedBB, List list, Entity entity)
	{
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityRamp();
	}

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}
}
