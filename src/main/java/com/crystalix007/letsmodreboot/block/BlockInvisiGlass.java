package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.proxy.ClientProxy;
import com.crystalix007.letsmodreboot.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockInvisiGlass extends BlockGlassLMRB
{
	protected int red = 0;
	protected int green = 0;
	protected int blue = 0;

	public BlockInvisiGlass()
	{
		super("invisiGlass");
		this.setBlockName("invisiGlass");
		this.lightOpacity = 0;
	}

	/*@Override //Makes it able to be walked through
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return null;
	}*/

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float v, float v1, float v2)
	{
		ItemStack currentItem = player.getCurrentEquippedItem();
		if (currentItem == null)
			return false;

		LogHelper.info("Current item: " + currentItem.getUnlocalizedName());
		LogHelper.info("ItemDye: " + new ItemDye().getUnlocalizedName());

		if (currentItem.getUnlocalizedName().substring(0, currentItem.getUnlocalizedName().indexOf('.')).equals("item.dyePowder"))
		{
			if (world.isRemote)
				ClientProxy.printMessageToPlayer("Using dye on block");
			if (currentItem.getItemDamage() == 1 && red < 240)
				red += 20;
			if (currentItem.getItemDamage() == 2 && green < 240)
				green += 20;
			if (currentItem.getItemDamage() == 4 && blue < 240)
				blue += 20;
		}

		if (world.isRemote)
		{
			ClientProxy.printMessageToPlayer("Red: " + String.valueOf(red));
			ClientProxy.printMessageToPlayer("Green: " + String.valueOf(green));
			ClientProxy.printMessageToPlayer("Blue: " + String.valueOf(blue));
		}
		return super.onBlockActivated(world, x, y, z, player, i, v, v1, v2);
	}

	@SideOnly(Side.CLIENT)
	public int getBlockColor()
	{
		return ((red * 65536) + (green * 256) + blue);
	}

	@SideOnly(Side.CLIENT)
	public int getRenderColor(int i)
	{
		return getBlockColor();
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess iBlockAccess, int x, int y, int z)
	{
		return getBlockColor();
	}

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z)
	{
		return AxisAlignedBB.getBoundingBox(0, 0, 0, 0, 0, 0);
	}
}
