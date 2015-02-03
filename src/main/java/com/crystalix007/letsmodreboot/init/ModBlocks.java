package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.block.*;
import com.crystalix007.letsmodreboot.client.render.RenderBlockRamp;
import com.crystalix007.letsmodreboot.client.render.RenderBlockWindmill;
import com.crystalix007.letsmodreboot.client.render.RenderBlockWindmillBase;
import com.crystalix007.letsmodreboot.client.render.RenderFrameBlock;
import com.crystalix007.letsmodreboot.item.ItemInvisiGlass;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.tileentities.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
	public static final BlockLMRB flag = new BlockFlag();
	public static final BlockLMRB spinel = new BlockSpinel();
	public static final BlockLMRB siliconNitride = new BlockSiliconNitride();
	public static final BlockLMRB frameBlock = new BlockFrame();
	public static final BlockLMRB generator = new BlockGenerator();
	public static final BlockLMRB invResetter = new BlockInvResetter();
	public static final BlockLMRB windmillBlock = new BlockWindmill();
	public static final BlockLMRB windmillBaseBlock = new BlockWindmillBase();
	public static final BlockLMRB blockFertilizer = new BlockFertilizer();
	public static final BlockLMRB blockAntiGrav = new BlockAntigrav();
	public static final BlockLMRB blockEntityAccelerator = new BlockEntityAccelerator();
	public static final BlockLMRB blockEasyWalk = new BlockEasyWalk();
	public static final BlockLMRB blockRamp = new BlockRamp();
	public static final BlockLMRB blockNuclearWaste = new BlockNuclearWaste();
	public static final BlockLMRB blockBioDetergent = new BlockBioDetergent();
	public static final BlockLMRB blockLockdown = new BlockLockdown();

	public static final BlockGlassLMRB invisiGlass = new BlockInvisiGlass();
    public static final BlockGlassLMRB trapBlock = new BlockTrap();
	public static final BlockGlassLMRB refBlock = new BlockReference();

	public static TileEntitySpecialRenderer frameBlockRenderer = new RenderFrameBlock();
	public static TileEntitySpecialRenderer windmillBlockRenderer = new RenderBlockWindmill();
	public static TileEntitySpecialRenderer windmillBaseBlockRenderer = new RenderBlockWindmillBase();
	public static TileEntitySpecialRenderer blockRampRenderer = new RenderBlockRamp();

	public static void init()
	{
		GameRegistry.registerBlock(blockBioDetergent, "blockBioDetergent");
		GameRegistry.registerBlock(flag, "flag");
		GameRegistry.registerBlock(spinel, "spinel");
		GameRegistry.registerBlock(siliconNitride, "siliconNitride");
		GameRegistry.registerBlock(invisiGlass, ItemInvisiGlass.class, "invisiGlass");
        GameRegistry.registerBlock(trapBlock, "trapBlock");
		GameRegistry.registerBlock(refBlock, "refBlock");
		GameRegistry.registerBlock(frameBlock, "frameBlock");
		GameRegistry.registerBlock(invResetter, "invResetterBlock");
		GameRegistry.registerBlock(windmillBlock, "windmillBlock");
		GameRegistry.registerBlock(windmillBaseBlock, "windmillBaseBlock");
		GameRegistry.registerBlock(blockFertilizer, "blockFertilizer");
		GameRegistry.registerBlock(blockAntiGrav, "blockAntiGrav");
		GameRegistry.registerBlock(blockEntityAccelerator, "blockEntityAccelerator");
		GameRegistry.registerBlock(blockEasyWalk, "blockEasyWalk");
		GameRegistry.registerBlock(blockRamp, "blockRamp");
		GameRegistry.registerBlock(blockNuclearWaste, "blockNuclearWaste");
		GameRegistry.registerBlock(blockLockdown, "blockLockdown");

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrame.class, frameBlockRenderer);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill.class, windmillBlockRenderer);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillBase.class, windmillBaseBlockRenderer);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRamp.class, blockRampRenderer);
    }

	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityFrame.class, "tileFrame");
		GameRegistry.registerTileEntity(TileEntityInvisiGlass.class, "tileInvisiGlass");
		GameRegistry.registerTileEntity(TileEntityWindmill.class, "tileEntityWindmill");
		GameRegistry.registerTileEntity(TileEntityWindmillBase.class, "tileEntityWindmillBase");
		GameRegistry.registerTileEntity(TileEntityFertilizer.class, "tileEntityFertilizer");
		GameRegistry.registerTileEntity(TileEntityRamp.class, "tileEntityRamp");
		GameRegistry.registerTileEntity(TileEntityNuclearWaste.class, "tileEntityNuclearWaste");
		GameRegistry.registerTileEntity(TileEntityBioDetergent.class, "tileEntityBioDetergent");
		GameRegistry.registerTileEntity(TileEntityLockdown.class, "tileEntityLockdown");
	}
}
