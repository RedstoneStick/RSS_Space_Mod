package net.mcreator.rssspacemod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.rssspacemod.RssSpaceModMod;

import java.util.Map;

public class IsNeighbouringBlockOnFireProcedure {

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency world for procedure IsNeighbouringBlockOnFire!");
			return false;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency x for procedure IsNeighbouringBlockOnFire!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency y for procedure IsNeighbouringBlockOnFire!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency z for procedure IsNeighbouringBlockOnFire!");
			return false;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		return Blocks.SOUL_FIRE == (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()
				|| Blocks.SOUL_FIRE == (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()
				|| Blocks.SOUL_FIRE == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()
				|| Blocks.SOUL_FIRE == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()
				|| Blocks.SOUL_FIRE == (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()
				|| Blocks.SOUL_FIRE == (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock()
				|| Blocks.FIRE == (world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock()
				|| Blocks.FIRE == (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock()
				|| Blocks.FIRE == (world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock()
				|| Blocks.FIRE == (world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock()
				|| Blocks.FIRE == (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock()
				|| Blocks.FIRE == (world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() ? true : false;
	}
}
