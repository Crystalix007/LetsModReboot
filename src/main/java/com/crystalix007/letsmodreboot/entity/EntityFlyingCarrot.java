package com.crystalix007.letsmodreboot.entity;

import com.crystalix007.letsmodreboot.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFlyingCarrot extends EntityProjectileBase {
	public EntityFlyingCarrot(World world, EntityLivingBase entityLivingBase, float velocity) {
		super(world, entityLivingBase, velocity);
		this.shouldDropAmmo = false;
		this.explodeOnContact = true;
		this.itemToUse = new ItemStack(ModItems.carrotAmmo);
		this.stayDelay = 2;
	}
}