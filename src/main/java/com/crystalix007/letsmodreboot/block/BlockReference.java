package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockReference extends BlockGlassLMRB
{
	IIcon sideZero = null, sideOne = null, sideTwo = null, sideThree = null, sideFour = null, sideFive = null;

	public BlockReference()
	{
		super("refBlock");
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister){
		this.sideZero = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "refBlock_0");
		this.sideOne = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "refBlock_1");
		this.sideTwo = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "refBlock_2");
		this.sideThree = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "refBlock_3");
		this.sideFour = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "refBlock_4");
		this.sideFive = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() + ":" + "refBlock_5");

		if (sideZero == null || sideFive == null || sideOne == null || sideTwo == null || sideThree == null || sideFour == null)
			LogHelper.info("Icon(s): null");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (side == 0)
			return sideZero;
		else if (side == 1)
			return sideOne;
		else if (side == 2)
			return sideTwo;
		else if (side == 3)
			return sideThree;
		else if (side == 4)
			return sideFour;
		else
			return sideFive;
	}
}
