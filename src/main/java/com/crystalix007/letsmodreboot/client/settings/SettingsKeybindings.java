package com.crystalix007.letsmodreboot.client.settings;

import com.crystalix007.letsmodreboot.reference.ReferenceNames;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class SettingsKeybindings
{
	public static KeyBinding charge = new KeyBinding(ReferenceNames.Keys.CHARGE, Keyboard.KEY_C, ReferenceNames.Keys.CATEGORY);
	public static KeyBinding release = new KeyBinding(ReferenceNames.Keys.RELEASE, Keyboard.KEY_R, ReferenceNames.Keys.CATEGORY);
	public static KeyBinding flight = new KeyBinding(ReferenceNames.Keys.FLIGHT, Keyboard.KEY_F, ReferenceNames.Keys.CATEGORY);
}
