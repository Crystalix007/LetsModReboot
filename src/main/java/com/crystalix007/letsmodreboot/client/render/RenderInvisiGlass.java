package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.model.ModelBlockLMRB;
import com.crystalix007.letsmodreboot.proxy.ClientProxy;
import com.crystalix007.letsmodreboot.tileentities.TileEntityInvisiGlass;
import com.crystalix007.letsmodreboot.utility.BlockCoord;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class RenderInvisiGlass extends TileEntitySpecialRenderer {
	static TileEntityInvisiGlass tile;
	public static BlockCoord blockToDebug = null;
	protected ModelBase model = new ModelBlockLMRB();

	/*@Override
	public void renderTileEntityAt(TileEntity tileEntity, double i, double j, double k, float f) {
		TileEntityInvisiGlass tile = (TileEntityInvisiGlass)(tileEntity);
		World world = tile.getWorldObj();
		bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "/textures/blocks/invisiGlass.png"));

		int x = (int)i, y = (int)j, z = (int)k;

		GL11.glColor4b(tile.red, tile.green, tile.blue, (byte)(tile.alpha * 255));
		RenderBlocks renderBlocks = new RenderBlocks(world);
		renderBlocks.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
		GL11.glPushMatrix();
		GL11.glTranslated(i, j, k);
		//GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
		//GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_BLEND);
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		Tessellator t = Tessellator.instance;//you could basically use "Tessellator.instance" all the time but it makes the code hard to read
		//t.setColorRGBA(tile.red, tile.green, tile.blue, tile.alpha);
		t.startDrawingQuads();

		{
			final double delta0 = 0.001;
			final double delta00 = 0.002;
			final double delta1 = 1 - 0.001;
			final double delta11 = 1 - 0.002;

			Block block = world.getBlock(x, y, z);
			int cm = block.colorMultiplier(world, x, y, z);

			if (cm == world.getBlock(x, y, z-1).colorMultiplier(world, x, y, z-1)) {
				t.addVertexWithUV(0, 0, delta0, 0, 0);
				t.addVertexWithUV(0, 1, delta0, 0, 1);
				t.addVertexWithUV(1, 1, delta0, 1, 1);
				t.addVertexWithUV(1, 0, delta0, 1, 0);
				t.addVertexWithUV(0, 0, delta00, 0, 0);
				t.addVertexWithUV(1, 0, delta00, 1, 0);
				t.addVertexWithUV(1, 1, delta00, 1, 1);
				t.addVertexWithUV(0, 1, delta00, 0, 1);
			}

			if (cm == world.getBlock(x, y, z+1).colorMultiplier(world, x, y, z+1)) {
				t.addVertexWithUV(0, 0, delta1, 0, 0);
				t.addVertexWithUV(0, 1, delta1, 0, 1);
				t.addVertexWithUV(1, 1, delta1, 1, 1);
				t.addVertexWithUV(1, 0, delta1, 1, 0);
				t.addVertexWithUV(0, 0, delta11, 0, 0);
				t.addVertexWithUV(1, 0, delta11, 1, 0);
				t.addVertexWithUV(1, 1, delta11, 1, 1);
				t.addVertexWithUV(0, 1, delta11, 0, 1);
			}

			if (cm == world.getBlock(x+1, y, z).colorMultiplier(world, x+1, y, z)) {
				t.addVertexWithUV(delta1, 0, 0, 0, 0);
				t.addVertexWithUV(delta1, 0, 1, 0, 1);
				t.addVertexWithUV(delta1, 1, 1, 1, 1);
				t.addVertexWithUV(delta1, 1, 0, 1, 0);
				t.addVertexWithUV(delta11, 0, 0, 0, 0);
				t.addVertexWithUV(delta11, 1, 0, 1, 0);
				t.addVertexWithUV(delta11, 1, 1, 1, 1);
				t.addVertexWithUV(delta11, 0, 1, 0, 1);
			}

			if (cm == world.getBlock(x-1, y, z).colorMultiplier(world, x-1, y, z)) {
				t.addVertexWithUV(delta0, 0, 0, 0, 0);
				t.addVertexWithUV(delta0, 0, 1, 0, 1);
				t.addVertexWithUV(delta0, 1, 1, 1, 1);
				t.addVertexWithUV(delta0, 1, 0, 1, 0);
				t.addVertexWithUV(delta00, 0, 0, 0, 0);
				t.addVertexWithUV(delta00, 1, 0, 1, 0);
				t.addVertexWithUV(delta00, 1, 1, 1, 1);
				t.addVertexWithUV(delta00, 0, 1, 0, 1);
			}

			if (cm == world.getBlock(x, y+1, z).colorMultiplier(world, x, y+1, z)) {
				t.addVertexWithUV(0, delta1, 0, 0, 0);
				t.addVertexWithUV(0, delta1, 1, 0, 1);
				t.addVertexWithUV(1, delta1, 1, 1, 1);
				t.addVertexWithUV(1, delta1, 0, 1, 0);
			}

			if (cm == world.getBlock(x, y-1, z).colorMultiplier(world, x, y-1, z)) {
				t.addVertexWithUV(0, delta0, 0, 0, 0);
				t.addVertexWithUV(0, delta0, 1, 0, 1);
				t.addVertexWithUV(1, delta0, 1, 1, 1);
				t.addVertexWithUV(1, delta0, 0, 1, 0);
			}
		}
		t.draw();

		//GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		//GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		GL11.glPopMatrix();
	}*/

	private abstract static class ElementDisplay {
		public Integer displayList;

		@Override
		public void finalize() {
			clear();
		}

		private void clear() {
			if (displayList != null) {
				GL11.glDeleteLists(displayList, 1);
				displayList = null;
			}
		}

		private Integer getDisplayList(IIcon icon) {
			displayList = compileList(icon);

			return displayList;
		}

		private int compileList(IIcon icon) {
			//ClientProxy.printMessageToPlayer("Rendering tile entity");
			int displayList = GL11.glGenLists(1);

			GL11.glNewList(displayList, GL11.GL_COMPILE);

			GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

			Tessellator tes = new Tessellator();
			tes.startDrawingQuads();
			addQuads(tes, icon);
			tes.draw();

			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

			GL11.glEndList();

			return displayList;
		}

		protected abstract void addQuads(Tessellator tes, IIcon icon);
	}

	private final static ElementDisplay blockDisplay = new ElementDisplay() {
		@Override
		public void addQuads(Tessellator tes, IIcon icon) {
			final double delta0 = 0.001;
			final double delta1 = 1 - delta0;
			World world = tile.getWorldObj();
			int x = tile.xCoord, y = tile.yCoord, z = tile.zCoord;
			boolean shouldDisplayMessage = blockToDebug != null && blockToDebug.equals(x, y, z);

			if (shouldDisplayMessage)
				ClientProxy.printMessageToPlayer("Tile being rendered is at: " + String.valueOf(x) + ", " + String.valueOf(y) + ", " + String.valueOf(z));

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y - 1, z, 0)) {
				tes.addVertexWithUV(0, delta0, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(1, delta0, 0, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, delta0, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(0, delta0, 1, icon.getMaxU(), icon.getMinV());

				if (shouldDisplayMessage)
					ClientProxy.printMessageToPlayer("Displayed side 0");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y + 1, z, 1)) {
				tes.addVertexWithUV(0, delta1, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(0, delta1, 1, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, delta1, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(1, delta1, 0, icon.getMaxU(), icon.getMinV());

				if (shouldDisplayMessage)
					ClientProxy.printMessageToPlayer("Displayed side 1");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z - 1, 2)) {
				tes.addVertexWithUV(0, 0, delta0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(0, 1, delta0, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, 1, delta0, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(1, 0, delta0, icon.getMaxU(), icon.getMinV());

				if (shouldDisplayMessage)
					ClientProxy.printMessageToPlayer("Displayed side 2");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z + 1, 3)) {
				tes.addVertexWithUV(0, 0, delta1, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(1, 0, delta1, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, 1, delta1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(0, 1, delta1, icon.getMaxU(), icon.getMinV());

				if (shouldDisplayMessage)
					ClientProxy.printMessageToPlayer("Displayed side 3");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x - 1, y, z, 4)) {
				tes.addVertexWithUV(delta0, 0, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(delta0, 0, 1, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(delta0, 1, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(delta0, 1, 0, icon.getMaxU(), icon.getMinV());

				if (shouldDisplayMessage)
					ClientProxy.printMessageToPlayer("Displayed side 4");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x + 1, y, z, 5)) {
				tes.addVertexWithUV(delta1, 0, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(delta1, 1, 0, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(delta1, 1, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(delta1, 0, 1, icon.getMaxU(), icon.getMinV());

				if (shouldDisplayMessage)
					ClientProxy.printMessageToPlayer("Displayed side 5");
			}
		}
	};

	public RenderInvisiGlass() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float partialTicks) {
		final TileEntityInvisiGlass te = (TileEntityInvisiGlass)tileentity;
		final World world = tileentity.getWorldObj();
		final Block block = world.getBlock(te.xCoord, te.yCoord, te.zCoord);
		tile = te;

		if (te.currentAlpha < te.alpha) te.currentAlpha = Math.min(te.alpha + 0.0001f, 1);
		else if (te.currentAlpha > te.alpha) te.currentAlpha = Math.max(te.alpha - 0.0001f, 0);

		if (te.alpha <= 0) return;

		bindTexture(TextureMap.locationBlocksTexture);

		byte red = te.red;
		byte green = te.green;
		byte blue = te.blue;

		Tessellator tessellator = Tessellator.instance;
		tessellator.setColorOpaque(red, green, blue);
		//tessellator.setColorRGBA(red, green, blue, (int)(te.alpha * 255.f));
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glColor4ub(red, green, blue, (byte)(255 * te.alpha));

		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);

		FaceRendererHelper faceRendererHelper = new FaceRendererHelper(world);
		FaceRendererHelper.tessellator = tessellator;
		faceRendererHelper.renderStandardBlock(block, (int)x, (int)y, (int)z);
		/*int displayList = blockDisplay.getDisplayList(ModBlocks.invisiGlass.getIcon(world, (int)x, (int)y, (int)z, 0));
		GL11.glCallList(displayList);*/
		GL11.glPopMatrix();
		GL11.glEnable(GL11.GL_CULL_FACE);

		if (blockToDebug != null && blockToDebug.equals((int)x, (int)y, (int)z))
			blockToDebug = null;
	}

	@SubscribeEvent
	public void onTextureReload(TextureStitchEvent.Pre event) {
		blockDisplay.clear();
	}
}