package com.crystalix007.letsmodreboot.proxy;

import com.crystalix007.letsmodreboot.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentTranslation;

public class ClientProxy extends CommonProxy
{
	public ClientProxy()
	{
		return;
	}

	@Override
	public void registerKeyBindings()
	{
		ClientRegistry.registerKeyBinding(Keybindings.charge);
		ClientRegistry.registerKeyBinding(Keybindings.release);
		ClientRegistry.registerKeyBinding(Keybindings.flight);
	}

	public static void printMessageToPlayer(String msg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(msg));
	}
}
