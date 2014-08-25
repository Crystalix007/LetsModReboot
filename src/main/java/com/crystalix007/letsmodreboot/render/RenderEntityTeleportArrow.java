package com.crystalix007.letsmodreboot.render;

import com.crystalix007.letsmodreboot.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class RenderEntityTeleportArrow extends RenderEntityProjectileBase
{
	public RenderEntityTeleportArrow() {
		super("entityTeleportArrow");
		arrowTextures = new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/entities/" + thisName + ".png");
	}
}
