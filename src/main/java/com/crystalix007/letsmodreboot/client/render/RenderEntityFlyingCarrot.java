package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class RenderEntityFlyingCarrot extends RenderEntityProjectileBase
{
	public RenderEntityFlyingCarrot() {
		super("entityFlyingCarrot");
		arrowTextures = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/entities/" + thisName + ".png");
	}
}