package com.crystalix007.letsmodreboot.block;
import com.crystalix007.letsmodreboot.init.InitModBlocks;
import com.crystalix007.letsmodreboot.tileentity.TileEntityLockdown;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLockdown extends BlockLMRB implements ITileEntityProvider
{
	public BlockLockdown()
	{
		super(Material.anvil);
		setBlockName("blockLockdown");
		setHarvestLevel("pickaxe", 2);
		setHardness(20.f);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z)
	{
		//ProxyClient.printMessageToPlayer("Added block");
		Block blockBelow = world.getBlock(x, y - 1, z);

		if ((blockBelow != null) && (blockBelow != Blocks.bedrock) && (blockBelow != InitModBlocks.blockLockdown) && (!world.isRemote))
		{
			TileEntity tileEntity = world.getTileEntity(x, y, z);

			if (tileEntity != null && tileEntity instanceof TileEntityLockdown)
				((TileEntityLockdown) tileEntity).setSubBlock(world.getBlock(x, y - 1, z), world.getTileEntity(x, y - 1, z), (world.getBlock(x, y + 1, z) != InitModBlocks.blockLockdown));

			world.setBlock(x, y - 1, z, InitModBlocks.blockLockdown);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int v) {
		return new TileEntityLockdown();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int v)
	{
		TileEntity te = world.getTileEntity(x, y, z);

		if (te != null)
			world.removeTileEntity(x, y, z);

		super.breakBlock(world, x, y, z, block, v);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int v, float x1, float y1, float z1)
	{
		replaceBlockWithPrevious(world, x, y, z);
		world.setBlockToAir(x, y, z);

		if (!world.isRemote && (world.getTileEntity(x, y, z) != null && world.getTileEntity(x, y, z) instanceof TileEntityLockdown && ((TileEntityLockdown) world.getTileEntity(x, y, z)).isTop()))
			world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(InitModBlocks.blockLockdown)));
		return true;
	}

	public void replaceBlockWithPrevious(World world, int x, int y, int z)
	{
		Block subBlock = world.getBlock(x, y - 1, z);

		if (subBlock != null && subBlock instanceof BlockLockdown)
			((BlockLockdown) subBlock).replaceBlockWithPrevious(world, x, y - 1, z);

		TileEntity tileEntity = world.getTileEntity(x, y, z);

		if (tileEntity != null && tileEntity instanceof TileEntityLockdown)
			((TileEntityLockdown) tileEntity).replaceBlock();
		else
			world.setBlockToAir(x, y - 1, z);
	}
}
