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
		shootingEntity.moveEntity(hitEntity.posX, hitEntity.posY, hitEntity.posZ);
	}
}
