package com.crystalix007.letsmodreboot.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class InitModOreDictionary
{
	public static void init()
	{
		//Items
		OreDictionary.registerOre("string", Items.string);
		OreDictionary.registerOre("gunpowder", Items.gunpowder);
		OreDictionary.registerOre("enderEye", Items.ender_eye);
		OreDictionary.registerOre("enderPearl", Items.ender_pearl);
		OreDictionary.registerOre("bonemeal", new ItemStack(Items.dye, OreDictionary.WILDCARD_VALUE, 15));

		//Blocks
		OreDictionary.registerOre("blockObsidian", Blocks.obsidian);
	}
}