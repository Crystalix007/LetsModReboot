package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.entity.EntityProjectileBase;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import com.crystalix007.letsmodreboot.utility.UtilityLogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderEntityProjectileBase extends Render
{
	protected static ResourceLocation arrowTextures;
	protected String thisName;

	public RenderEntityProjectileBase(String name)
	{
		thisName = name;
		arrowTextures = new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase(), "textures/entities/" + name);
		UtilityLogHelper.info("Reading file at: " + arrowTextures.toString());
		//bindEntityTexture(EntityFlyingCarrot.class);
		//bindTexture(arrowTextures);
		Minecraft.getMinecraft().renderEngine.bindTexture(arrowTextures);
	}

	public String getUnlocalizedName()
	{
		return thisName;
	}

	public void doRender(EntityArrow entityArrow, double v, double v1, double v2, float Float, float Float2)
	{
		this.bindEntityTexture(entityArrow);
		GL11.glPushMatrix();
		GL11.glTranslatef((float)v, (float)v1, (float)v2);
		GL11.glRotatef(entityArrow.prevRotationYaw + (entityArrow.rotationYaw - entityArrow.prevRotationYaw) * Float2 - 90.0F, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(entityArrow.prevRotationPitch + (entityArrow.rotationPitch - entityArrow.prevRotationPitch) * Float2, 0.0F, 0.0F, 1.0F);
		Tessellator tessellator = Tessellator.instance;
		byte b0 = 0;
		float f2 = 0.0F;
		float f3 = 0.5F;
		float f4 = (float)(0 + b0 * 10) / 32.0F;
		float f5 = (float)(5 + b0 * 10) / 32.0F;
		float f6 = 0.0F;
		float f7 = 0.15625F;
		float f8 = (float)(5 + b0 * 10) / 32.0F;
		float f9 = (float)(10 + b0 * 10) / 32.0F;
		float f10 = 0.05625F;
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		float f11 = (float)entityArrow.arrowShake - Float2;

		if (f11 > 0.0F)
		{
			float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
			GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
		}

		GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
		GL11.glScalef(f10, f10, f10);
		GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
		GL11.glNormal3f(f10, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)f6, (double)f8);
		tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)f7, (double)f8);
		tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)f7, (double)f9);
		tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)f6, (double)f9);
		tessellator.draw();
		GL11.glNormal3f(-f10, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-7.0D, 2.0D, -2.0D, (double)f6, (double)f8);
		tessellator.addVertexWithUV(-7.0D, 2.0D, 2.0D, (double)f7, (double)f8);
		tessellator.addVertexWithUV(-7.0D, -2.0D, 2.0D, (double)f7, (double)f9);
		tessellator.addVertexWithUV(-7.0D, -2.0D, -2.0D, (double)f6, (double)f9);
		tessellator.draw();

		for (int i = 0; i < 4; ++i)
		{
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
			GL11.glNormal3f(0.0F, 0.0F, f10);
			tessellator.startDrawingQuads();
			tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double)f2, (double)f4);
			tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, (double)f3, (double)f4);
			tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, (double)f3, (double)f5);
			tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double)f2, (double)f5);
			tessellator.draw();
		}

		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityArrow entityArrow)
	{
		return arrowTextures;
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityArrow)entity);
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	 * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	 * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	 * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity entity, double v, double v1, double v2, float Float, float Float2)
	{
		this.doRender((EntityProjectileBase)entity, v, v1, v2, Float, Float2);
	}
}
