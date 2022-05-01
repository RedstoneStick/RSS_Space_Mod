package net.mcreator.rssspacemod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rssspacemod.particle.TtestprtclParticle;
import net.mcreator.rssspacemod.RssSpaceModMod;

import java.util.stream.Stream;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

public class PukeGeneratorProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency world for procedure PukeGenerator!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency entity for procedure PukeGenerator!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
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
				if (20 > entity.getPersistentData().getDouble("PukeAmount")) {
					entity.getPersistentData().putDouble("PukeAmount", (entity.getPersistentData().getDouble("PukeAmount") + 1));
					if (entity instanceof PlayerEntity) {
						if (4 < ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).getFoodStats().getFoodLevel() : 0)) {
							world.addParticle(TtestprtclParticle.particle, (entity.getPosX()), (entity.getPosY() + entity.getHeight() * 0.7),
									(entity.getPosZ()),
									(Math.sin(Math.toRadians(0 - entity.rotationYaw))
											* (1 - Math.abs(Math.sin(Math.toRadians(0 - entity.rotationPitch)))) * 0.5 + Math.random() / 10 - 0.05
											+ entity.getMotion().getX() * 1.5),
									(Math.sin(Math.toRadians(0 - entity.rotationPitch)) * 0.5 + 0.2 + Math.random() / 10 - 0.05
											+ entity.getMotion().getY() * 1.5),
									(Math.cos(Math.toRadians(0 - entity.rotationYaw))
											* (1 - Math.abs(Math.sin(Math.toRadians(0 - entity.rotationPitch)))) * 0.5 + Math.random() / 10 - 0.05
											+ entity.getMotion().getZ() * 1.5));
							if (entity instanceof PlayerEntity) {
								((PlayerEntity) entity).addExhaustion((float) 2);
							}
						}
					} else if (!(entity instanceof PlayerEntity)) {
						world.addParticle(TtestprtclParticle.particle, (entity.getPosX()), (entity.getPosY() + entity.getHeight() * 0.7),
								(entity.getPosZ()),
								(Math.sin(Math.toRadians(0 - entity.rotationYaw)) * (1 - Math.abs(Math.sin(Math.toRadians(0 - entity.rotationPitch))))
										* 0.5 + Math.random() / 10 - 0.05 + entity.getMotion().getX() * 1.5),
								(Math.sin(Math.toRadians(0 - entity.rotationPitch)) * 0.5 + 0.2 + Math.random() / 10 - 0.05
										+ entity.getMotion().getY() * 1.5),
								(Math.cos(Math.toRadians(0 - entity.rotationYaw)) * (1 - Math.abs(Math.sin(Math.toRadians(0 - entity.rotationPitch))))
										* 0.5 + Math.random() / 10 - 0.05 + entity.getMotion().getZ() * 1.5));
					}
					PukeGeneratorProcedure.executeProcedure(
							Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
									.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				} else {
					entity.getPersistentData().putDouble("PukeAmount", 0);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 2);
	}
}
