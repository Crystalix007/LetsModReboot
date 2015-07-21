package com.crystalix007.letsmodreboot.entity;

import com.crystalix007.letsmodreboot.utility.UtilityMoveHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

public class EntityTeleportArrow extends EntityProjectileBase
{
	public EntityTeleportArrow(World world, EntityLivingBase entityLivingBase, float velocity)
	{
		super(world, entityLivingBase, velocity);
		this.stayDelay = 2;
	}

	protected void onCollide()
	{
		double shootingEntityPos[] = {shootingEntity.posX, shootingEntity.posY, shootingEntity.posZ};
		double hitEntityPos[] = {hitEntity.posX, hitEntity.posY, hitEntity.posZ};
		UtilityMoveHelper.moveTo(shootingEntity, hitEntityPos, shootingEntityPos);
	}
}