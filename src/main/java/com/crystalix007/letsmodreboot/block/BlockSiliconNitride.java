package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.init.InitModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSiliconNitride extends BlockLMRB {
	public BlockSiliconNitride() {
		super();
		this.setBlockName("blockSiliconNitride");
		this.setHardness(150);
		this.setHarvestLevel("pickaxe", 5);
	}

	public Item getItemDropped(int i, Random random, int j) {
		return InitModItems.itemSiliconNitrideDust;
	}

	public void harvestBlock(World world, EntityPlayer entityPlayer, int x, int y, int z, int metadata) {
		entityPlayer.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
		entityPlayer.addExhaustion(0.025F);

		if (entityPlayer.getCurrentEquippedItem().getUnlocalizedName().equals((new ItemStack(InitModItems.heavyHammer).getUnlocalizedName()))) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(InitModItems.itemSiliconNitrideDust));
		} else {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(this));
		}
	}
}
