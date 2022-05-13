package net.mcreator.rssspacemod.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.rssspacemod.entity.CrashedSatteliteEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class CrashedSatteliteRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(CrashedSatteliteEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcrashed_sattelite(), 0.5f) {

					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("rss_space_mod:textures/crashed_sattelite_texturemap.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 4.2.4
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelcrashed_sattelite extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube3_r1;
		private final ModelRenderer thruster1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer cube_r5;
		private final ModelRenderer thruster2;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer cube_r9;
		private final ModelRenderer thruster3;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer cube_r13;
		private final ModelRenderer decor;
		private final ModelRenderer solar_r1;

		public Modelcrashed_sattelite() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(-16.0F, 14.0F, 0.0F);
			setRotationAngle(bone, 0.0F, 0.0F, 1.8326F);
			bone.setTextureOffset(36, 32).addBox(-6.0F, -32.0F, -6.0F, 12.0F, 32.0F, 12.0F, 0.0F, false);
			bone.setTextureOffset(48, 0).addBox(-8.0F, -2.0F, -8.0F, 16.0F, 4.0F, 16.0F, 0.0F, false);
			bone.setTextureOffset(70, 62).addBox(-7.0F, -3.0F, -7.0F, 14.0F, 2.0F, 14.0F, -0.4F, false);
			bone.setTextureOffset(34, 76).addBox(-9.0F, 0.0F, -7.0F, 1.0F, 8.0F, 14.0F, 0.0F, false);
			bone.setTextureOffset(72, 20).addBox(8.0F, 0.0F, -7.0F, 1.0F, 8.0F, 14.0F, 0.0F, false);
			bone.setTextureOffset(48, 20).addBox(-7.0F, 1.0F, 8.0F, 14.0F, 7.0F, 1.0F, 0.0F, false);
			bone.setTextureOffset(0, 44).addBox(-7.0F, 1.0F, -9.0F, 14.0F, 7.0F, 1.0F, 0.0F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.0F, -0.7854F, 0.0F);
			cube_r1.setTextureOffset(0, 0).addBox(-6.0F, -32.0F, -6.0F, 12.0F, 32.0F, 12.0F, 0.01F, false);
			cube3_r1 = new ModelRenderer(this);
			cube3_r1.setRotationPoint(0.2426F, -34.2574F, -2.6213F);
			bone.addChild(cube3_r1);
			setRotationAngle(cube3_r1, -0.7854F, 0.0F, -0.7854F);
			cube3_r1.setTextureOffset(0, 64).addBox(-7.0F, -7.0F, -3.0F, 12.0F, 12.0F, 12.0F, 0.0F, false);
			thruster1 = new ModelRenderer(this);
			thruster1.setRotationPoint(0.0F, -2.0F, 0.0F);
			bone.addChild(thruster1);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(0.0F, 0.0F, -2.0F);
			thruster1.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.0F, 0.0F, -0.2182F);
			cube_r2.setTextureOffset(96, 0).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, 0.0F, 2.0F);
			thruster1.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0F, -1.5708F, 0.0436F);
			cube_r3.setTextureOffset(72, 93).addBox(-1.1F, 4.0F, 1.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, 0.0F, 0.0F);
			thruster1.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0436F);
			cube_r4.setTextureOffset(94, 78).addBox(6.1F, 4.0F, 1.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(0.0F, 0.0F, -2.0F);
			thruster1.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, 0.2618F);
			cube_r5.setTextureOffset(94, 96).addBox(-5.0F, 4.0F, 3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			thruster2 = new ModelRenderer(this);
			thruster2.setRotationPoint(0.0F, -2.0F, -10.0F);
			bone.addChild(thruster2);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(0.0F, 0.0F, 0.0F);
			thruster2.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, -0.2182F);
			cube_r6.setTextureOffset(96, 0).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(0.0F, 0.0F, 4.0F);
			thruster2.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, -1.5708F, 0.0436F);
			cube_r7.setTextureOffset(72, 93).addBox(-1.1F, 4.0F, 1.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(0.0F, 0.0F, 0.0F);
			thruster2.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, -1.5708F, 0.0436F);
			cube_r8.setTextureOffset(94, 78).addBox(8.1F, 4.0F, 1.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(0.0F, 0.0F, 0.0F);
			thruster2.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, 0.2618F);
			cube_r9.setTextureOffset(94, 96).addBox(-5.0F, 4.0F, 3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			thruster3 = new ModelRenderer(this);
			thruster3.setRotationPoint(8.0F, -2.0F, -6.0F);
			bone.addChild(thruster3);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(0.0F, 0.0F, 0.0F);
			thruster3.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, -0.2182F);
			cube_r10.setTextureOffset(96, 0).addBox(-4.0F, 2.0F, 3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(0.0F, 0.0F, 4.0F);
			thruster3.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, -1.5708F, 0.0436F);
			cube_r11.setTextureOffset(72, 93).addBox(-1.1F, 4.0F, 1.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(0.0F, 0.0F, 0.0F);
			thruster3.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, -1.5708F, 0.0436F);
			cube_r12.setTextureOffset(94, 78).addBox(8.1F, 4.0F, 1.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(0.0F, 0.0F, 0.0F);
			thruster3.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.0F, 0.0F, 0.2618F);
			cube_r13.setTextureOffset(94, 96).addBox(-5.0F, 4.0F, 3.0F, 1.0F, 9.0F, 6.0F, 0.0F, false);
			decor = new ModelRenderer(this);
			decor.setRotationPoint(0.0F, 0.0F, 0.0F);
			bone.addChild(decor);
			decor.setTextureOffset(0, 89).addBox(-2.0F, -28.0F, 5.0F, 8.0F, 9.0F, 1.0F, -0.1F, false);
			decor.setTextureOffset(0, 102).addBox(-3.0F, -11.0F, 5.0F, 6.0F, 6.0F, 2.0F, 0.0F, false);
			solar_r1 = new ModelRenderer(this);
			solar_r1.setRotationPoint(0.0F, -16.0F, 0.0F);
			decor.addChild(solar_r1);
			setRotationAngle(solar_r1, 0.0F, -0.7854F, 0.0F);
			solar_r1.setTextureOffset(0, 116).addBox(-28.0F, -5.0F, 0.0F, 40.0F, 11.0F, 0.0F, 0.1F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
		}
	}

}
