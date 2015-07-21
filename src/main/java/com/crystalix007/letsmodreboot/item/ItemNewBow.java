package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.entity.EntityFlyingCarrot;
import com.crystalix007.letsmodreboot.init.InitModItems;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemNewBow extends ItemBow
{
    private IIcon[] iconArray;
	long timeStartedClick = 0;
	boolean haveReleased = true;
	byte stage = 0;

    public ItemNewBow()
    {
        super();
        this.setUnlocalizedName("itemNewBow");
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabsLMRB.LMRB_TAB);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIconRegister)
    {
        this.itemIcon = iIconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_standby");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = iIconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_" + bowPullIconNameArray[i]);
        }
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

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(long duration)
    {
        //LogHelper.info("Trying to render icon: " + String.valueOf(duration));

	    if (duration < 12)
		    return this.iconArray[0];
	    else if (duration < 19)
	        return this.iconArray[1];
	    else
	        return this.iconArray[2];
    }

	private long max(long val, long maxVal)
	{
		if (val > maxVal)
			return maxVal;
		else
			return val;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
	{
		if (usingItem == null)
		{
			return itemIcon;
		}
		long timeUsed = (player.worldObj.getTotalWorldTime() - this.timeStartedClick);

		float f = (float)timeUsed / 20.0F;
		f = (f * f + f * 2.0F) / 3.0F;

		//LogHelper.info("Getting icon at index: " + String.valueOf(timeUsed));
		//LogHelper.info("Current time: " + String.valueOf(player.worldObj.getTotalWorldTime()) + ", time started: " + String.valueOf(this.timeStartedClick));

		return getItemIconForUseDuration(timeUsed);
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
	{
		ArrowNockEvent event = new ArrowNockEvent(entityPlayer, itemStack);
		MinecraftForge.EVENT_BUS.post(event);

		if (event.isCanceled())
		{
			return event.result;
		}

		if (entityPlayer.capabilities.isCreativeMode || entityPlayer.inventory.hasItem(InitModItems.itemCarrotAmmo))
		{
			entityPlayer.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
		}


		if (this.haveReleased)
			this.timeStartedClick = world.getTotalWorldTime();

		this.haveReleased = false;
		return itemStack;
	}

	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int i)
	{
		this.haveReleased = true;
		this.stage = 0;
		int j = this.getMaxItemUseDuration(itemStack) - i;

		ArrowLooseEvent event = new ArrowLooseEvent(entityPlayer, itemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled())
		{
			return;
		}
		j = event.charge;

		boolean flag = entityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

		if (flag || entityPlayer.inventory.hasItem(InitModItems.itemCarrotAmmo))
		{
			float f = (float)j / 20.0F;
			f = (f * f + f * 2.0F) / 3.0F;

			if ((double)f < 0.1D)
			{
				return;
			}

			if (f > 1.0F)
			{
				f = 1.0F;
			}

			EntityFlyingCarrot entityarrow = new EntityFlyingCarrot(world, entityPlayer, f * 5.0F);
			//EntityArrow entityarrow = new EntityArrow(world, entityPlayer, f * 2.0F);

			if (f == 1.0F)
			{
				entityarrow.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);

			if (k > 0)
			{
				entityarrow.setDamage(entityarrow.getDamage() + (double)k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

			if (l > 0)
			{
				entityarrow.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0)
			{
				entityarrow.setFire(100);
			}

			itemStack.damageItem(1, entityPlayer);
			world.playSoundAtEntity(entityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

			if (flag)
			{
				entityarrow.canBePickedUp = 2;
			}
			else
			{
				entityPlayer.inventory.consumeInventoryItem(InitModItems.itemCarrotAmmo);
			}

			if (!world.isRemote)
			{
				world.spawnEntityInWorld(entityarrow);
			}
		}
	}
}
