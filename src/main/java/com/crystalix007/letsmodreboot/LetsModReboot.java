package com.crystalix007.letsmodreboot;

import com.crystalix007.letsmodreboot.client.handler.HandlerKeyInput;
import com.crystalix007.letsmodreboot.event.EventHookContainerClass;
import com.crystalix007.letsmodreboot.handler.HandlerConfiguration;
import com.crystalix007.letsmodreboot.init.*;
import com.crystalix007.letsmodreboot.proxy.IProxy;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import com.crystalix007.letsmodreboot.utility.UtilityLogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = ReferenceMod.MOD_ID, name = ReferenceMod.MOD_NAME, version = ReferenceMod.VERSION, guiFactory = ReferenceMod.GUI_FACTORY_CLASS)
public class LetsModReboot
{
	@Mod.Instance(ReferenceMod.MOD_ID)
	public static LetsModReboot instance;

	@SidedProxy(clientSide = ReferenceMod.CLIENT_PROXY_CLASS, serverSide = ReferenceMod.SERVER_PROXY_CLASS)
	public static IProxy proxy;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)    //Network handling, mod config, items and blocks init
	{
		HandlerConfiguration.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new HandlerConfiguration());

		//Registers key bindings
		proxy.registerKeyBindings();

		//Init items
		InitModItems.init();
		//Init blocks
		InitModBlocks.init();
		//Init OreDictionary stuff
		InitModOreDictionary.init();

		UtilityLogHelper.info("Pre-initialization complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)  //Register GUIs, TileEntities, crafting recipes, general, even handlers
	{
		FMLCommonHandler.instance().bus().register(new HandlerKeyInput());
		MinecraftForge.EVENT_BUS.register(new EventHookContainerClass());

		InitModRecipes.init();
		InitModEntities.init();
		InitModBlocks.registerTileEntities();

		UtilityLogHelper.info("Initialization complete");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)  //Things you want to do after other mods have loaded
	{
		for (String oreName : OreDictionary.getOreNames())
			UtilityLogHelper.info("Id: " + OreDictionary.getOreID(oreName) + ", name: " + oreName);

		UtilityLogHelper.info("Post-initialization complete");
	}

	@Mod.EventHandler
	public void serverLoad(FMLServerStartingEvent event){
		InitModCommands.init(event);
	}
}