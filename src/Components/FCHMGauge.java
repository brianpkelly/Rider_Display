/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a full circle heat map gauge generated from a sprite sheet.
 * 
 */

package Components;

import java.awt.Graphics;

import Data.CANCorder;
import Graphics.SpriteSheet;

public class FCHMGauge implements Component {
	
	private int value;
	private int width;
	private int xPosition;
	private int yPosition;
	private int layoutWidth;
	public final int SPRITE_SIZE = 256;
	public final int SPRITE_NUMBER = 129;
	public SpriteSheet spritesheet;
	private CANCorder cancorder;
	
	public FCHMGauge(int layoutWidth, int width, int xPosition, int yPosition, String variableName) {
		
		this.value = 0;
		this.width = width;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spritesheet = new SpriteSheet("/spritesheets/fchm_gauge_min.png", this.SPRITE_SIZE, this.SPRITE_SIZE, this.SPRITE_NUMBER);
		this.cancorder = new CANCorder(variableName);
		this.layoutWidth = layoutWidth;
	}

	@Override
	public void update() {
		
		this.value = (int) this.cancorder.getValue();
		//this.value += 1;
		this.value %= 129;
	} 

	@Override
	public void render(Graphics graphics) {
		// The data read in from the CANCorder has to be analyzed to figure out how to render
		switch (this.value) {
			case CANCorder.ERROR_MISSING_DATA:
				// The data is bad and nothing should be rendered
				return;
			case CANCorder.ERROR_OLD_DATA:
				// The data has not been updated recently, a special sprite will likely rendered in this case
				graphics.drawImage(this.spritesheet.getSprite(this.value), this.xPosition, this.yPosition, null);
				break;
			default:
				// The data is standard and the component should be updated
				graphics.drawImage(this.spritesheet.getSprite(this.value), this.xPosition, this.yPosition, null);
		}
	}
}