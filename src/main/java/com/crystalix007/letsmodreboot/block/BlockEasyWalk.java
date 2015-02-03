package com.crystalix007.letsmodreboot.block;

import net.minecraft.block.material.Material;

public class BlockEasyWalk extends BlockLMRB
{
	public BlockEasyWalk()
	{
		super(Material.cloth);
		this.setBlockName("blockEasyWalk");
		this.slipperiness = 0.3f;
	}
}
