package com.crystalix007.letsmodreboot.block;

import net.minecraft.block.material.Material;

public class BlockDirectionalLMRB extends BlockLMRB {
	public BlockDirectionalLMRB(Material material) {
		super(material);
	}

	public BlockDirectionalLMRB() {
		super();
	}

	public static int getDirection(int i) {
		return i & 3;
	}
}
