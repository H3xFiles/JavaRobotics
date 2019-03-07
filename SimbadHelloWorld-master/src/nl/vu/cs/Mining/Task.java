package nl.vu.cs.Mining;

public class Task implements TaskHandler{

	private Coordinates coords;

	public Coordinates setTask() {
		return this.coords;
	}

	@Override
	public void setSuccessor(TaskHandler successor) {
		this.setSuccessor(successor);
	}
	
}
