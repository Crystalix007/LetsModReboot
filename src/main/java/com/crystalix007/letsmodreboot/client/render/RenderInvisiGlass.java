package com.crystalix007.letsmodreboot.client.render;

import com.crystalix007.letsmodreboot.model.ModelBlockLMRB;
import com.crystalix007.letsmodreboot.proxy.ClientProxy;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.tileentities.TileEntityInvisiGlass;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

public class RenderInvisiGlass extends TileEntitySpecialRenderer {
	static TileEntityInvisiGlass tile;
	protected ModelBase model = new ModelBlockLMRB();

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double i, double j, double k, float f) {
		TileEntityInvisiGlass tile = (TileEntityInvisiGlass)(tileEntity);
		World world = tile.getWorldObj();
		bindTexture(new ResourceLocation(Reference.MOD_ID.toLowerCase(), "/textures/blocks/invisiGlass.png"));

		int x = (int)i, y = (int)j, z = (int)k;

		GL11.glColor4b(tile.red, tile.green, tile.blue, (byte)(tile.alpha * 255));
		RenderBlocks renderBlocks = new RenderBlocks(world);
		renderBlocks.renderStandardBlock(world.getBlock(x, y, z), x, y, z);
		/*GL11.glPushMatrix();
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
*//*
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
			}*//*
		}
		t.draw();

		//GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		//GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
		GL11.glPopMatrix();*/
	}

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

			/*Tessellator tes = new Tessellator();
			tes.startDrawingQuads();
			addQuads(tes, icon);
			tes.draw();*/
			RenderBlocks render = new RenderBlocks();
			World world = tile.getWorldObj();
			render.renderStandardBlock(world.getBlock(tile.xCoord, tile.yCoord, tile.zCoord), tile.xCoord, tile.yCoord, tile.zCoord);

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
			final double delta1 = 1 - 0.001;
			World world = tile.getWorldObj();
			int x = tile.xCoord, y = tile.yCoord, z = tile.zCoord;
			boolean shouldDebug = tile.debug;

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z, 0)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 0");
				tes.addVertexWithUV(0, delta0, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(1, delta0, 0, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, delta0, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(0, delta0, 1, icon.getMaxU(), icon.getMinV());
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 0");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z, 1)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 1");
				tes.addVertexWithUV(0, delta1, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(0, delta1, 1, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, delta1, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(1, delta1, 0, icon.getMaxU(), icon.getMinV());
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 1");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z, 2)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 2");
				tes.addVertexWithUV(0, 0, delta0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(0, 1, delta0, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, 1, delta0, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(1, 0, delta0, icon.getMaxU(), icon.getMinV());
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 2");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z, 3)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 3");
				tes.addVertexWithUV(0, 0, delta1, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(1, 0, delta1, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(1, 1, delta1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(0, 1, delta1, icon.getMaxU(), icon.getMinV());
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 3");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z, 4)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 4");
				tes.addVertexWithUV(delta0, 0, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(delta0, 0, 1, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(delta0, 1, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(delta0, 1, 0, icon.getMaxU(), icon.getMinV());
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 4");
			}

			if (world.getBlock(x, y, z).shouldSideBeRendered(world, x, y, z, 5)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 5");
				tes.addVertexWithUV(delta1, 0, 0, icon.getMinU(), icon.getMinV());
				tes.addVertexWithUV(delta1, 1, 0, icon.getMinU(), icon.getMaxV());
				tes.addVertexWithUV(delta1, 1, 1, icon.getMaxU(), icon.getMaxV());
				tes.addVertexWithUV(delta1, 0, 1, icon.getMaxU(), icon.getMinV());
			}
			else if (shouldDebug)
				ClientProxy.printMessageToPlayer("Not rendering side 5");

			tile.debug = false;
		}
	};

	public RenderInvisiGlass() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	/*@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float partialTicks) {
		final TileEntityInvisiGlass te = (TileEntityInvisiGlass)tileentity;
		final World world = tileentity.getWorldObj();
		final Block block = world.getBlock(te.xCoord, te.yCoord, te.zCoord);
		tile = te;

		if (te.debug)
		{
			ClientProxy.printMessageToPlayer("Rendering block start");
		}

		if (te.currentAlpha < te.alpha) te.currentAlpha = Math.min(te.alpha + 0.0001f, 1);
		else if (te.currentAlpha > te.alpha) te.currentAlpha = Math.max(te.alpha - 0.0001f, 0);

		if (te.alpha <= 0) return;


		bindTexture(TextureMap.locationBlocksTexture);

		byte red = te.red;
		byte green = te.green;
		byte blue = te.blue;
		GL11.glColor4ub(red, green, blue, (byte)(255 * te.alpha));

		GL11.glPushMatrix();
		GL11.glTranslated(x, y, z);

		GL11.glAlphaFunc(GL11.GL_GREATER, 0.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_CULL_FACE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		*//*int displayList = blockDisplay.getDisplayList(ModBlocks.invisiGlass.getIcon(world, (int)x, (int)y, (int)z, 0));
		GL11.glCallList(displayList);*//*
		Tessellator tes = new Tessellator();
		tes.startDrawingQuads();
		IIcon icon = ModBlocks.invisiGlass.getIcon(world, (int)x, (int)y, (int)z, 0);
		RenderBlocks render = new RenderBlocks(world);

		{
			boolean shouldDebug = tile.debug;

			if (world.getBlock((int)x, (int)y, (int)z).shouldSideBeRendered(world, (int)x, (int)y, (int)z, 0)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 0");
				render.renderFaceYNeg(block, x, y, z, icon);
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 0");
			}

			if (world.getBlock((int)x, (int)y, (int)z).shouldSideBeRendered(world, (int)x, (int)y, (int)z, 1)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 1");
				render.renderFaceYPos(block, x, y, z, icon);
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 1");
			}

			if (world.getBlock((int)x, (int)y, (int)z).shouldSideBeRendered(world, (int)x, (int)y, (int)z, 2)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 2");
				render.renderFaceZNeg(block, x, y, z, icon);
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 2");
			}

			if (world.getBlock((int)x, (int)y, (int)z).shouldSideBeRendered(world, (int)x, (int)y, (int)z, 3)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 3");
				render.renderFaceZPos(block, x, y, z, icon);
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 3");
			}

			if (world.getBlock((int)x, (int)y, (int)z).shouldSideBeRendered(world, (int)x, (int)y, (int)z, 4)) {
				if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 4");
				render.renderFaceXNeg(block, x, y, z, icon);
			}
			else if (shouldDebug)
			{
				ClientProxy.printMessageToPlayer("Not rendering side 4");
			}

			if (world.getBlock((int)x, (int)y, (int)z).shouldSideBeRendered(world, (int)x, (int)y, (int)z, 5)) {
				//if (shouldDebug)
					ClientProxy.printMessageToPlayer("Rendering side 5");
				render.renderFaceXPos(block, x, y, z, icon);
			}
			else if (shouldDebug)
				ClientProxy.printMessageToPlayer("Not rendering side 5");

			tile.debug = false;
		}
		tes.draw();

		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

		GL11.glPopMatrix();

		if (te.debug)
		{
			ClientProxy.printMessageToPlayer("Rendering block end");
		}
	}*/

	@SubscribeEvent
	public void onTextureReload(TextureStitchEvent.Pre event) {
		blockDisplay.clear();
	}
}