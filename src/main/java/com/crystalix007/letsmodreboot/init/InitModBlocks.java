package com.crystalix007.letsmodreboot.init;

import com.crystalix007.letsmodreboot.block.*;
import com.crystalix007.letsmodreboot.client.render.RenderTERamp;
import com.crystalix007.letsmodreboot.client.render.RenderTEWindmill;
import com.crystalix007.letsmodreboot.client.render.RenderTEWindmillBase;
import com.crystalix007.letsmodreboot.client.render.RenderTEFrame;
import com.crystalix007.letsmodreboot.item.ItemInvisiGlass;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import com.crystalix007.letsmodreboot.tileentity.*;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

@GameRegistry.ObjectHolder(ReferenceMod.MOD_ID)
public class InitModBlocks
{
	public static final BlockLMRB blockFlag = new BlockFlag();
	public static final BlockLMRB blockSpinel = new BlockSpinel();
	public static final BlockLMRB blockSiliconNitride = new BlockSiliconNitride();
	public static final BlockLMRB blockFrame = new BlockFrame();
	public static final BlockLMRB blockGenerator = new BlockGenerator();
	public static final BlockLMRB blockInvResetter = new BlockInvResetter();
	public static final BlockLMRB blockWindmill = new BlockWindmill();
	public static final BlockLMRB blockWindmillBase = new BlockWindmillBase();
	public static final BlockLMRB blockFertilizer = new BlockFertilizer();
	public static final BlockLMRB blockAntiGrav = new BlockAntigrav();
	public static final BlockLMRB blockEntityAccelerator = new BlockEntityAccelerator();
	public static final BlockLMRB blockEasyWalk = new BlockEasyWalk();
	public static final BlockLMRB blockRamp = new BlockRamp();
	public static final BlockLMRB blockNuclearWaste = new BlockNuclearWaste();
	public static final BlockLMRB blockBioDetergent = new BlockBioDetergent();
	public static final BlockLMRB blockLockdown = new BlockLockdown();

	public static final BlockGlassLMRB blockInvisiGlass = new BlockInvisiGlass();
    public static final BlockGlassLMRB blockTrap = new BlockTrap();
	public static final BlockGlassLMRB blockRef = new BlockReference();

	public static TileEntitySpecialRenderer rendererFrameBlock = new RenderTEFrame();
	public static TileEntitySpecialRenderer rendererWindmillBlock = new RenderTEWindmill();
	public static TileEntitySpecialRenderer rendererWindmillBaseBlock = new RenderTEWindmillBase();
	public static TileEntitySpecialRenderer rendererRampBlock = new RenderTERamp();

	public static void init()
	{
		GameRegistry.registerBlock(blockFlag, "blockFlag");
		GameRegistry.registerBlock(blockSpinel, "blockSpinel");
		GameRegistry.registerBlock(blockSiliconNitride, "blockSiliconNitride");
		GameRegistry.registerBlock(blockFrame, "blockFrame");
		GameRegistry.registerBlock(blockGenerator, "blockGenerator");
		GameRegistry.registerBlock(blockInvResetter, "blockInvResetter");
		GameRegistry.registerBlock(blockWindmill, "blockWindmill");
		GameRegistry.registerBlock(blockWindmillBase, "blockWindmillBase");
		GameRegistry.registerBlock(blockFertilizer, "blockFertilizer");
		GameRegistry.registerBlock(blockAntiGrav, "blockAntiGrav");
		GameRegistry.registerBlock(blockEntityAccelerator, "blockEntityAccelerator");
		GameRegistry.registerBlock(blockEasyWalk, "blockEasyWalk");
		GameRegistry.registerBlock(blockRamp, "blockRamp");
		GameRegistry.registerBlock(blockNuclearWaste, "blockNuclearWaste");
		GameRegistry.registerBlock(blockBioDetergent, "blockBioDetergent");
		GameRegistry.registerBlock(blockLockdown, "blockLockdown");

		GameRegistry.registerBlock(blockInvisiGlass, ItemInvisiGlass.class, "blockInvisiGlass");
		GameRegistry.registerBlock(blockTrap, "blockTrap");
		GameRegistry.registerBlock(blockRef, "blockRef");

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFrame.class, rendererFrameBlock);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmill.class, rendererWindmillBlock);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityWindmillBase.class, rendererWindmillBaseBlock);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRamp.class, rendererRampBlock);
    }

	public static void registerTileEntities()
	{
		GameRegistry.registerTileEntity(TileEntityFrame.class, "tileEntityFrame");
		GameRegistry.registerTileEntity(TileEntityInvisiGlass.class, "tileEntityInvisiGlass");
		GameRegistry.registerTileEntity(TileEntityWindmill.class, "tileEntityWindmill");
		GameRegistry.registerTileEntity(TileEntityWindmillBase.class, "tileEntityWindmillBase");
		GameRegistry.registerTileEntity(TileEntityFertilizer.class, "tileEntityFertilizer");
		GameRegistry.registerTileEntity(TileEntityRamp.class, "tileEntityRamp");
		GameRegistry.registerTileEntity(TileEntityNuclearWaste.class, "tileEntityNuclearWaste");
		GameRegistry.registerTileEntity(TileEntityBioDetergent.class, "tileEntityBioDetergent");
		GameRegistry.registerTileEntity(TileEntityLockdown.class, "tileEntityLockdown");
	}
}
