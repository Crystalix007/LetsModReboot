package com.crystalix007.letsmodreboot.event;

import com.crystalix007.letsmodreboot.proxy.ProxyClient;
import com.crystalix007.letsmodreboot.utility.UtilityLogHelper;
import com.mojang.realmsclient.gui.ChatFormatting;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;

public class EventHookContainerClass
{
	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event)
	{
		ProxyClient.printMessageToPlayer(/*ChatFormatting.BLUE + */"Welcome "/* + ChatFormatting.GOLD + event.player.getDisplayName()*/);
		UtilityLogHelper.info("A player logged in");
	}

	@SubscribeEvent
	public void onPlayerSleepInBed(PlayerSleepInBedEvent event)
	{
		if (event.entityPlayer.worldObj.isDaytime() && !event.entity.worldObj.isRemote)
		{
			ProxyClient.printMessageToPlayer("Current time: " + event.entityPlayer.worldObj.getWorldTime());
			ProxyClient.printMessageToPlayer(ChatFormatting.BOLD + "Good luck sleeping at this time!");
		}
	}
}
