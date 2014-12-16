/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class opens and manages sprite sheet objects.
 * 
 */

package Graphics;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int HEIGHT;
	public final int WIDTH;
	public final int NUMBER;
	public int[] pixels;
	
	public SpriteSheet(String path, int height, int width, int number) {
		
		this.path = path;
		this.HEIGHT = height;
		this.WIDTH = width;
		this.NUMBER = number;
		this.pixels = new int[this.HEIGHT * this.WIDTH * this.NUMBER];
		this.load();
	}
	
	private void load() {
		
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, this.pixels, 0, width);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
