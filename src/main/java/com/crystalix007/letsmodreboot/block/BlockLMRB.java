package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockLMRB extends Block {
	public BlockLMRB(Material material) {
		super(material);
		this.setCreativeTab(CreativeTabsLMRB.LMRB_TAB);
	}

	public BlockLMRB() {
		this(Material.rock);
		this.setCreativeTab(CreativeTabsLMRB.LMRB_TAB);
		this.setStepSound(Block.soundTypeStone);
	}

	@Override
	public String getUnlocalizedName() {
		return String.format("tile.%s%s", ReferenceMod.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}