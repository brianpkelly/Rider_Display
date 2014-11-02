/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Layout implementation for demo purposes.
 * 
 */

package Layouts;

import Components.BarGraph1;
import Components.Component;

public class GridLayout1 implements Layout {
	
	public int[] pixels;
	private Component component1;
	
	public GridLayout1(int width, int height) {
		
		this.pixels = new int[width * height];
		this.component1 = new BarGraph1(width, height, 0, 0, "TirePressure");
	}

	@Override
	public void clear() {
		
		for (int i = 0; i < this.pixels.length; i++) {
			this.pixels[i] = 0;
		}
	}
	
	@Override
	public int[] pixels() {
		
		return this.pixels;
	}

	@Override
	public void update() {
		
		this.component1.update();
	}

	@Override
	public void render() {
		
		this.component1.render(this.pixels);
	}

}
