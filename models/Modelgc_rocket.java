// Made with Blockbench 4.2.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports

public static class Modelgc_rocket extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer cube3_r1;

	public Modelgc_rocket() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(-12.0F, 0.0F, 0.0F);
		setRotationAngle(bone, 0.0F, 0.0F, 2.3998F);
		bone.setTextureOffset(0, 0).addBox(-6.0F, -32.0F, -6.0F, 12.0F, 32.0F, 12.0F, 0.0F, false);
		bone.setTextureOffset(32, 28).addBox(-8.0F, 0.0F, -8.0F, 16.0F, 2.0F, 16.0F, 0.0F, false);

		cube3_r1 = new ModelRenderer(this);
		cube3_r1.setRotationPoint(1.2426F, -33.2574F, -1.6213F);
		bone.addChild(cube3_r1);
		setRotationAngle(cube3_r1, -0.7854F, 0.0F, 0.7854F);
		cube3_r1.setTextureOffset(0, 44).addBox(-5.0F, -5.0F, -3.0F, 10.0F, 10.0F, 10.0F, -0.1F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}