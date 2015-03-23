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
	private BufferedImage image;
	
	public SpriteSheet(String path, int height, int width, int number) {
		
		this.path = path;
		this.HEIGHT = height;
		this.WIDTH = width;
		this.NUMBER = number;
		this.load();
	}
	
	private void load() {
		
		try {
			this.image = ImageIO.read(SpriteSheet.class.getResource(path));
			int width = image.getWidth();
			int height = image.getHeight();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int index) {
		BufferedImage sprite = this.image.getSubimage(index * this.WIDTH, 0, this.WIDTH, this.HEIGHT);
		return sprite;
	}
}
