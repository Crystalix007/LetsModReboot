package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.proxy.ProxyClient;
import com.crystalix007.letsmodreboot.tileentity.TileEntityWindmillBase;
import com.crystalix007.letsmodreboot.utility.UtilityPositionedBlock;
import com.crystalix007.letsmodreboot.utility.UtilityWorldHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Vector;

public class BlockWindmillBase extends BlockContainerLMRB {
	public BlockWindmillBase() {
		super(Material.circuits);
		setBlockName("blockWindmillBase");
		setCreativeTab(CreativeTabsLMRB.MECHANICAL_TAB);
		setBlockBounds(0, 0, 0, 1, 5.f / 16.f, 1);
		setHarvestLevel("pickaxe", 1);
	}

	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int v) {
		super.onBlockDestroyedByPlayer(world, x, y, z, v);

		Vector<UtilityPositionedBlock> blocks = UtilityWorldHelper.getBlocks(world, x - 1, y, z - 1, x + 1, y, z + 1);

		for (UtilityPositionedBlock block : blocks) {
			if (block.getBlock() instanceof BlockWindmillBase)
				((BlockWindmillBase) block.getBlock()).isMultiBlockStructure(world, x, y, z);
		}

		return;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbourBlock) {
		if (neighbourBlock instanceof BlockWindmillBase)
			isMultiBlockStructure(world, x, y, z);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		isMultiBlockStructure(world, x, y, z);
		return;
	}

	public void updateMultiblockStructure(World world, int x, int y, int z) {
		isMultiBlockStructure(world, x, y, z);
		return;
	}

	public boolean isSupported(World world, int x, int y, int z)
	{
		Vector<UtilityPositionedBlock> blocks = UtilityWorldHelper.getBlocks(world, x - 1, y, z - 1, x + 1, y, z + 1);
		boolean allFound = true;

		for (UtilityPositionedBlock block : blocks) {
			if (block.getBlock() instanceof BlockWindmillBase && world.getBlockMetadata(block.xPos, block.yPos, block.zPos) == 2)
			{
				allFound = true;
				blocks = UtilityWorldHelper.getBlocks(world, block.xPos - 1, block.yPos, block.zPos - 1, block.xPos + 1, block.yPos, block.zPos + 1);

				for (UtilityPositionedBlock positionedBlock : blocks) {
					if (!(positionedBlock.getBlock() instanceof BlockWindmillBase) || world.getBlockMetadata(positionedBlock.xPos, positionedBlock.yPos, positionedBlock.zPos) == 0)
					{
						allFound = false;
						break;
					}
				}

				if (allFound)
					return true;
			}
		}
		return false;
	}


	public boolean isMultiBlockStructure(World world, int x, int y, int z) {
		Vector<UtilityPositionedBlock> blocks;
		boolean hasHole;

		for (int xSubtract = -2; xSubtract <= 0; xSubtract++) {
			for (int zSubtract = -2; zSubtract <= 0; zSubtract++) {
				hasHole = false;
				blocks = UtilityWorldHelper.getBlocks(world, x + xSubtract, y, z + zSubtract, x + xSubtract + 2, y, z + zSubtract + 2);

				/*world.setBlock(x + xSubtract, y, z + zSubtract, Blocks.wool);
				world.setBlock(x - xSubtract, y, z + zSubtract, Blocks.wool);
				world.setBlock(x - xSubtract, y, z - zSubtract, Blocks.wool);
				world.setBlock(x + xSubtract, y, z - zSubtract, Blocks.wool);*/ //Marks boundaries

				for (UtilityPositionedBlock block : blocks) {
					if (!(block.getBlock() instanceof BlockWindmillBase) || (world.getBlockMetadata(block.xPos, block.yPos, block.zPos) != 0)) {
						hasHole = true;
						break;
					}
					/*else {
						ClientProxy.printMessageToPlayer("Block meta: " + String.valueOf(world.getBlockMetadata(block.xPos, block.yPos, block.zPos)));
					}*/
				}

				if (!hasHole) {
					for (UtilityPositionedBlock block : blocks) {
						world.setBlockMetadataWithNotify(block.xPos, block.yPos, block.zPos, 1, 2);
					}

					UtilityPositionedBlock theCentre = blocks.elementAt(((blocks.size() + 1) / 2) - 1);
					world.setBlockMetadataWithNotify(theCentre.xPos, theCentre.yPos, theCentre.zPos, 2, 2);
					ProxyClient.printMessageToPlayer("Block: " + String.valueOf(theCentre.xPos) + ", " + String.valueOf(theCentre.yPos) + ", " + String.valueOf(theCentre.zPos));
					ProxyClient.printMessageToPlayer("Found complete multiblock");
					return true;
				}
				else
				{
					for (UtilityPositionedBlock block : blocks) {
						if (block.getBlock() instanceof BlockWindmillBase && (!((BlockWindmillBase) block.getBlock()).isSupported(world, block.xPos, block.yPos, block.zPos)))
							world.setBlockMetadataWithNotify(block.xPos, block.yPos, block.zPos, 0, 2);
					}
				}

				blocks.clear();
			}
		}
		return false;
	}

	public int getPositionInMultiblock(World world, int x, int y, int z)
	{
		Vector<UtilityPositionedBlock> blocks;
		boolean hasHole;

		for (int xSubtract = -2; xSubtract <= 0; xSubtract++) {
			for (int zSubtract = -2; zSubtract <= 0; zSubtract++) {
				hasHole = false;
				blocks = UtilityWorldHelper.getBlocks(world, x + xSubtract, y, z + zSubtract, x + xSubtract + 2, y, z + zSubtract + 2);

				for (UtilityPositionedBlock block : blocks) {
					if (!(block.getBlock() instanceof BlockWindmillBase) || (world.getBlockMetadata(block.xPos, block.yPos, block.zPos) != 0)) {
						hasHole = true;
						break;
					}
					else {
//						ClientProxy.printMessageToPlayer("Block meta: " + String.valueOf(world.getBlockMetadata(block.xPos, block.yPos, block.zPos)));
					}
				}

				if (!hasHole) {
					UtilityPositionedBlock startBlock = blocks.elementAt(0);
					return ((x - startBlock.xPos) + (3 * (z - startBlock.zPos)));
				}
				blocks.clear();
			}
		}

		return -1;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityWindmillBase();
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}