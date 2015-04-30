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
import Components.MDBarGauge;
import Components.MDHCGaugeLeft;
import Components.MDHCGaugeRight;
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
		int xoffset = 113;
		int yoffset = 65;
		this.component1 = new MDHCGaugeLeft(xoffset + 0, yoffset, CANCorder.FRONT_TIRE_TEMPERATURE);
		this.component2 = new MDBarGauge(xoffset + 260, yoffset, CANCorder.THROTTLE);
		this.component3 = new MDHCGaugeRight(xoffset + 260 + 240, yoffset, CANCorder.CELL_1_TEMPERATURE);
	
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
		this.component2.update();
		this.component3.update();
	}

	@Override
	public void render(Graphics graphics) {
		this.component1.render(graphics);
		this.component2.render(graphics);
		this.component3.render(graphics);
	}

}
