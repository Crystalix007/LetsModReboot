package com.crystalix007.letsmodreboot.utility;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;

import javax.vecmath.Vector3d;

public class UtilityVectorHelper
{
	public static Vec3 getEyePosition(EntityPlayer player)
	{
		Vec3 res = Vec3.createVectorHelper(player.posX, player.posY, player.posZ);

		if (player.worldObj.isRemote)
		{
			res.yCoord += player.getEyeHeight() - player.getDefaultEyeHeight();
		}
		else
		{
			res.yCoord += player.getEyeHeight();

			if (player instanceof EntityPlayerMP && player.isSneaking())
			{
				res.yCoord -= 0.08;
			}
		}
		return res;
	}

	public static Vector3d getEyePositionLMRB(EntityPlayer player)
	{
		Vector3d res = new Vector3d(player.posX, player.posY, player.posZ);

		if (player.worldObj.isRemote)
		{
			res.y += player.getEyeHeight() - player.getDefaultEyeHeight();
		}
		else
		{
			res.y += player.getEyeHeight();

			if (player instanceof EntityPlayerMP && player.isSneaking())
			{
				res.y -= 0.08;
			}
		}
		return res;
	}

	public static Vector3d getLookVecLMRB(EntityPlayer player)
	{
		Vec3 lv = player.getLookVec();
		return new Vector3d(lv.xCoord, lv.yCoord, lv.zCoord);
	}
}
