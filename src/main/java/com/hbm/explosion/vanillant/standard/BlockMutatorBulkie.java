package com.hbm.explosion.vanillant.standard;

import com.hbm.explosion.vanillant.ExplosionVNT;
import com.hbm.explosion.vanillant.interfaces.IBlockMutator;
import com.hbm.inventory.RecipesCommon.MetaBlock;
import com.hbm.render.amlfrom1710.Vec3;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;

public class BlockMutatorBulkie implements IBlockMutator {

	protected MetaBlock metaBlock;

	public BlockMutatorBulkie(Block block) {
		this(block, 0);
	}

	public BlockMutatorBulkie(Block block, int meta) {
		this.metaBlock = new MetaBlock(block, meta);
	}

	@Override
	public void mutatePre(ExplosionVNT explosion, IBlockState state, BlockPos pos) {

		if (!state.getBlock().isNormalCube(state, explosion.world, pos)) return;

		Vec3 vec =  Vec3.createVectorHelper(pos.getX() + 0.5 - explosion.posX, pos.getY() + 0.5 - explosion.posY, pos.getZ() + 0.5 - explosion.posZ);

		if (vec.length() >= explosion.size - 0.5) {
			explosion.world.setBlockState(pos, metaBlock.block.getStateFromMeta(metaBlock.meta), 3);
		}
	}

	@Override
	public void mutatePost(ExplosionVNT explosion, BlockPos pos) {
	}
}
