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
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Steve.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}