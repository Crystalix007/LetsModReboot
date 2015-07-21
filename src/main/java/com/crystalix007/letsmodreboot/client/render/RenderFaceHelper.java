package com.crystalix007.letsmodreboot.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class RenderFaceHelper
{
	public static Tessellator tessellator = Tessellator.instance;
	public final World world;

	public RenderFaceHelper(World theWorld)
	{
		world = theWorld;
	}

	public boolean renderStandardBlock(Block block, int x, int y, int z)
	{
		int l = block.colorMultiplier(world, x, y, z);
		float red = (float)(l >> 16 & 255) / 255.0F;
		float green = (float)(l >> 8 & 255) / 255.0F;
		float blue = (float)(l & 255) / 255.0F;

		if (EntityRenderer.anaglyphEnable)
		{
			float f3 = (red * 30.0F + green * 59.0F + blue * 11.0F) / 100.0F;
			float f4 = (red * 30.0F + green * 70.0F) / 100.0F;
			float f5 = (red * 30.0F + blue * 70.0F) / 100.0F;
			red = f3;
			green = f4;
			blue = f5;
		}

		return this.renderStandardBlockWithColorMultiplier(block, x, y, z, red, green, blue);
	}

	public int damageDropped(int meta)
	{
		return meta;
	}

	public boolean renderStandardBlockWithColorMultiplier(Block block, int x, int y, int z, float red, float green, float blue)
	{
		boolean flag = false;
		float f3 = 0.5F;
		float f4 = 1.0F;
		float f5 = 0.8F;
		float f6 = 0.6F;
		float f7 = f4 * red;
		float f8 = f4 * green;
		float f9 = f4 * blue;
		float f10;
		float f11;
		float f12;
		float f13;
		float f14;
		float f15;
		float f16;
		float f17;
		float f18;
		
		f10 = f3 * red;
		f11 = f5 * red;
		f12 = f6 * red;
		f13 = f3 * green;
		f14 = f5 * green;
		f15 = f6 * green;
		f16 = f3 * blue;
		f17 = f5 * blue;
		f18 = f6 * blue;
		

		int l = block.getMixedBrightnessForBlock(world, x, y, z);

		if (block.shouldSideBeRendered(world, x, y - 1, z, 0))
		{
			tessellator.setBrightness(block.getBlockBoundsMinY() > 0.0D ? l : block.getMixedBrightnessForBlock(world, x, y - 1, z));
			//tessellator.setColorOpaque_F(f10, f13, f16);
			this.renderFaceYNeg(block, (double)x, (double)y, (double)z, block.getBlockTextureFromSide(0));
			flag = true;
		}

		if (block.shouldSideBeRendered(world, x, y + 1, z, 1))
		{
			tessellator.setBrightness(block.getBlockBoundsMaxY() < 1.0D ? l : block.getMixedBrightnessForBlock(world, x, y + 1, z));
			//tessellator.setColorOpaque_F(f7, f8, f9);
			this.renderFaceYPos(block, (double)x, (double)y, (double)z, block.getBlockTextureFromSide(1));
			flag = true;
		}

		IIcon iicon;

		if (block.shouldSideBeRendered(world, x, y, z - 1, 2))
		{
			tessellator.setBrightness(block.getBlockBoundsMinZ() > 0.0D ? l : block.getMixedBrightnessForBlock(world, x, y, z - 1));
			//tessellator.setColorOpaque_F(f11, f14, f17);
			iicon = block.getBlockTextureFromSide(2);
			this.renderFaceZNeg(block, (double)x, (double)y, (double)z, iicon);
			flag = true;
		}

		if (block.shouldSideBeRendered(world, x, y, z + 1, 3))
		{
			tessellator.setBrightness(block.getBlockBoundsMaxZ() < 1.0D ? l : block.getMixedBrightnessForBlock(world, x, y, z + 1));
			//tessellator.setColorOpaque_F(f11, f14, f17);
			iicon = block.getBlockTextureFromSide(3);
			this.renderFaceZPos(block, (double)x, (double)y, (double)z, iicon);
			flag = true;
		}

		if (block.shouldSideBeRendered(world, x - 1, y, z, 4))
		{
			tessellator.setBrightness(block.getBlockBoundsMinX() > 0.0D ? l : block.getMixedBrightnessForBlock(world, x - 1, y, z));
			//tessellator.setColorOpaque_F(f12, f15, f18);
			iicon = block.getBlockTextureFromSide(4);
			this.renderFaceXNeg(block, (double)x, (double)y, (double)z, iicon);
			flag = true;
		}

		if (block.shouldSideBeRendered(world, x + 1, y, z, 5))
		{
			tessellator.setBrightness(block.getBlockBoundsMaxX() < 1.0D ? l : block.getMixedBrightnessForBlock(world, x + 1, y, z));
			//tessellator.setColorOpaque_F(f12, f15, f18);
			iicon = block.getBlockTextureFromSide(5);
			this.renderFaceXPos(block, (double)x, (double)y, (double)z, iicon);
			flag = true;
		}

		return flag;
	}

	/**
	 * Renders the given texture to the bottom face of the block. Args: block, x, y, z, texture
	 */
	public void renderFaceYNeg(Block block, double x, double y, double z, IIcon texture)
	{
		double d3 = (double)texture.getInterpolatedU(block.getBlockBoundsMinX() * 16.0D);
		double d4 = (double)texture.getInterpolatedU(block.getBlockBoundsMaxX() * 16.0D);
		double d5 = (double)texture.getInterpolatedV(block.getBlockBoundsMinZ() * 16.0D);
		double d6 = (double)texture.getInterpolatedV(block.getBlockBoundsMaxZ() * 16.0D);

		if (block.getBlockBoundsMinX() < 0.0D || block.getBlockBoundsMaxX() > 1.0D)
		{
			d3 = (double)texture.getMinU();
			d4 = (double)texture.getMaxU();
		}

		if (block.getBlockBoundsMinZ() < 0.0D || block.getBlockBoundsMaxZ() > 1.0D)
		{
			d5 = (double)texture.getMinV();
			d6 = (double)texture.getMaxV();
		}

		double d7 = d4;
		double d8 = d3;
		double d9 = d5;
		double d10 = d6;
		double d11 = x + block.getBlockBoundsMinX();
		double d12 = x + block.getBlockBoundsMaxX();
		double d13 = y + block.getBlockBoundsMinY();
		double d14 = z + block.getBlockBoundsMinZ();
		double d15 = z + block.getBlockBoundsMaxZ();
		
		tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
		tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
		tessellator.addVertexWithUV(d12, d13, d14, d7, d9);
		tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
		
	}

	/**
	 * Renders the given texture to the top face of the block. Args: block, x, y, z, texture
	 */
	public void renderFaceYPos(Block block, double x, double y, double z, IIcon texture)
	{
		double d3 = (double)texture.getInterpolatedU(block.getBlockBoundsMinX() * 16.0D);
		double d4 = (double)texture.getInterpolatedU(block.getBlockBoundsMaxX() * 16.0D);
		double d5 = (double)texture.getInterpolatedV(block.getBlockBoundsMinZ() * 16.0D);
		double d6 = (double)texture.getInterpolatedV(block.getBlockBoundsMaxZ() * 16.0D);

		if (block.getBlockBoundsMinX() < 0.0D || block.getBlockBoundsMaxX() > 1.0D)
		{
			d3 = (double)texture.getMinU();
			d4 = (double)texture.getMaxU();
		}

		if (block.getBlockBoundsMinZ() < 0.0D || block.getBlockBoundsMaxZ() > 1.0D)
		{
			d5 = (double)texture.getMinV();
			d6 = (double)texture.getMaxV();
		}

		double d7 = d4;
		double d8 = d3;
		double d9 = d5;
		double d10 = d6;

		double d11 = x + block.getBlockBoundsMinX();
		double d12 = x + block.getBlockBoundsMaxX();
		double d13 = y + block.getBlockBoundsMaxY();
		double d14 = z + block.getBlockBoundsMinZ();
		double d15 = z + block.getBlockBoundsMaxZ();
		
		tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
		tessellator.addVertexWithUV(d12, d13, d14, d7, d9);
		tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
		tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
		
	}

	/**
	 * Renders the given texture to the north (z-negative) face of the block.  Args: block, x, y, z, texture
	 */
	public void renderFaceZNeg(Block block, double x, double y, double z, IIcon texture)
	{
		double d3 = (double)texture.getInterpolatedU(block.getBlockBoundsMinX() * 16.0D);
		double d4 = (double)texture.getInterpolatedU(block.getBlockBoundsMaxX() * 16.0D);

		double d5 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMaxY() * 16.0D);
		double d6 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMinY() * 16.0D);
		double d7;

		if (block.getBlockBoundsMinX() < 0.0D || block.getBlockBoundsMaxX() > 1.0D)
		{
			d3 = (double)texture.getMinU();
			d4 = (double)texture.getMaxU();
		}

		if (block.getBlockBoundsMinY() < 0.0D || block.getBlockBoundsMaxY() > 1.0D)
		{
			d5 = (double)texture.getMinV();
			d6 = (double)texture.getMaxV();
		}

		d7 = d4;
		double d8 = d3;
		double d9 = d5;
		double d10 = d6;

		double d11 = x + block.getBlockBoundsMinX();
		double d12 = x + block.getBlockBoundsMaxX();
		double d13 = y + block.getBlockBoundsMinY();
		double d14 = y + block.getBlockBoundsMaxY();
		double d15 = z + block.getBlockBoundsMinZ();
		
		tessellator.addVertexWithUV(d11, d14, d15, d7, d9);
		tessellator.addVertexWithUV(d12, d14, d15, d3, d5);
		tessellator.addVertexWithUV(d12, d13, d15, d8, d10);
		tessellator.addVertexWithUV(d11, d13, d15, d4, d6);
	}

	/**
	 * Renders the given texture to the south (z-positive) face of the block.  Args: block, x, y, z, texture
	 */
	public void renderFaceZPos(Block block, double x, double y, double z, IIcon texture)
	{
		double d3 = (double)texture.getInterpolatedU(block.getBlockBoundsMinX() * 16.0D);
		double d4 = (double)texture.getInterpolatedU(block.getBlockBoundsMaxX() * 16.0D);
		double d5 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMaxY() * 16.0D);
		double d6 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMinY() * 16.0D);
		double d7;

		if (block.getBlockBoundsMinX() < 0.0D || block.getBlockBoundsMaxX() > 1.0D)
		{
			d3 = (double)texture.getMinU();
			d4 = (double)texture.getMaxU();
		}

		if (block.getBlockBoundsMinY() < 0.0D || block.getBlockBoundsMaxY() > 1.0D)
		{
			d5 = (double)texture.getMinV();
			d6 = (double)texture.getMaxV();
		}

		d7 = d4;
		double d8 = d3;
		double d9 = d5;
		double d10 = d6;

		double d11 = x + block.getBlockBoundsMinX();
		double d12 = x + block.getBlockBoundsMaxX();
		double d13 = y + block.getBlockBoundsMinY();
		double d14 = y + block.getBlockBoundsMaxY();
		double d15 = z + block.getBlockBoundsMaxZ();
		
		tessellator.addVertexWithUV(d11, d14, d15, d3, d5);
		tessellator.addVertexWithUV(d11, d13, d15, d8, d10);
		tessellator.addVertexWithUV(d12, d13, d15, d4, d6);
		tessellator.addVertexWithUV(d12, d14, d15, d7, d9);

	}

	/**
	 * Renders the given texture to the west (x-negative) face of the block.  Args: block, x, y, z, texture
	 */
	public void renderFaceXNeg(Block block, double x, double y, double z, IIcon texture)
	{
		double d3 = (double)texture.getInterpolatedU(block.getBlockBoundsMinZ() * 16.0D);
		double d4 = (double)texture.getInterpolatedU(block.getBlockBoundsMaxZ() * 16.0D);
		double d5 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMaxY() * 16.0D);
		double d6 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMinY() * 16.0D);
		double d7;

		if (block.getBlockBoundsMinZ() < 0.0D || block.getBlockBoundsMaxZ() > 1.0D)
		{
			d3 = (double)texture.getMinU();
			d4 = (double)texture.getMaxU();
		}

		if (block.getBlockBoundsMinY() < 0.0D || block.getBlockBoundsMaxY() > 1.0D)
		{
			d5 = (double)texture.getMinV();
			d6 = (double)texture.getMaxV();
		}

		d7 = d4;
		double d8 = d3;
		double d9 = d5;
		double d10 = d6;

		double d11 = x + block.getBlockBoundsMinX();
		double d12 = y + block.getBlockBoundsMinY();
		double d13 = y + block.getBlockBoundsMaxY();
		double d14 = z + block.getBlockBoundsMinZ();
		double d15 = z + block.getBlockBoundsMaxZ();

		tessellator.addVertexWithUV(d11, d13, d15, d7, d9);
		tessellator.addVertexWithUV(d11, d13, d14, d3, d5);
		tessellator.addVertexWithUV(d11, d12, d14, d8, d10);
		tessellator.addVertexWithUV(d11, d12, d15, d4, d6);

	}

	/**
	 * Renders the given texture to the east (x-positive) face of the block.  Args: block, x, y, z, texture
	 */
	public void renderFaceXPos(Block block, double x, double y, double z, IIcon texture)
	{
		double d3 = (double)texture.getInterpolatedU(block.getBlockBoundsMinZ() * 16.0D);
		double d4 = (double)texture.getInterpolatedU(block.getBlockBoundsMaxZ() * 16.0D);

		double d5 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMaxY() * 16.0D);
		double d6 = (double)texture.getInterpolatedV(16.0D - block.getBlockBoundsMinY() * 16.0D);
		double d7;

		if (block.getBlockBoundsMinZ() < 0.0D || block.getBlockBoundsMaxZ() > 1.0D)
		{
			d3 = (double)texture.getMinU();
			d4 = (double)texture.getMaxU();
		}

		if (block.getBlockBoundsMinY() < 0.0D || block.getBlockBoundsMaxY() > 1.0D)
		{
			d5 = (double)texture.getMinV();
			d6 = (double)texture.getMaxV();
		}

		d7 = d4;
		double d8 = d3;
		double d9 = d5;
		double d10 = d6;
		double d11 = x + block.getBlockBoundsMaxX();
		double d12 = y + block.getBlockBoundsMinY();
		double d13 = y + block.getBlockBoundsMaxY();
		double d14 = z + block.getBlockBoundsMinZ();
		double d15 = z + block.getBlockBoundsMaxZ();

		tessellator.addVertexWithUV(d11, d12, d15, d8, d10);
		tessellator.addVertexWithUV(d11, d12, d14, d4, d6);
		tessellator.addVertexWithUV(d11, d13, d14, d7, d9);
		tessellator.addVertexWithUV(d11, d13, d15, d3, d5);
	}
}
