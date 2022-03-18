package net.mcreator.rsstechmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.rsstechmod.block.RadonBlock;
import net.mcreator.rsstechmod.RssTechModMod;

import java.util.Map;

public class RadonGenerateProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				RssTechModMod.LOGGER.warn("Failed to load dependency world for procedure RadonGenerate!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				RssTechModMod.LOGGER.warn("Failed to load dependency x for procedure RadonGenerate!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				RssTechModMod.LOGGER.warn("Failed to load dependency y for procedure RadonGenerate!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				RssTechModMod.LOGGER.warn("Failed to load dependency z for procedure RadonGenerate!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;

			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (Blocks.AIR == (world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock()) {
					world.setBlockState(new BlockPos((int) x, (int) y, (int) z), RadonBlock.block.getDefaultState(), 3);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 10);
	}
}
