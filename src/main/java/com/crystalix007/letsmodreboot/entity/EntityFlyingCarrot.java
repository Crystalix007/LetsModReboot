package com.crystalix007.letsmodreboot.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityFlyingCarrot extends EntityArrow
{
	private boolean inGround = false;

	public EntityFlyingCarrot(World world, EntityLivingBase entityLivingBase, float velocity)
	{
		super(world, entityLivingBase.posX + 0.00001D, entityLivingBase.posY + 0.00001D, entityLivingBase.posZ + 0.00001D);

		this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
		this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI));
		this.motionY = (double)(-MathHelper.sin(this.rotationPitch / 180.0F * (float)Math.PI));
		this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, velocity * 1.5F, 1.0F);
	}

	//Creates particle stream
	public boolean getIsCritical()
	{
		return true;
	}

	public void onCollideWithPlayer(EntityPlayer entityPlayer)
	{
		super.onCollideWithPlayer(entityPlayer);
		int i = MathHelper.floor_double(this.boundingBox.minX + 0.001D);
		int j = MathHelper.floor_double(this.boundingBox.minY + 0.001D);
		int k = MathHelper.floor_double(this.boundingBox.minZ + 0.001D);
		World world = this.worldObj;
		world.createExplosion((Entity)null, i, j, k, 4.0F, true);
	}
}
