package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.util.ResourceLocation;

public class RenderEntityTeleportArrow extends RenderEntityProjectileBase
{
	public RenderEntityTeleportArrow() {
		super("entityTeleportArrow");
		this.arrowTextures = new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase() + ":textures/entities/" + thisName + ".png");
	}
}
