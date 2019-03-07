package nl.vu.cs.Mining;

import javax.vecmath.Point3d;

public interface Observer {
	
	public abstract void update(Point3d position);
}
