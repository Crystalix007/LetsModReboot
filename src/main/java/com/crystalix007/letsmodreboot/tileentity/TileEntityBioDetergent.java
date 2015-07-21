package com.crystalix007.letsmodreboot.tileentity;

import com.crystalix007.letsmodreboot.init.InitModBlocks;
import com.crystalix007.letsmodreboot.utility.UtilityPositionedBlock;
import com.crystalix007.letsmodreboot.utility.UtilityWorldHelper;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import java.util.Vector;

public class TileEntityBioDetergent extends TileEntity
{
	int ticksExisted;

	public TileEntityBioDetergent()
	{
		ticksExisted = 0;
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
	}

	@Override
	public void updateEntity()
	{
		if (ticksExisted == 1) {
			//ClientProxy.printMessageToPlayer("Checking for destroyable blocks");
			Vector<UtilityPositionedBlock> blocks = UtilityWorldHelper.getBlocks(worldObj, xCoord - 1, yCoord - 1, zCoord - 1, xCoord + 1, yCoord + 1, zCoord + 1);

			for (int i = 0; i < blocks.size(); i++) {
				UtilityPositionedBlock positionedBlock = blocks.elementAt(i);
				Block thisBlock = positionedBlock.getBlock();

				if (thisBlock != null && (thisBlock != Blocks.air) && (thisBlock == InitModBlocks.blockNuclearWaste)) {
					TileEntity te = worldObj.getTileEntity(positionedBlock.xPos, positionedBlock.yPos, positionedBlock.zPos);

					if (te != null && te instanceof TileEntityNuclearWaste) {
						((TileEntityNuclearWaste) te).destroyTileEntity();

						//ClientProxy.printMessageToPlayer(((worldObj.getTileEntity(xCoord + Facing.offsetsXForSide[i], yCoord + Facing.offsetsYForSide[i], zCoord + Facing.offsetsZForSide[i])) == null ? "Removed TE successfully" : "TE still exists"));
					}

					worldObj.setBlock(positionedBlock.xPos, positionedBlock.yPos, positionedBlock.zPos, InitModBlocks.blockBioDetergent);
					worldObj.notifyBlockChange(positionedBlock.xPos, positionedBlock.yPos, positionedBlock.zPos, InitModBlocks.blockBioDetergent);
				}
			}
		}

		//Prevent infinite checking
		if (ticksExisted > 60 && !worldObj.isRemote) {
			worldObj.setBlockToAir(xCoord, yCoord, zCoord);
			worldObj.notifyBlockChange(xCoord, yCoord, zCoord, Blocks.air);
		}

		ticksExisted++;
	}

	@Override
	public boolean canUpdate()
	{
		return true;
	}
}
