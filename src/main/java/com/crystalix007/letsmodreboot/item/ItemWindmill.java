package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.init.InitModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWindmill extends ItemLMRB
{
	public ItemWindmill()
	{
		super();
		setUnlocalizedName("itemWindmill");
		setCreativeTab(CreativeTabsLMRB.MECHANICAL_TAB);
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world,int x, int y, int z, int side, float xPos, float yPos, float zPos)
	{
		if (side == 1)
			world.setBlock(x, y + 1, z, InitModBlocks.blockWindmill);

		return true;
	}
}