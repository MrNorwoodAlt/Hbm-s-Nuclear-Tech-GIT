package com.hbm.inventory.gui;

import com.hbm.lib.RefStrings;
import com.hbm.tileentity.turret.TileEntityTurretBaseNT;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GUITurretRichard extends GUITurretBase {
	
	private static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/weapon/gui_turret_richard.png");

	public GUITurretRichard(InventoryPlayer invPlayer, TileEntityTurretBaseNT tedf) {
		super(invPlayer, tedf);
	}
	
	protected ResourceLocation getTexture() {
		return texture;
	}

	@Override
	public int getTurretFontColor(){
		return 0x433B33;
	}
}
