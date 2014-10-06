package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.client.render.RenderEffectHelper;
import com.crystalix007.letsmodreboot.effect.EntityEnderFX;
import com.crystalix007.letsmodreboot.handler.ConfigurationHandler;
import com.crystalix007.letsmodreboot.utility.BlockCoord;
import com.crystalix007.letsmodreboot.utility.VectorHelper;
import net.minecraft.block.BlockAir;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import javax.vecmath.Vector3d;

public class ItemEnderStaff extends ItemLMRB
{
	protected ItemStack emptyItem = null;
	protected static int maxDamage;

	public ItemEnderStaff()
	{
		super();
		setUnlocalizedName("enderStaff");

		setMaxStackSize(1);
		setMaxDamage(256);
		maxDamage = getMaxDamage();

		setNoRepair();
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (player.isSneaking()) {
			Vector3d eye = VectorHelper.getEyePositionLMRB(player);
			Vector3d look = VectorHelper.getLookVecLMRB(player);

			Vector3d sample = new Vector3d(look);
			sample.scale(ConfigurationHandler.teleportDist);
			sample.add(eye);

			Vec3 eye3 = Vec3.createVectorHelper(eye.x, eye.y, eye.z);
			Vec3 end = Vec3.createVectorHelper(sample.x, sample.y, sample.z);

			double playerHeight = player.yOffset;
			double lookComp = -look.y * playerHeight;
			double maxDistance = ConfigurationHandler.teleportDist + lookComp;

			MovingObjectPosition p = player.worldObj.rayTraceBlocks(eye3, end, false);

			if (p == null) {
				for (double i = maxDistance; i > 1; i--) {
					sample.set(look);
					sample.scale(i);
					sample.add(eye);
					sample.y -= playerHeight;

					if (canTravelTo(player, sample.x, sample.y, sample.z)) {
						RenderEffectHelper.spreadEffects(new EntityEnderFX(world, player.posX, player.posY, player.posZ), player.posX, player.posZ, 4, 5);
						itemStack.damageItem(1, player);
						player.fallDistance = 0;
					}

					if (doBlinkAround(player, sample)) {
						RenderEffectHelper.spreadEffects(new EntityEnderFX(world, player.posX, player.posY, player.posZ), player.posX, player.posZ, 4, 5);
						return itemStack;
					}
				}
			} else {
				eye3 = Vec3.createVectorHelper(eye.x, eye.y, eye.z);
				Vector3d targetBc = new Vector3d(p.blockX, p.blockY, p.blockZ);
				double sampleDistance = 1.5;
				double teleDistance = p.hitVec.distanceTo(eye3) + sampleDistance;

				while (teleDistance < maxDistance) {
					sample.set(look);
					sample.scale(sampleDistance);
					sample.add(targetBc);
					sample.y -= playerHeight;

					if (doBlinkAround(player, sample)) {
						player.swingItem();
						itemStack.damageItem(1, player);
						return itemStack;
					}
					teleDistance++;
					sampleDistance++;
				}
				sampleDistance = -0.5;
				teleDistance = p.hitVec.distanceTo(eye3) + sampleDistance;

				while (teleDistance > 1) {
					sample.set(look);
					sample.scale(sampleDistance);
					sample.add(targetBc);
					sample.y -= playerHeight;

					if (doBlinkAround(player, sample)) {
						player.swingItem();
						itemStack.damageItem(1, player);
						return itemStack;
					}
					sampleDistance--;
					teleDistance--;
				}
			}
		}
		return itemStack;
	}

	private boolean doBlinkAround(EntityPlayer player, Vector3d sample)
	{
		if (doBlink(player, new BlockCoord((int) Math.round(sample.x), (int) Math.round(sample.y) - 1, (int) Math.round(sample.z)))) {
			return true;
		}
		if (doBlink(player, new BlockCoord((int) Math.round(sample.x), (int) Math.round(sample.y), (int) Math.round(sample.z)))) {
			return true;
		}
		return (doBlink(player, new BlockCoord((int) Math.round(sample.x), (int) Math.round(sample.y) + 1, (int) Math.round(sample.z))));
	}

	private boolean doBlink(EntityPlayer player, BlockCoord coord)
	{
		World world = player.worldObj;

		if  (canTravelTo(player, coord.x, coord.y, coord.z)) {
			player.setPositionAndUpdate(coord.x, coord.y, coord.z);
			player.swingItem();
			return true;
		}
		else
			return false;
	}

	public boolean canTravelTo(Entity entity, double x, double y, double z)
	{
		int i = (int)(Math.round(x));
		int j = (int)(Math.round(y));
		int k = (int)(Math.round(z));

		return canTravelTo(entity, i, j, k);
	}

	public boolean canTravelTo(Entity entity, int x, int y, int z)
	{
		World world = entity.worldObj;

		for (int i = y; i <= y + (entity.getEyeHeight() - entity.yOffset); i++)
		{
			if (!(world.getBlock(x, i, z) instanceof BlockAir))
			{
				return false;
			}
		}

		return true;
	}
}
