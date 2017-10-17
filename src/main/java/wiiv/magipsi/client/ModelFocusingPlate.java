/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Psi Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Psi
 *
 * Psi is Open Source and distributed under the
 * Psi License: http://psi.vazkii.us/license.php
 *
 * File Created @ [20/02/2016, 22:41:34 (GMT)]
 */
package wiiv.magipsi.client;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityArmorStand;
import vazkii.arl.item.ModelModArmor;
import vazkii.psi.client.core.handler.ClientTickHandler;

public class ModelFocusingPlate extends ModelModArmor {

	private final ModelRenderer helmAnchor;
	private final ModelRenderer helm;
	private final ModelRenderer helmDetailr;
	private final ModelRenderer helmDetaill;
	
	private final ModelRenderer bodyAnchor;
	private final ModelRenderer body;

	private final ModelRenderer armLAnchor;
	private final ModelRenderer armL;
	private final ModelRenderer armLpauldron;
	private final ModelRenderer armLcrystal;
	
	private final ModelRenderer armRAnchor;
	private final ModelRenderer armR;
	private final ModelRenderer armRpauldron;
	private final ModelRenderer armRcrystal;
	
	private final ModelRenderer pantsAnchor;
	private final ModelRenderer belt;
	private final ModelRenderer legL;
	private final ModelRenderer skirtL;
	private final ModelRenderer legR;
	private final ModelRenderer skirtR;

	private final ModelRenderer bootL;
	private final ModelRenderer bootR;
	
	private final ModelRenderer sensor;
	private final ModelRenderer sensorColor;
	
	int slot = 0;

	public ModelFocusingPlate(int slot) {
		this.slot = slot;

		textureWidth = 64;
		textureHeight = 128;
		float s = 0.01F;

		//helm
        helmAnchor = new ModelRenderer(this, 0, 0);
        helmAnchor.setRotationPoint(0.0F, 0.0F, 0.0F);
        helmAnchor.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 2, s);
        helm = new ModelRenderer(this, 0, 0);
        helm.setRotationPoint(0.0F, 0.0F, 0.0F);
        helm.addBox(-4.5F, -9.0F, -5.0F, 9, 9, 10, s);
        helmDetaill = new ModelRenderer(this, 0, 0);
        helmDetaill.mirror = true;
        helmDetaill.setRotationPoint(0.0F, 0.0F, 0.0F);
        helmDetaill.addBox(4.5F, -5.0F, 0.0F, 1, 3, 3, s);
        helmDetailr = new ModelRenderer(this, 0, 0);
        helmDetailr.setRotationPoint(0.0F, 0.0F, 0.0F);
        helmDetailr.addBox(-5.5F, -5.0F, 0.0F, 1, 3, 3, s);
        
        //sensor
        sensor = new ModelRenderer(this, 38, 0);
        sensor.setRotationPoint(0.0F, -5.0F, -5.0F);
        sensor.addBox(-1.5F, -7.0F, -1.0F, 3, 13, 5, s);
        sensorColor = new ModelRenderer(this, 0, 0);
        sensorColor.mirror = true;
        sensorColor.setRotationPoint(0.0F, -6.0F, 6.0F);
        sensorColor.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 2, s);
        
        //body
        bodyAnchor = new ModelRenderer(this, 0, 0);
        bodyAnchor.setRotationPoint(0.0F, 0.0F, 0.0F);
        bodyAnchor.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, s);
        body = new ModelRenderer(this, 0, 19);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox(-4.5F, -0.5F, -3.0F, 9, 7, 6, s);
        
     	//armL
        armLAnchor = new ModelRenderer(this, 0, 0);
        armLAnchor.mirror = true;
        armLAnchor.setRotationPoint(4.0F, 2.0F, 0.0F);
        armLAnchor.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, s);
        armL = new ModelRenderer(this, 0, 44);
        armL.mirror = true;
        armL.setRotationPoint(0.0F, 0.0F, 0.0F);
        armL.addBox(0.5F, 6.0F, -2.5F, 3, 4, 5, s);
        armLpauldron = new ModelRenderer(this, 0, 32);
        armLpauldron.mirror = true;
        armLpauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        armLpauldron.addBox(1.0F, -2.5F, -2.5F, 3, 7, 5, s);
        setRotateAngle(armLpauldron, 0.0F, 0.0F, -0.17453292519943295F);
        armLcrystal = new ModelRenderer(this, 16, 32);
        armLcrystal.mirror = true;
        armLcrystal.setRotationPoint(0.0F, 0.0F, 0.0F);
        armLcrystal.addBox(2.5F, -5.5F, -1.5F, 3, 11, 3, s);
        
        //armR
        armRAnchor = new ModelRenderer(this, 0, 0);
        armRAnchor.mirror = true;
        armRAnchor.setRotationPoint(-4.0F, 2.0F, 0.0F);
        armRAnchor.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2, s);
        armR = new ModelRenderer(this, 0, 44);
        armR.setRotationPoint(0.0F, 0.0F, 0.0F);
        armR.addBox(-3.5F, 6.0F, -2.51F, 3, 4, 5, s);
        armRpauldron = new ModelRenderer(this, 0, 32);
        armRpauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        armRpauldron.addBox(-4.0F, -2.5F, -2.5F, 3, 7, 5, s);
        setRotateAngle(armRpauldron, 0.0F, 0.0F, 0.17453292519943295F);
        armRcrystal = new ModelRenderer(this, 16, 32);
        armRcrystal.setRotationPoint(0.0F, 0.0F, 0.0F);
        armRcrystal.addBox(-5.5F, -5.5F, -1.5F, 3, 11, 3, s);
        
        //pants
        pantsAnchor = new ModelRenderer(this, 0, 0);
        pantsAnchor.setRotationPoint(0.0F, 0.0F, 0.0F);
        pantsAnchor.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, s);
        belt = new ModelRenderer(this, 0, 53);
        belt.setRotationPoint(0.0F, 0.0F, 0.0F);
        belt.addBox(-2.5F, 8.0F, -4.0F, 5, 13, 3, 0.0F);
        setRotateAngle(belt, -0.08726646259971647F, 0.0F, 0.0F);
        legL = new ModelRenderer(this, 0, 69);
        legL.mirror = true;
        legL.setRotationPoint(1.9F, 12.0F, 0.0F);
        legL.addBox(-1.39F, 1.0F, -2.49F, 4, 5, 5, s);
        skirtL = new ModelRenderer(this, 16, 53);
        skirtL.mirror = true;
        skirtL.setRotationPoint(-0.5F, -2.0F, -2.5F);
        skirtL.addBox(-1.5F, 0.0F, -0.5F, 5, 13, 6, s);
        setRotateAngle(skirtL, 0.0F, -0.17453292519943295F, -0.2617993877991494F);
        legR = new ModelRenderer(this, 0, 69);
        legR.setRotationPoint(-1.9F, 12.0F, 0.0F);
        legR.addBox(-2.61F, 1.0F, -2.51F, 4, 5, 5, s);
        skirtR = new ModelRenderer(this, 16, 53);
        skirtR.setRotationPoint(0.5F, -2.0F, -2.5F);
        skirtR.addBox(-3.5F, 0.0F, -0.5F, 5, 13, 6, s);
        setRotateAngle(skirtR, 0.0F, 0.17453292519943295F, 0.2617993877991494F);
        
        //boots
        bootL = new ModelRenderer(this, 0, 80);
        bootL.mirror = true;
        bootL.setRotationPoint(1.9F, 12.0F, 0.0F);
        bootL.addBox(-2.39F, 8.0F, -2.49F, 5, 4, 5, s);
        bootR = new ModelRenderer(this, 0, 80);
        bootR.setRotationPoint(-1.9F, 12.0F, 0.0F);
        bootR.addBox(-2.61F, 8.0F, -2.51F, 5, 4, 5, s);
        
        //hierarchy
        helmAnchor.addChild(helm);
        helm.addChild(helmDetaill);
        helm.addChild(helmDetailr);
        helm.addChild(sensor);
        sensor.addChild(sensorColor);
        
        bodyAnchor.addChild(body);
        
        armLAnchor.addChild(armL);
        armL.addChild(armLpauldron);
        armLpauldron.addChild(armLcrystal);
        armRpauldron.addChild(armRcrystal);
        armRAnchor.addChild(armR);
        armR.addChild(armRpauldron);
        
        pantsAnchor.addChild(belt);
        belt.addChild(legL);
        legL.addChild(skirtL);
        belt.addChild(legR);
        legR.addChild(skirtR);
        
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		if(entity instanceof EntityArmorStand) {
			f = 0;
			f1 = 0;
			f2 = 0;
			f3 = 0;
			f4 = 0;
		}
		
		helm.showModel = slot == 3;
		body.showModel = slot == 2;
		armR.showModel = slot == 2;
		armL.showModel = slot == 2;
		belt.showModel = slot == 1;
		bootL.showModel = slot == 0;
		bootR.showModel = slot == 0;
		bipedHeadwear.showModel = false;

		setModelParts();
		prepareForRender(entity, ClientTickHandler.partialTicks);
		super.render(entity, f, f1, f2, f3, f4, f5);
	}
	
	@Override
	public void setModelParts() {
		bipedHead = helmAnchor;
		bipedBody = bodyAnchor;
		bipedRightArm = armRAnchor;
		bipedLeftArm = armLAnchor;
		if(slot == 1) {
			bipedBody = pantsAnchor;
			bipedRightLeg = legR;
			bipedLeftLeg = legL;
		} else {
			bipedRightLeg = bootR;
			bipedLeftLeg = bootL;
		}
	}
}