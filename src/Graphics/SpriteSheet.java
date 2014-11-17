/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This class opens and manages sprite sheet objects.
 * 
 */

package Graphics;

import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.File;
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
		
		File spritesheet = null;
		
		try {
			spritesheet = new File(this.path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			BufferedImage image = ImageIO.read(spritesheet);
			int width = image.getWidth();
			int height = image.getHeight();
			image.getRGB(0, 0, width, height, this.pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
