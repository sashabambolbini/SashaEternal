package net.sashabambolbi.sashaeternal.client.gui;

import net.sashabambolbi.sashaeternal.world.inventory.CrystalballguMenu;
import net.sashabambolbi.sashaeternal.network.CrystalballguButtonMessage;
import net.sashabambolbi.sashaeternal.init.SashaeternalModScreens;
import net.sashabambolbi.sashaeternal.SashaeternalMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class CrystalballguScreen extends AbstractContainerScreen<CrystalballguMenu> implements SashaeternalModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_bowchoose;
	private ImageButton imagebutton_spirechoose;
	private ImageButton imagebutton_wandchoose;
	private ImageButton imagebutton_swordchoose;
	private static final ResourceLocation BACKGROUND = new ResourceLocation("sashaeternal:textures/screens/crystalballgu.png");
	private static final ResourceLocation IMAGE_0 = new ResourceLocation("sashaeternal:textures/screens/background.png");

	public CrystalballguScreen(CrystalballguMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 425;
		this.imageHeight = 235;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 424, 232, 424, 232);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_bowchoose = new ImageButton(this.leftPos + 1, this.topPos + 37, 100, 148, 0, 0, 148, new ResourceLocation("sashaeternal:textures/screens/atlas/imagebutton_bowchoose.png"), 100, 296, e -> {
			int x = CrystalballguScreen.this.x;
			int y = CrystalballguScreen.this.y;
			if (true) {
				SashaeternalMod.PACKET_HANDLER.sendToServer(new CrystalballguButtonMessage(0, x, y, z));
				CrystalballguButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_bowchoose);
		imagebutton_spirechoose = new ImageButton(this.leftPos + 110, this.topPos + 37, 100, 148, 0, 0, 148, new ResourceLocation("sashaeternal:textures/screens/atlas/imagebutton_spirechoose.png"), 100, 296, e -> {
			int x = CrystalballguScreen.this.x;
			int y = CrystalballguScreen.this.y;
			if (true) {
				SashaeternalMod.PACKET_HANDLER.sendToServer(new CrystalballguButtonMessage(1, x, y, z));
				CrystalballguButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_spirechoose);
		imagebutton_wandchoose = new ImageButton(this.leftPos + 324, this.topPos + 37, 100, 148, 0, 0, 148, new ResourceLocation("sashaeternal:textures/screens/atlas/imagebutton_wandchoose.png"), 100, 296, e -> {
			int x = CrystalballguScreen.this.x;
			int y = CrystalballguScreen.this.y;
			if (true) {
				SashaeternalMod.PACKET_HANDLER.sendToServer(new CrystalballguButtonMessage(2, x, y, z));
				CrystalballguButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_wandchoose);
		imagebutton_swordchoose = new ImageButton(this.leftPos + 215, this.topPos + 37, 100, 148, 0, 0, 148, new ResourceLocation("sashaeternal:textures/screens/atlas/imagebutton_swordchoose.png"), 100, 296, e -> {
			int x = CrystalballguScreen.this.x;
			int y = CrystalballguScreen.this.y;
			if (true) {
				SashaeternalMod.PACKET_HANDLER.sendToServer(new CrystalballguButtonMessage(3, x, y, z));
				CrystalballguButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_swordchoose);
	}
}