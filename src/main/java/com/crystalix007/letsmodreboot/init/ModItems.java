package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.item.ItemLMRB;
import com.crystalix007.letsmodreboot.item.ItemMapleLeaf;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by Michael on 01/08/2014.
 */
public class ModItems
{
	public static final ItemLMRB mapleLeaf = new ItemMapleLeaf();

	public static void init()
	{
		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");

	}
}
