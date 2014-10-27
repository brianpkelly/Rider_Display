/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Component implementation for demo purposes.
 * 
 */

package Components;

import Other.CANCorder;

public class BarGraph1 implements Component {
	
	private String variableName;
	private int value;
	private int width;
	private int height;
	private int xPosition;
	private int yPosition;
	
	public BarGraph1(int width, int height, String variableName) {
		
		this.value = 1;
		this.variableName = variableName;
		this.width = width;
		this.height = height;
	}

	@Override
	public void update() {
		
		// Normally, this line would be CANCorder.getValue(this.variableName);
		this.value += 1;
	}

	@Override
	public void render(int[] pixels) {
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				if (y < this.value) {
					pixels[y * this.width + x] = 0xFFFFFF;
				}
			}
		}
		
		return;
	}

}
