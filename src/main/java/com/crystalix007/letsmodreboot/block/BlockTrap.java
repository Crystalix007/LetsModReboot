package com.crystalix007.letsmodreboot.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockTrap extends BlockGlassLMRB {
	public BlockTrap() {
		super("blockTrap");
		this.setBlockName("blockTrap");
		this.lightOpacity = 0;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
	}

	@Override //Makes it able to be walked through
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
}