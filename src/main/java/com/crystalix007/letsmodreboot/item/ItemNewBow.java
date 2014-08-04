package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabLMRB;
import com.crystalix007.letsmodreboot.entity.EntityFlyingCarrot;
import com.crystalix007.letsmodreboot.reference.Reference;
import com.crystalix007.letsmodreboot.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
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

	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer entityPlayer, int i) {
		int j = this.getMaxItemUseDuration(itemStack) - i;

		ArrowLooseEvent event = new ArrowLooseEvent(entityPlayer, itemStack, j);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return;
		}
		j = event.charge;

		boolean flag = entityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;

		if (flag || entityPlayer.inventory.hasItem(Items.arrow)) {
			float power = (float) j / 20.0F;
			power = (power * power + power * 2.0F) / 3.0F;

			if ((double) power < 0.1D) {
				return;
			}

			if (power > 1.0F) {
				power = 1.0F;
			}

			EntityFlyingCarrot entityFlyingCarrot = new EntityFlyingCarrot(world, entityPlayer, power * 2.0F);

			if (power == 1.0F) {
				entityFlyingCarrot.setIsCritical(true);
			}

			int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, itemStack);

			if (k > 0) {
				entityFlyingCarrot.setDamage(entityFlyingCarrot.getDamage() + (double) k * 0.5D + 0.5D);
			}

			int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, itemStack);

			if (l > 0) {
				entityFlyingCarrot.setKnockbackStrength(l);
			}

			if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0) {
				entityFlyingCarrot.setFire(100);
			}

			itemStack.damageItem(1, entityPlayer);
			world.playSoundAtEntity(entityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + power * 0.5F);

			if (flag) {
				entityFlyingCarrot.canBePickedUp = 2;
			} else {
				entityPlayer.inventory.consumeInventoryItem(Items.arrow);
			}

			if (!world.isRemote) {
				world.spawnEntityInWorld(entityFlyingCarrot);
			}
		}
	}
}