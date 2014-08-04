package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.item.ItemLMRB;
import com.crystalix007.letsmodreboot.item.ItemMapleLeaf;
import com.crystalix007.letsmodreboot.item.ItemSpinelPickaxe;
import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemLMRB mapleLeaf = new ItemMapleLeaf();
    public static Item.ToolMaterial spinelMaterial = EnumHelper.addToolMaterial("spinelMaterial", 4, 3000, 12, 7, 0);
    public static final ItemPickaxe spinelPickaxe = new ItemSpinelPickaxe(spinelMaterial);

	public static void init()
	{
		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        GameRegistry.registerItem(spinelPickaxe, "spinelPickaxe");
	}
}
