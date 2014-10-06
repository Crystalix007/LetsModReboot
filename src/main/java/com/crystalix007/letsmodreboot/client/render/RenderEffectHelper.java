package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.utility.EntityTeleporter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;

public class RenderEffectHelper
{
	public static void renderEffect(EntityFX entityFX)
	{
		Minecraft.getMinecraft().effectRenderer.addEffect(entityFX);
	}

	public static void updateEffects()
	{
		Minecraft.getMinecraft().effectRenderer.updateEffects();
	}

	public static void spreadEffects(EntityFX entityFX, double x, double z, int effectCount, int radius)
	{
		if (!entityFX.worldObj.isRemote)
			return;

		EntityTeleporter entityTeleporter = new EntityTeleporter();

		double minX = x - radius;
		double minZ = z - radius;

		double maxX = x + radius;
		double maxZ = z + radius;

		for (int i = 0; i < effectCount; i++)
		{
			entityTeleporter.teleportEntity(entityFX, (int)(x + (((Math.random() * 20) % (radius * 2)) - radius)), (int)(entityFX.posY), (int)(z + (((Math.random() * 20) % (radius * 2)) - radius)));

			/*if (entityFX.posX < minX || entityFX.posX > maxX || entityFX.posZ < minZ || entityFX.posZ > maxZ)
				ClientProxy.printMessageToPlayer("Entity not created within correct radius");
			else
				ClientProxy.printMessageToPlayer("X: " + String.valueOf(entityFX.posX) + ", Z: " + String.valueOf(entityFX.posZ));*/
			renderEffect(entityFX);
			updateEffects();
		}
	}
}
