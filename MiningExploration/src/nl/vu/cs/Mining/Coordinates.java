package nl.vu.cs.Mining;

import javax.vecmath.Vector3d;

public class Coordinates {
	public static Vector3d setCoords(final int x, final int z) {
        return new Vector3d((double)z, 0.0, (double)x);
    }
    
    public static Vector3d getRandCoord() {
        final Utility x_coord = new Utility();
        final Utility y_coord = new Utility();
        Vector3d coords = setCoords(x_coord.mathRand(-10, 10), y_coord.mathRand(-10, 10));
        coords = checkIfCoordsAreGood(coords);
        System.out.println(coords);
        return coords;
    }
    
    private static Vector3d checkIfCoordsAreGood(Vector3d coords) {
        while ((coords.x > -5.0 && coords.x < 5.0 && coords.z > -5.0 && coords.z < 5.0) || Environment.mountainPosition.containsValue(coords) || Environment.mineralPosition.containsValue(coords)) {
            coords = getRandCoord();
        }
        return coords;
    }

}
