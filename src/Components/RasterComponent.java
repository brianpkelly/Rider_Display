package Components;

import java.awt.Graphics;

import Data.CANCorder;
import Graphics.SpriteSheet;

public abstract class RasterComponent implements Component {
	protected int currentValue;
	protected double minValue;
	protected double maxValue;
	protected int xPosition;
	protected int yPosition;
	protected SpriteSheet spritesheet;
	protected CANCorder cancorder;

	@Override
	public void update() {
		
		this.currentValue = (int) this.cancorder.getValue();
	} 

	@Override
	public void render(Graphics graphics) {
		
		// Maps the current value to a sprite
		//int index =  (int) (spritesheet.NUMBER * (currentValue - minValue) / maxValue);
		int index = currentValue;
		// The data read in from the CANCorder has to be analyzed to figure out how to render
		switch (this.currentValue) {
			case CANCorder.ERROR_MISSING_DATA:
				// The data is bad and nothing should be rendered
				System.out.println("Bad data");
				return;
			case CANCorder.ERROR_OLD_DATA:
				// The data has not been updated recently, a special sprite will likely rendered in this case
				graphics.drawImage(this.spritesheet.getSprite(index), this.xPosition, this.yPosition, null);
				break;
			default:
				// The data is standard and the component should be updated
				graphics.drawImage(this.spritesheet.getSprite(index), this.xPosition, this.yPosition, null);
		}
	}
}
