package nl.vu.cs.Mining;


import simbad.gui.*;
import simbad.sim.*;

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

/**
  Derivate your own code from this example.
 */


public class Main {

    public static void main(String[] args) {
    	
        System.setProperty("j3d.implicitAntialiasing", "true");
        EnvironmentDescription environment = new Environment();

        
        Robot robot1 = new Robot(new Vector3d(0, 0, 0), "Robot 1",8,1,1);
        Robot robot2 = new Robot(new Vector3d(1, 0, 0), "Robot 2",8,1,1);

        environment.add(robot1);
        environment.add(robot2);

        Simbad frame = new Simbad(environment, false);
        frame.update(frame.getGraphics());
    }

} 

