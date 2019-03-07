package nl.vu.cs.Mining;

import java.util.Random;

import javax.vecmath.Vector3d;

public class Utility {
	public int mathRand(int min, int max) {
        final Random rand = new Random();
        final int magicNumber = rand.nextInt(max - min + 1) + min;
        return magicNumber;    
	}
	
	public Vector3d setCoords(final int x, final int z) {
		return new Vector3d((double)z, 0.0, (double)x);
	}
	    
	public Vector3d getRandCoord() {
		Vector3d coords = setCoords(new Utility().mathRand(-10, 10), new Utility().mathRand(-10, 10));
		coords = checkIfCoordsAreGood(coords);
		return coords;
	}
	    
	private Vector3d checkIfCoordsAreGood(Vector3d coords) {
		while ((coords.x > -5.0 && coords.x < 5.0 && coords.z > -5.0 && coords.z < 5.0) || 
				Environment.mountainPosition.containsValue(coords) || 
				Environment.mineralPosition.containsValue(coords)) {
			coords = getRandCoord();
		}
		return coords;
	}
}
