package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.handler.ConfigurationHandler;
import com.crystalix007.letsmodreboot.proxy.ClientProxy;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockInvResetter extends BlockDirectionalLMRB {
	public BlockInvResetter() {
		super(Material.cloth);
		setBlockName("invResetterBlock");
		setHarvestLevel("pickaxe", 0);
	}

	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity entity, float velocity) {
		if (!(entity instanceof EntityPlayer) || world.isRemote)
			return;
		else {
			EntityPlayerMP player = (EntityPlayerMP) (entity);

			if (player.capabilities.isCreativeMode && !ConfigurationHandler.removeInvOfCreative)
				return;

			boolean needToClear = false;

			for (int i = 0; i < player.inventory.getSizeInventory(); i++) {
				ItemStack itemStack = player.inventory.getStackInSlot(i);
				if (itemStack != null)
					needToClear = true;
			}

			if (needToClear) {
				ClientProxy.printMessageToPlayer("Your inventory has been reset");
				player.inventory.clearInventory(null, -1);
			}
		}
	}
}
