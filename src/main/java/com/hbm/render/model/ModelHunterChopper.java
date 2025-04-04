package com.hbm.render.model;

import com.hbm.main.MainRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHunterChopper extends ModelBase {
	// fields
	ModelRenderer RotorPivotStem;
	ModelRenderer RotorPivotTop;
	ModelRenderer RotorPivotPlate;
	ModelRenderer TorsoBaseCenter;
	ModelRenderer TorsoPlateLeft;
	ModelRenderer TorsoBaseBottom;
	ModelRenderer TorsoPlateRight;
	ModelRenderer TorsoPlateBottom;
	ModelRenderer WingLeftPlate;
	ModelRenderer WingRightPlate;
	ModelRenderer WingLeft;
	ModelRenderer WingLeftFront;
	ModelRenderer WingLeftTip;
	ModelRenderer WingRight;
	ModelRenderer WingRightFront;
	ModelRenderer WingRightTip;
	ModelRenderer TorsoBaseBack;
	ModelRenderer TorsoBoxBottom;
	ModelRenderer TorsoPlateBack;
	ModelRenderer TorsoBoxBack;
	ModelRenderer TorsoPlateLeftBack;
	ModelRenderer TorsoPlateRightBack;
	ModelRenderer TailFrontBase;
	ModelRenderer TailFrontPlate;
	ModelRenderer TailBackBase;
	ModelRenderer TailRotorFront;
	ModelRenderer TailRotorTop;
	ModelRenderer TailRotorBack;
	ModelRenderer TailRotorBottom;
	ModelRenderer TailRotorBlades;
	ModelRenderer TailRotorPivot;
	ModelRenderer HeadNeck;
	ModelRenderer HeadBack;
	ModelRenderer HeadBase;
	ModelRenderer HeadTop;
	ModelRenderer HeadFront;
	ModelRenderer HeadLeft;
	ModelRenderer HeadRight;
	ModelRenderer HeadFrontTop;
	ModelRenderer TorsoRotorBottom;
	ModelRenderer TorsoRotorFront;
	ModelRenderer TorsoRotorBack;
	ModelRenderer TorsoRotorBlades;
	ModelRenderer TorsoRotorPivot;
	ModelRenderer RotorBlades;
	ModelRenderer Antenna1;
	ModelRenderer Antenna2;
	ModelRenderer GunPivot;
	ModelRenderer GunBarrel;
	ModelRenderer GunBack;
	float f = 0.1F;

	public ModelHunterChopper() {
		textureWidth = 256;
		textureHeight = 128;
		
		RotorPivotStem = new ModelRenderer(this, 40, 22);
		RotorPivotStem.addBox(0F, 0F, 0F, 1, 4, 1);
		RotorPivotStem.setRotationPoint(-0.5F, 0F, -0.5F);
		RotorPivotStem.setTextureSize(256, 128);
		RotorPivotStem.mirror = true;
		setRotation(RotorPivotStem, 0F, 0F, 0F);
		RotorPivotTop = new ModelRenderer(this, 40, 27);
		RotorPivotTop.addBox(0F, 0F, 0F, 3, 1, 3);
		RotorPivotTop.setRotationPoint(-1.5F, -1F, -1.5F);
		RotorPivotTop.setTextureSize(256, 128);
		RotorPivotTop.mirror = true;
		setRotation(RotorPivotTop, 0F, 0F, 0F);
		RotorPivotPlate = new ModelRenderer(this, 40, 31);
		RotorPivotPlate.addBox(0F, 0F, 0F, 6, 1, 6);
		RotorPivotPlate.setRotationPoint(-3F, 1.5F, -3F);
		RotorPivotPlate.setTextureSize(256, 128);
		RotorPivotPlate.mirror = true;
		setRotation(RotorPivotPlate, 0F, 0F, 0F);
		TorsoBaseCenter = new ModelRenderer(this, 70, 0);
		TorsoBaseCenter.addBox(0F, 0F, 0F, 14, 4, 2);
		TorsoBaseCenter.setRotationPoint(-8F, 4F, -1F);
		TorsoBaseCenter.setTextureSize(256, 128);
		TorsoBaseCenter.mirror = true;
		setRotation(TorsoBaseCenter, 0F, 0F, 0F);
		TorsoPlateLeft = new ModelRenderer(this, 70, 6);
		TorsoPlateLeft.addBox(0F, -4F, 0F, 14, 4, 1);
		TorsoPlateLeft.setRotationPoint(-8F, 8F, -2F);
		TorsoPlateLeft.setTextureSize(256, 128);
		TorsoPlateLeft.mirror = true;
		setRotation(TorsoPlateLeft, -0.2268928F, 0F, 0F);
		TorsoBaseBottom = new ModelRenderer(this, 70, 11);
		TorsoBaseBottom.addBox(0F, 0F, 0F, 7, 2, 4);
		TorsoBaseBottom.setRotationPoint(-4F, 8F, -2F);
		TorsoBaseBottom.setTextureSize(256, 128);
		TorsoBaseBottom.mirror = true;
		setRotation(TorsoBaseBottom, 0F, 0F, 0F);
		TorsoPlateRight = new ModelRenderer(this, 70, 17);
		TorsoPlateRight.addBox(0F, -4F, -1F, 14, 4, 1);
		TorsoPlateRight.setRotationPoint(-8F, 8F, 2F);
		TorsoPlateRight.setTextureSize(256, 128);
		TorsoPlateRight.mirror = true;
		setRotation(TorsoPlateRight, 0.2268928F, 0F, 0F);
		TorsoPlateBottom = new ModelRenderer(this, 70, 22);
		TorsoPlateBottom.addBox(-5F, -2F, 0F, 5, 2, 4);
		TorsoPlateBottom.setRotationPoint(-4F, 10F, -2F);
		TorsoPlateBottom.setTextureSize(256, 128);
		TorsoPlateBottom.mirror = true;
		setRotation(TorsoPlateBottom, 0F, 0F, 0.2094395F);
		WingLeftPlate = new ModelRenderer(this, 110, 0);
		WingLeftPlate.addBox(0F, -3F, 0F, 9, 3, 1);
		WingLeftPlate.setRotationPoint(-8F, 9F, -3F);
		WingLeftPlate.setTextureSize(256, 128);
		WingLeftPlate.mirror = true;
		setRotation(WingLeftPlate, -0.2268928F, 0F, 0F);
		WingRightPlate = new ModelRenderer(this, 130, 0);
		WingRightPlate.addBox(0F, -3F, 0F, 9, 3, 1);
		WingRightPlate.setRotationPoint(-8F, 9F, 2F);
		WingRightPlate.setTextureSize(256, 128);
		WingRightPlate.mirror = true;
		setRotation(WingRightPlate, 0.2268928F, 0F, 0F);
		WingLeft = new ModelRenderer(this, 110, 4);
		WingLeft.addBox(0F, 0F, 0F, 3, 1, 6);
		WingLeft.setRotationPoint(-3F, 10F, -8F);
		WingLeft.setTextureSize(256, 128);
		WingLeft.mirror = true;
		setRotation(WingLeft, 0.3490659F, 0F, 0F);
		WingLeftFront = new ModelRenderer(this, 110, 11);
		WingLeftFront.addBox(0F, 0F, 0F, 2, 1, 7);
		WingLeftFront.setRotationPoint(-3F, 10F, -8F);
		WingLeftFront.setTextureSize(256, 128);
		WingLeftFront.mirror = true;
		setRotation(WingLeftFront, 0.3490659F, -0.3490659F, -0.1745329F);
		WingLeftTip = new ModelRenderer(this, 110, 19);
		WingLeftTip.addBox(0F, 0F, 0F, 5, 2, 1);
		WingLeftTip.setRotationPoint(-4F, 9F, -8F);
		WingLeftTip.setTextureSize(256, 128);
		WingLeftTip.mirror = true;
		setRotation(WingLeftTip, 0F, 0F, 0F);
		WingRight = new ModelRenderer(this, 130, 4);
		WingRight.addBox(0F, 0F, -6F, 3, 1, 6);
		WingRight.setRotationPoint(-3F, 10F, 8F);
		WingRight.setTextureSize(256, 128);
		WingRight.mirror = true;
		setRotation(WingRight, -0.3490659F, 0F, 0F);
		WingRightFront = new ModelRenderer(this, 130, 11);
		WingRightFront.addBox(0F, 0F, -7F, 2, 1, 7);
		WingRightFront.setRotationPoint(-3F, 10F, 8F);
		WingRightFront.setTextureSize(256, 128);
		WingRightFront.mirror = true;
		setRotation(WingRightFront, -0.3490659F, 0.3490659F, -0.1745329F);
		WingRightTip = new ModelRenderer(this, 130, 19);
		WingRightTip.addBox(0F, 0F, 0F, 5, 2, 1);
		WingRightTip.setRotationPoint(-4F, 9F, 7F);
		WingRightTip.setTextureSize(256, 128);
		WingRightTip.mirror = true;
		setRotation(WingRightTip, 0F, 0F, 0F);
		TorsoBaseBack = new ModelRenderer(this, 70, 28);
		TorsoBaseBack.addBox(0F, 0F, 0F, 3, 2, 3);
		TorsoBaseBack.setRotationPoint(3F, 7.5F, -1.5F);
		TorsoBaseBack.setTextureSize(256, 128);
		TorsoBaseBack.mirror = true;
		setRotation(TorsoBaseBack, 0F, 0F, 0F);
		TorsoBoxBottom = new ModelRenderer(this, 70, 33);
		TorsoBoxBottom.addBox(0F, -2F, 0F, 7, 2, 2);
		TorsoBoxBottom.setRotationPoint(-3F, 10F, -1F);
		TorsoBoxBottom.setTextureSize(256, 128);
		TorsoBoxBottom.mirror = true;
		setRotation(TorsoBoxBottom, 0F, 0F, 0.1570796F);
		TorsoPlateBack = new ModelRenderer(this, 70, 37);
		TorsoPlateBack.addBox(0F, 0F, 0F, 3, 1, 2);
		TorsoPlateBack.setRotationPoint(6F, 4F, -1F);
		TorsoPlateBack.setTextureSize(256, 128);
		TorsoPlateBack.mirror = true;
		setRotation(TorsoPlateBack, 0F, 0F, 0.2268928F);
		TorsoBoxBack = new ModelRenderer(this, 70, 40);
		TorsoBoxBack.addBox(0F, 0F, 0F, 2, 4, 2);
		TorsoBoxBack.setRotationPoint(6F, 5F, -1F);
		TorsoBoxBack.setTextureSize(256, 128);
		TorsoBoxBack.mirror = true;
		setRotation(TorsoBoxBack, 0F, 0F, 0F);
		TorsoPlateLeftBack = new ModelRenderer(this, 70, 46);
		TorsoPlateLeftBack.addBox(0F, -4F, -1F, 3, 4, 1);
		TorsoPlateLeftBack.setRotationPoint(6F, 8.5F, -1F);
		TorsoPlateLeftBack.setTextureSize(256, 128);
		TorsoPlateLeftBack.mirror = true;
		setRotation(TorsoPlateLeftBack, -0.2268928F, 0F, 0F);
		TorsoPlateRightBack = new ModelRenderer(this, 70, 51);
		TorsoPlateRightBack.addBox(0F, -4F, 0F, 3, 4, 1);
		TorsoPlateRightBack.setRotationPoint(6F, 8.5F, 1F);
		TorsoPlateRightBack.setTextureSize(256, 128);
		TorsoPlateRightBack.mirror = true;
		setRotation(TorsoPlateRightBack, 0.2268928F, 0F, 0F);
		TailFrontBase = new ModelRenderer(this, 24, 54);
		TailFrontBase.addBox(0F, 0F, 0F, 5, 2, 2);
		TailFrontBase.setRotationPoint(8F, 6F, -1F);
		TailFrontBase.setTextureSize(256, 128);
		TailFrontBase.mirror = true;
		setRotation(TailFrontBase, 0F, 0F, 0F);
		TailFrontPlate = new ModelRenderer(this, 24, 58);
		TailFrontPlate.addBox(-5F, 0F, 0F, 5, 1, 2);
		TailFrontPlate.setRotationPoint(13F, 6F, -1F);
		TailFrontPlate.setTextureSize(256, 128);
		TailFrontPlate.mirror = true;
		setRotation(TailFrontPlate, 0F, 0F, 0.2268928F);
		TailBackBase = new ModelRenderer(this, 24, 61);
		TailBackBase.addBox(0F, 0F, 0F, 4, 2, 1);
		TailBackBase.setRotationPoint(13F, 6F, -0.5F);
		TailBackBase.setTextureSize(256, 128);
		TailBackBase.mirror = true;
		setRotation(TailBackBase, 0F, 0F, 0F);
		TailRotorFront = new ModelRenderer(this, 24, 64);
		TailRotorFront.addBox(0F, 0F, 0F, 1, 3, 1);
		TailRotorFront.setRotationPoint(15.5F, 8F, -0.5F);
		TailRotorFront.setTextureSize(256, 128);
		TailRotorFront.mirror = true;
		setRotation(TailRotorFront, 0F, 0F, -0.2268928F);
		TailRotorTop = new ModelRenderer(this, 24, 68);
		TailRotorTop.addBox(0F, 0F, 0F, 3, 1, 1);
		TailRotorTop.setRotationPoint(17F, 6F, -0.5F);
		TailRotorTop.setTextureSize(256, 128);
		TailRotorTop.mirror = true;
		setRotation(TailRotorTop, 0F, 0F, 0F);
		TailRotorBack = new ModelRenderer(this, 24, 70);
		TailRotorBack.addBox(0F, 0F, 0F, 1, 4, 1);
		TailRotorBack.setRotationPoint(20F, 6F, -0.5F);
		TailRotorBack.setTextureSize(256, 128);
		TailRotorBack.mirror = true;
		setRotation(TailRotorBack, 0F, 0F, 0F);
		TailRotorBottom = new ModelRenderer(this, 24, 75);
		TailRotorBottom.addBox(0F, 0F, 0F, 3, 1, 1);
		TailRotorBottom.setRotationPoint(18F, 10F, -0.5F);
		TailRotorBottom.setTextureSize(256, 128);
		TailRotorBottom.mirror = true;
		setRotation(TailRotorBottom, 0F, 0F, 0F);
		TailRotorBlades = new ModelRenderer(this, 120, 120);
		TailRotorBlades.addBox(-1.5F, -1.5F, 0F, 3, 3, 0);
		TailRotorBlades.setRotationPoint(17F + 1.5F, 7F + 1.5F, 0F);
		TailRotorBlades.setTextureSize(256, 128);
		TailRotorBlades.mirror = true;
		setRotation(TailRotorBlades, 0F, 0F, 0F);
		TailRotorPivot = new ModelRenderer(this, 24, 77);
		TailRotorPivot.addBox(0F, 0F, 0F, 1, 2, 1);
		TailRotorPivot.setRotationPoint(18F, 8F, -0.5F);
		TailRotorPivot.setTextureSize(256, 128);
		TailRotorPivot.mirror = true;
		setRotation(TailRotorPivot, 0F, 0F, 0F);
		HeadNeck = new ModelRenderer(this, 0, 40);
		HeadNeck.addBox(-1F, 0F, 0F, 1, 6, 3);
		HeadNeck.setRotationPoint(-7F, 4F, -1.5F);
		HeadNeck.setTextureSize(256, 128);
		HeadNeck.mirror = true;
		setRotation(HeadNeck, 0F, 0F, 0.2268928F);
		HeadBack = new ModelRenderer(this, 0, 49);
		HeadBack.addBox(0F, 0F, 0F, 1, 7, 4);
		HeadBack.setRotationPoint(-8.5F, 3.5F, -2F);
		HeadBack.setTextureSize(256, 128);
		HeadBack.mirror = true;
		setRotation(HeadBack, 0F, 0F, 0.2268928F);
		HeadBase = new ModelRenderer(this, 0, 60);
		HeadBase.addBox(-2F, 1F, 0F, 2, 6, 4);
		HeadBase.setRotationPoint(-8.5F, 3.5F, -2F);
		HeadBase.setTextureSize(256, 128);
		HeadBase.mirror = true;
		setRotation(HeadBase, 0F, 0F, 0.2268928F);
		HeadTop = new ModelRenderer(this, 0, 70);
		HeadTop.addBox(-2F, 0F, 0F, 2, 2, 4);
		HeadTop.setRotationPoint(-8.5F, 3.5F, -2F);
		HeadTop.setTextureSize(256, 128);
		HeadTop.mirror = true;
		setRotation(HeadTop, 0F, 0F, -0.2268928F);
		HeadFront = new ModelRenderer(this, 0, 76);
		HeadFront.addBox(0F, 0F, 0F, 2, 4, 2);
		HeadFront.setRotationPoint(-13F, 5F, -1F);
		HeadFront.setTextureSize(256, 128);
		HeadFront.mirror = true;
		setRotation(HeadFront, 0F, 0F, 0F);
		HeadLeft = new ModelRenderer(this, 0, 82);
		HeadLeft.addBox(-3F, 0F, 0F, 3, 4, 1);
		HeadLeft.setRotationPoint(-10F, 5F, -2F);
		HeadLeft.setTextureSize(256, 128);
		HeadLeft.mirror = true;
		setRotation(HeadLeft, 0F, 0.3490659F, 0F);
		HeadRight = new ModelRenderer(this, 0, 87);
		HeadRight.addBox(-3F, 0F, -1F, 3, 4, 1);
		HeadRight.setRotationPoint(-10F, 5F, 2F);
		HeadRight.setTextureSize(256, 128);
		HeadRight.mirror = true;
		setRotation(HeadRight, 0F, -0.3490659F, 0F);
		HeadFrontTop = new ModelRenderer(this, 0, 92);
		HeadFrontTop.addBox(-3F, 0F, 0F, 3, 1, 2);
		HeadFrontTop.setRotationPoint(-10.5F, 4F, -1F);
		HeadFrontTop.setTextureSize(256, 128);
		HeadFrontTop.mirror = true;
		setRotation(HeadFrontTop, 0F, 0F, -0.3490659F);
		TorsoRotorBottom = new ModelRenderer(this, 0, 0);
		TorsoRotorBottom.addBox(0F, 0F, 0F, 3, 1, 1);
		TorsoRotorBottom.setRotationPoint(-7F, 11.5F, -0.5F);
		TorsoRotorBottom.setTextureSize(256, 128);
		TorsoRotorBottom.mirror = true;
		setRotation(TorsoRotorBottom, 0F, 0F, 0F);
		TorsoRotorFront = new ModelRenderer(this, 0, 2);
		TorsoRotorFront.addBox(0F, 0F, 0F, 1, 3, 1);
		TorsoRotorFront.setRotationPoint(-8F, 9F, -0.5F);
		TorsoRotorFront.setTextureSize(256, 128);
		TorsoRotorFront.mirror = true;
		setRotation(TorsoRotorFront, 0F, 0F, 0F);
		TorsoRotorBack = new ModelRenderer(this, 0, 6);
		TorsoRotorBack.addBox(0F, 0F, 0F, 1, 2, 1);
		TorsoRotorBack.setRotationPoint(-4F, 10F, -0.5F);
		TorsoRotorBack.setTextureSize(256, 128);
		TorsoRotorBack.mirror = true;
		setRotation(TorsoRotorBack, 0F, 0F, 0F);
		TorsoRotorBlades = new ModelRenderer(this, 112, 120);
		TorsoRotorBlades.addBox(-1.5F, -1.5F, 0F, 3, 3, 0);
		TorsoRotorBlades.setRotationPoint(-7F + 1.5F, 8.5F + 1.5F, 0F);
		TorsoRotorBlades.setTextureSize(256, 128);
		TorsoRotorBlades.mirror = true;
		setRotation(TorsoRotorBlades, 0F, 0F, 0F);
		TorsoRotorPivot = new ModelRenderer(this, 0, 9);
		TorsoRotorPivot.addBox(0F, 0F, 0F, 1, 2, 1);
		TorsoRotorPivot.setRotationPoint(-6F, 8.5F, -0.5F);
		TorsoRotorPivot.setTextureSize(256, 128);
		TorsoRotorPivot.mirror = true;
		setRotation(TorsoRotorPivot, 0F, 0F, 0F);
		RotorBlades = new ModelRenderer(this, 76, 68);
		RotorBlades.addBox(-30F, 0F, -30F, 60, 0, 60);
		RotorBlades.setRotationPoint(0F, 1.5F, 0F);
		RotorBlades.setTextureSize(256, 128);
		RotorBlades.mirror = true;
		setRotation(RotorBlades, 0F, 0F, 0F);
		Antenna1 = new ModelRenderer(this, 0, 95);
		Antenna1.addBox(0F, 0F, 0F, 4, 1, 1);
		Antenna1.setRotationPoint(-14F, 4F, 0.5F);
		Antenna1.setTextureSize(256, 128);
		Antenna1.mirror = true;
		setRotation(Antenna1, 0F, 0F, 0F);
		Antenna2 = new ModelRenderer(this, 0, 97);
		Antenna2.addBox(0F, 0F, 0F, 2, 1, 1);
		Antenna2.setRotationPoint(-15F, 7F, 0F);
		Antenna2.setTextureSize(256, 128);
		Antenna2.mirror = true;
		setRotation(Antenna2, 0F, 0F, 0F);
		GunPivot = new ModelRenderer(this, 0, 106);
		GunPivot.addBox(0F, 0F, 0F, 1, 2, 2);
		GunPivot.setRotationPoint(-11F, 10F, -1F);
		GunPivot.setTextureSize(256, 128);
		GunPivot.mirror = true;
		setRotation(GunPivot, 0F, 0F, 0F);
		GunBarrel = new ModelRenderer(this, 0, 110);
		GunBarrel.addBox(-6F, 0F, -0.5F, 6, 1, 1);
		GunBarrel.setRotationPoint(-10.5F, 11.5F, 0F);
		GunBarrel.setTextureSize(256, 128);
		GunBarrel.mirror = true;
		setRotation(GunBarrel, 0F, MainRegistry.x, 0F);
		GunBack = new ModelRenderer(this, 0, 112);
		GunBack.addBox(0F, -1F, -1F, 2, 2, 2);
		GunBack.setRotationPoint(-10.5F, 12F, 0F);
		GunBack.setTextureSize(256, 128);
		GunBack.mirror = true;
		setRotation(GunBack, 0F, MainRegistry.x, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		RotorPivotStem.render(f5);
		RotorPivotTop.render(f5);
		RotorPivotPlate.render(f5);
		TorsoBaseCenter.render(f5);
		TorsoPlateLeft.render(f5);
		TorsoBaseBottom.render(f5);
		TorsoPlateRight.render(f5);
		TorsoPlateBottom.render(f5);
		WingLeftPlate.render(f5);
		WingRightPlate.render(f5);
		WingLeft.render(f5);
		WingLeftFront.render(f5);
		WingLeftTip.render(f5);
		WingRight.render(f5);
		WingRightFront.render(f5);
		WingRightTip.render(f5);
		TorsoBaseBack.render(f5);
		TorsoBoxBottom.render(f5);
		TorsoPlateBack.render(f5);
		TorsoBoxBack.render(f5);
		TorsoPlateLeftBack.render(f5);
		TorsoPlateRightBack.render(f5);
		TailFrontBase.render(f5);
		TailFrontPlate.render(f5);
		TailBackBase.render(f5);
		TailRotorFront.render(f5);
		TailRotorTop.render(f5);
		TailRotorBack.render(f5);
		TailRotorBottom.render(f5);
		TailRotorBlades.render(f5);
		TailRotorPivot.render(f5);
		HeadNeck.render(f5);
		HeadBack.render(f5);
		HeadBase.render(f5);
		HeadTop.render(f5);
		HeadFront.render(f5);
		HeadLeft.render(f5);
		HeadRight.render(f5);
		HeadFrontTop.render(f5);
		TorsoRotorBottom.render(f5);
		TorsoRotorFront.render(f5);
		TorsoRotorBack.render(f5);
		TorsoRotorBlades.render(f5);
		TorsoRotorPivot.render(f5);
		RotorBlades.render(f5);
		Antenna1.render(f5);
		Antenna2.render(f5);
		//GunPivot.render(f5);
		//GunBarrel.render(f5);
		//GunBack.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
	
	public void renderAll(float f5) {
		RotorPivotStem.render(f5);
		RotorPivotTop.render(f5);
		RotorPivotPlate.render(f5);
		TorsoBaseCenter.render(f5);
		TorsoPlateLeft.render(f5);
		TorsoBaseBottom.render(f5);
		TorsoPlateRight.render(f5);
		TorsoPlateBottom.render(f5);
		WingLeftPlate.render(f5);
		WingRightPlate.render(f5);
		WingLeft.render(f5);
		WingLeftFront.render(f5);
		WingLeftTip.render(f5);
		WingRight.render(f5);
		WingRightFront.render(f5);
		WingRightTip.render(f5);
		TorsoBaseBack.render(f5);
		TorsoBoxBottom.render(f5);
		TorsoPlateBack.render(f5);
		TorsoBoxBack.render(f5);
		TorsoPlateLeftBack.render(f5);
		TorsoPlateRightBack.render(f5);
		TailFrontBase.render(f5);
		TailFrontPlate.render(f5);
		TailBackBase.render(f5);
		TailRotorFront.render(f5);
		TailRotorTop.render(f5);
		TailRotorBack.render(f5);
		TailRotorBottom.render(f5);
		TailRotorBlades.render(f5);
		TailRotorPivot.render(f5);
		HeadNeck.render(f5);
		HeadBack.render(f5);
		HeadBase.render(f5);
		HeadTop.render(f5);
		HeadFront.render(f5);
		HeadLeft.render(f5);
		HeadRight.render(f5);
		HeadFrontTop.render(f5);
		TorsoRotorBottom.render(f5);
		TorsoRotorFront.render(f5);
		TorsoRotorBack.render(f5);
		TorsoRotorBlades.render(f5);
		TorsoRotorPivot.render(f5);
		RotorBlades.render(f5);
		Antenna1.render(f5);
		Antenna2.render(f5);
		//GunPivot.render(f5);
		//GunBarrel.render(f5);
		//GunBack.render(f5);

		RotorBlades.rotateAngleY += f * 5;
		TorsoRotorBlades.rotateAngleZ += f * 5;
		TailRotorBlades.rotateAngleZ += f * 5;
	}

}
