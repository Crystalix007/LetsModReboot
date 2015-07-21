package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemPickaxeLMRB extends ItemPickaxe
{


    public ItemPickaxeLMRB(ToolMaterial toolMaterial)
    {
        super(toolMaterial);
        this.setCreativeTab(CreativeTabsLMRB.LMRB_TAB);
	    this.setMaxStackSize(1);
    }

	/*public ItemPickaxeLMRB(float damageVsEntity, ToolMaterial toolMaterial, Set mineableBlocks)
	{
		super(toolMaterial);
		this.getClass().getSuperclass().getConstructor()
		this.setCreativeTab(CreativeTabLMRB.LMRB_TAB);
		this.setMaxStackSize(1);
	}*/

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

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }


    public boolean isDamageable()
    {
        return true;
    }
}
