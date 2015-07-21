package com.crystalix007.letsmodreboot.effect;

import net.minecraft.world.World;

public class EffectEntityEnder extends EffectEntityLMRB {
	public EffectEntityEnder(World world, double x, double y, double z) {
		super(world, x, y, z, "enderFX");
		setGravity(0.1F);
		setScale(1);
		setMaxAge(60);
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

			EffectEntityEnder newEntityFX = new EffectEntityEnder(world, randX, randY, randZ);

			renderEffect(newEntityFX);
			updateEffects();
		}
	}
}
