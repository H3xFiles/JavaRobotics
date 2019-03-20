
/*
 * The class camera provide the logic for the use of the cameras on installed on top of the robots.
 */

package nl.vu.cs.Mining;

import java.awt.image.BufferedImage;
import java.util.Vector;

public class AnalyzePictures {

	
	/*
	 * The function take an int as paramenter and return a vector of colors.
	 */
	public Vector color(int rgba) {

		Vector color = new Vector();
		
		/*
		 * The 24,16,8 are the channels and the 0xff is the color mask. 
		 */
		int alpha = (rgba >> 24) & 0xff;
		int red = (rgba >> 16) & 0xff;
		int green = (rgba >> 8) & 0xff;
		int blue = rgba & 0xff;
		
		color.add(red);
		color.add(green);
		color.add(blue);

		return color;
	}

	/*
	 * The function extract the rgba from the buffimage and return true if find the color blue
	 * in case it does not find it, it return false
	 */
	public Boolean searchForMinerals(BufferedImage buffImage) {
		int height = buffImage.getHeight(), width = buffImage.getWidth();
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int rgba = buffImage.getRGB(x, y);
				Vector color = color(rgba);
				int blue = (int) color.get(3);
				if (blue > 0) {
					color.clear();
					return true;
				}
				color.clear();
			}
		}
		return false;
	}

}
