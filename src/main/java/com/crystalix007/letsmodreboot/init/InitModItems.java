package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.item.*;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

@GameRegistry.ObjectHolder(ReferenceMod.MOD_ID)
public class InitModItems
{
	//Items
	public static final ItemLMRB itemMapleLeaf = new ItemMapleLeaf();
    public static final ItemLMRB itemCarrotAmmo = new ItemCarrotAmmo();
	public static final ItemLMRB itemSpinelDust = new ItemSpinelDust();
	public static final ItemLMRB itemSiliconNitrideDust = new ItemSiliconNitrideDust();
	public static final ItemLMRB itemSiliconNitrideIngot = new ItemSiliconNitrideIngot();
	public static final ItemLMRB itemSpinelIngot = new ItemSpinelIngot();
	public static final ItemLMRB itemTeleportArrow = new ItemTeleportArrow();
	public static final ItemLMRB itemGenerator = new ItemGenerator();
	public static final ItemLMRB itemWindmill = new ItemWindmill();

	//Irregular inheritance items
	public static final Item itemDarkString = new ItemDarkString();

    //Tool materials
    public static Item.ToolMaterial materialSpinel = EnumHelper.addToolMaterial("materialSpinel", 4, 3000, 12, 7, 0);
    public static Item.ToolMaterial materialSiliconNitride = EnumHelper.addToolMaterial("materialSiliconNitride", 5, 8000, 20, 10, 30);

    //Tools
    public static final ItemPickaxeLMRB itemSpinelPickaxe = new ItemSpinelPickaxe(materialSpinel);
    public static final ItemPickaxeLMRB siliconNitridePickaxe = new ItemSiliconNitridePickaxe(materialSiliconNitride);
	public static final ItemPickaxeLMRB heavyHammer = new ItemHeavyHammer();
	public static final ItemLMRB itemDebugTool = new ItemDebugTool();
	public static final ItemLMRB itemEnderStaff = new ItemEnderStaff();

	//Bows
	public static final Item itemNewBow = new ItemNewBow();

	public static void init()
	{
		//Items
		GameRegistry.registerItem(itemMapleLeaf, "itemMapleLeaf");
        GameRegistry.registerItem(itemCarrotAmmo, "itemCarrotAmmo");
		GameRegistry.registerItem(itemSpinelDust, "itemSpinelDust");
		GameRegistry.registerItem(itemSiliconNitrideDust, "itemSiliconNitrideDust");
		GameRegistry.registerItem(itemSiliconNitrideIngot, "itemSiliconNitrideIngot");
		GameRegistry.registerItem(itemSpinelIngot, "itemSpinelIngot");
		GameRegistry.registerItem(itemTeleportArrow, "itemTeleportArrow");
		GameRegistry.registerItem(itemGenerator, "itemGenerator");
		GameRegistry.registerItem(itemWindmill, "itemWindmill");

		//Irregular inheritance items
		GameRegistry.registerItem(itemDarkString, "itemDarkString");

		//Tools
        GameRegistry.registerItem(itemSpinelPickaxe, "itemSpinelPickaxe");
        GameRegistry.registerItem(siliconNitridePickaxe, "itemSiliconNitridePickaxe");
		GameRegistry.registerItem(heavyHammer, "itemHeavyHammer");
		GameRegistry.registerItem(itemDebugTool, "itemDebugTool");
		GameRegistry.registerItem(itemEnderStaff, "itemEnderStaff");

		//Bows
        GameRegistry.registerItem(itemNewBow, "itemNewBow");
	}
}
