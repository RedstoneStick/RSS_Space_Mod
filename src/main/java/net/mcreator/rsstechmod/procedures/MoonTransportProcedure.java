package net.mcreator.rsstechmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.potion.EffectInstance;
import net.minecraft.network.play.server.SPlayerAbilitiesPacket;
import net.minecraft.network.play.server.SPlaySoundEventPacket;
import net.minecraft.network.play.server.SPlayEntityEffectPacket;
import net.minecraft.network.play.server.SChangeGameStatePacket;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.rsstechmod.RssTechModModVariables;
import net.mcreator.rsstechmod.RssTechModMod;

import java.util.Map;
import java.util.Collections;

public class MoonTransportProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RssTechModMod.LOGGER.warn("Failed to load dependency entity for procedure MoonTransport!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (entity.getPosX());
			entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.XCord = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getPosY());
			entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.YCord = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getPosZ());
			entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.ZCord = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.world.getDimensionKey()) == (RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("rss_tech_mod:moon")))) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
					RegistryKey<World> destinationType = World.OVERWORLD;
					ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
					if (nextWorld != null) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
						((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
								nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
						for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
						}
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(
						((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).XCord),
						((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).YCord),
						((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).ZCord));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).XCord),
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).YCord),
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).ZCord),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
		} else if ((entity.world.getDimensionKey()) == (World.OVERWORLD)) {
			{
				Entity _ent = entity;
				if (!_ent.world.isRemote && _ent instanceof ServerPlayerEntity) {
					RegistryKey<World> destinationType = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation("rss_tech_mod:moon"));
					ServerWorld nextWorld = _ent.getServer().getWorld(destinationType);
					if (nextWorld != null) {
						((ServerPlayerEntity) _ent).connection.sendPacket(new SChangeGameStatePacket(SChangeGameStatePacket.field_241768_e_, 0));
						((ServerPlayerEntity) _ent).teleport(nextWorld, nextWorld.getSpawnPoint().getX(), nextWorld.getSpawnPoint().getY() + 1,
								nextWorld.getSpawnPoint().getZ(), _ent.rotationYaw, _ent.rotationPitch);
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayerAbilitiesPacket(((ServerPlayerEntity) _ent).abilities));
						for (EffectInstance effectinstance : ((ServerPlayerEntity) _ent).getActivePotionEffects()) {
							((ServerPlayerEntity) _ent).connection.sendPacket(new SPlayEntityEffectPacket(_ent.getEntityId(), effectinstance));
						}
						((ServerPlayerEntity) _ent).connection.sendPacket(new SPlaySoundEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
			}
			{
				Entity _ent = entity;
				_ent.setPositionAndUpdate(
						((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).XCord),
						((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).YCord),
						((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).ZCord));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).XCord),
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).YCord),
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).ZCord),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
		}
	}
}
