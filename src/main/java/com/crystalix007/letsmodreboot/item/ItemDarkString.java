package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
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
		this.setUnlocalizedName("itemDarkString");
		this.setMaxStackSize(16);
		this.setCreativeTab(CreativeTabsLMRB.LMRB_TAB);
	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", ReferenceMod.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s%s", ReferenceMod.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
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
