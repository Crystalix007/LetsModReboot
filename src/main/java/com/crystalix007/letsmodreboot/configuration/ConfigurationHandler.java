package com.crystalix007.letsmodreboot.configuration;

import  net.minecraftforge.common.config.Configuration;
import java.io.File;

public class ConfigurationHandler
{
	public static void init(File configFile)
	{
		//Create configuration object from the given File
		Configuration configuration = new Configuration(configFile);
		boolean configValue = false;

		try {   //Exceptions can be thrown
			//Load configuration file
			configuration.load();

			//Read in properties from configuration file
			configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example config value").getBoolean(true);
		}
		catch (Exception e)
		{
			//Log the exception
		}
		finally {
			//Save configuration file
			configuration.save();
		}

		System.out.println(configValue);
	}
}
