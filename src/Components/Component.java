/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This interface defines the GUI components (gauges, charts, etc).
 * 
 */

package Components;

import java.awt.Graphics;

public interface Component {
	
	public void update();
	
	public void render(Graphics graphics);

}
