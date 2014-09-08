package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.init.ModBlocks;
import com.crystalix007.letsmodreboot.init.ModMaterials;
import com.crystalix007.letsmodreboot.proxy.ClientProxy;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.tileentities.TileEntityInvisiGlass;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockInvisiGlass extends BlockGlassLMRB implements ITileEntityProvider {
	public static IIcon alpha0, alpha1, alpha2, alpha3, alpha4, alpha5;

	public BlockInvisiGlass() {
		super("invisiGlass", ModMaterials.materialSoft);
		this.setBlockName("invisiGlass");
		this.lightOpacity = 0;
		this.isBlockContainer = true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
		alpha0 = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "invisiGlass_0");
		alpha1 = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "invisiGlass_1");
		alpha2 = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "invisiGlass_2");
		alpha3 = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "invisiGlass_3");
		alpha4 = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "invisiGlass_4");
		alpha5 = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "invisiGlass_5");
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list) {
		list.add(new ItemStack(item, 1, 0));
		list.add(new ItemStack(item, 1, 1));
		list.add(new ItemStack(item, 1, 2));
		list.add(new ItemStack(item, 1, 3));
		list.add(new ItemStack(item, 1, 4));
		list.add(new ItemStack(item, 1, 5));
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		switch (meta) {
			/*case 0:
				return alpha0;
			case 1:
				return alpha1;
			case 2:
				return alpha2;
			case 3:
				return alpha3;
			case 4:
				return alpha4;
			case 5:
				return alpha5;*/
			default:
				return blockIcon;
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float v, float v1, float v2) {
		ItemStack currentItem = player.getCurrentEquippedItem();
		boolean used = false;
		if (currentItem == null)
			return false;

		TileEntityInvisiGlass tile = (TileEntityInvisiGlass) world.getTileEntity(x, y, z);

		if (currentItem.getUnlocalizedName().contains("dye")) {
			if (currentItem.getItemDamage() == 0 && tile.alpha < 0.9f && tile.getBlockMetadata() < 5) {
				tile.alpha += 0.2f;
				tile.blockMetadata++;
				used = true;
			}

			if (currentItem.getItemDamage() == 1 && tile.red < 110) {
				tile.red += 20;
				used = true;
			}
			if (currentItem.getItemDamage() == 2 && tile.green < 110) {
				tile.green += 20;
				used = true;
			}
			if (currentItem.getItemDamage() == 4 && tile.blue < 110) {
				tile.blue += 20;
				used = true;
			}
			if (currentItem.getItemDamage() == 15 && tile.alpha > 0.1f && tile.getBlockMetadata() > 0) {
				tile.alpha -= 0.2f;
				tile.blockMetadata--;
				used = true;
			}
			if (!player.capabilities.isCreativeMode && used)
				currentItem.stackSize--;
			world.markBlockForUpdate(x, y, z);
		} else {
			player.getCurrentEquippedItem().useItemRightClick(world, player);
		}

		return used;
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor(IBlockAccess iBlockAccess, int x, int y, int z) {
		if (iBlockAccess == null)
		{
			ClientProxy.printMessageToPlayer("World is null");
			return super.getBlockColor();
		}

		TileEntity tileEntity = iBlockAccess.getTileEntity(x, y, z);

		if (tileEntity == null)
			return super.getBlockColor();

		TileEntityInvisiGlass tile = (TileEntityInvisiGlass) tileEntity;
		return ((65536 * tile.red) + (256 * tile.green) + tile.blue);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess iBlockAccess, int x, int y, int z) {
		return getBlockColor(iBlockAccess, x, y, z);
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityInvisiGlass();
	}

	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	}

	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		world.setTileEntity(x, y, z, createNewTileEntity(world, 0));
	}

	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer entityPlayer) {
		if (entityPlayer.capabilities.isCreativeMode)
			return;
		TileEntityInvisiGlass tile = (TileEntityInvisiGlass) world.getTileEntity(x, y, z);

		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.dye, tile.red / 20, 1)));
		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.dye, tile.green / 20, 2)));
		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.dye, tile.blue / 20, 4)));
	}

	@Override
	public int getMobilityFlag() {
		return 0;
	}

	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity entity, float v) {
		entity.motionY = Math.max(entity.motionY, -1);
		entity.fallDistance = 0;
	}

	@Override
	public boolean isBlockSolid(IBlockAccess iBlockAccess, int x, int y, int z, int l) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
		Block block = world.getBlock(x, y, z);

		if (this == ModBlocks.invisiGlass)
		{
			if (world.getBlock(x, y, z).colorMultiplier(world, x, y, z) != world.getBlock(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]).colorMultiplier(world, x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]))
			{
				return true;
			}

			if (block == this)
			{
				return false;
			}
		}

		return block == this ? false : super.shouldSideBeRendered(world, x, y, z, side);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		world.markBlockForUpdate(x, y, z);
		world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
		ClientProxy.printMessageToPlayer("Rendering block again");
	}

	/*@Override
	public int getRenderType() {
		return -1;
	}*/
}
