package com.crystalix007.letsmodreboot.client.handler;

import com.crystalix007.letsmodreboot.client.settings.Keybindings;
import com.crystalix007.letsmodreboot.reference.Key;
import com.crystalix007.letsmodreboot.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler
{
	private static Key getPressedKeybinding()
	{
		if (Keybindings.charge.isPressed())
			return Key.CHARGE;
		else if (Keybindings.release.isPressed())
			return Key.RELEASE;

		//Default key press value
		return Key.UNKNOWN;
	}

	@SubscribeEvent
	public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
	{
		Key keyPressed = getPressedKeybinding();
		LogHelper.info(keyPressed);

		//ClientProxy.printMessageToPlayer(keyPressed.toString());
	}
}
