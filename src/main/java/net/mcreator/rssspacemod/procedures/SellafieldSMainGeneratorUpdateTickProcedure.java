package net.mcreator.rssspacemod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Rotation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Mirror;

import net.mcreator.rssspacemod.world.RSSSMStructureGenerateGameRule;
import net.mcreator.rssspacemod.RssSpaceModMod;

import java.util.Map;

public class SellafieldSMainGeneratorUpdateTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency world for procedure SellafieldSMainGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency x for procedure SellafieldSMainGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency y for procedure SellafieldSMainGeneratorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency z for procedure SellafieldSMainGeneratorUpdateTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		if (true == world.getWorldInfo().getGameRulesInstance().getBoolean(RSSSMStructureGenerateGameRule.gamerule)) {
			world.setBlockState(new BlockPos((int) x, (int) y, (int) z), (world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))), 3);
			if (world instanceof ServerWorld) {
				Template template = ((ServerWorld) world).getStructureTemplateManager()
						.getTemplateDefaulted(new ResourceLocation("rss_space_mod", "sellafield_small"));
				if (template != null) {
					template.func_237144_a_((ServerWorld) world, new BlockPos((int) (x - 4), (int) (y - 1), (int) (z - 4)),
							new PlacementSettings().setRotation(Rotation.NONE).setMirror(Mirror.NONE).setChunk(null).setIgnoreEntities(false),
							((World) world).rand);
				}
			}
		}
	}
}
