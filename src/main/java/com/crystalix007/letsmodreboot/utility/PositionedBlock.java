package com.crystalix007.letsmodreboot.utility;

import net.minecraft.block.Block;

public class PositionedBlock /*extends Block*/ {
	public final int xPos, yPos, zPos;
	public final Block block;

	public PositionedBlock(Block block, int x, int y, int z) {
		/*super(block.getMaterial());*/
		xPos = x;
		yPos = y;
		zPos = z;
		this.block = block;
	}

	public Block getBlock()
	{
		return block;
	}
}
