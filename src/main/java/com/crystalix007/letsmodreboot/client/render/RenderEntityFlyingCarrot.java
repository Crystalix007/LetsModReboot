package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.util.ResourceLocation;

public class RenderEntityFlyingCarrot extends RenderEntityProjectileBase
{
	public RenderEntityFlyingCarrot() {
		super("entityFlyingCarrot");
		arrowTextures = new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase(), "textures/entities/" + thisName);
	}
}