/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class opens and manages sprite sheet objects.
 * 
 */

package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private String path;
	public final int SIZE;
	public int[] pixels;
	
	public SpriteSheet(String path, int size) {
		
		this.path = path;
		this.SIZE = size;
		this.pixels = new int[33024 * 256];
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
