package com.crystalix007.letsmodreboot.command;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

import java.util.List;

public abstract class CommandLMRB implements ICommand
{
	String commandName;

	CommandLMRB(String name)
	{
		commandName = name;
	}

	@Override
	public String getCommandName() {
		return commandName;
	}

	@Override
	public String getCommandUsage(ICommandSender iCommandSender) {
		return "/" + commandName;
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public abstract void processCommand(ICommandSender iCommandSender, String[] strings);

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender iCommandSender) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender iCommandSender, String[] strings) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] strings, int i) {
		return false;
	}

	@Override
	public int compareTo(Object c)
	{
		return -1;
	}
}
