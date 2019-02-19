package nl.vu.cs.s2.simbadtest;


import javax.vecmath.*;
import java.util.*;
import simbad.sim.*;


public class ExampleRobot extends Agent {

	private String currentMode;
	private Map<Integer,Tuple3d> visitedPosition  = new HashMap<Integer,Tuple3d>();
	private Map<Integer,Tuple3d> basePosition  = new HashMap<Integer,Tuple3d>();
	private Map<Integer,Tuple3d> mineralPosition  = new HashMap<Integer,Tuple3d>();
	RangeSensorBelt sonar;
	RangeSensorBelt bumper;
	int rvelocity = 1;
	int speed = 1;
	
	public void getBasePosition(){
		Point3d baseLoc = returnCurrentPosition();
		int hashCurrentLoc = baseLoc.hashCode();
	    visitedPosition.put(hashCurrentLoc,baseLoc);
	    System.out.println("BaseLoc: "+ baseLoc);
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
    
    public Point3d returnCurrentPosition(){
        Point3d loc = new Point3d();
        this.getCoords(loc);
        return loc;
    }

    /** This method is call cyclically (20 times per second) by the simulator engine. */
    public void performBehavior() {
        Point3d currentLoc = returnCurrentPosition();
        int hashCurrentLoc = currentLoc.hashCode();
        double range = sonar.getMeasurement(0);
        Point3d nextStep = returnCurrentPosition();
        if (visitedPosition.containsValue(currentLoc)) {
        	System.out.println(currentLoc + "has been already visited - changing direction");
        	this.setTranslationalVelocity(-speed);
        	this.setRotationalVelocity(rvelocity);
        } 
    	// perform the following actions every 20 virtual seconds
    	if(this.getCounter() % 20 == 0) {

	    	if(this.collisionDetected() || range < 5) {
	    	    System.out.println(range);
	    		this.currentMode = "collision";
	    	} else {
	    		this.currentMode = "cruising";
	    	}
	        
	    	if(this.currentMode == "cruising") {
//	    		System.out.println("cruising {");
	    		// the robot's speed is always 0.5 m/s
	    		this.setRotationalVelocity(0);
	            this.setTranslationalVelocity(0.5);
	            
//	            System.out.println("cruising }");
	        } else {
//	        	System.out.println("else {");
	        	// don't move
	        	this.setTranslationalVelocity(0);
	        	// rotate only until obstacle is not there
	        	this.setRotationalVelocity(0.5);
//	        	System.out.println("else }");
	        }
//	    	System.out.println(currentLoc + " - " + hashCurrentLoc);
	    	
	    	visitedPosition.put(hashCurrentLoc,currentLoc);
    	}
    	
    }
}