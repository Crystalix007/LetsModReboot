package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import com.crystalix007.letsmodreboot.tileentity.TileEntityBioDetergent;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBioDetergent extends BlockLMRB implements ITileEntityProvider
{
	public BlockBioDetergent()
	{
		super(Material.water);
		setBlockName("blockBioDetergent");
		setBlockTextureName(ReferenceMod.MOD_ID.toLowerCase() + ":" + this.getUnlocalizedName());
		//setBlockTextureName("LetsModReboot:blocks/BlockBioDetergent");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int v) {
		return new TileEntityBioDetergent();
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int v)
	{
		TileEntity te = world.getTileEntity(x, y, z);

		if (te != null)
			world.removeTileEntity(x, y, z);

		super.breakBlock(world, x, y, z, block, v);
	}
}