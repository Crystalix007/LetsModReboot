package com.crystalix007.letsmodreboot.effect;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import static org.lwjgl.opengl.GL11.*;

abstract public class EffectEntityLMRB extends EntityFX
{
	protected String unlocalizedName;
	protected static ResourceLocation texture;

	protected EffectEntityLMRB(World world, double x, double y, double z, String name) {
		super(world, x, y, z);

		//Naming
		unlocalizedName = name;
		//Setting texture based on name
		texture = new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase(), "textures/particle/" + unlocalizedName + ".png");
		//Functions on the actual object would go here - like setGravity(1);
	}

	@Override
	public void renderParticle(Tessellator tessellator, float partialTicks, float par3, float par4, float par5, float par6, float par7)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		glPushMatrix();

		glDepthMask(false);
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		glAlphaFunc(GL_GREATER, 0.003921569F);

		tessellator.startDrawingQuads();
		tessellator.setBrightness(getBrightnessForRender(partialTicks));

		float scale = 0.1F * particleScale;
		float x = (float)(prevPosX + (posX - prevPosX) * partialTicks - interpPosX);
		float y = (float)(prevPosY + (posY - prevPosY) * partialTicks - interpPosY);
		float z = (float)(prevPosZ + (posZ - prevPosZ) * partialTicks - interpPosZ);

		//The square
		tessellator.addVertexWithUV(x - par3 * scale - par6 * scale, y - par4 * scale, z - par5 *scale - par7 * scale, 0, 0);
		tessellator.addVertexWithUV(x - par3 * scale + par6 * scale, y + par4 * scale, z - par5 *scale + par7 * scale, 1, 0);
		tessellator.addVertexWithUV(x + par3 * scale + par6 * scale, y + par4 * scale, z - par5 *scale + par7 * scale, 1, 1);
		tessellator.addVertexWithUV(x + par3 * scale - par6 * scale, y - par4 * scale, z - par5 *scale - par7 * scale, 0, 1);

		tessellator.draw();
		glDisable(GL_BLEND);
		glDepthMask(true);
		glAlphaFunc(GL_GREATER, 0.1F);

		glPopMatrix();
	}

	@Override
	public int getFXLayer()
	{
		return 3;
	}

	public EffectEntityLMRB setMaxAge(int maxAge)
	{
		particleMaxAge = maxAge;
		return this;
	}

	public EffectEntityLMRB setGravity(float gravity)
	{
		particleGravity = gravity;
		return this;
	}

	public EffectEntityLMRB setScale(float scale)
	{
		particleScale = scale;
		return this;
	}

	public String getUnlocalizedName()
	{
		return unlocalizedName;
	}

	public void setTextureName(String textureName)
	{
		texture = new ResourceLocation(ReferenceMod.MOD_ID.toLowerCase(), "textures/particles/" + textureName + ".png");
	}

	public String getLocalizedName()
	{
		return StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
	}

	public static void renderEffect(EntityFX entityFX)
	{
		Minecraft.getMinecraft().effectRenderer.addEffect(entityFX);
	}

	public static void updateEffects()
	{
		Minecraft.getMinecraft().effectRenderer.updateEffects();
	}

	public static void spreadEffects(World world, double x, double y, double z, int effectCount, int radius){};
}
