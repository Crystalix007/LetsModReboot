package com.crystalix007.letsmodreboot.utility;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class UtilityBlockCoord
{
	public final int x;
	public final int y;
	public final int z;

	public UtilityBlockCoord(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public UtilityBlockCoord(TileEntity tile) {
		this(tile.xCoord, tile.yCoord, tile.zCoord);
	}

	public UtilityBlockCoord getLocation(ForgeDirection dir) {
		return new UtilityBlockCoord(x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ);
	}

	public int distanceSquared(UtilityBlockCoord other) {
		int dx, dy, dz;
		dx = x - other.x;
		dy = y - other.y;
		dz = z - other.z;
		return (dx * dx + dy * dy + dz * dz);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		UtilityBlockCoord other = (UtilityBlockCoord) obj;
		if(x != other.x)
			return false;
		if(y != other.y)
			return false;
		if(z != other.z)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BlockCoord [x=" + x + ", y=" + y + ", z=" + z + "]";
	}

	public boolean equals(int xCoord, int yCoord, int zCoord) {
		return x == xCoord && y == yCoord && z == zCoord;
	}
}
