package com.hbm.inventory.gui;

import com.hbm.inventory.container.ContainerMachineLargeTurbine;
import com.hbm.inventory.fluid.Fluids;
import com.hbm.lib.RefStrings;
import com.hbm.tileentity.machine.TileEntityMachineLargeTurbine;
import com.hbm.util.I18nUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GUIMachineLargeTurbine extends GuiInfoContainer {

	public static ResourceLocation texture = new ResourceLocation(RefStrings.MODID + ":textures/gui/generators/gui_turbine_large.png");
	private TileEntityMachineLargeTurbine turbine;

	public GUIMachineLargeTurbine(InventoryPlayer invPlayer, TileEntityMachineLargeTurbine tedf) {
		super(new ContainerMachineLargeTurbine(invPlayer, tedf));
		turbine = tedf;

		this.xSize = 176;
		this.ySize = 168;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		super.drawScreen(mouseX, mouseY, f);

		turbine.tanksNew[0].renderTankInfo(this, mouseX, mouseY, guiLeft + 62, guiTop + 69 - 52, 16, 52);
		turbine.tanksNew[1].renderTankInfo(this, mouseX, mouseY, guiLeft + 134, guiTop + 69 - 52, 16, 52);

		if(turbine.tanksNew[1].getTankType().getName().equals(Fluids.NONE.getName())) {

			String[] text2 = I18nUtil.resolveKeyArray("desc.errorfluid");
			this.drawCustomInfoStat(mouseX, mouseY, guiLeft - 16, guiTop + 36 + 32, 16, 16, guiLeft - 8, guiTop + 36 + 16 + 32, text2);
		}

		this.drawElectricityInfo(this, mouseX, mouseY, guiLeft + 123, guiTop + 69 - 34, 7, 34, turbine.power, TileEntityMachineLargeTurbine.maxPower);
		super.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.turbine.hasCustomInventoryName() ? this.turbine.getInventoryName() : I18n.format(this.turbine.getInventoryName());

		this.fontRenderer.drawString(name, this.xSize / 2 - this.fontRenderer.getStringWidth(name) / 2, 6, 4210752);
		this.fontRenderer.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		super.drawDefaultBackground();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		if(turbine.tanksNew[0].getTankType() == Fluids.STEAM) {
			drawTexturedModalRect(guiLeft + 99, guiTop + 18, 183, 0, 14, 14);
		}
		if(turbine.tanksNew[0].getTankType() == Fluids.HOTSTEAM) {
			drawTexturedModalRect(guiLeft + 99, guiTop + 18, 183, 14, 14, 14);
		}
		if(turbine.tanksNew[0].getTankType() == Fluids.SUPERHOTSTEAM) {
			drawTexturedModalRect(guiLeft + 99, guiTop + 18, 183, 28, 14, 14);
		}
		if(turbine.tanksNew[0].getTankType() == Fluids.ULTRAHOTSTEAM) {
			drawTexturedModalRect(guiLeft + 99, guiTop + 18, 183, 42, 14, 14);
		}

		int i = (int)turbine.getPowerScaled(34);
		drawTexturedModalRect(guiLeft + 123, guiTop + 69 - i, 176, 34 - i, 7, i);

		if(turbine.tanksNew[1].getTankType() == Fluids.NONE) {
			this.drawInfoPanel(guiLeft - 16, guiTop + 36 + 32, 16, 16, 6);
		}

		turbine.tanksNew[0].renderTank(guiLeft + 62, guiTop + 69, this.zLevel, 16, 52);
		turbine.tanksNew[1].renderTank(guiLeft + 134, guiTop + 69, this.zLevel, 16, 52);
	}
}