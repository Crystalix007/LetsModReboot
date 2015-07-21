package com.crystalix007.letsmodreboot.utility;

import net.minecraft.entity.Entity;

public class UtilityMoveHelper
{
	public static void moveTo(Entity entity, double[] newPos, double[] currPos)
	{
		double move[] = {0, 0, 0};

		for (int i = 0; i < 3; i++)
			move[i] = newPos[i] - currPos[i];

		entity.moveEntity(move[0], move[1], move[2]);
	}

	public static void moveTo(Entity entity, double newX, double newY, double newZ, double[] currPos)
	{
		double move[] = {0, 0, 0};

		move[0] = newX - currPos[0];
		move[1] = newY - currPos[1];
		move[2] = newZ - currPos[2];

		entity.moveEntity(move[0], move[1], move[2]);
	}

	public static void moveTo(Entity entity, double[] newPos, double currX, double currY, double currZ)
	{
		double move[] = {0, 0, 0};

		move[0] = newPos[0] - currX;
		move[1] = newPos[1] - currY;
		move[2] = newPos[2] - currZ;

		entity.moveEntity(move[0], move[1], move[2]);
	}

	public static void moveTo(Entity entity, double newX, double newY, double newZ, double currX, double currY, double currZ)
	{
		double move[] = {0, 0, 0};

		move[0] = newX - currX;
		move[1] = newY - currY;
		move[2] = newZ - currZ;

		entity.moveEntity(move[0], move[1], move[2]);
	}
}
