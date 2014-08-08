package com.crystalix007.letsmodreboot.entity;

import com.crystalix007.letsmodreboot.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFlyingCarrot extends EntityProjectileBase {

	public EntityFlyingCarrot(World world) {
		super(world);
		this.shouldDropAmmo = false;
		this.itemToUse = new ItemStack(ModItems.carrotAmmo);
		this.stayDelay = 2;
	}

	public EntityFlyingCarrot(World world, EntityLivingBase entityLivingBase, float velocity) {
		super(world, entityLivingBase, velocity);
		this.shouldDropAmmo = false;
		this.itemToUse = new ItemStack(ModItems.carrotAmmo);
		this.stayDelay = 2;
	}

	@Override
	void onCollide() {
		worldObj.createExplosion(hitEntity, hitEntity.posX, hitEntity.posY, hitEntity.posZ, initialVelocity * 2.0f, true);
	}
}