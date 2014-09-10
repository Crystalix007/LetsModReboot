package com.crystalix007.letsmodreboot.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemInvisiGlass extends ItemBlock
{
	public ItemInvisiGlass(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int meta)
	{
		return meta;
	}
}
