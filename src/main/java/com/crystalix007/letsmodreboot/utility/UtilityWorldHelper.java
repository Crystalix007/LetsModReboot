package com.crystalix007.letsmodreboot.utility;

import net.minecraft.world.World;

import java.util.Vector;

public class UtilityWorldHelper
{
	public static Vector<UtilityPositionedBlock> getBlocks(World world, int minX, int minY, int minZ, int maxX, int maxY, int maxZ)
	{
		Vector<UtilityPositionedBlock> blocks = new Vector<UtilityPositionedBlock>();
		blocks.clear();

		//ClientProxy.printMessageToPlayer("getBlocks(" + String.valueOf(minX) + ", " + String.valueOf(minY) + ", " + String.valueOf(minZ) + ", " + String.valueOf(maxX) + ", " + String.valueOf(maxY) + ", " + String.valueOf(maxZ));

		if (minX > maxX)
		{
			int holder;
			holder = maxX;
			maxX = minX;
			minX = holder;
		}
		if (minY > maxY)
		{
			int holder;
			holder = maxY;
			maxY = minY;
			minY = holder;
		}
		if (minZ > maxZ)
		{
			int holder;
			holder = maxZ;
			maxZ = minZ;
			minZ = holder;
		}

		//ClientProxy.printMessageToPlayer("Now, getBlocks(" + String.valueOf(minX) + ", " + String.valueOf(minY) + ", " + String.valueOf(minZ) + ", " + String.valueOf(maxX) + ", " + String.valueOf(maxY) + ", " + String.valueOf(maxZ));

		for (int x = minX; x <= maxX; x++)
		{
			for (int y = minY; y <= maxY; y++)
			{
				for (int z = minZ; z <= maxZ; z++) {
					blocks.add(new UtilityPositionedBlock(world.getBlock(x, y, z), x, y, z));
				}
			}
		}

		//ClientProxy.printMessageToPlayer("Now blocks has " + String.valueOf(blocks.size()) + " size");
		return blocks;
	}
}
