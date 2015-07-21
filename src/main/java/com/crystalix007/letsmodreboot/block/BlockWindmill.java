package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.tileentity.TileEntityWindmill;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWindmill extends BlockContainerLMRB {
	public BlockWindmill() {
		super(Material.iron);
		setBlockName("blockWindmill");
		setCreativeTab(CreativeTabsLMRB.MECHANICAL_TAB);
		setHarvestLevel("pickaxe", 1);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int x) {
		return new TileEntityWindmill();
	}
}