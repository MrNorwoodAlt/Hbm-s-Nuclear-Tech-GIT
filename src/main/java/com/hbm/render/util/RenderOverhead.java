package com.hbm.render.util;

import com.hbm.render.amlfrom1710.Vec3;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.lwjgl.opengl.GL11;

import java.util.*;

public class RenderOverhead {

	public static void renderTag(EntityLivingBase living, double x, double y, double z, RenderLivingBase renderer, String name, boolean depthTest) {

		EntityPlayer thePlayer = Minecraft.getMinecraft().player;

		GlStateManager.alphaFunc(GL11.GL_GREATER, 0.1F);

		if(shouldRenderTag(living)) {
			float f = 1.6F;
			double distSq = living.getDistanceSq(thePlayer);
			float range = living.isSneaking() ? RenderLivingBase.NAME_TAG_RANGE_SNEAK : RenderLivingBase.NAME_TAG_RANGE;

			if(distSq < (double) (range * range)) {
				String s = name;
				drawTagAware(living, x, y, z, name, depthTest);
			}
		}
	}

	protected static boolean shouldRenderTag(EntityLivingBase p_110813_1_) {
		return Minecraft.isGuiEnabled() && p_110813_1_ != Minecraft.getMinecraft().player && !p_110813_1_.isInvisibleToPlayer(Minecraft.getMinecraft().player) && !p_110813_1_.isBeingRidden();
	}

	protected static void drawTagAware(EntityLivingBase entity, double x, double y, double z, String string, boolean depthTest) {
		if(entity.isPlayerSleeping()) {
			drawTag(entity, string, x, y - 1.5D, z, 64, depthTest);
		} else {
			drawTag(entity, string, x, y, z, 64, depthTest);
		}
	}

	protected static void drawTag(Entity entity, String name, double x, double y, double z, int dist, boolean depthTest) {

		double distsq = entity.getDistanceSq(Minecraft.getMinecraft().player);

		if(distsq <= (double) (dist * dist)) {
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			float f = 1.6F;
			float scale = 0.016666668F * f;
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.0F, (float) y + entity.height + 0.75F, (float) z);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(-scale, -scale, scale);
			GlStateManager.disableLighting();
			GlStateManager.depthMask(false);
			if(depthTest) {
				GlStateManager.disableDepth();
			}
			GlStateManager.enableBlend();
			//src alpha, one minus src alpha
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder buf = tessellator.getBuffer();
			byte heightOffset = 0;

			if(name.equals("deadmau5")) {
				heightOffset = -10;
			}

			GlStateManager.disableTexture2D();
			buf.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
			int center = fontrenderer.getStringWidth(name) / 2;
			GlStateManager.color(0.0F, 0.0F, 0.0F, 0.25F);
			buf.pos((double) (-center - 1), (double) (-1 + heightOffset), 0.0D).endVertex();
			buf.pos((double) (-center - 1), (double) (8 + heightOffset), 0.0D).endVertex();
			buf.pos((double) (center + 1), (double) (8 + heightOffset), 0.0D).endVertex();
			buf.pos((double) (center + 1), (double) (-1 + heightOffset), 0.0D).endVertex();
			tessellator.draw();
			GlStateManager.enableTexture2D();
			fontrenderer.drawString(name, -fontrenderer.getStringWidth(name) / 2, heightOffset, 553648127);
			GlStateManager.enableDepth();
			GlStateManager.depthMask(true);
			fontrenderer.drawString(name, -fontrenderer.getStringWidth(name) / 2, heightOffset, -1);
			GlStateManager.enableLighting();
			GlStateManager.disableBlend();
			GlStateManager.color(1, 1, 1, 1);
			GL11.glPopMatrix();
		}
	}

	protected static void drawTag(float offset, double distsq, String name, double x, double y, double z, int dist, boolean depthTest, int color, int shadowColor) {

		if(distsq <= (double) (dist * dist)) {
			FontRenderer fontrenderer = Minecraft.getMinecraft().fontRenderer;
			float f = 1.6F;
			float scale = 0.016666668F * f;
			GL11.glPushMatrix();
			GL11.glTranslatef((float) x + 0.0F, (float) y + offset, (float) z);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-Minecraft.getMinecraft().getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(Minecraft.getMinecraft().getRenderManager().playerViewX, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(-scale, -scale, scale);
			GlStateManager.disableLighting();
			GlStateManager.depthMask(false);
			if(depthTest) {
				GlStateManager.disableDepth();
			}
			GlStateManager.enableBlend();
			//src alpha, one minus src alpha
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			Tessellator tessellator = Tessellator.getInstance();
			BufferBuilder buf = tessellator.getBuffer();
			byte heightOffset = 0;

			if(name.equals("deadmau5")) {
				heightOffset = -10;
			}

			GlStateManager.disableTexture2D();
			buf.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
			int center = fontrenderer.getStringWidth(name) / 2;
			GlStateManager.color(0.0F, 0.0F, 0.0F, 0.25F);
			buf.pos((double) (-center - 1), (double) (-1 + heightOffset), 0.0D).endVertex();
			buf.pos((double) (-center - 1), (double) (8 + heightOffset), 0.0D).endVertex();
			buf.pos((double) (center + 1), (double) (8 + heightOffset), 0.0D).endVertex();
			buf.pos((double) (center + 1), (double) (-1 + heightOffset), 0.0D).endVertex();
			tessellator.draw();
			GlStateManager.enableTexture2D();
			fontrenderer.drawString(name, -fontrenderer.getStringWidth(name) / 2, heightOffset, shadowColor);
			GlStateManager.enableDepth();
			GlStateManager.depthMask(true);
			fontrenderer.drawString(name, -fontrenderer.getStringWidth(name) / 2, heightOffset, color);
			GlStateManager.enableLighting();
			GlStateManager.disableBlend();
			GlStateManager.color(1, 1, 1, 1);
			GL11.glPopMatrix();
		}
	}

	public static void renderThermalSight(float partialTicks) {

		EntityPlayer player = Minecraft.getMinecraft().player;
		double x = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
		double y =  player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
		double z =  player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;

		GL11.glPushMatrix();
		GlStateManager.disableColorMaterial();
		GlStateManager.disableTexture2D();
		GlStateManager.disableLighting();
		GL11.glEnable(GL11.GL_POINT_SMOOTH);
		GlStateManager.enableBlend();
		GlStateManager.disableDepth();
		GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);

		net.minecraft.client.renderer.Tessellator tess = net.minecraft.client.renderer.Tessellator.getInstance();
		BufferBuilder buf = tess.getBuffer();
		buf.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_COLOR);

		for(Object o : player.world.loadedEntityList) {

			Entity ent = (Entity) o;

			if(ent == player)
				continue;

			if(ent.getDistanceSq(player) > 4096)
				continue;
			float r, g, b;
			r = g = b = 1;
			if(ent instanceof IMob){
				r = 1; g = 0; b = 0;
			} else if(ent instanceof EntityPlayer){
				r = 1; g = 0; b = 1;
			} else if(ent instanceof EntityLiving){
				r = 0; g = 1; b = 0;
			} else if(ent instanceof EntityItem){
				r = 1; g = 1; b = 0.5F;
			} else if(ent instanceof EntityXPOrb) {
				if(player.ticksExisted % 10 < 5){
					r = 1; g = 1; b = 0.5F;
				} else {
					r = 0.5F; g = 1; b = 0.5F;
				}
			} else {
				continue;
			}

			AxisAlignedBB bb = ent.getEntityBoundingBox();
			buf.pos(bb.minX - x, bb.maxY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.minY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.maxY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.maxY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.maxY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.minY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.minY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.minY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.minY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.minY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.maxY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.maxY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.maxY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.minY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.maxY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.maxY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.maxY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.minY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.maxY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.maxY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.minY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.maxX - x, bb.minY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.minY - y, bb.minZ - z).color(r, g, b, 1).endVertex();
			buf.pos(bb.minX - x, bb.minY - y, bb.maxZ - z).color(r, g, b, 1).endVertex();
		}

		tess.draw();

		GlStateManager.enableColorMaterial();
		GlStateManager.enableTexture2D();
		GL11.glDisable(GL11.GL_POINT_SMOOTH);
		GlStateManager.disableBlend();
		GlStateManager.enableDepth();
        GL11.glPopMatrix();
	}

	public static final HashMap<BlockPos, Marker> queuedMarkers = new HashMap();
	private static final HashMap<BlockPos, Marker> markers = new HashMap();

	public static void renderMarkers(float partialTicks) {

		markers.putAll(queuedMarkers);
		queuedMarkers.clear();

		if(markers.isEmpty())
			return;

		EntityPlayer player = Minecraft.getMinecraft().player;
		double x = player.prevPosX + (player.posX - player.prevPosX) * partialTicks;
		double y =  player.prevPosY + (player.posY - player.prevPosY) * partialTicks;
		double z =  player.prevPosZ + (player.posZ - player.prevPosZ) * partialTicks;

		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_COLOR_MATERIAL);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_POINT_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA,GL11.GL_ONE_MINUS_SRC_ALPHA);

		Tessellator tess = Tessellator.getInstance();
		BufferBuilder buf = tess.getBuffer();
		buf.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_COLOR);

		Iterator<Map.Entry<BlockPos, Marker>> it = markers.entrySet().iterator();
		List<Map.Entry<BlockPos, Marker>> tagList = new ArrayList();
		while(it.hasNext()) {
			Map.Entry<BlockPos, Marker> entry = it.next();
			BlockPos pos = entry.getKey();
			Marker marker = entry.getValue();

			int pX = pos.getX();
			int pY = pos.getY();
			int pZ = pos.getZ();

			double minX = marker.minX;
			double minY = marker.minY;
			double minZ = marker.minZ;
			double maxX = marker.maxX;
			double maxY = marker.maxY;
			double maxZ = marker.maxZ;

			int r = (marker.color >> 16) & 0xFF;
			int g = (marker.color >> 8) & 0xFF;
			int b = marker.color & 0xFF;
			int a = 255;

			buf.pos(pX + minX - x, pY + maxY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + minY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + maxY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + maxY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + maxY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + minY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + minY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + minY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + minY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + minY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + maxY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + maxY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + maxY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + minY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + maxY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + maxY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + maxY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + minY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + maxY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + maxY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + minY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + maxX - x, pY + minY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + minY - y, pZ + minZ - z).color(r, g, b, a).endVertex();
			buf.pos(pX + minX - x, pY + minY - y, pZ + maxZ - z).color(r, g, b, a).endVertex();

			tagList.add(entry);

			if(marker.expire > 0 && System.currentTimeMillis() > marker.expire) {
				it.remove();
			} else if(marker.maxDist > 0) {
				double aX = pX + (maxX - minX) / 2D;
				double aY = pY + (maxY - minY) / 2D;
				double aZ = pZ + (maxZ - minZ) / 2D;
				Vec3 vec = Vec3.createVectorHelper(x - aX, y - aY, z - aZ);
				if(vec.length() > marker.maxDist) {
					it.remove();
				}
			}
		}

		tess.draw();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_POINT_SMOOTH);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_DEPTH_TEST);

		for(Map.Entry<BlockPos, Marker> entry : tagList) {

			BlockPos pos = entry.getKey();
			Marker marker = entry.getValue();

			int pX = pos.getX();
			int pY = pos.getY();
			int pZ = pos.getZ();

			double minX = marker.minX;
			double minY = marker.minY;
			double minZ = marker.minZ;
			double maxX = marker.maxX;
			double maxY = marker.maxY;
			double maxZ = marker.maxZ;

			double aX = pX + (maxX - minX) / 2D;
			double aY = pY + (maxY - minY) / 2D;
			double aZ = pZ + (maxZ - minZ) / 2D;
			Vec3 vec = Vec3.createVectorHelper(aX - x, aY - y, aZ - z);
			double len = vec.xCoord * vec.xCoord + vec.yCoord * vec.yCoord + vec.zCoord * vec.zCoord;
			double sqrt = Math.sqrt(len);
			double mult = Math.min(sqrt, 16D);
			vec.xCoord *= mult / sqrt;
			vec.yCoord *= mult / sqrt;
			vec.zCoord *= mult / sqrt;
			Vec3d look = player.getLookVec();
			Vec3 diff = vec.normalize();
			String label = marker.label;
			if(label == null) {
				label = "";
			}

			if(Math.abs(look.x - diff.xCoord) + Math.abs(look.y - diff.yCoord) + Math.abs(look.z - diff.zCoord) < 0.15) {
				label += (!label.isEmpty() ? " " : "") + ((int) sqrt) + "m";
			}

			if(!label.isEmpty()) drawTag(1F, len, label, vec.xCoord, vec.yCoord, vec.zCoord, 100, true, marker.color, marker.color);
		}
		GL11.glPopMatrix();
	}


	public static class Marker {
		double minX = 0;
		double minY = 0;
		double minZ = 0;
		double maxX = 1;
		double maxY = 1;
		double maxZ = 1;

		int color;
		String label;

		long expire;
		double maxDist;

		public Marker(int color) {
			this.color = color;
		}

		public Marker setExpire(long expire) {
			this.expire = expire;
			return this;
		}

		public Marker setDist(double maxDist) {
			this.maxDist = maxDist;
			return this;
		}

		public Marker withLabel(String label) {
			this.label = label;
			return this;
		}
	}
}
