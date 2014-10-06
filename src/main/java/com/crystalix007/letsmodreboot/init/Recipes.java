package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.recipes.EnderStaffRecipe;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {
	public static void init() {
		//Using ore dictionary to allow mod compatibility
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.mapleLeaf), " X ", "XOX", " O ", 'X', "treeLeaves", 'O', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.spinelPickaxe), "XXX", " | ", " | ", 'X', new ItemStack(ModItems.spinelIngot), '|', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.siliconNitridePickaxe), "XXX", " | ", " | ", 'X', new ItemStack(ModItems.siliconNitrideIngot), '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.itemNewBow), "s/ ", "s /", "s/ ", 's', ModItems.darkString, '/', new ItemStack(ModItems.siliconNitrideIngot)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.heavyHammer), "###", "#|#", " | ", '#', new ItemStack(ModBlocks.siliconNitride), '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.frameBlock), "###", "#/#", "###", '#', "ingotIron", '/', "stickWood"));

		//Adding positionless recipe of teleport staff
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.enderStaff), "O  ", " | ", "   ", 'O', "enderEye", '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.enderStaff), " O ", "  |", "   ", 'O', "enderEye", '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.enderStaff), "   ", "O  ", " | ", 'O', "enderEye", '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.enderStaff), "   ", " O ", "  |", 'O', "enderEye", '|', "stickWood"));

		//Repair recipe for the ender staff
		GameRegistry.addRecipe(new EnderStaffRecipe());

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.flag), "stickWood", new ItemStack(ModItems.mapleLeaf)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.carrotAmmo), "gunpowder", "cropCarrot"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.darkString), "dyeBlack", "string"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.teleportArrow), "arrow", "enderPearl"));

		GameRegistry.addSmelting(new ItemStack(Blocks.obsidian), new ItemStack(ModBlocks.spinel), 0.5f);
		GameRegistry.addSmelting(new ItemStack(ModBlocks.spinel), new ItemStack(ModBlocks.siliconNitride), 0.75f);
		GameRegistry.addSmelting(new ItemStack(ModItems.spinelDust), new ItemStack(ModItems.spinelIngot), 0.5f);
		GameRegistry.addSmelting(new ItemStack(ModItems.siliconNitrideDust), new ItemStack(ModItems.siliconNitrideIngot), 0.75f);
		GameRegistry.addSmelting(new ItemStack(Blocks.glass), new ItemStack(ModBlocks.invisiGlass), 0.f);
	}
}