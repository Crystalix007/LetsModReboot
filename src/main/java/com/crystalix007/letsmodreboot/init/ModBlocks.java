package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.block.BlockFlag;
import com.crystalix007.letsmodreboot.block.BlockLMRB;
import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final BlockLMRB flag = new BlockFlag();

	public static void init()
	{
		GameRegistry.registerBlock(flag, "flag");
	}
}
