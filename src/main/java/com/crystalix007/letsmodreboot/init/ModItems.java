package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.item.ItemLMRB;
import com.crystalix007.letsmodreboot.item.ItemMapleLeaf;
import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemLMRB mapleLeaf = new ItemMapleLeaf();

	public static void init()
	{
		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");

	}
}
