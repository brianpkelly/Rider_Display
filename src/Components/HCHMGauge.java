/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is the a full circle heat map gauge generated from a sprite sheet.
 * 
 */

package Components;

import Graphics.SpriteSheet;

public class HCHMGauge implements Component {
	
	private String variableName;
	private int value;
	private int width;
	private int xPosition;
	private int yPosition;
	public final int SPRITE_SIZE = 256;
	public final int SPRITE_NUMBER = 129;
	public SpriteSheet spritesheet;
	
	public HCHMGauge(int width, int xPosition, int yPosition, String variableName) {
		
		this.value = 0;
		this.variableName = variableName;
		this.width = width;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spritesheet = new SpriteSheet("res/spritesheets/fchm_gauge_long_256_2.png", this.SPRITE_SIZE, this.SPRITE_SIZE, this.SPRITE_NUMBER);
	}

	@Override
	public void update() {
		
		this.value += 1;
		this.value = this.value % 127;
	} 

	@Override
	public void render(int[][] pixels) {

		int index = this.value * this.SPRITE_SIZE;
		for (int y = this.yPosition; y < this.width + this.yPosition; y++) {
			for (int x = this.xPosition; x < this.width + this.xPosition; x++) {
				
				int pixel = this.spritesheet.pixels[(y * this.SPRITE_SIZE * 129) + x + index];
				if (pixel != -16777216) {
					pixels[y][x] = pixel;
				}
			}
		}
	}
}
