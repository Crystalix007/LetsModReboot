package com.crystalix007.letsmodreboot.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentTranslation;

public class ClientProxy extends CommonProxy
{
	public ClientProxy()
	{
		return;
	}

	public static void printMessageToPlayer(String msg) {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentTranslation(msg));
	}
}
