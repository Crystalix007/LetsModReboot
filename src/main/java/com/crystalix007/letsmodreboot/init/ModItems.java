package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.handler.ConfigurationHandler;
import com.crystalix007.letsmodreboot.item.*;
import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemLMRB mapleLeaf = new ItemMapleLeaf();

    //Tool materials
    public static Item.ToolMaterial spinelMaterial = EnumHelper.addToolMaterial("spinelMaterial", 4, 3000, 12, 7, 0);
    public static Item.ToolMaterial siliconNitrideMaterial = EnumHelper.addToolMaterial("siliconNitrideMaterial", 5, 8000, 20, 10, 30);

    //Tools
    public static final ItemPickaxeLMRB spinelPickaxe = new ItemSpinelPickaxe(spinelMaterial);
    public static final ItemPickaxeLMRB siliconNitridePickaxe = new ItemSiliconNitridePickaxe(siliconNitrideMaterial);
    public static final Item itemNewBow = new ItemNewBow();

	public static void init()
	{
		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        GameRegistry.registerItem(spinelPickaxe, "spinelPickaxe");
        GameRegistry.registerItem(siliconNitridePickaxe, "siliconNitridePickaxe");

        GameRegistry.registerItem(itemNewBow, "newBow");
	}
}
