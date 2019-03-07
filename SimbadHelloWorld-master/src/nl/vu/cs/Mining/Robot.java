package nl.vu.cs.Mining;
 
import javax.vecmath.*;

import java.util.*;
import simbad.sim.*;
 
public class Robot extends Agent {
    static final int MIN_COLL_DISTANCE = 1;
    static final int MAX_TRAV_DIST = 1000;
    static final int REFRESH_RATE = 10;
    static final int NUMBER_OF_BUMPERS = 1;
    
	private int hashname = name.hashCode();
	private int suffix = new Utility().mathRand(99, 311);
	public int id = hashname+suffix;
	public boolean busy = false;
	
 // the robot's turning speed
    int rvelocity = 1;
    // the robot's speed is always in m/s
    int speed = 1;
    public Map<Tuple3d, String> visitedPosition = new HashMap<Tuple3d, String>();
    RangeSensorBelt sonar;
    RangeSensorBelt bumper;
    
    public Robot(Vector3d position, String name) {
        super(position, name); // Call the super-constructor from the API.
        this.bumper = RobotFactory.addBumperBeltSensor(this, NUMBER_OF_BUMPERS); // API function.
        this.sonar = RobotFactory.addSonarBeltSensor(this); // API function.
    }
 
    public Point3d getPosition() {
        Point3d position = new Point3d();
        this.getCoords(position);
        return position;
    }
    
    public void setVisitedPosition() {
        Point3d location = getPosition();
    
        double x = (int)location.x;
        double y = (int)location.y;
        double z = (int)location.z;
    
        Point3d editedLoc = new Point3d(x, y, z);
        visitedPosition.put(editedLoc, "Visited");
    }
 
    // This method is call cyclically every REFRESH_RATE-times per second by the simulator engine.
    public void move() {
        // Here, I get measurement from the sonar number 0(front)
        double range = sonar.getMeasurement(0);
        Boolean collisionDetected = this.collisionDetected();

        // Here, I check if there is any collision and if the sonar detected something
        // within a range
        if (collisionDetected || range <= MIN_COLL_DISTANCE) {
        	this.setRotationalVelocity(Math.PI / 2);
        	this.setTranslationalVelocity(0);
        }
        else {
        	this.setRotationalVelocity(0);
            this.setTranslationalVelocity(speed);
        }
        setVisitedPosition();
        // every 10000 in-game sec the visited position map get cleared.
        // a good range is between 5000 and 10000.
        if (this.getCounter() % MAX_TRAV_DIST == 0)
            visitedPosition.clear();
    }
}