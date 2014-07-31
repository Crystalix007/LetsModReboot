package com.crystalix007.letsmodreboot.client.gui;

import com.crystalix007.letsmodreboot.LetsModReboot;
import com.crystalix007.letsmodreboot.handler.ConfigurationHandler;
import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class ModGuiConfig extends GuiConfig {

	public ModGuiConfig(GuiScreen guiScreen)
	{
		super(guiScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
	}
}
