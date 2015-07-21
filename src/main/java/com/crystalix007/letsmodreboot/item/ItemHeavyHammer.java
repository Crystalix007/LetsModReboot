package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.init.InitModItems;

public class ItemHeavyHammer extends ItemPickaxeLMRB
{
	//private static final Block[] mineableBlocks = new Block[]{ModBlocks.spinel, ModBlocks.siliconNitride};

	public ItemHeavyHammer()
	{
		//super(5, ModItems.siliconNitrideMaterial, "heavyHammer", mineableBlocks);
		super(InitModItems.materialSiliconNitride);
		this.setUnlocalizedName("itemHeavyHammer");
	}

	/*@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
	{
		//ClientProxy.printMessageToPlayer("Block  destroyed: " + block.getUnlocalizedName());

		if ((block.getUnlocalizedName().equals("tile.letsmodreboot:spinel") || (block.getUnlocalizedName().equals("tile.letsmodreboot:siliconNitride"))) && !world.isRemote)
			spawnDust(block.getUnlocalizedName(), world, x, y, z);

		return true;
	}*/

	/*public boolean func_150897_b(Block block)
	{
		//LogHelper.info("Tried to destroy block with heavy hammer. Can destroy: " + String.valueOf((block.getUnlocalizedName().equals("tile.letsmodreboot:spinel")) || (block.getUnlocalizedName().equals("tile.letsmodreboot:siliconNitride"))));
		return ((block.getUnlocalizedName().equals("tile.letsmodreboot:spinel")) || (block.getUnlocalizedName().equals("tile.letsmodreboot:siliconNitride")));
	}

	private void spawnDust(String name, World world, int x, int y, int z)
	{
		if (name.equals("tile.letsmodreboot:spinel"))
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.spinelDust)));
		else
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(ModItems.siliconNitrideDust)));
	}*/
}