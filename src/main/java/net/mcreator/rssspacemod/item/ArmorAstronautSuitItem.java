
package net.mcreator.rssspacemod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ArmorItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.BipedModel;

import net.mcreator.rssspacemod.itemgroup.DevToolsCreativeTabItemGroup;
import net.mcreator.rssspacemod.RssSpaceModModElements;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@RssSpaceModModElements.ModElement.Tag
public class ArmorAstronautSuitItem extends RssSpaceModModElements.ModElement {
	@ObjectHolder("rss_space_mod:armor_astronaut_suit_helmet")
	public static final Item helmet = null;
	@ObjectHolder("rss_space_mod:armor_astronaut_suit_chestplate")
	public static final Item body = null;
	@ObjectHolder("rss_space_mod:armor_astronaut_suit_leggings")
	public static final Item legs = null;
	@ObjectHolder("rss_space_mod:armor_astronaut_suit_boots")
	public static final Item boots = null;

	public ArmorAstronautSuitItem(RssSpaceModModElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		IArmorMaterial armormaterial = new IArmorMaterial() {
			@Override
			public int getDurability(EquipmentSlotType slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDamageReductionAmount(EquipmentSlotType slot) {
				return new int[]{2, 5, 6, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantability() {
				return 0;
			}

			@Override
			public net.minecraft.util.SoundEvent getSoundEvent() {
				return (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}

			@OnlyIn(Dist.CLIENT)
			@Override
			public String getName() {
				return "armor_astronaut_suit";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		};
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.HEAD,
				new Item.Properties().group(DevToolsCreativeTabItemGroup.tab).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedHead = new ModelAstronaut_Suit_Armor().Head_Group;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "rss_space_mod:textures/astronaut_suit_texture.png";
			}
		}.setRegistryName("armor_astronaut_suit_helmet"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.CHEST,
				new Item.Properties().group(DevToolsCreativeTabItemGroup.tab).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedBody = new ModelAstronaut_Suit_Armor().Body_Group;
				armorModel.bipedLeftArm = new ModelAstronaut_Suit_Armor().Arm_Left_Group;
				armorModel.bipedRightArm = new ModelAstronaut_Suit_Armor().Arm_Right_Group;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "rss_space_mod:textures/astronaut_suit_texture.png";
			}
		}.setRegistryName("armor_astronaut_suit_chestplate"));
		elements.items.add(() -> new ArmorItem(armormaterial, EquipmentSlotType.LEGS,
				new Item.Properties().group(DevToolsCreativeTabItemGroup.tab).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public BipedModel getArmorModel(LivingEntity living, ItemStack stack, EquipmentSlotType slot, BipedModel defaultModel) {
				BipedModel armorModel = new BipedModel(1);
				armorModel.bipedLeftLeg = new ModelAstronaut_Suit_Armor().Leg_Left_Group;
				armorModel.bipedRightLeg = new ModelAstronaut_Suit_Armor().Leg_Right_Group;
				armorModel.isSneak = living.isSneaking();
				armorModel.isSitting = defaultModel.isSitting;
				armorModel.isChild = living.isChild();
				return armorModel;
			}

			@Override
			public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
				return "rss_space_mod:textures/astronaut_suit_texture.png";
			}
		}.setRegistryName("armor_astronaut_suit_leggings"));
	}

	// Made with Blockbench 3.8.4
	// Exported for Minecraft version 1.15 - 1.16
	// Paste this class into your mod and generate all required imports
	public static class ModelAstronaut_Suit_Armor extends EntityModel<Entity> {
		private final ModelRenderer Steve;
		private final ModelRenderer Arms_Group;
		private final ModelRenderer Arm_Left_Group;
		private final ModelRenderer Arm_Right_Group;
		private final ModelRenderer Body_Group;
		private final ModelRenderer Legs_Group;
		private final ModelRenderer Leg_Left_Group;
		private final ModelRenderer Leg_Right_Group;
		private final ModelRenderer Head_Group;

		public ModelAstronaut_Suit_Armor() {
			textureWidth = 128;
			textureHeight = 128;
			Steve = new ModelRenderer(this);
			Steve.setRotationPoint(8.0F, -8.0F, -8.0F);
			Arms_Group = new ModelRenderer(this);
			Arms_Group.setRotationPoint(-8.0F, 0.0F, 8.0F);
			Steve.addChild(Arms_Group);
			Arm_Left_Group = new ModelRenderer(this);
			Arm_Left_Group.setRotationPoint(5.0F, 10.0F, 0.0F);
			Arms_Group.addChild(Arm_Left_Group);
			Arm_Left_Group.setTextureOffset(112, 80).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, true);
			Arm_Right_Group = new ModelRenderer(this);
			Arm_Right_Group.setRotationPoint(-5.0F, 10.0F, 0.0F);
			Arms_Group.addChild(Arm_Right_Group);
			Arm_Right_Group.setTextureOffset(96, 112).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, false);
			Body_Group = new ModelRenderer(this);
			Body_Group.setRotationPoint(-8.0F, 8.0F, 8.0F);
			Steve.addChild(Body_Group);
			Body_Group.setTextureOffset(80, 96).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.1F, false);
			Legs_Group = new ModelRenderer(this);
			Legs_Group.setRotationPoint(0.0F, 12.0F, 0.0F);
			Steve.addChild(Legs_Group);
			Leg_Left_Group = new ModelRenderer(this);
			Leg_Left_Group.setRotationPoint(-6.0F, 8.0F, 8.0F);
			Legs_Group.addChild(Leg_Left_Group);
			Leg_Left_Group.setTextureOffset(104, 96).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, true);
			Leg_Right_Group = new ModelRenderer(this);
			Leg_Right_Group.setRotationPoint(-10.0F, 8.0F, 8.0F);
			Legs_Group.addChild(Leg_Right_Group);
			Leg_Right_Group.setTextureOffset(80, 112).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.1F, false);
			Head_Group = new ModelRenderer(this);
			Head_Group.setRotationPoint(-8.0F, 8.0F, 8.0F);
			Steve.addChild(Head_Group);
			Head_Group.setTextureOffset(80, 80).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.1F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			Steve.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}

}
