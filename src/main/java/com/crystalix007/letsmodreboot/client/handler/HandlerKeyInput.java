package com.crystalix007.letsmodreboot.client.handler;

import com.crystalix007.letsmodreboot.client.settings.SettingsKeybindings;
import com.crystalix007.letsmodreboot.reference.ReferenceKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;

public class HandlerKeyInput
{
	public static ReferenceKey getPressedKeybinding()
	{
		if (SettingsKeybindings.charge.isPressed())
			return ReferenceKey.CHARGE;
		else if (SettingsKeybindings.release.isPressed())
			return ReferenceKey.RELEASE;
		else if (SettingsKeybindings.flight.isPressed())
			return ReferenceKey.FLIGHT;

		//Default key press value
		return ReferenceKey.UNKNOWN;
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		ReferenceKey keyPressed = getPressedKeybinding();
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;

		if (keyPressed == ReferenceKey.FLIGHT) {
			if (player.capabilities.isCreativeMode) {
				player.capabilities.isFlying = true;
				player.setPosition(player.posX, player.posY + 0.1f, player.posZ);
			}
		}
	}
}
