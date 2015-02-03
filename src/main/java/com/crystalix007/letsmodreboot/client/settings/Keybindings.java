package com.crystalix007.letsmodreboot.client.settings;

import com.crystalix007.letsmodreboot.reference.Names;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class Keybindings
{
	public static KeyBinding charge = new KeyBinding(Names.Keys.CHARGE, Keyboard.KEY_C, Names.Keys.CATEGORY);
	public static KeyBinding release = new KeyBinding(Names.Keys.RELEASE, Keyboard.KEY_R, Names.Keys.CATEGORY);
	public static KeyBinding flight = new KeyBinding(Names.Keys.FLIGHT, Keyboard.KEY_F, Names.Keys.CATEGORY);
}
