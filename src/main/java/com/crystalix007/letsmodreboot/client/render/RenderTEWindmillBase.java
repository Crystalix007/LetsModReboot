package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.block.BlockWindmillBase;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderTEWindmillBase extends TileEntitySpecialRenderer
{
	protected static final ResourceLocation textureWindmillBase = new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase(), "textures/model/windmillBase.png");
	protected static final int textureWidth = 32;
	protected static final int textureHeight = 32;

	protected static float pixel = 1.f / 16.f;
	protected static float wPixel = 1 / (float)(textureWidth);
	protected static float hPixel = 1 / (float)(textureHeight);

	public void renderNormalBlock(double x, double y, double z)
	{
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		{
			//Draw top face
			tessellator.addVertexWithUV(1, 5 * pixel, 1, 1, 1);
			tessellator.addVertexWithUV(1, 5 * pixel, 0, 1, 0);
			tessellator.addVertexWithUV(0, 5 * pixel, 0, 0, 0);
			tessellator.addVertexWithUV(0, 5 * pixel, 1, 0, 1);

			//Draw 0-side faces
			tessellator.addVertexWithUV(0, 5 * pixel, 1, 1, 1);
			tessellator.addVertexWithUV(0, 5 * pixel, 0, 1, 0);
			tessellator.addVertexWithUV(0, 0, 0, 0, 0);
			tessellator.addVertexWithUV(0, 0, 1, 0, 1);

			tessellator.addVertexWithUV(1, 5 * pixel, 0, 1, 1);
			tessellator.addVertexWithUV(1, 0, 0, 1, 0);
			tessellator.addVertexWithUV(0, 0, 0, 0, 0);
			tessellator.addVertexWithUV(0, 5 * pixel, 0, 0, 1);

			//Draw 1-side faces
			tessellator.addVertexWithUV(1, 0, 1, 0, 1);
			tessellator.addVertexWithUV(1, 0, 0, 0, 0);
			tessellator.addVertexWithUV(1, 5 * pixel, 0, 1, 0);
			tessellator.addVertexWithUV(1, 5 * pixel, 1, 1, 1);

			tessellator.addVertexWithUV(0, 5 * pixel, 1, 0, 1);
			tessellator.addVertexWithUV(0, 0, 1, 0, 0);
			tessellator.addVertexWithUV(1, 0, 1, 1, 0);
			tessellator.addVertexWithUV(1, 5 * pixel, 1, 1, 1);

			//Draw top face
			tessellator.addVertexWithUV(0, 5 * pixel, 1, 0, 1);
			tessellator.addVertexWithUV(0, 5 * pixel, 0, 0, 0);
			tessellator.addVertexWithUV(1, 5 * pixel, 0, 1, 0);
			tessellator.addVertexWithUV(1, 5 * pixel, 1, 1, 1);
		}
		tessellator.draw();
		return;
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float v) {
		World theWorld = tileEntity.getWorldObj();
		GL11.glPushMatrix();
		{
			GL11.glTranslated(x, y, z);
			Tessellator tessellator = Tessellator.instance;
			bindTexture(textureWindmillBase);
			{
				int posInMultiblockStructure = ((BlockWindmillBase) theWorld.getBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord)).getPositionInMultiblock(theWorld, tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);

				if (posInMultiblockStructure == -1) //If not part of a multiblock
					renderNormalBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
				else if (theWorld.getBlockMetadata(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord) == 2)    //Is the center block
					renderNormalBlock(tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord);
				else
				{
					tessellator.startDrawingQuads();
					tessellator.addVertexWithUV(0, 5 * pixel, 1, (32) * wPixel, (32) * hPixel);
					tessellator.addVertexWithUV(1, 5 * pixel, 1, (32) * wPixel, (8 + 16) * hPixel);
					tessellator.addVertexWithUV(1, 5 * pixel, 0, 8 * wPixel, (8 + 16) * hPixel);
					tessellator.addVertexWithUV(0, 5 * pixel, 0, 8 * wPixel, (8 + 32) * hPixel);
					tessellator.draw();
				}
			}
		}
		GL11.glPopMatrix();
	}
}
