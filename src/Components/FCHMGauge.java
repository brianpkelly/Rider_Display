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

	public FCHMGauge(int xPosition, int yPosition, String variableName) {
		
		this.currentValue = 0;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spritesheet = new SpriteSheet("/spritesheets/fchm_gauge.png", this.SPRITE_SIZE, this.SPRITE_SIZE, this.SPRITE_NUMBER);
		this.cancorder = new CANCorder(variableName);
		//double[] minMax = this.cancorder.getMinMax();
		//this.minValue = minMax[0];
		//this.maxValue = minMax[1];
		this.minValue = 0;
		this.maxValue = 128;
	}

}