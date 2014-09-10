package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.item.*;
import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
	public static final ItemLMRB mapleLeaf = new ItemMapleLeaf();
    public static final ItemLMRB carrotAmmo = new ItemCarrotAmmo();
	public static final Item darkString = new ItemDarkString();
	public static final ItemLMRB spinelDust = new ItemSpinelDust();
	public static final ItemLMRB siliconNitrideDust = new ItemSiliconNitrideDust();
	public static final ItemLMRB siliconNitrideIngot = new ItemSiliconNitrideIngot();
	public static final ItemLMRB spinelIngot = new ItemSpinelIngot();
	public static final ItemLMRB teleportArrow = new ItemTeleportArrow();
	public static final ItemLMRB debugTool = new ItemDebugTool();

    //Tool materials
    public static Item.ToolMaterial spinelMaterial = EnumHelper.addToolMaterial("spinelMaterial", 4, 3000, 12, 7, 0);
    public static Item.ToolMaterial siliconNitrideMaterial = EnumHelper.addToolMaterial("siliconNitrideMaterial", 5, 8000, 20, 10, 30);

    //Tools
    public static final ItemPickaxeLMRB spinelPickaxe = new ItemSpinelPickaxe(spinelMaterial);
    public static final ItemPickaxeLMRB siliconNitridePickaxe = new ItemSiliconNitridePickaxe(siliconNitrideMaterial);
	public static final ItemPickaxeLMRB heavyHammer = new ItemHeavyHammer();
    public static final Item itemNewBow = new ItemNewBow();
	public static final ItemLMRB enderStaff = new ItemEnderStaff();

	public static void init()
	{
		OreDictionary.registerOre("string", Items.string);
		OreDictionary.registerOre("gunpowder", Items.gunpowder);

		GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        GameRegistry.registerItem(carrotAmmo, "carrotAmmo");
		GameRegistry.registerItem(darkString, "darkString");
		GameRegistry.registerItem(spinelDust, "spinelDust");
		GameRegistry.registerItem(siliconNitrideDust, "siliconNitrideDust");
		GameRegistry.registerItem(siliconNitrideIngot, "siliconNitrideIngot");
		GameRegistry.registerItem(spinelIngot, "spinelIngot");
		GameRegistry.registerItem(teleportArrow, "teleportArrow");

        GameRegistry.registerItem(spinelPickaxe, "spinelPickaxe");
        GameRegistry.registerItem(siliconNitridePickaxe, "siliconNitridePickaxe");
		GameRegistry.registerItem(heavyHammer, "heavyHammer");
		GameRegistry.registerItem(debugTool, "debugTool");
		GameRegistry.registerItem(enderStaff, "enderStaff");

        GameRegistry.registerItem(itemNewBow, "newBow");
	}
}
