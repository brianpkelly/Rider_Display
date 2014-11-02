/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Layout implementation for demo purposes.
 * 
 */

package Layouts;

import Components.BarGraph1;
import Components.Component;
import Components.Gauge1;

public class GridLayout1 implements Layout {
	
	public int[][] pixels;
	private Component component1;
	private Component component2;
	private Component component3;
	private int width;
	private int height;
	
	public GridLayout1(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.pixels = new int[height][width];
		this.component1 = new BarGraph1(width / 2, height, 0, 0, "TirePressure");
		//this.component1 = new Gauge1(width / 2, 0, 0, "TirePressure");
		this.component2 = new BarGraph1(width / 4, height / 2, width / 2, 0, "Battery Voltage");
		this.component3 = new Gauge1(width / 4, (width / 2) + (width / 4), 0, "RPM");
	}

	@Override
	public void clear() {
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				this.pixels[y][x] = 0;
			}
		}
	}
	
	@Override
	public int[] pixels() {
		
		int[] a = new int[this.height * this.width];
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				a[(y * this.width) + x] =  this.pixels[y][x];
			}
		}
		
		return a;
	}

	@Override
	public void update() {
		
		this.component1.update();
		this.component2.update();
		this.component3.update();
	}

	@Override
	public void render() {
		
		this.component1.render(this.pixels);
		this.component2.render(this.pixels);
		this.component3.render(this.pixels);
	}

}
