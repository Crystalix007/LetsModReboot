package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class BlockAntigrav extends BlockLMRB
{
	protected IIcon top_icon;
	protected IIcon other_icon;

	public BlockAntigrav()
	{
		super(Material.iron);
		this.setBlockName("blockAntigrav");
		this.setBlockBounds(0, 0, 0, 1, 0.99f, 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		return (side == 1 ? top_icon : other_icon);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, int x, int y, int z, Entity entity)
	{
		if (entity instanceof EntityItem || entity instanceof EntityFallingBlock)
		{
			entity.motionY *= -2;
			entity.velocityChanged = true;
		}
		else {
			entity.fallDistance = 0;
			entity.velocityChanged = true;
			entity.motionY = 10;
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.top_icon = iconRegister.registerIcon(ReferenceMod.MOD_ID.toLowerCase() + ":" + "blockAntigrav_top");
		this.other_icon = iconRegister.registerIcon(ReferenceMod.MOD_ID.toLowerCase() + ":" + "blockAntigrav_side");
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int v, float xPos, float yPos, float zPos)
	{
		List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, AxisAlignedBB.getBoundingBox(x - 3, y, z - 3, x + 3, y + 7, z + 3));

		for (Entity entity : entities)
		{
			entity.motionY += max(7 - (entity.posX - x), 0);
			entity.velocityChanged = true;

			if (entity instanceof EntityPlayer && !world.isRemote)
			{
				((EntityPlayer) entity).addChatComponentMessage(new ChatComponentText("You are whisked into the sky"));
			}
		}

		return true;
	}

	private double min(double one, double two) {
		return (one > two ? two : one);
	}

	private double max(double one, double two) {
		return (one < two ? two : one);
	}
}
