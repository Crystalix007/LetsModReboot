package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.entity.EntityTeleportArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTeleportArrow extends ItemLMRB
{
	public ItemTeleportArrow()
	{
		super();
		this.setUnlocalizedName("itemTeleportArrow");
		this.setMaxStackSize(16);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int i, int i1, int i2, int i3, float v, float v1, float v2)
	{
		return true;
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		entityPlayer.getCurrentEquippedItem().stackSize--;

		if (world.isRemote)
			world.spawnEntityInWorld(new EntityTeleportArrow(world, entityPlayer, 1.f));
		return itemStack;
	}
}
