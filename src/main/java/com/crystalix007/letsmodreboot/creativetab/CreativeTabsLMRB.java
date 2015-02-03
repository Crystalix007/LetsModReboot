package com.crystalix007.letsmodreboot.creativetab;

import com.crystalix007.letsmodreboot.init.ModItems;
import com.crystalix007.letsmodreboot.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsLMRB
{
	public static final CreativeTabs LMRB_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.mapleLeaf;
		}
	};

	public static final CreativeTabs MECHANICAL_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase() + ":mechanical") {
		@Override
		public Item getTabIconItem() {
			return ModItems.itemGenerator;
		}
	};
}