package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.init.ModBlocks;
import com.crystalix007.letsmodreboot.model.ModelBlockLMRB;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.tileentities.TileEntityInvisiGlass;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class RenderInvisiGlass extends TileEntitySpecialRenderer {
	protected ModelBase model = new ModelBlockLMRB();

	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
		//This will move our renderer so that it will be on proper place in the world
		GL11.glTranslatef((float)x, (float)y, (float)z);
		TileEntityInvisiGlass tileInvisiGlass = (TileEntityInvisiGlass)tileEntity;
         /*Note that true tile entity coordinates (tileEntity.xCoord, etc) do not match to render coordinates (d, etc) that are calculated as [true coordinates] - [player coordinates (camera coordinates)]*/
		renderTileInvisiGlass(tileInvisiGlass, tileEntity.getWorldObj(), tileEntity.xCoord, tileEntity.yCoord, tileEntity.zCoord, ModBlocks.invisiGlass);
		GL11.glPopMatrix();
	}

	//And this method actually renders your tile entity
	public void renderTileInvisiGlass(TileEntityInvisiGlass tileEntityInvisiGlass, World world, int x, int y, int z, Block block) {
		Tessellator tessellator = Tessellator.instance;
		//This will make your block brightness dependent from surroundings lighting.
		bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "textures/blocks/invisiGlass.png"));
		int l = world.getLightBrightnessForSkyBlocks(x, y, z, 0);
		int l1 = l % 65536;
		int l2 = l / 65536;
		tessellator.setColorRGBA_F(tileEntityInvisiGlass.red / 255.f, tileEntityInvisiGlass.green / 255.f, tileEntityInvisiGlass.blue / 255.f, tileEntityInvisiGlass.alpha / 255.f);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) l1, (float) l2);

		GL11.glPushMatrix();
		GL11.glTranslatef(1F, -0.5f, 1F);
		//This line actually rotates the renderer.
		GL11.glRotatef(0, 0F, 1F, 0F);
		GL11.glTranslatef(-0.5F, 0, -0.5F);
		this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}
