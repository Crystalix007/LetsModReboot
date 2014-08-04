package com.crystalix007.letsmodreboot.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityFlyingCarrot extends EntityArrow
{
	private boolean inGround = false;

	public EntityFlyingCarrot(World world, EntityLivingBase entityLivingBase, float velocity)
	{
		super(world, entityLivingBase, velocity);
	}

	//Creates particle stream
	public boolean getIsCritical()
	{
		return true;
	}

	public void onCollideWithPlayer(EntityPlayer entityPlayer)
	{
		if (!this.worldObj.isRemote && this.inGround && this.arrowShake <= 0)
		{
			boolean flag = this.canBePickedUp == 1 || this.canBePickedUp == 2 && entityPlayer.capabilities.isCreativeMode;
			this.worldObj.createExplosion(entityPlayer, entityPlayer.posX, entityPlayer.posY, entityPlayer.posZ, 2F, true);

			if (this.canBePickedUp == 1 && !entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.arrow, 1)))
			{
				flag = false;
			}

			if (flag)
			{
				this.playSound("random.pop", 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				entityPlayer.onItemPickup(this, 1);
				this.setDead();
			}
		}
	}
}
