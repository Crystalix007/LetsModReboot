package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.block.BlockInvisiGlass;
import com.crystalix007.letsmodreboot.init.ModBlocks;
import com.crystalix007.letsmodreboot.proxy.ClientProxy;
import com.crystalix007.letsmodreboot.tileentities.TileEntityInvisiGlass;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDebugTool extends ItemLMRB {
	public ItemDebugTool()
	{
		super();
		this.setUnlocalizedName("debugTool");
		this.setMaxStackSize(1);
		this.setNoRepair();
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer, World world, int x, int y, int z, int meta, float v, float v1, float v2) {
		Block block = world.getBlock(x, y, z);
		boolean used = false;

		if (world.isRemote)
			return false;

		if (block instanceof BlockInvisiGlass)
		{
			TileEntityInvisiGlass tile = ((TileEntityInvisiGlass) world.getTileEntity(x, y, z));
			world.markBlockForUpdate(x, y, z);

			ClientProxy.printMessageToPlayer("RGBA: " + String.valueOf(tile.red) + ", " + String.valueOf(tile.green) + ", " + String.valueOf(tile.blue) + ", " + String.valueOf(tile.alpha));

			for (int i = 0; i <= 5; i++)
				ClientProxy.printMessageToPlayer("Should render side " + String.valueOf(i) + ": " + String.valueOf(ModBlocks.invisiGlass.shouldSideBeRendered(world, x, y, z, i)));

			used = true;
		}
		return used;
	}
}