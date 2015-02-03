package com.crystalix007.letsmodreboot.block;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public abstract class BlockContainerLMRB extends BlockLMRB implements ITileEntityProvider {
	protected BlockContainerLMRB(Material material) {
		super(material);
		this.isBlockContainer = true;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int i) {
		super.breakBlock(world, x, y, z, block, i);
		world.removeTileEntity(x, y, z);
	}

	@Override
	public boolean onBlockEventReceived(World world, int x, int y, int z, int i, int i1) {
		super.onBlockEventReceived(world, x, y, z, i, i1);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		return (tileentity != null && tileentity.receiveClientEvent(i, i1));
	}
}
