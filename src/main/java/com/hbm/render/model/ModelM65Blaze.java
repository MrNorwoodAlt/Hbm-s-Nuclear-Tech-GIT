package com.hbm.render.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

public class ModelM65Blaze extends ModelBiped {
	// fields
	public ModelRenderer mask;
	public ModelRenderer Shape1;
	public ModelRenderer Shape2;
	public ModelRenderer Shape3;
	public ModelRenderer Shape4;
	public ModelRenderer Shape5;
	public ModelRenderer Shape6;
	public ModelRenderer Shape7;
	public ModelRenderer Shape8;
	public ModelRenderer Shape9;
	public ModelRenderer Shape10;

	public ModelM65Blaze() {
		textureWidth = 32;
		textureHeight = 32;

		float yOffset = 4F;

		mask = new ModelRenderer(this, 0, 0);
		Shape1 = new ModelRenderer(this, 0, 0);
		Shape1.addBox(0F, 0F, 0F, 8, 8, 8);
		Shape1.setRotationPoint(-4F, -8F + yOffset, -4F);
		Shape1.setTextureSize(32, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		convertToChild(mask, Shape1);
		Shape2 = new ModelRenderer(this, 0, 16);
		Shape2.addBox(0F, 0F, 0F, 3, 3, 1);
		Shape2.setRotationPoint(-1.5F, -3.5F + yOffset, -5F);
		Shape2.setTextureSize(32, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		convertToChild(mask, Shape2);
		Shape3 = new ModelRenderer(this, 0, 20);
		Shape3.addBox(0F, -2F, 0F, 2, 2, 1);
		Shape3.setRotationPoint(-1F, -3.5F + yOffset, -5F);
		Shape3.setTextureSize(32, 32);
		Shape3.mirror = true;
		setRotation(Shape3, -0.4799655F, 0F, 0F);
		convertToChild(mask, Shape3);
		Shape4 = new ModelRenderer(this, 8, 16);
		Shape4.addBox(0F, 0F, -2F, 3, 2, 2);
		Shape4.setRotationPoint(-1.5F, -2F + yOffset, -4F);
		Shape4.setTextureSize(32, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0.6108652F, 0F, 0F);
		convertToChild(mask, Shape4);
		Shape5 = new ModelRenderer(this, 0, 23);
		Shape5.addBox(0F, 0F, 0F, 3, 3, 0);
		Shape5.setRotationPoint(-3.5F, -6F + yOffset, -4.2F);
		Shape5.setTextureSize(32, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		convertToChild(mask, Shape5);
		Shape6 = new ModelRenderer(this, 0, 26);
		Shape6.addBox(0F, 0F, 0F, 3, 3, 0);
		Shape6.setRotationPoint(0.5F, -6F + yOffset, -4.2F);
		Shape6.setTextureSize(32, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		convertToChild(mask, Shape6);
		Shape7 = new ModelRenderer(this, 6, 20);
		Shape7.addBox(0F, 0F, 0F, 2, 2, 1);
		Shape7.setRotationPoint(-1F, -3.2F + yOffset, -6F);
		Shape7.setTextureSize(32, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		convertToChild(mask, Shape7);
		Shape8 = new ModelRenderer(this, 6, 23);
		Shape8.addBox(0F, 0F, -3F, 2, 2, 1);
		Shape8.setRotationPoint(-1F, -2F + yOffset, -4F);
		Shape8.setTextureSize(32, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0.6108652F, 0F, 0F);
		convertToChild(mask, Shape8);
		Shape9 = new ModelRenderer(this, 18, 21);
		Shape9.addBox(0F, -1F, -5F, 3, 4, 2);
		Shape9.setRotationPoint(-1.5F, -2F + yOffset, -4F);
		Shape9.setTextureSize(32, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0.6108652F, 0F, 0F);
		convertToChild(mask, Shape9);
		Shape10 = new ModelRenderer(this, 18, 16);
		Shape10.addBox(0F, -0.5F, -5F, 4, 3, 2);
		Shape10.setRotationPoint(-2F, -2F + yOffset, -4F);
		Shape10.setTextureSize(32, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0.6108652F, 0F, 0F);
		convertToChild(mask, Shape10);
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

		if(entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			if (player.isSneaking()) {
				this.isSneak = true;
			} else {
				this.isSneak = false;
			}
		}
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		this.mask.rotationPointX = this.bipedHead.rotationPointX;
		this.mask.rotationPointY = this.bipedHead.rotationPointY;
		this.mask.rotateAngleY = this.bipedHead.rotateAngleY;
		this.mask.rotateAngleX = this.bipedHead.rotateAngleX;
	}

	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
		GL11.glPushMatrix();
		double d = 1D / 16D * 18D;
		//GL11.glTranslated(0, 1/16D, 0);
		GL11.glScaled(d, d, d);
		GL11.glScaled(1.01D, 1.01D, 1.01D);
		this.mask.render(par7);
		GL11.glPopMatrix();
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	protected void convertToChild(ModelRenderer parParent, ModelRenderer parChild) {
		// move child rotation point to be relative to parent
		parChild.rotationPointX -= parParent.rotationPointX;
		parChild.rotationPointY -= parParent.rotationPointY;
		parChild.rotationPointZ -= parParent.rotationPointZ;
		// make rotations relative to parent
		parChild.rotateAngleX -= parParent.rotateAngleX;
		parChild.rotateAngleY -= parParent.rotateAngleY;
		parChild.rotateAngleZ -= parParent.rotateAngleZ;
		// create relationship
		parParent.addChild(parChild);
	}

}