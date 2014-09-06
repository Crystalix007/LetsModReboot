package com.crystalix007.letsmodreboot.material;

public class MaterialSoft extends MaterialHidden
{
	public MaterialSoft() {
		super();
	}

	@Override
	public boolean blocksMovement ()
	{
		return false;
	}

	@Override
	public boolean isSolid()
	{
		return false;
	}
}
