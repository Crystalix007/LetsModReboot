package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.model.ModelFrame;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTEFrame extends TileEntitySpecialRenderer
{
	protected ModelFrame model;

	public RenderTEFrame() {
		this.model = new ModelFrame();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float v) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5f, (float) y + 1.5f, (float) z + 0.5f);
		GL11.glRotatef(180F, 0F, 0F, 1F);

		bindTexture(new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase(), "textures/model/frameBlock.png"));
		GL11.glPushMatrix();
		model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
