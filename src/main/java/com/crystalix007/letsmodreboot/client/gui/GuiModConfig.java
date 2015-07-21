package com.crystalix007.letsmodreboot.client.gui;

import com.crystalix007.letsmodreboot.handler.HandlerConfiguration;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

public class GuiModConfig extends GuiConfig {

	public GuiModConfig(GuiScreen guiScreen)
	{
		super(guiScreen, new ConfigElement(HandlerConfiguration.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), ReferenceMod.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(HandlerConfiguration.configuration.toString()));
	}
}
