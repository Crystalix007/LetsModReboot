package com.crystalix007.letsmodreboot.item;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCarrotAmmo extends ItemLMRB
{
    public ItemCarrotAmmo()
    {
        super();
        this.setUnlocalizedName("itemCarrotAmmo");
        this.setMaxStackSize(64);
    }

	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int side, float pX, float pY, float pZ)
	{
		world.createExplosion(entityPlayer, x, y, z, 3.0f, true);
		entityPlayer.getCurrentEquippedItem().stackSize--;

		if (!world.isRemote && !entityPlayer.capabilities.isCreativeMode)
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.carrot)));
		return true;
	}
}
