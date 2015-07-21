package com.crystalix007.letsmodreboot.recipes;

import com.crystalix007.letsmodreboot.init.InitModItems;
import com.crystalix007.letsmodreboot.utility.UtilityLogHelper;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnderPearl;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class RecipeEnderStaff extends ShapelessOreRecipe
{
	static final int enderEyeRepairModifier = 80;
	boolean foundStaff = false;
	int enderEyes = 0;
	ItemStack enderStaff;

	public RecipeEnderStaff() {
		super(new ItemStack(InitModItems.itemEnderStaff, 1, InitModItems.itemEnderStaff.getMaxDamage() - enderEyeRepairModifier), new ItemStack(InitModItems.itemEnderStaff, 1, OreDictionary.WILDCARD_VALUE), Items.ender_pearl);
	}

	@Override
	public boolean matches(InventoryCrafting inventoryCrafting, World world) {
		foundStaff = false;
		enderEyes = 0;

		for (int i = 0; i < inventoryCrafting.getSizeInventory(); i++)
		{
			ItemStack itemStack = inventoryCrafting.getStackInSlot(i);

			if (itemStack == null)
				continue;

			Item item = itemStack.getItem();

			if (item != null)
			{
				if (item == InitModItems.itemEnderStaff && !foundStaff) {
					foundStaff = true;
					enderStaff = itemStack.copy();
				}
				//else if (OreDictionary.getOres("enderEye").contains(itemStack))
				else if (item instanceof ItemEnderPearl)
					enderEyes++;
				else
					return false;
			}
		}

		boolean matchesRecipe = (foundStaff && (enderEyes > 0));
		UtilityLogHelper.info("The recipe " + (matchesRecipe ? "matches" : "doesn't match") + " the expected recipe");

		return matchesRecipe;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inventory) {
		ItemStack enderStaff = null;
		int enderCount = 0;

		for (int i = 0; i < inventory.getSizeInventory(); i++) {
			ItemStack stack = inventory.getStackInSlot(i);
			if (stack == null) continue;

			Item item = stack.getItem();
			if (item == InitModItems.itemEnderStaff)
				enderStaff = stack;
			else if (item instanceof ItemEnderPearl)
				enderCount++;
		}

		if (enderStaff == null)
			return null;

		ItemStack result = enderStaff.copy();
		result.setItemDamage(enderStaff.getItemDamage() - enderCount * enderEyeRepairModifier);
		return result;
	}
}
