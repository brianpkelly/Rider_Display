/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a full circle heat map gauge generated from a sprite sheet.
 * 
 */

package Components;


import Data.CANCorder;
import Graphics.SpriteSheet;

public class FCHMGauge extends RasterComponent {
	
	public final int SPRITE_SIZE = 256;
	public final int SPRITE_NUMBER = 129;

	public FCHMGauge(int width, int xPosition, int yPosition, String variableName) {
		
		this.value = 0;
		this.width = width;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spritesheet = new SpriteSheet("/spritesheets/fchm_gauge_min.png", this.SPRITE_SIZE, this.SPRITE_SIZE, this.SPRITE_NUMBER);
		this.cancorder = new CANCorder(variableName);
	}

}