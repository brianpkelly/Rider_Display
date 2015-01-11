/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This is the over-arching class and executable. Most of the code is administrative.
 * 
 */

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import Data.CANCorder;
import Layouts.GridLayout1;

public class Display extends Canvas implements Runnable {
	
	// Keep the compiler happy
	static final long serialVersionUID = 42L;
	
	public static int width = 1024;
	public static int height = 600;
	public static int scale = 1;
	
	// Controls when the Display runs
	private boolean isRunning = false;
	
	// The Display runs it its own thread. 
	// Currently does nothing special, but might be useful later on for handling the controls.
	private Thread thread;
	
	// The Display renders to a Canvas, which is contained in a JFrame. A JFrame is a window in whichever OS this application is running in.
	private JFrame window;
	
	// Some details in how things get rendered.
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	
	private GridLayout1 layout;
	private CANCorder cancorder;
	
	// Constants for connecting to the database
	
	public Display() {
		
		// Sets the size of the Canvas that the Display renders to.
		this.setPreferredSize(new Dimension(width * scale, height * scale));
		this.layout = new GridLayout1(width, height);
		this.window = new JFrame();
	}
	
	// Starts the Display thread.
	public synchronized void start() {
		
		this.isRunning = true;
		this.thread = new Thread(this);
		this.thread.start();
	}
	
	// Stops the Display thread.
	public synchronized void stop() {
		
		this.isRunning = false;
		
		try {
			this.thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	// Runs the Display thread.
	@Override
	public void run() {
		
		// Variable to control the refresh rate for rendering. Might be unnecessary.
		long timeStart = System.nanoTime();
		double timeInterval = 0;
		
		while (this.isRunning) {
			
			long timeNow = System.nanoTime();
			timeInterval += (timeNow - timeStart) / (1000000000.0 / 60.0);
			timeStart = timeNow;
			
			while (timeInterval >= 1) {
				
				this.update();
				timeInterval--;
			}
			
			this.render();
		}
		
		this.stop();	
	}
	
	// Updates the state of the Display. 
	// This ultimately retrieves the current measurements of the variables that are being displayed from the CANCorder database.
	private void update() {
		
		this.layout.update();
	}
	
	// Ultimately draws the components to the screen.
	// The BufferStrategy allows multiple images to drawn before they are actually rendered to the screen, which is probably unnecessary for our purposes, but good practice anyway. 
	private void render() {
		
		BufferStrategy buffStrat = getBufferStrategy();
		
		if (buffStrat == null) {
			
			createBufferStrategy(3);
			return;
		}
		
		// Get the new set of pixels to be rendered
		this.layout.clear();
		this.layout.render();
		int[] layoutPixels = this.layout.pixels();
		
		for (int i = 0; i < this.pixels.length; i++) {
			
			this.pixels[i] = layoutPixels[i];
		}
		
		// More rendering details. Turns the pixel array to an image and actually draws it.
		Graphics graphics = buffStrat.getDrawGraphics();
		graphics.drawImage(this.image, 0, 0, getWidth(), getHeight(), null);
		graphics.dispose();
		buffStrat.show();
	}

	public static void main(String[] args) {
		
		Display display = new Display();
		
		// Set a variety of JFrame properties for the Display
		display.window.setResizable(false);
		display.window.setTitle("Rider Display");
		display.window.add(display);
		display.window.pack();
		display.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.window.setLocationRelativeTo(null);
		display.window.setVisible(true);
		
		// Connect to CANcorder database
		display.cancorder = new CANCorder();
		
		// Start the display
		display.start();
		
		// Disconnect from CANcorder database
		display.cancorder.close();
	}	
}