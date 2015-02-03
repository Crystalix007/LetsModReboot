package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.init.ModItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class BlockSpinel extends BlockLMRB {
	public BlockSpinel() {
		super();
		this.setBlockName("spinel");
		this.setHardness(100);
		this.setHarvestLevel("pickaxe", 4);
	}

	public void harvestBlock(World world, EntityPlayer entityPlayer, int x, int y, int z, int metadata) {
		entityPlayer.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
		entityPlayer.addExhaustion(0.025F);

		if (entityPlayer.getCurrentEquippedItem().getUnlocalizedName().equals((new ItemStack(ModItems.heavyHammer).getUnlocalizedName()))) {
			entityPlayer.worldObj.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.spinelDust)));
		} else {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(this));
		}
	}
}
