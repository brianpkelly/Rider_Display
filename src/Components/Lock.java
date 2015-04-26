/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a full circle heat map gauge generated from a sprite sheet.
 * 
 */

package Components;


import Data.CANCorder;
import Graphics.SpriteSheet;

public class Lock extends RasterComponent {
	
	public final int SPRITE_SIZE = 64;
	public final int SPRITE_NUMBER = 2;

	public Lock(int xPosition, int yPosition) {
		
		this.currentValue = 0;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spritesheet = new SpriteSheet("/spritesheets/lock.png", this.SPRITE_SIZE, this.SPRITE_SIZE, this.SPRITE_NUMBER);
		//this.spritesheet = new SpriteSheet("res/spritesheets/fchm_gauge_alpha.png", this.SPRITE_SIZE, this.SPRITE_SIZE, this.SPRITE_NUMBER);
		this.cancorder = new CANCorder(CANCorder.LOCK);
		this.minValue = 0;
		this.maxValue = 1;
	}

}