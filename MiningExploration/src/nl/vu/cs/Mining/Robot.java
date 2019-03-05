package nl.vu.cs.Mining;
 
import javax.vecmath.*;

import java.awt.image.BufferedImage;
import java.util.*;
import simbad.sim.*;
 
public class Robot extends Agent {
    static final int MIN_COLL_DISTANCE = 1;
    static final int MAX_TRAV_DIST = 10000;
    static final int REFRESH_RATE = 10;
    static final int NUMBER_OF_BUMPERS = 8;
    static final int NUMBER_OF_SONARS = 1;


//    private String currentMode;
    private Map<Tuple3d, String> visitedPosition = new HashMap<Tuple3d, String>();
//    private Map<Tuple3d, String> availableDirections = new HashMap<Tuple3d,String>();
    RangeSensorBelt sonar;
    RangeSensorBelt bumper;
 
    // the robot's turning speed
    int rvelocity = 1;
    // the robot's speed is always in m/s
    int speed = 1;
    
    public Robot(Vector3d position, String name) {
        super(position, name);
        // Add bumpers
        this.bumper = RobotFactory.addBumperBeltSensor(this, NUMBER_OF_BUMPERS);
        // Add sonars
        this.sonar = RobotFactory.addSonarBeltSensor(this,NUMBER_OF_SONARS);
    }
 
    public Point3d getPosition() {
        Point3d position = new Point3d();
        this.getCoords(position);
        return position;
    }
 
    // This method is call cyclically every REFRESH_RATE-times per second by the simulator engine.
    public void move() {
    	Point3d position = getPosition();
    	 
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

        // every 10000 in-game sec the visited position map get cleared.
        // a good range is between 5000 and 10000.
        visitedPosition.put(position, "Visited");
        if (this.getCounter() % MAX_TRAV_DIST == 0)
            visitedPosition.clear();
    }
 
    // I do not know why we would a function returning the initial position, because the function never gets used.
}