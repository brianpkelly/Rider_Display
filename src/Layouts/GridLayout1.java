/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Layout implementation for demo purposes.
 * 
 */

package Layouts;

import Components.Component;
import Components.FCHMGauge;
import Graphics.SpriteSheet;

import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GridLayout1 implements Layout {
	
	public int[][] pixels;
	private int[] bgPixels;
	private Component component1;
	private Component component2;
	private Component component3;
	private int width;
	private int height;
	
	public GridLayout1(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.pixels = new int[height][width];
		this.bgPixels = new int[height * width];
		
		try {
			BufferedImage image = ImageIO.read(GridLayout1.class.getResource("/background.png"));
			int iwidth = image.getWidth();
			int iheight = image.getHeight();
			image.getRGB(0, 0, iwidth, iheight, this.bgPixels, 0, iwidth);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.component1 = new FCHMGauge(width / 4, 0, 0, "TirePressure");
		//this.component1 = new BarGraph1(width / 2, height, 0, 0, "TirePressure");
		//this.component1 = new Gauge1(width / 2, 0, 0, "TirePressure");
		this.component2 = new FCHMGauge(width / 4, width / 2, 0, "BatteryVoltage");
		//this.component3 = new Gauge1(width / 4, (width / 2) + (width / 4), 0, "RPM");
	}

	@Override
	public void clear() {
		
		for (int y = 0; y < this.height; y++) {
			for (int x = 0; x < this.width; x++) {
				this.pixels[y][x] = this.bgPixels[y * this.width + x];
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
		//this.component3.update();
	}

	@Override
	public void render() {
		
		this.component1.render(this.pixels);
		this.component2.render(this.pixels);
		//this.component3.render(this.pixels);
	}

}
