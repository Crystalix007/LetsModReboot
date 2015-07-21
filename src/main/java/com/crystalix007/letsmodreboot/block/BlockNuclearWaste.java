package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.tileentity.TileEntityNuclearWaste;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockNuclearWaste extends BlockLMRB implements ITileEntityProvider
{
	public BlockNuclearWaste()
	{
		super(Material.lava);
		setBlockName("blockNuclearWaste");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int v) {
		return new TileEntityNuclearWaste();
	}

	@Override
	public void onBlockPreDestroy(World world, int x, int y, int z, int v)
	{
		TileEntity te = world.getTileEntity(x, y, z);

		if (te != null && !world.isRemote)
			world.removeTileEntity(x, y, z);

		super.onBlockPreDestroy(world, x, y, z, v);
	}
}
