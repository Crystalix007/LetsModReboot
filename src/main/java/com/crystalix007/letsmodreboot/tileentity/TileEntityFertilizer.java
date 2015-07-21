package com.crystalix007.letsmodreboot.tileentity;

import com.crystalix007.letsmodreboot.init.InitModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFertilizer extends TileEntity
{
	protected ItemStack items;

	public ItemStack getItems()
	{
		return items;
	}

	public boolean addItems(ItemStack itemStack)
	{
		if (itemStack == null)
			return false;
		if (itemStack.getItem() == InitModItems.itemDebugTool)
			return false;
		if (items == null)
		{
			items = itemStack;
			itemStack.stackSize = 0;
			return true;
		}
		else if (ItemStack.areItemStacksEqual(items, itemStack))
		{
			//ProxyClient.printMessageToPlayer("Added item");
			if (items.getMaxStackSize() == items.stackSize)
				return false;
			else
			{
				if ((items.stackSize + itemStack.stackSize) >= items.getMaxStackSize())
				{
					int stackSize = items.stackSize;
					items.stackSize = items.getMaxStackSize();
					itemStack.stackSize -= (items.stackSize - stackSize);
				}
				else {
					items.stackSize += itemStack.stackSize;
					itemStack.stackSize = 0;
				}
				return true;
			}
		}
		else return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		items = ItemStack.loadItemStackFromNBT(compound);
		/*String itemName = compound.getString("itemName");
		int itemCount = compound.getInteger("itemCount"), itemDamage = compound.getInteger("itemDamage");

		if (itemName.equals("null")) {
			items = null;
		}
		else {
			items = new ItemStack((Item) (Item.itemRegistry.getObject(itemName)), itemCount, itemDamage);
			ClientProxy.printMessageToPlayer("Added item: " + items.getUnlocalizedName());
		}*/
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);

		if (items != null)
			items.writeToNBT(compound);
		/*compound.setString("itemName", items == null ? "null" : items.getUnlocalizedName());
		compound.setInteger("itemCount", items == null ? 0 : items.stackSize);
		compound.setInteger("itemDamage", items == null ? 0 : items.getItemDamage());*/
	}
}