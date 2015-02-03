package com.crystalix007.letsmodreboot.effect;

import net.minecraft.world.World;

public class EntityEnderFX extends EntityLMRBFX {
	public EntityEnderFX(World world, double x, double y, double z) {
		super(world, x, y, z, "enderFX");
		setGravity(0.01F);
		setScale(1);
		setMaxAge(600);
	}

	public static void spreadEffects(World world, double x, double y, double z, int effectCount, int radius)
	{
		if (!world.isRemote)
			return;

		for (int i = 0; i < effectCount; i++)
		{
			int randX = (int)(x + (((Math.random() * 20) % (radius * 2)) - radius));
			int randY = (int)(y);
			int randZ = (int)(z + (((Math.random() * 20) % (radius * 2)) - radius));

			EntityEnderFX newEntityFX = new EntityEnderFX(world, randX, randY, randZ);

			renderEffect(newEntityFX);
			updateEffects();
		}
	}
}
