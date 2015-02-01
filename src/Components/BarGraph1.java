/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Component implementation for demo purposes.
 * 
 */

package Components;

import java.util.Random;

import Data.CANCorder;

public class BarGraph1 implements Component {
	
	private String variableName;
	private int value;
	private int width;
	private int height;
	private int xPosition;
	private int yPosition;
	private int layoutWidth;
	private int[] pixels;
	
	public BarGraph1(int layoutWidth, int width, int height, int xPosition, int yPosition, String variableName, int[] pixels) {
		
		this.value = this.height;
		this.variableName = variableName;
		this.width = width;
		this.height = height;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.pixels = pixels;
	}

	@Override
	public void update() {
		
		// Normally, this line would be CANCorder.getValue(this.variableName);
		this.value += 1;
		this.value %= this.height;
	}

	@Override
	public void render() {
		
		for (int y = this.yPosition; y < this.height + this.yPosition; y++) {
			for (int x = this.xPosition; x < this.width + this.xPosition; x++) {
				if (y > this.height - this.value) {
					this.pixels[y * this.layoutWidth + x] = 0xFFFFFF;
				}
			}
		}
	}
}
