package com.crystalix007.letsmodreboot;

import com.crystalix007.letsmodreboot.handler.ConfigurationHandler;
import com.crystalix007.letsmodreboot.init.ModBlocks;
import com.crystalix007.letsmodreboot.init.ModEntities;
import com.crystalix007.letsmodreboot.init.ModItems;
import com.crystalix007.letsmodreboot.init.Recipes;
import com.crystalix007.letsmodreboot.proxy.IProxy;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class LetsModReboot
{
	@Mod.Instance(Reference.MOD_ID)
	public static LetsModReboot instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)    //Network handling, mod config, items and blocks init
	{
		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

		//Init items
		ModItems.init();
		//Init blocks
		ModBlocks.init();

		LogHelper.info("Pre-initialization complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)  //Register GUIs, TileEntities, crafting recipes, general even handlers
	{
		Recipes.init();
		ModEntities.init();

		LogHelper.info("Initialization complete");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)  //Things you want to do after other mods have loaded
	{
		for (String oreName : OreDictionary.getOreNames())
			LogHelper.info("Id: "+ OreDictionary.getOreID(oreName) + ", name: " + oreName);

		LogHelper.info("Post-initialization complete");
	}
}