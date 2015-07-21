package com.crystalix007.letsmodreboot.handler;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import com.crystalix007.letsmodreboot.utility.UtilityLogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

public class HandlerConfiguration
{
	public static Configuration configuration;

	//Config values
	public static int teleportDist = 5;
	public static boolean removeInvOfCreative = false;

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
		if (event.modID.equalsIgnoreCase(ReferenceMod.MOD_ID)) //Resync configs
		{
			loadConfiguration();
		}
		configuration.save();
	}

	private static void loadConfiguration()
	{
		try {
			//Load config file
			configuration.load();

			teleportDist = configuration.getInt("TeleportDistance", CATEGORY_GENERAL, 5, 1, 15, "Distance the EnderStaff teleports");
			removeInvOfCreative = configuration.getBoolean("RemoveCreativeInv", CATEGORY_GENERAL, false, "Whether a creative player should have their inventory cleared");
			UtilityLogHelper.info("Should remove inv: " + String.valueOf(removeInvOfCreative));
		}
		catch (Exception e)
		{
			UtilityLogHelper.error(e.getMessage());
		}
		finally {
			//If the config has been modified
			if (configuration.hasChanged())
			{
				configuration.save();
			}
		}
	}
}
