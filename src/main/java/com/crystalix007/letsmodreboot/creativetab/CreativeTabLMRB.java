package com.crystalix007.letsmodreboot.creativetab;

import com.crystalix007.letsmodreboot.init.ModItems;
import com.crystalix007.letsmodreboot.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabLMRB
{
	public static final CreativeTabs LMRB_TAB = new CreativeTabs(Reference.MOD_ID)
	{
		@Override
		public Item getTabIconItem()
		{
			return ModItems.mapleLeaf;
		}

		@Override
		public String getTranslatedTabLabel()
		{
			return Reference.MOD_NAME;
		}
	};
}
