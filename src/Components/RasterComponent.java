package Components;

import java.awt.Graphics;

import Data.CANCorder;
import Graphics.SpriteSheet;

public abstract class RasterComponent implements Component {
	protected int value;
	protected int width;
	protected int xPosition;
	protected int yPosition;
	protected SpriteSheet spritesheet;
	protected CANCorder cancorder;

	@Override
	public void update() {
		
		this.value = (int) this.cancorder.getValue();
		this.value %= 129;
	} 

	@Override
	public void render(Graphics graphics) {
		// The data read in from the CANCorder has to be analyzed to figure out how to render
		switch (this.value) {
			case CANCorder.ERROR_MISSING_DATA:
				// The data is bad and nothing should be rendered
				System.out.println("Bad data");
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
