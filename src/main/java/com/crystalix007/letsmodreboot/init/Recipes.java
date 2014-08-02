package com.crystalix007.letsmodreboot.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes
{
	public static void init()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.mapleLeaf), " X ", "XOX", " O ", 'X', new ItemStack(Blocks.leaves), 'O', new ItemStack(Items.stick));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.flag), new ItemStack(ModItems.mapleLeaf), new ItemStack(ModItems.mapleLeaf));
	}
}
