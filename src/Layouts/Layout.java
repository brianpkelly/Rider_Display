/*
 * RW3 Rider Interface Display
 * Author: Brian Kelly
 * Description: This interface defines the role of Layout classes. The Layout classes control where the components are rendered to the screen.
 *      This is an interface in case we want to change how the layout actually works. For example, we could use an XML-based layout or a grid-based layout.
 *      Each would require a different implementation. This interface just reduces the work if we switch implementations. 
 * 
 */

package Layouts;

public interface Layout {
	
	public void clear();
	
	public int[] pixels();
	
	public void update();
	
	public void render();
}
