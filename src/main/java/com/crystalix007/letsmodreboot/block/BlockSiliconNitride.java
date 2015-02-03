package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

import java.util.Random;

public class BlockSiliconNitride extends BlockLMRB {
	public BlockSiliconNitride() {
		super();
		this.setBlockName("siliconNitride");
		this.setHardness(150);
		this.setHarvestLevel("pickaxe", 5);
	}

	public Item getItemDropped(int i, Random random, int j) {
		return ModItems.siliconNitrideDust;
	}

	public void harvestBlock(World world, EntityPlayer entityPlayer, int x, int y, int z, int metadata) {
		entityPlayer.addStat(StatList.mineBlockStatArray[getIdFromBlock(this)], 1);
		entityPlayer.addExhaustion(0.025F);

		if (entityPlayer.getCurrentEquippedItem().getUnlocalizedName().equals((new ItemStack(ModItems.heavyHammer).getUnlocalizedName()))) {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(ModItems.siliconNitrideDust));
		} else {
			this.dropBlockAsItem(world, x, y, z, new ItemStack(this));
		}
	}
}
