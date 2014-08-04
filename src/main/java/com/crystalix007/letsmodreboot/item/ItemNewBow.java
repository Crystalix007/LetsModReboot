package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabLMRB;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;

public class ItemNewBow extends ItemBow
{
    private IIcon[] iconArray;
    public ItemNewBow()
    {
        super();
        this.setUnlocalizedName("newBow");
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabLMRB.LMRB_TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIconRegister)
    {
        this.itemIcon = iIconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_standby");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            LogHelper.info("Registering icon: " + this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_" + bowPullIconNameArray[i]);
            this.iconArray[i] = iIconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_" + bowPullIconNameArray[i]);
        }
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

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int duration)
    {
        LogHelper.info("Trying to render icon");
        return this.iconArray[duration];
    }
}
