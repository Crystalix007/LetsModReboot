package com.crystalix007.letsmodreboot.client.handler;

import com.crystalix007.letsmodreboot.client.settings.Keybindings;
import com.crystalix007.letsmodreboot.reference.Key;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;

public class KeyInputHandler
{
	public static Key getPressedKeybinding()
	{
		if (Keybindings.charge.isPressed())
			return Key.CHARGE;
		else if (Keybindings.release.isPressed())
			return Key.RELEASE;
		else if (Keybindings.flight.isPressed())
			return Key.FLIGHT;

		//Default key press value
		return Key.UNKNOWN;
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		Key keyPressed = getPressedKeybinding();
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;

		if (keyPressed == Key.FLIGHT) {
			if (player.capabilities.isCreativeMode) {
				player.capabilities.isFlying = true;
				player.setPosition(player.posX, player.posY + 0.1f, player.posZ);
			}
		}
	}
}
