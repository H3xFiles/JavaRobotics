package nl.vu.cs.Mining;

import javax.vecmath.Point3d;

public class Task implements TaskHandler{

	private Coordinates coords;

	public Coordinates setTask(Point3d coords) {
		return this.coords;
	}

	@Override
	public void setSuccessor(TaskHandler successor) {
		this.setSuccessor(successor);
	}


}
