package com.crystalix007.letsmodreboot.block;

import com.crystalix007.letsmodreboot.proxy.ProxyClient;
import com.crystalix007.letsmodreboot.tileentity.TileEntityFertilizer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;

public class BlockFertilizer extends BlockContainerLMRB {
	public BlockFertilizer() {
		super(Material.ground);
		setBlockName("blockFertilizer");
		setHarvestLevel("shovel", 1);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int v, float x1, float y1, float z1) {
		if (entityPlayer.getCurrentEquippedItem() == null)
			return false;

		TileEntity te = world.getTileEntity(x, y, z);

		if (te == null) {
			createNewTileEntity(world, 0);
			te = world.getTileEntity(x, y, z);
		}

		Block aboveBlock = world.getBlock(x, y + 1, z);

		if (((TileEntityFertilizer) te).getItems() == null)
			return false;

		if (((TileEntityFertilizer) (te)).getItems().stackSize >= 3 && aboveBlock != null) {
			BonemealEvent event = new BonemealEvent(entityPlayer, world, aboveBlock, x, y + 1, z);
			ProxyClient.printMessageToPlayer("Created bonemeal event -> posting to bus!");
			MinecraftForge.EVENT_BUS.post(event);
		} else
			ProxyClient.printMessageToPlayer("Doesn't have at least 3 items!");

		if (entityPlayer.getCurrentEquippedItem().getItem() instanceof IPlantable)
		{
			Item currItem = entityPlayer.getCurrentEquippedItem().getItem();
			EnumPlantType plantType = ((IPlantable)(currItem)).getPlantType(world, x, y, z);

			if (plantType == EnumPlantType.Crop) {
				if (aboveBlock == null) {
					if (!world.isRemote)
						world.setBlock(x, y + 1, z, ((IPlantable) (currItem)).getPlant(world, x, y, z));

					if (!world.isRemote)
						entityPlayer.getCurrentEquippedItem().stackSize--;
					return true;
				} else
					return false;
			}
			else {
				ProxyClient.printMessageToPlayer("Not a crop!");
				return false;
			}
		}
		else
		{
			ProxyClient.printMessageToPlayer("Trying OreDic");
			ArrayList<ItemStack> bonemeal = OreDictionary.getOres("bonemeal");

			for (ItemStack itemStack : bonemeal) {
				if (entityPlayer.getCurrentEquippedItem().getItem() == itemStack.getItem() && entityPlayer.getCurrentEquippedItem().getItemDamage() == itemStack.getItemDamage()) {
					boolean addedItems = ((TileEntityFertilizer) (world.getTileEntity(x, y, z))).addItems(itemStack);
					ProxyClient.printMessageToPlayer((addedItems ? "Did" : "Didn't") + " manage to add items");
					return addedItems;
				}
			}
		}
		return false;
	}

	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable)
	{
		EnumPlantType plantType = plantable.getPlantType(world, x, y + 1, z);

		if (plantType == EnumPlantType.Beach)
		{
			boolean hasWater = (world.getBlock(x - 1, y, z    ).getMaterial() == Material.water ||
					world.getBlock(x + 1, y, z).getMaterial() == Material.water ||
					world.getBlock(x, y, z - 1).getMaterial() == Material.water ||
					world.getBlock(x, y, z + 1).getMaterial() == Material.water);
			return hasWater;
		}
		else {
			return true;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World world, int v) {
		return new TileEntityFertilizer();
	}
}
