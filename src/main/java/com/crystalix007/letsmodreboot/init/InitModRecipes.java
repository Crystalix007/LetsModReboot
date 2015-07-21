package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.recipes.RecipeEnderStaff;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class InitModRecipes {
	public static void init() {
		//Using ore dictionary to allow mod compatibility
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.itemMapleLeaf), " X ", "XOX", " O ", 'X', "treeLeaves", 'O', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.itemSpinelPickaxe), "XXX", " | ", " | ", 'X', new ItemStack(InitModItems.itemSpinelIngot), '|', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.siliconNitridePickaxe), "XXX", " | ", " | ", 'X', new ItemStack(InitModItems.itemSiliconNitrideIngot), '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.itemNewBow), "s/ ", "s /", "s/ ", 's', InitModItems.itemDarkString, '/', new ItemStack(InitModItems.itemSiliconNitrideIngot)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.heavyHammer), "###", "#|#", " | ", '#', new ItemStack(InitModBlocks.blockSiliconNitride), '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModBlocks.blockFrame), "###", "#/#", "###", '#', "ingotIron", '/', "stickWood"));

		//Adding positionless recipe of teleport staff
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.itemEnderStaff), "O  ", " | ", "   ", 'O', "enderEye", '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.itemEnderStaff), " O ", "  |", "   ", 'O', "enderEye", '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.itemEnderStaff), "   ", "O  ", " | ", 'O', "enderEye", '|', "stickWood"));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitModItems.itemEnderStaff), "   ", " O ", "  |", 'O', "enderEye", '|', "stickWood"));

		//Repair recipe for the ender staff
		GameRegistry.addRecipe(new RecipeEnderStaff());

		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(InitModBlocks.blockFlag), "stickWood", new ItemStack(InitModItems.itemMapleLeaf)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(InitModItems.itemCarrotAmmo), "gunpowder", "cropCarrot"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(InitModItems.itemDarkString), "dyeBlack", "string"));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(InitModItems.itemTeleportArrow), "arrow", "enderPearl"));

		GameRegistry.addSmelting(new ItemStack(Blocks.obsidian), new ItemStack(InitModBlocks.blockSpinel), 0.5f);
		GameRegistry.addSmelting(new ItemStack(InitModBlocks.blockSpinel), new ItemStack(InitModBlocks.blockSiliconNitride), 0.75f);
		GameRegistry.addSmelting(new ItemStack(InitModItems.itemSpinelDust), new ItemStack(InitModItems.itemSpinelIngot), 0.5f);
		GameRegistry.addSmelting(new ItemStack(InitModItems.itemSiliconNitrideDust), new ItemStack(InitModItems.itemSiliconNitrideIngot), 0.75f);
		GameRegistry.addSmelting(new ItemStack(Blocks.glass), new ItemStack(InitModBlocks.blockInvisiGlass), 0.f);
	}
}