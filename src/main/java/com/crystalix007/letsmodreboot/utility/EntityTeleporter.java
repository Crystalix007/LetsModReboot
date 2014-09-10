package com.crystalix007.letsmodreboot.utility;

import net.minecraft.entity.Entity;

public class EntityTeleporter
{
	public void teleportEntity(Entity entity, int x, int y, int z)
	{
		entity.setPosition(x, y, z);
	}
}
