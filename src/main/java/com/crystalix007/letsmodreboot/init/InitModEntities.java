package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.LetsModReboot;
import com.crystalix007.letsmodreboot.client.render.RenderEntityFlyingCarrot;
import com.crystalix007.letsmodreboot.client.render.RenderEntityTeleportArrow;
import com.crystalix007.letsmodreboot.entity.EntityFlyingCarrot;
import com.crystalix007.letsmodreboot.entity.EntityTeleportArrow;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;

public class InitModEntities
{
	public static void init()
	{
		EntityRegistry.registerModEntity(EntityFlyingCarrot.class, "flyingCarrot", 240, LetsModReboot.instance, 64, 1, true);
		EntityRegistry.registerModEntity(EntityTeleportArrow.class, "teleportArrow", 240, LetsModReboot.instance, 64, 1, true);
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingCarrot.class, new RenderEntityFlyingCarrot());
		RenderingRegistry.registerEntityRenderingHandler(EntityTeleportArrow.class, new RenderEntityTeleportArrow());
	}
}
