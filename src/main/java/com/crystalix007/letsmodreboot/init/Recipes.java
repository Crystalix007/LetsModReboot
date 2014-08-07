package com.crystalix007.letsmodreboot.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {
	public static void init() {
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.mapleLeaf), " X ", "XOX", " O ", 'X', new ItemStack(Blocks.leaves), 'O', new ItemStack(Items.stick));
		//GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.flag), new ItemStack(ModItems.mapleLeaf), new ItemStack(ModItems.mapleLeaf));
		//Using ore dictionary to allow mod compatibility
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mapleLeaf), " X ", "XOX", " O ", 'X', "treeLeaves", 'O', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.spinelPickaxe), "XXX", " | ", " | ", 'X', new ItemStack(ModItems.spinelIngot), '|', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.siliconNitridePickaxe), "XXX", " | ", " | ", 'X', new ItemStack(ModItems.siliconNitrideIngot), '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemNewBow), "s/ ", "s /", "s/ ", 's', ModItems.darkString, '/', new ItemStack(ModItems.siliconNitrideIngot)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.heavyHammer), "###", "#|#", " | ", '#', new ItemStack(ModBlocks.siliconNitride), '|', "stickWood"));

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.flag), "stickWood", new ItemStack(ModItems.mapleLeaf)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.carrotAmmo), "gunpowder", "cropCarrot"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.darkString), "dyeBlack", "string"));

		GameRegistry.addSmelting(new ItemStack(Blocks.obsidian), new ItemStack(ModBlocks.spinel), 0.5f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.spinel), new ItemStack(ModBlocks.siliconNitride), 0.75f);
		GameRegistry.addSmelting(new ItemStack(ModItems.spinelDust), new ItemStack(ModItems.spinelIngot), 0.5f);
		GameRegistry.addSmelting(new ItemStack(ModItems.siliconNitrideDust), new ItemStack(ModItems.siliconNitrideIngot), 0.75f);
	}
}