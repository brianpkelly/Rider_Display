/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is a basic Layout implementation for demo purposes.
 * 
 */

package Layouts;

import Components.Component;
import Components.FCHMGauge;
import Components.Lock;
import Data.CANCorder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GridLayout1 implements Layout {
	
	private Component component1;
	private Component component2;
	private Component component3;
	private int width;
	private int height;
	private BufferedImage backgroundImage;
	
	public GridLayout1(int width, int height) {
		
		this.width = width;
		this.height = height;
		
		this.component1 = new FCHMGauge(this.width / 4, this.width / 2 - 128, this.height / 2 - 128, CANCorder.FRONT_TIRE_TEMPERATURE);
		//this.component2 = new FCHMGauge(this.width / 4, this.width / 4, 0, CANCorder.FRONT_TIRE_TEMPERATURE);
		//this.component2 = new Lock(this.width - 64, 64);
		//this.component3 = new FCHMGauge(this.width / 4, this.width / 2, this.height / 4, CANCorder.FRONT_TIRE_TEMPERATURE);
	
		try {
			this.backgroundImage = ImageIO.read(GridLayout1.class.getResource("/background.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void clear(Graphics graphics) {
		graphics.drawImage(this.backgroundImage, 0, 0, null);
	}

	@Override
	public void update() {
		
		this.component1.update();
		//this.component2.update();
		//this.component3.update();
	}

	@Override
	public void render(Graphics graphics) {
		this.component1.render(graphics);
		//this.component2.render(graphics);
		//this.component3.render(graphics);
	}

}
