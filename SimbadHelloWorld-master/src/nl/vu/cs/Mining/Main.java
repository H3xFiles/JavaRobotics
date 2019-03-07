package nl.vu.cs.Mining;

import simbad.gui.*;
import simbad.sim.*;

public class Main {
	public static void main(String[] args) {
	        System.setProperty("j3d.implicitAntialiasing", "true");
	        MissionConfiguration mission = new MissionConfiguration();
	        EnvironmentDescription environment = mission.configure();
	 
	        Simbad frame = new Simbad(environment, false);
	        frame.update(frame.getGraphics());
	    }
}
