package com.crystalix007.letsmodreboot.client.handler;

import com.crystalix007.letsmodreboot.client.settings.Keybindings;
import com.crystalix007.letsmodreboot.reference.Key;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputHandler
{
	public static Key getPressedKeybinding()
	{
		if (Keybindings.charge.isPressed())
			return Key.CHARGE;
		else if (Keybindings.release.isPressed())
			return Key.RELEASE;

		//Default key press value
		return Key.UNKNOWN;
	}

	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event)
	{
		Key keyPressed = getPressedKeybinding();
	}
}