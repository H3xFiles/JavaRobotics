package nl.vu.cs.Mining;

import javax.vecmath.*;
import java.util.*;
import simbad.sim.*;

public class Robot extends Agent {
	static final int MIN_COLL_DISTANCE = 1;
	static final int MAX_TRAV_DIST = 10000;
	static final int REFRESH_RATE = 10;
	private String currentMode;
	private Map<Tuple3d, String> visitedPosition = new HashMap<Tuple3d, String>();
	private Map<Tuple3d, String> availableDirections = new HashMap<Tuple3d,String>();
	RangeSensorBelt sonar;
	RangeSensorBelt bumper;

	// the robot's turning speed
	int rvelocity = 1;
	// the robot's speed is always in m/s
	int speed = 1;

	public Point3d getInitialRobotPosition() {
		Point3d initialPos = returnCurrentPosition();
		visitedPosition.put(initialPos, "Visited");
		return initialPos;
	}

	private Point3d returnCurrentPosition() {
		Point3d loc = new Point3d();
		this.getCoords(loc);
		return loc;
	}
	
	public Vector3d setCoords(int x, int z) {
		return new Vector3d(z, 0, x);
	}

	public Robot(Vector3d position, String name, int bumpers, int sonars, int cameras) {
		super(position, name);
		// Add bumpers
		bumper = RobotFactory.addBumperBeltSensor(this, bumpers);
		// Add sonars
		sonar = RobotFactory.addSonarBeltSensor(this, sonars);
	}

	// this function try to avoid that the robot does not walk the same path.
	// this function is used only when there is a collision detected
	private void look_for_new_paths(Point3d currentLoc) {
		if (visitedPosition.containsKey(currentLoc)) {
			this.setTranslationalVelocity(0);
			this.setRotationalVelocity(rvelocity);
		}
	}

	// this is the standard mod for the robot, basically it goes straight
	private void mod_cruising() {
		this.setRotationalVelocity(0);
		this.setTranslationalVelocity(speed);
	}

	// this is the avoiding collision mod, it performs a turn on the y-axe until it
	// does not find an
	private void mod_avoiding_collision() {
		this.setTranslationalVelocity(0);
		this.setRotationalVelocity(rvelocity);
		Point3d currentLoc = returnCurrentPosition();
		look_for_new_paths(currentLoc);
	}

	// This method is call cyclically every REFRESH_RATE-times per second by the simulator engine.
	public void performBehavior() {
		if (this.getCounter() % REFRESH_RATE == 0) {

			// Here, I take the current position
			Point3d currentLoc = returnCurrentPosition();

			// Here, I get measurement from the sonar number 0(front)
			double range = sonar.getMeasurement(0);


			// Here, I check if there is any collision and if the sonar detected something
			// within a range
			if (this.collisionDetected() || range <= MIN_COLL_DISTANCE) {
				this.currentMode = "collision";
			} else {
				this.currentMode = "cruising";
			}

			if (this.currentMode == "cruising") {
				mod_cruising();

			} else {
				mod_avoiding_collision();
			}

			// every 10000 in-game sec the visited position map get cleared.
			// a good range is between 5000 and 10000.
			visitedPosition.put(currentLoc, "Visited");
			if (this.getCounter() % MAX_TRAV_DIST == 0) {
				visitedPosition.clear();
			}
		}

	}
}