package com.hbm.render.entity.missile;

import com.hbm.entity.missile.EntityMissileTier4;
import com.hbm.main.ResourceManager;
import com.hbm.render.NTMRenderHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

public class RenderMissileDoomsday extends Render<EntityMissileTier4.EntityMissileDoomsday> {

	public static final IRenderFactory<EntityMissileTier4.EntityMissileDoomsday> FACTORY = (RenderManager man) -> {return new RenderMissileDoomsday(man);};
	
	protected RenderMissileDoomsday(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	public void doRender(EntityMissileTier4.EntityMissileDoomsday missile, double x, double y, double z, float entityYaw, float partialTicks) {
		GL11.glPushMatrix();
		GL11.glPushAttrib(GL11.GL_LIGHTING_BIT);
		GlStateManager.enableLighting();
		double[] renderPos = NTMRenderHelper.getRenderPosFromMissile(missile, partialTicks);
		x = renderPos[0];
		y = renderPos[1];
		z = renderPos[2];
		GL11.glTranslated(x, y, z);
        GL11.glRotatef(missile.prevRotationYaw + (missile.rotationYaw - missile.prevRotationYaw) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(missile.prevRotationPitch + (missile.rotationPitch - missile.prevRotationPitch) * partialTicks, 0.0F, 0.0F, 1.0F);
        GL11.glScalef(2F, 2F, 2F);

        GL11.glDisable(GL11.GL_CULL_FACE);
        bindTexture(ResourceManager.missileDoomsday_tex);
        ResourceManager.missileDoomsday.renderAll();
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glPopAttrib();
		GL11.glPopMatrix();
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityMissileTier4.EntityMissileDoomsday entity) {
		return ResourceManager.missileDoomsday_tex;
	}

}
