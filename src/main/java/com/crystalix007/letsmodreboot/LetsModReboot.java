package com.crystalix007.letsmodreboot;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = "LetsModReboot", name = "Lets Mod Reboot", version = "1.7.2-1.0")

public class LetsModReboot
{
	@Mod.Instance("LetsModReboot")
	public static LetsModReboot instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)    //Network handling, mod config, items and blocks init
	{

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)  //Register GUIs, TileEntities, crafting recipes, general even handlers
	{

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)  //Things you want to do after other mods have loaded
	{

	}
}