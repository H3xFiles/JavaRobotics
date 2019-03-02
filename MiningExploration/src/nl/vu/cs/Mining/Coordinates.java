package nl.vu.cs.Mining;
import java.util.HashMap;
import java.util.Map;
import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;
import javax.vecmath.*;
import java.util.*;
import simbad.sim.*;

public class Coordinates {
	/*
	 * Set a pair of coordinates
	 */
	public static Vector3d setCoords(int x, int z) {
		return new Vector3d(z, 0, x);
	}
	
	/*
	 * In this function the x, y coords are generated randomly at each loop cycle
	 * coords function take 2 parameters: (-(FIELD_SIZE/2))+EXT_WALL_SIZE for the
	 * lower and left side of the axes in respect of x,y
	 * (FIELD_SIZE/2)-EXT_WALL_SIZE for the upper and right side of the axes in
	 * respect of x,y
	 */	
	public static Vector3d getRandCoord() {
		System.out.println("here crush 5");
		MathRand x_coord = new MathRand();
		MathRand y_coord = new MathRand();
		System.out.println("here crush 6");
		Vector3d coords = setCoords(
				x_coord.MathRand(((-(Environment.FIELD_SIZE / 2)) + Environment.EXT_WALL_SIZE), (Environment.FIELD_SIZE / 2) - Environment.EXT_WALL_SIZE),
				y_coord.MathRand(((-(Environment.FIELD_SIZE / 2)) + Environment.EXT_WALL_SIZE), (Environment.FIELD_SIZE / 2) - Environment.EXT_WALL_SIZE));
		System.out.println("here crush 7");
		coords = checkIfCoordsAreGood(coords);
		System.out.println("here crush 8");
		System.out.println(coords);
		return coords;
	}
	
	/*
	 * In this function I check if the coordinate are not already occupied by some other object.
	 * Currently it is not accurate, but it has improved the distribution of the objects.
	 */
	private static Vector3d checkIfCoordsAreGood(Vector3d coords) {
		while (((coords.x > -5 && coords.x < 5) && (coords.z > -5 && coords.z < 5))
				|| (Environment.mountainPosition.containsValue(coords) || Environment.mineralPosition.containsValue(coords)))
 {
			coords = getRandCoord();
			System.out.println("here crush 11");

		} 
		
		System.out.println("here crush 12 " + coords);


		return coords;
	}
}
