package joaogl.d4rk.ld27.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import joaogl.d4rk.ld27.data.GameValues;
import joaogl.d4rk.ld27.tiles.Tile;
import joaogl.d4rk.ld27.tiles.WaterTile;

public class Screen {

	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = GameValues.TILE_SIZE;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int xOffset, yOffset;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	Graphics g;
	Gui gui;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}

	public void graphics(Graphics g) {
		this.width = GameValues.width;
		this.height = GameValues.height;
		pixels = new int[width * height];
		this.g = g;
		gui = new Gui(this);
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa < 0) xa = 0;
				if (ya < 0) ya = 0;
				int col = tile.sprite.pixels[(x + y * tile.sprite.SIZE)];
				if (tile.sprite.pixels[x + y * tile.sprite.SIZE] == 0xFFFF00FF) {
					if (pixels.length > (xa + ya * this.width)) pixels[(xa + ya * this.width)] = ScreenColor.changeBrightness(Tile.Grass1.sprite.pixels[x + y * tile.sprite.SIZE], TimeManager.getBrightness());
				} else if ((col != -65281) && (col != -8454017)) {
					if (pixels.length > (xa + ya * this.width)) pixels[(xa + ya * this.width)] = ScreenColor.changeBrightness(col, TimeManager.getBrightness());
				}
			}
		}
	}

	public void renderTile(int xp, int yp, Sprite sprite) {
		xp -= this.xOffset;
		yp -= this.yOffset;
		for (int y = 0; y < GameValues.TILE_SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < GameValues.TILE_SIZE; x++) {
				int xa = x + xp;
				if ((xa < -GameValues.TILE_SIZE) || (xa >= this.width) || (ya < -GameValues.TILE_SIZE) || (ya >= this.height)) break;
				if (xa < 0) xa = 0;
				if (ya < 0) ya = 0;
				if (sprite != null) {
					int col = sprite.pixels[(x + y * GameValues.TILE_SIZE)];
					if ((col != -65281) && (col != -8454017)) pixels[(xa + ya * this.width)] = ScreenColor.changeBrightness(col, TimeManager.getBrightness());
				}
			}
		}
	}

	public void renderMob(int xp, int yp, Mob mob, int flip, boolean hurt) {
		xp -= this.xOffset;
		yp -= this.yOffset;
		for (int y = 0; y < GameValues.PLAYER_SIZE; y++) {
			int yt = y + yp;
			int ys = y;
			if ((flip == 2) || (flip == 3)) ys = GameValues.PLAYER_SIZE_MASK - y;
			for (int x = 0; x < GameValues.PLAYER_SIZE; x++) {
				int xt = x + xp;
				int xs = x;
				if ((flip == 1) || (flip == 3)) xs = GameValues.PLAYER_SIZE_MASK - x;
				if ((xt < -GameValues.PLAYER_SIZE_MASK) || (xt >= this.width) || (yt < -GameValues.PLAYER_SIZE) || (yt >= this.height)) break;
				if (xt < 0) xt = 0;
				if (yt < 0) yt = 0;
				int col = mob.sprite.pixels[(xs + ys * GameValues.PLAYER_SIZE)];
				if ((col != -65281) && (col != -8454017)) {
					if (((mob instanceof Npc)) && (col == -4446173)) col = -11611301;
					if (col < 0) {
						if (mob.lightDist < 0.0D) col = ScreenColor.changeBrightness(col, TimeManager.getBrightness());
						else col = ScreenColor.changeBrightness(col, (int) (mob.lightDist * (TimeManager.getBrightness() * 0.008999999999999999D)));
					}
					if (pixels.length > (xt + yt * this.width)) this.pixels[(xt + yt * this.width)] = col;
				}
			}
		}
	}

	public void renderLight(int xp, int yp, Tile tile, int r, int g, int b, double intensity) {
		xp -= this.xOffset;
		yp -= this.yOffset;
		for (int y = 0; y < GameValues.TILE_SIZE; y++) {
			int yt = y + yp;
			int ys = y;
			for (int x = 0; x < GameValues.TILE_SIZE; x++) {
				int xt = x + xp;
				int xs = x;
				if ((xt < -GameValues.TILE_SIZE_MASK) || (xt >= this.width) || (yt < -GameValues.TILE_SIZE) || (yt >= this.height)) break;
				if (xt < 0) xt = 0;
				if (yt < 0) yt = 0;
				int col = tile.sprite.pixels[(xs + ys * GameValues.TILE_SIZE)];
				if ((tile instanceof WaterTile)) col = WaterTile.sprite.pixels[(xs + ys * GameValues.TILE_SIZE)];
				if ((tile instanceof TorchTile)) col = WaterTile.sprite.pixels[(xs + ys * GameValues.TILE_SIZE)];
				if (col != -65281) {
					col = ScreenColor.tint(col, r * intensity, g * intensity, b * intensity);
					this.pixels[(xt + yt * this.width)] = col;
				}
			}
		}
	}

	public void renderText(String text, int x, int y, int size, int style, int color) {
		int r = (color & 0xFF0000) >> 16;
		int g = (color & 0xFF00) >> 8;
		int b = color & 0xFF;
		Color c = new Color(r, g, b);
		Font f = new Font("Verdana", style, size);
		this.g.setColor(c);
		this.g.setFont(f);
		this.g.drawString(text, x, y);
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
