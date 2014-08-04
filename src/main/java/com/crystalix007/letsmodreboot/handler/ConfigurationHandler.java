package com.crystalix007.letsmodreboot.handler;

import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
	public static Configuration configuration;
	public static boolean testValue = false;
    public static boolean alphaFeatures = true;

	public static void init(File configFile)
	{
		//Create configuration object from the given File
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) //Resync configs
		{
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		try {   //Exceptions can be thrown
			//Load configuration file
			configuration.load();

			//Read in properties from configuration file
			testValue = configuration.getBoolean("configValue", Configuration.CATEGORY_GENERAL, false, "This is an example config value");
            alphaFeatures = configuration.getBoolean("alphaFeatures", Configuration.CATEGORY_GENERAL, true, "Should alpha features be used");
		}
		catch (Exception e)
		{
			//Log the exception
		}
		finally {
			//Save configuration file
			if (configuration.hasChanged())
				configuration.save();
		}

		System.out.println("LetsModReboot: " + testValue);
	}
}
