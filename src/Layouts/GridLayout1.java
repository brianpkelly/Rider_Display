/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Layout implementation for demo purposes.
 * 
 */

package Layouts;

import Components.Component;
import Components.FCHMGauge;
import Components.HCHMGauge;
import Data.CANCorder;
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
	private Component component4;
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
		
		this.component1 = new FCHMGauge(this.width / 4, 0, 0, CANCorder.RPM);
		this.component2 = new FCHMGauge(this.width / 4, this.width / 4, 0, CANCorder.BATTERY_VOLTAGE);
		this.component3 = new FCHMGauge(this.width / 4, this.width / 2, 0, CANCorder.TIRE_PRESSURE);
		this.component4 = new HCHMGauge(this.width / 4, (3 * this.width) / 4, this.width / 4, CANCorder.RPM);
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
		this.component3.update();
		this.component4.update();
	}

	@Override
	public void render() {
		
		this.component1.render(this.pixels);
		this.component2.render(this.pixels);
		this.component3.render(this.pixels);
		this.component4.render(this.pixels);
	}

}
