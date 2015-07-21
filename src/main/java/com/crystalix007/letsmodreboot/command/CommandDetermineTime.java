package com.crystalix007.letsmodreboot.command;

import com.crystalix007.letsmodreboot.proxy.ProxyClient;
import net.minecraft.command.CommandTime;
import net.minecraft.command.ICommandSender;

public class CommandDetermineTime extends CommandLMRB
{
	public CommandDetermineTime()
	{
		super("time");
	}

	@Override
	public void processCommand(ICommandSender iCommandSender, String[] strings) {
		if (strings.length != 0)
		{
			CommandTime vanillaTimeCommand = new CommandTime();
			vanillaTimeCommand.processCommand(iCommandSender, strings);
			return;
		}

		long worldTime = iCommandSender.getEntityWorld().getWorldTime();
		byte hour = (byte)(((worldTime / 1000) + 6) % 12);
		byte minutes = (byte)((worldTime % 1000) / 17);

		boolean isAfternoon = ((((worldTime / 1000) + 6) % 24) > 12);

		ProxyClient.printMessageToPlayer("Time: " + String.valueOf(worldTime));
		ProxyClient.printMessageToPlayer("...: " + String.valueOf(hour) + ':' + (minutes < 10 ? '0' : "") + String.valueOf(minutes) + (isAfternoon ? "PM" : "AM"));
	}
}
