package com.crystalix007.letsmodreboot.entity;

import com.crystalix007.letsmodreboot.init.InitModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFlyingCarrot extends EntityProjectileBase {

	public EntityFlyingCarrot(World world) {
		super(world);
		this.shouldDropAmmo = false;
		this.itemToUse = new ItemStack(InitModItems.itemCarrotAmmo);
		this.stayDelay = 2;
	}

	public EntityFlyingCarrot(World world, EntityLivingBase entityLivingBase, float velocity) {
		super(world, entityLivingBase, velocity);
		this.shouldDropAmmo = false;
		this.itemToUse = new ItemStack(InitModItems.itemCarrotAmmo);
		this.stayDelay = 2;
	}

	public void onUpdate()
	{
		super.onUpdate();
		if (!isBurning())
		{
			setFire(100);
		}
	}

	@Override
	void onCollide() {
		worldObj.createExplosion(hitEntity, hitEntity.posX, hitEntity.posY, hitEntity.posZ, initialVelocity * 100.0f, false);
	}
}