package net.mcreator.rssspacemod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.rssspacemod.RssSpaceModModVariables;
import net.mcreator.rssspacemod.RssSpaceModMod;

import java.util.Map;
import java.util.HashMap;

public class PlayerRandNumHandlerProcedure {
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
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RssSpaceModMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerRandNumHandler!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = Math.random();
			entity.getCapability(RssSpaceModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.PlayerSpesificRandNum = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
