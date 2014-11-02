/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Component implementation for demo purposes.
 * 
 */

package Components;

import java.util.Random;

import Other.CANCorder;

public class BarGraph1 implements Component {
	
	private String variableName;
	private int value;
	private int width;
	private int height;
	private int xPosition;
	private int yPosition;
	
	public BarGraph1(int width, int height, int xPosition, int yPosition, String variableName) {
		
		this.value = this.height;
		this.variableName = variableName;
		this.width = width;
		this.height = height;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	@Override
	public void update() {
		
		// Normally, this line would be CANCorder.getValue(this.variableName);
		this.value += 1;
		this.value %= this.height;
	}

	@Override
	public void render(int[][] pixels) {
		
		for (int y = this.yPosition; y < this.height + this.yPosition; y++) {
			for (int x = this.xPosition; x < this.width + this.xPosition; x++) {
				if (y > this.height - this.value) {
					pixels[y][x] = 0xFFFFFF;
				}
			}
		}
	}
}
