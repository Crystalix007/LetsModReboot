package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTEWindmill extends TileEntitySpecialRenderer
{
	protected static final ResourceLocation textureWindmill = new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase() + ":textures/model/windmill.png");
	protected static final int textureWidth = 64;
	protected static final int textureHeight = 32;

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float v) {
		GL11.glPushMatrix();
		{
			GL11.glTranslated(x, y, z);

			Tessellator tessellator = Tessellator.instance;
			bindTexture(textureWindmill);
			tessellator.startDrawingQuads();
			{
				tessellator.addVertexWithUV(0, 0, 1, 1, 1);
				tessellator.addVertexWithUV(0, 1, 1, 1, 0);
				tessellator.addVertexWithUV(0, 1, 0, 0, 0);
				tessellator.addVertexWithUV(0, 0, 0, 0, 1);
			}
			tessellator.draw();
		}   GL11.glPopMatrix();
	}
}
