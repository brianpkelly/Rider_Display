/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is the a full circle heat map gauge generated from a sprite sheet.
 * 
 */

package Components;

import Graphics.SpriteSheet;

public class FCHMGauge implements Component {
	
	private String variableName;
	private int value;
	private int width;
	private int xPosition;
	private int yPosition;
	public final int SPRITE_SIZE = 474;
	public SpriteSheet spritesheet;
	
	public FCHMGauge(int width, int xPosition, int yPosition, String variableName) {
		
		this.value = 0;
		this.variableName = variableName;
		this.width = width;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spritesheet = new SpriteSheet("res/spritesheets/fchm_gauge_long.png", SPRITE_SIZE);
	}

	@Override
	public void update() {
		
		this.value += 1;
		this.value %= 129;
	} ;

	@Override
	public void render(int[][] pixels) {
		int index = this.value * this.SPRITE_SIZE;
		for (int y = this.yPosition; y < this.width + this.yPosition; y++) {
			for (int x = this.xPosition; x < this.width + this.xPosition; x++) {
				
				pixels[y][x] = spritesheet.pixels[(y * 61944) + x + index];
			}
		}
	}
}
