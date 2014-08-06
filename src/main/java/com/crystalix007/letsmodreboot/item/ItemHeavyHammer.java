package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHeavyHammer extends ItemPickaxeLMRB
{
	public ItemHeavyHammer(ToolMaterial toolMaterial)
	{
		super(toolMaterial);
		this.setHarvestLevel("pickaxe", 5);
		this.setUnlocalizedName("heavyHammer");
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
	{
		if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
		{
			itemStack.damageItem(1, entityLivingBase);
		}

		//ClientProxy.printMessageToPlayer("Block  destroyed: " + block.getUnlocalizedName());

		if ((block.getUnlocalizedName().equals("tile.letsmodreboot:spinel") || (block.getUnlocalizedName().equals("tile.letsmodreboot:siliconNitride"))) && !world.isRemote)
			spawnDust(block.getUnlocalizedName(), world, x, y, z);

		return true;
	}

	public boolean func_150897_b(Block block)
	{
		return ((block.getUnlocalizedName().equals("tile.letsmodreboot:spinel")) || (block.getUnlocalizedName().equals("tile.letsmodreboot:siliconNitride")));
	}

	private void spawnDust(String name, World world, int x, int y, int z)
	{
		if (name.equals("tile.letsmodreboot:spinel"))
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.spinelDust)));
		else
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.siliconNitrideDust)));
	}
}