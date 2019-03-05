package nl.vu.cs.Mining;

public abstract class Observer {
	protected Subject subject;
	
	public abstract void update();
}
