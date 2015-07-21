package com.crystalix007.letsmodreboot.creativetab;

import com.crystalix007.letsmodreboot.init.InitModItems;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabsLMRB
{
	public static final CreativeTabs LMRB_TAB = new CreativeTabs(ReferenceMod.MOD_ID.toLowerCase())
	{
		@Override
		public Item getTabIconItem()
		{
			return InitModItems.itemMapleLeaf;
		}
	};

	public static final CreativeTabs MECHANICAL_TAB = new CreativeTabs(ReferenceMod.MOD_ID.toLowerCase() + ":mechanical") {
		@Override
		public Item getTabIconItem() {
			return InitModItems.itemGenerator;
		}
	};
}