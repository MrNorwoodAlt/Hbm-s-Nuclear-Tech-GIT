package com.hbm.inventory.fluid.trait;

import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import com.hbm.inventory.fluid.tank.FluidTankNTM;
import com.hbm.saveddata.RadiationSavedData;
import com.hbm.util.I18nUtil;
import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.io.IOException;
import java.util.List;

public class FT_VentRadiation extends FluidTrait {
	
	float radPerMB = 0;
	
	public FT_VentRadiation() { }
	
	public FT_VentRadiation(float rad) {
		this.radPerMB = rad;
	}
	
	public float getRadPerMB() {
		return this.radPerMB;
	}
	
	@Override
	public void onFluidRelease(World world, int x, int y, int z, FluidTankNTM tank, int overflowAmount, FluidReleaseType type) {
		RadiationSavedData.incrementRad(world, new BlockPos(x, y, z), overflowAmount * radPerMB, Integer.MAX_VALUE);
	}
	
	@Override
	public void addInfo(List<String> info) {
		info.add(ChatFormatting.YELLOW + "[" + I18nUtil.resolveKey("trait.radioactive") + "]");
	}

	@Override
	public void serializeJSON(JsonWriter writer) throws IOException {
		writer.name("radiation").value(radPerMB);
	}
	
	@Override
	public void deserializeJSON(JsonObject obj) {
		this.radPerMB = obj.get("radiation").getAsFloat();
	}
}
