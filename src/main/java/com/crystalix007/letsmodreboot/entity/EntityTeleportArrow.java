package com.crystalix007.letsmodreboot.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityTeleportArrow extends EntityProjectileBase
{
	public EntityTeleportArrow(World world, EntityLivingBase entityLivingBase, float velocity)
	{
		super(world, entityLivingBase, velocity);
	}

	protected void onCollide()
	{
		//shootingEntity.moveEntity(prevX - hitEntity.posX, prevY - hitEntity.posY, prevZ - hitEntity.posZ);
		shootingEntity.lastTickPosX = x;
		shootingEntity.lastTickPosY = y;
		shootingEntity.lastTickPosZ = z;

		shootingEntity.moveEntity(x, y, z);

		//ClientProxy.printMessageToPlayer("X: " + String.valueOf(x) + ", Y: " + String.valueOf(y) + ", Z: " + String.valueOf(z));
	}
}