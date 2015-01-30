/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a half circle heat map gauge generated from a sprite sheet.
 * 
 */

package Components;

import Data.CANCorder;
import Graphics.SpriteSheet;

public class HCHMGauge implements Component {
	
	private String variableName;
	private int value;
	private int width;
	private int xPosition;
	private int yPosition;
	private int layoutWidth;
	public final int SPRITE_WIDTH = 256;
	public final int SPRITE_HEIGHT = 138;
	public final int SPRITE_NUMBER = 129;
	public SpriteSheet spritesheet;
	private CANCorder cancorder;
	
	public HCHMGauge(int layoutWidth, int width, int xPosition, int yPosition, String variableName) {
		
		this.value = 0;
		this.variableName = variableName;
		this.width = width;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.layoutWidth = layoutWidth;
		this.spritesheet = new SpriteSheet("/spritesheets/hchm_gauge.png", this.SPRITE_HEIGHT, this.SPRITE_WIDTH, this.SPRITE_NUMBER);
		this.cancorder = new CANCorder();
	}

	@Override
	public void update() {
		
		//value = (int) this.cancorder.getValue(variableName);
		this.value += 1;
		this.value %= 129;
	} 

	@Override
	public void render(int[] pixels) {

		int index = this.value * this.SPRITE_WIDTH;
		for (int y = this.yPosition; y < this.SPRITE_HEIGHT + this.yPosition; y++) {
			for (int x = this.xPosition; x < this.SPRITE_WIDTH + this.xPosition; x++) {
				
				int pixel = this.spritesheet.pixels[((y - this.yPosition) * this.SPRITE_WIDTH * this.SPRITE_NUMBER) + (x - this.xPosition) + index];
				pixels[y * this.layoutWidth + x] = pixel;
				if (pixel != -16777216) {
					
				}
			}
		}
	}
}