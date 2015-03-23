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
	
	private String variableName;
	private int value;
	private int width;
	private int xPosition;
	private int yPosition;
	private int layoutWidth;
	public final int SPRITE_SIZE = 256;
	public final int SPRITE_NUMBER = 129;
	public SpriteSheet spritesheet;
	private CANCorder cancorder;
	
	public FCHMGauge(int layoutWidth, int width, int xPosition, int yPosition, String variableName, CANCorder cancorder) {
		
		this.value = 0;
		this.variableName = variableName;
		this.width = width;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.spritesheet = new SpriteSheet("/spritesheets/fchm_gauge_min.png", this.SPRITE_SIZE, this.SPRITE_SIZE, this.SPRITE_NUMBER);
		this.cancorder = cancorder;
		this.layoutWidth = layoutWidth;
	}

	@Override
	public void update() {
		
		this.value = (int) this.cancorder.getValue(variableName);
		//this.value += 1;
		this.value %= 129;
	} 

	@Override
	public void render(Graphics graphics) {

		graphics.drawImage(this.spritesheet.getSprite(this.value), this.xPosition, this.yPosition, null);
	}
}