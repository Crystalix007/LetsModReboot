package com.crystalix007.letsmodreboot.proxy;

import com.crystalix007.letsmodreboot.client.settings.SettingsKeybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentTranslation;

public class ProxyClient extends ProxyCommon
{
	public ProxyClient()
	{
		return;
	}

	@Override
	public void registerKeyBindings()
	{
		ClientRegistry.registerKeyBinding(SettingsKeybindings.charge);
		ClientRegistry.registerKeyBinding(SettingsKeybindings.release);
		ClientRegistry.registerKeyBinding(SettingsKeybindings.flight);
	}

	public static void printMessageToPlayer(String msg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(msg));
	}
}
