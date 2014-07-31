package com.crystalix007.letsmodreboot;
import com.crystalix007.letsmodreboot.handler.ConfigurationHandler;
import com.crystalix007.letsmodreboot.proxy.IProxy;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

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
		LogHelper.info("Pre-initialization complete");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)  //Register GUIs, TileEntities, crafting recipes, general even handlers
	{
		LogHelper.info("Initialization complete");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)  //Things you want to do after other mods have loaded
	{
		LogHelper.info("Post-initialization complete");
	}
}