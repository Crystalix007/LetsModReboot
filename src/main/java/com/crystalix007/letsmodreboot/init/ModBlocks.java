package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.block.*;
import com.crystalix007.letsmodreboot.client.render.RenderFrameBlock;
import com.crystalix007.letsmodreboot.item.ItemInvisiGlass;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.tileentities.TileEntityFrame;
import com.crystalix007.letsmodreboot.tileentities.TileEntityInvisiGlass;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final BlockLMRB flag = new BlockFlag();
	public static final BlockLMRB spinel = new BlockSpinel();
	public static final BlockLMRB siliconNitride = new BlockSiliconNitride();
	public static final BlockLMRB frameBlock = new BlockFrame();
	public static final BlockGlassLMRB invisiGlass = new BlockInvisiGlass();
    public static final BlockGlassLMRB trapBlock = new BlockTrap();
	public static final BlockGlassLMRB refBlock = new BlockReference();

	public static RenderFrameBlock frameBlockRenderer = new RenderFrameBlock();

	public static void init()
	{
		GameRegistry.registerBlock(flag, "flag");
		GameRegistry.registerBlock(spinel, "spinel");
		GameRegistry.registerBlock(siliconNitride, "siliconNitride");
		GameRegistry.registerBlock(invisiGlass, ItemInvisiGlass.class, "invisiGlass");
        GameRegistry.registerBlock(trapBlock, "trapBlock");
		GameRegistry.registerBlock(refBlock, "refBlock");
		GameRegistry.registerBlock(frameBlock, "frameBlock");

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrame.class, frameBlockRenderer);
    }

	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityInvisiGlass.class, "tileInvisiGlass");
	}
}
