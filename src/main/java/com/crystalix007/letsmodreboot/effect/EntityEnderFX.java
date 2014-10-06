package com.crystalix007.letsmodreboot.effect;

import net.minecraft.world.World;

public class EntityEnderFX extends EntityLMRBFX {
	public EntityEnderFX(World world, double x, double y, double z) {
		super(world, x, y, z, "enderFX");
		setGravity(0.01F);
		setScale(1);
		setMaxAge(600);
	}
}
