
package net.mcreator.rssspacemod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.state.StateContainer;
import net.minecraft.item.Rarity;
import net.minecraft.item.Item;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.rssspacemod.procedures.UraniumHexaflouriteUpdateTickProcedure;
import net.mcreator.rssspacemod.RssSpaceModModElements;

import java.util.stream.Stream;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.AbstractMap;

@RssSpaceModModElements.ModElement.Tag
public class UraniumHexaflouriteBlock extends RssSpaceModModElements.ModElement {
	@ObjectHolder("rss_space_mod:uranium_hexaflourite")
	public static final FlowingFluidBlock block = null;
	@ObjectHolder("rss_space_mod:uranium_hexaflourite_bucket")
	public static final Item bucket = null;
	public static FlowingFluid flowing = null;
	public static FlowingFluid still = null;
	private ForgeFlowingFluid.Properties fluidproperties = null;

	public UraniumHexaflouriteBlock(RssSpaceModModElements instance) {
		super(instance, 45);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FluidRegisterHandler());
	}

	private static class FluidRegisterHandler {
		@SubscribeEvent
		public void registerFluids(RegistryEvent.Register<Fluid> event) {
			event.getRegistry().register(still);
			event.getRegistry().register(flowing);
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(still, RenderType.getTranslucent());
		RenderTypeLookup.setRenderLayer(flowing, RenderType.getTranslucent());
	}

	@Override
	public void initElements() {
		fluidproperties = new ForgeFlowingFluid.Properties(() -> still, () -> flowing,
				FluidAttributes.builder(new ResourceLocation("rss_space_mod:blocks/hf6_still"), new ResourceLocation("rss_space_mod:blocks/uf6_flow"))
						.luminosity(0).density(5090).viscosity(5090).temperature(420)

						.rarity(Rarity.COMMON).sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty"))))
								.explosionResistance(100f)

								.tickRate(25).levelDecreasePerBlock(2).slopeFindDistance(1)

								.block(() -> block);
		still = (FlowingFluid) new CustomFlowingFluid.Source(fluidproperties).setRegistryName("uranium_hexaflourite");
		flowing = (FlowingFluid) new CustomFlowingFluid.Flowing(fluidproperties).setRegistryName("uranium_hexaflourite_flowing");
		elements.blocks.add(() -> new FlowingFluidBlock(still,
				Block.Properties.create(Material.WATER, MaterialColor.LIGHT_GRAY).hardnessAndResistance(100f).setLightLevel(s -> 0)) {
			@Override
			public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
				return 4;
			}

			@Override
			public void onBlockAdded(BlockState blockstate, World world, BlockPos pos, BlockState oldState, boolean moving) {
				super.onBlockAdded(blockstate, world, pos, oldState, moving);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();
				world.getPendingBlockTicks().scheduleTick(pos, this, 10);
			}

			@Override
			public void tick(BlockState blockstate, ServerWorld world, BlockPos pos, Random random) {
				super.tick(blockstate, world, pos, random);
				int x = pos.getX();
				int y = pos.getY();
				int z = pos.getZ();

				UraniumHexaflouriteUpdateTickProcedure.executeProcedure(Stream
						.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
								new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z))
						.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
				world.getPendingBlockTicks().scheduleTick(pos, this, 10);
			}
		}.setRegistryName("uranium_hexaflourite"));
	}

	public static abstract class CustomFlowingFluid extends ForgeFlowingFluid {
		public CustomFlowingFluid(Properties properties) {
			super(properties);
		}

		@Override
		public Vector3d getFlow(IBlockReader world, BlockPos pos, FluidState fluidstate) {
			return super.getFlow(world, pos, fluidstate).scale(0.2);
		}

		public static class Source extends CustomFlowingFluid {
			public Source(Properties properties) {
				super(properties);
			}

			public int getLevel(FluidState state) {
				return 8;
			}

			public boolean isSource(FluidState state) {
				return true;
			}
		}

		public static class Flowing extends CustomFlowingFluid {
			public Flowing(Properties properties) {
				super(properties);
			}

			protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
				super.fillStateContainer(builder);
				builder.add(LEVEL_1_8);
			}

			public int getLevel(FluidState state) {
				return state.get(LEVEL_1_8);
			}

			public boolean isSource(FluidState state) {
				return false;
			}
		}
	}
}
