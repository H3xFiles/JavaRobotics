package nl.vu.cs.Mining;

import simbad.gui.*;
import simbad.sim.*;
 
//import javax.vecmath.Point3d;
//import javax.vecmath.Vector3d;

public class Main {
	public static void main(String[] args) {
	        
	        System.setProperty("j3d.implicitAntialiasing", "true");
	        MissionConfiguration mission = new MissionConfiguration();
	        EnvironmentDescription environment = mission.configure();
	        
//	        Robot robot1 = new Robot(new Vector3d(0, 0, 0), "Robot 1",8,1,1);
	 
	        Simbad frame = new Simbad(environment, false);
	        frame.update(frame.getGraphics());
	    }
}
