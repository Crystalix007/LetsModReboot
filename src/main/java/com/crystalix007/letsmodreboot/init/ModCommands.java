package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.command.CommandDetermineTime;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class ModCommands
{
	public static void init(FMLServerStartingEvent event){
		event.registerServerCommand(new CommandDetermineTime());
		return;
	}
}
