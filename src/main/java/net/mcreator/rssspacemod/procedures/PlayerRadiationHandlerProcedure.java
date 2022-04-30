package net.mcreator.rssspacemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.DamageSource;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rssspacemod.RssSpaceModModVariables;
import net.mcreator.rssspacemod.RssSpaceModMod;

import java.util.Map;
import java.util.HashMap;

public class PlayerRadiationHandlerProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency world for procedure PlayerRadiationHandler!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency x for procedure PlayerRadiationHandler!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency y for procedure PlayerRadiationHandler!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency z for procedure PlayerRadiationHandler!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerRadiationHandler!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (19 == RssSpaceModModVariables.MapVariables.get(world).PlayerRadiationTimer) {
			RssSpaceModModVariables.MapVariables.get(world).PlayerRadiationTimer = 0;
			RssSpaceModModVariables.MapVariables.get(world).syncData(world);
			{
				double _setval = ((entity.getCapability(RssSpaceModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new RssSpaceModModVariables.PlayerVariables())).RadiationExposure
						+ entity.getPersistentData().getDouble("RadiationBuffer"));
				entity.getCapability(RssSpaceModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.RadiationExposure = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(
						new StringTextComponent(("Total RAD: " + (entity.getCapability(RssSpaceModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssSpaceModModVariables.PlayerVariables())).RadiationExposure)),
						(false));
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity)
						.sendStatusMessage(new StringTextComponent(("RAD/s: " + entity.getPersistentData().getDouble("RadiationBuffer"))), (false));
			}
			if (1000 <= (entity.getCapability(RssSpaceModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RssSpaceModModVariables.PlayerVariables())).RadiationExposure) {
				entity.attackEntityFrom(DamageSource.GENERIC, (float) 5000);
			} else if (50 <= (entity.getCapability(RssSpaceModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new RssSpaceModModVariables.PlayerVariables())).RadiationExposure) {
				if (0.2 <= Math.random()) {
					if (world instanceof ServerWorld) {
						((ServerWorld) world).spawnParticle(ParticleTypes.EXPLOSION, x, y, z, (int) 20, 3, 3, 3, 1);
					}
				}
			}
			entity.getPersistentData().putDouble("RadiationBuffer", 0);
		} else {
			RssSpaceModModVariables.MapVariables.get(world).PlayerRadiationTimer = (1
					+ RssSpaceModModVariables.MapVariables.get(world).PlayerRadiationTimer);
			RssSpaceModModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
