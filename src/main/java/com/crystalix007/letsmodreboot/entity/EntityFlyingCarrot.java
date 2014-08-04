package com.crystalix007.letsmodreboot.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class EntityFlyingCarrot extends EntityArrow
{
	public EntityFlyingCarrot(World world, EntityLivingBase entityLivingBase, float velocity)
	{
		super(world, entityLivingBase, velocity);
	}

	//Creates particle stream
	public boolean getIsCritical()
	{
		return true;
	}
}
