package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.init.InitModBlocks;
import com.crystalix007.letsmodreboot.init.InitModMaterials;
import com.crystalix007.letsmodreboot.proxy.ProxyClient;
import com.crystalix007.letsmodreboot.tileentity.TileEntityInvisiGlass;
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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;
import java.util.Random;

public class BlockInvisiGlass extends BlockGlassLMRB implements ITileEntityProvider {
	protected IIcon[] icons = new IIcon[6]; //0 - 5

	public BlockInvisiGlass() {
		super("blockInvisiGlass", InitModMaterials.materialSoft);
		this.setBlockName("blockInvisiGlass");
		this.lightOpacity = 0;
		this.isBlockContainer = true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		super.registerBlockIcons(iconRegister);

		for (int i = 0; i <= 5; i++)
			icons[i] = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_" + String.valueOf(i));
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
		if (meta <= 5)
			return icons[meta];
		else
			return blockIcon;
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float v, float v1, float v2) {
		ItemStack currentItem = player.getCurrentEquippedItem();
		boolean used = false;
		if (currentItem == null)
			return false;

		TileEntityInvisiGlass tile = (TileEntityInvisiGlass) world.getTileEntity(x, y, z);

		if (currentItem.getUnlocalizedName().contains("dye")) {
			if (currentItem.getItemDamage() == 0 && tile.alpha < 0.9f && world.getBlockMetadata(x, y, z) < 5) {
				tile.alpha += 0.2f;
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) + 1, 1);
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
			if (currentItem.getItemDamage() == 15 && tile.alpha > 0.1f && world.getBlockMetadata(x, y, z) > 0) {
				tile.alpha -= 0.2f;
				world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) - 1, 1);
				used = true;
			}
			world.markBlockForUpdate(x, y, z);
		} else {
			List<ItemStack> obsidiBlocks = OreDictionary.getOres("blockObsidian");

			for (ItemStack oreDictStack : obsidiBlocks) {
				if (currentItem.equals(oreDictStack)) {
					tile.hardness += 20.f;
					used = true;
				}
			}

			player.getCurrentEquippedItem().useItemRightClick(world, player);
		}

		if (!player.capabilities.isCreativeMode && used)
			currentItem.stackSize--;

		return used;
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor(IBlockAccess iBlockAccess, int x, int y, int z) {
		if (iBlockAccess == null) {
			ProxyClient.printMessageToPlayer("World is null");
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

	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
		super.onBlockPlacedBy(world, x, y, z, entityLivingBase, itemStack);
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		world.setTileEntity(x, y, z, createNewTileEntity(world, 0));
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer entityPlayer) {
		if (entityPlayer.capabilities.isCreativeMode)
			return;
		TileEntityInvisiGlass tile = (TileEntityInvisiGlass) world.getTileEntity(x, y, z);

		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.dye, tile.red / 20, 1)));
		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.dye, tile.green / 20, 2)));
		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Items.dye, tile.blue / 20, 4)));
		world.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.obsidian, (int) (tile.hardness / 50.f))));
	}

	@Override
	public int getMobilityFlag() {
		return 0;
	}

	@Override
	public void onFallenUpon(World world, int x, int y, int z, Entity entity, float v) {
		entity.motionY = 10/*Math.max(entity.motionY, -1)*/;
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

		if (this == InitModBlocks.blockInvisiGlass) {
			if (world.getBlock(x, y, z).colorMultiplier(world, x, y, z) != world.getBlock(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]).colorMultiplier(world, x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side]) || world.getBlockMetadata(x, y, z) != world.getBlockMetadata(x - Facing.offsetsXForSide[side], y - Facing.offsetsYForSide[side], z - Facing.offsetsZForSide[side])) {
				return true;
			}

			if (block == this) {
				return false;
			}
		}

		return block == this ? false : super.shouldSideBeRendered(world, x, y, z, side);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}
}
