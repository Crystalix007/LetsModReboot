package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabLMRB;
import com.crystalix007.letsmodreboot.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemReed;
import net.minecraft.item.ItemStack;

public class ItemDarkString extends ItemReed
{
	public ItemDarkString()
	{
		super(Blocks.tripwire);
		this.setUnlocalizedName("darkString");
		this.setMaxStackSize(16);
		this.setCreativeTab(CreativeTabLMRB.LMRB_TAB);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
}