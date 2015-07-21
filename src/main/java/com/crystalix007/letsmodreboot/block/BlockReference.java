package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import com.crystalix007.letsmodreboot.utility.UtilityLogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockReference extends BlockGlassLMRB {
	IIcon[] sides = new IIcon[6];

	public BlockReference() {
		super("blockRef");
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i < 6; i++)
		{
			sides[i] = iconRegister.registerIcon(ReferenceMod.MOD_ID.toLowerCase() + ":blockRef_" + String.valueOf(i));

			if (sides[i] == null)
				UtilityLogHelper.warn("BlockReg's icon " + String.valueOf(i) + " is missing");
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return sides[side];
	}
}
