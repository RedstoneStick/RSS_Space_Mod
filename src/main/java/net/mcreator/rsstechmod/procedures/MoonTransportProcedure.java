package net.mcreator.rsstechmod.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
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
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				RssTechModMod.LOGGER.warn("Failed to load dependency world for procedure MoonTransport!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				RssTechModMod.LOGGER.warn("Failed to load dependency entity for procedure MoonTransport!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (entity.getPosX());
			entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.XCord = _setval;
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
						20, ((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).ZCord));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).XCord),
							20,
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).ZCord),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
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
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((entity.getPosX()),
								(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (entity.getPosX()), (int) (entity.getPosZ()))),
								(entity.getPosZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()),
									(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (entity.getPosX()), (int) (entity.getPosZ()))),
									(entity.getPosZ()), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 10);
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
						20, ((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new RssTechModModVariables.PlayerVariables())).ZCord));
				if (_ent instanceof ServerPlayerEntity) {
					((ServerPlayerEntity) _ent).connection.setPlayerLocation(
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).XCord),
							20,
							((entity.getCapability(RssTechModModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new RssTechModModVariables.PlayerVariables())).ZCord),
							_ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
				}
			}
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
					{
						Entity _ent = entity;
						_ent.setPositionAndUpdate((entity.getPosX()),
								(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (entity.getPosX()), (int) (entity.getPosZ()))),
								(entity.getPosZ()));
						if (_ent instanceof ServerPlayerEntity) {
							((ServerPlayerEntity) _ent).connection.setPlayerLocation((entity.getPosX()),
									(world.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, (int) (entity.getPosX()), (int) (entity.getPosZ()))),
									(entity.getPosZ()), _ent.rotationYaw, _ent.rotationPitch, Collections.emptySet());
						}
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 10);
		}
	}
}
