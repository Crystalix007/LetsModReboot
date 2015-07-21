package com.crystalix007.letsmodreboot.item;

import com.crystalix007.letsmodreboot.creativetab.CreativeTabsLMRB;
import com.crystalix007.letsmodreboot.proxy.ProxyClient;
import com.crystalix007.letsmodreboot.reference.ReferenceMod;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class ItemSpecialToolLMRB extends Item
{
	protected Block[] blocksEffectiveAgainst;
	private int harvestLevel;
	protected float efficiencyOnProperMaterial;
	private int damageVsEntity;
	private int enchantability;
	protected float efficiencyOnWrongMaterial = 1;

	public ItemSpecialToolLMRB(int HarvestLevel, ToolMaterial toolMaterial, String toolName, Block[] mineableBlocks)
	{
		harvestLevel = HarvestLevel;
		efficiencyOnProperMaterial = toolMaterial.getEfficiencyOnProperMaterial();
		damageVsEntity = ((int) toolMaterial.getDamageVsEntity());
		enchantability = toolMaterial.getEnchantability();
		blocksEffectiveAgainst = mineableBlocks;
		this.setUnlocalizedName(toolName);
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

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	public float func_150893_a(ItemStack itemStack, Block block)
	{
		for (int i = 0; i < blocksEffectiveAgainst.length; i++)
		{
			ProxyClient.printMessageToPlayer(blocksEffectiveAgainst[i].getLocalizedName());

			if (blocksEffectiveAgainst[i] == block)
			{
				return efficiencyOnProperMaterial;
			}
		}

		return efficiencyOnWrongMaterial;
	}
	
	/*protected void addHarvestableBlock(Block block)
	{
		Block[] tempList = new Block[blocksEffectiveAgainst.length + 1];
		System.arraycopy(blocksEffectiveAgainst, 0, tempList, 0, blocksEffectiveAgainst.length);
		tempList[tempList.length] = block;
	}*/

	public boolean hitEntity(ItemStack itemStack, EntityLivingBase attacker, EntityLivingBase target)
	{
		itemStack.damageItem(damageVsEntity, target);
		return true;
	}

	public boolean onBlockDestroyed(ItemStack itemStack, World world, Block block, int x, int y, int z, EntityLivingBase entityLivingBase)
	{
		if ((double)block.getBlockHardness(world, x, y, z) != 0.0D)
			itemStack.damageItem(1, entityLivingBase);
		return true;
	}

	/*public boolean isFull3D()
	{
		return true;
	}*/

	public int getItemEnchantability()
	{
		return enchantability;
	}
}
