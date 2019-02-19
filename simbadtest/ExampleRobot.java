package nl.vu.cs.s2.simbadtest;

import javax.vecmath.*;
import java.util.*;
import simbad.sim.*;

public class ExampleRobot extends Agent {

	private String currentMode;
	private Map<Integer, Tuple3d> visitedPosition = new HashMap<Integer, Tuple3d>();
	private Map<Integer, Tuple3d> basePosition = new HashMap<Integer, Tuple3d>();
	private Map<Integer, Tuple3d> mineralPosition = new HashMap<Integer, Tuple3d>();
	RangeSensorBelt sonar;
	RangeSensorBelt bumper;

	// the robot's turning speed
	int rvelocity = 1;
	// the robot's speed is always in m/s
	int speed = 1;

	public void getBasePosition() {
		Point3d baseLoc = returnCurrentPosition();
		int hashCurrentLoc = baseLoc.hashCode();
		visitedPosition.put(hashCurrentLoc, baseLoc);
	}

	public ExampleRobot(Vector3d position, String name) {
		super(position, name);

		// Add bumpers
		bumper = RobotFactory.addBumperBeltSensor(this, 12);
		// Add sonars
		sonar = RobotFactory.addSonarBeltSensor(this, 1);
	}

	/** This method is called by the simulator engine on reset. */
	public void initBehavior() {

	}

	public Point3d returnCurrentPosition() {
		Point3d loc = new Point3d();
		this.getCoords(loc);
		return loc;
	}

	/**
	 * This method is call cyclically (20 times per second) by the simulator engine.
	 */
	public void performBehavior() {
		/*
		 * Here, I take the current position and I hash it and add to a map
		 */
		Point3d currentLoc = returnCurrentPosition();
		int hashCurrentLoc = currentLoc.hashCode();

		/*
		 * Here, I get measurement from the sonar number 0(front)
		 */
		double range = sonar.getMeasurement(0);

		/*
		 * Here, I check if the current location has been already visited, if yes change
		 * direction
		 */
		if (visitedPosition.containsValue(currentLoc)) {
			System.out.println(currentLoc + "has been already visited - changing direction");
			this.setTranslationalVelocity(-speed);
			this.setRotationalVelocity(rvelocity);
		}

		/*
		 * Here, I detect collision every 20 virtual-sec and in case of collision or
		 * wall detection perform a turn
		 */ if (this.getCounter() % 20 == 0) {

			if (this.collisionDetected() || range < 1) {
				this.currentMode = "collision";
			} else {
				this.currentMode = "cruising";
			}

			if (this.currentMode == "cruising") {
				this.setRotationalVelocity(0);
				this.setTranslationalVelocity(speed);

			} else {
				this.setTranslationalVelocity(0);
				this.setRotationalVelocity(rvelocity);

			}
			visitedPosition.put(hashCurrentLoc, currentLoc);
		}

	}
}