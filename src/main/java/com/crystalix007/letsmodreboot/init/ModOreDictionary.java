package com.crystalix007.letsmodreboot.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreDictionary;

public class ModOreDictionary
{
	public static void init()
	{
		//Items
		OreDictionary.registerOre("string", Items.string);
		OreDictionary.registerOre("gunpowder", Items.gunpowder);
		OreDictionary.registerOre("enderEye", Items.ender_eye);
		OreDictionary.registerOre("enderPearl", Items.ender_pearl);

		//Blocks
		OreDictionary.registerOre("blockObsidian", Blocks.obsidian);
	}
}
