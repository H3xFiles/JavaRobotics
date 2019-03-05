package nl.vu.cs.Mining;

import java.util.ArrayList;

import javax.vecmath.Vector3d;
import javax.vecmath.Point3d;

import simbad.sim.EnvironmentDescription;

//import javax.vecmath.Vector3d;

//import java.util.Random;
//import java.Math;

enum MissionType {
	ExploringMission, CommercialMission
}

enum TaskStatus {
	NewTask,
	CompletedTask
}

public class MissionConfiguration {
	private static MissionConfiguration mission = new MissionConfiguration();
	private MissionType type;
	public int objective;
	public ArrayList<Point3d> tasks = new ArrayList<Point3d>();
	private Point3d currentTask = null;
	
	public MissionConfiguration() {
		this.type = getRandomMissionType();
		this.objective = getObjective(this.type);
	}
	
	public static MissionConfiguration getInstance() {
		return mission;
	}
	
	public MissionType getRandomMissionType() {
//		Random random = new Random();
		MissionType[] values = MissionType.values();
		return values[(int) Math.random() * values.length];
	}
	
	private int getObjective(MissionType type) {
		int objective;
		if (type == MissionType.ExploringMission)
			objective = 5;
		else
			objective = 1;
		return objective;
	}
	
	public void setNextTask(Point3d task) {
		currentTask = task;
	}
	
	public Point3d getTask() {
		return currentTask;
	}
	
	// I remember from the Advanced Programming course that you can have a function that takes
	// an unspecified amount of parameters of one type. We can use this maybe if we want to
	// add a different amount of robots during each mission.
	// Then, we create the robots in Main.java and we pass them as parameters to the configure
	// function. The function will look like: public void configure(Robot ... robot, Environment environment).
	public EnvironmentDescription configure() {
		EnvironmentDescription environment = new Environment();
        
		Robot miningRobot = Explorer.getInstance();
        Robot exploringRobot = new Miner(new Vector3d(1, 0, 0), "Explorer Robot");
 
        environment.add(miningRobot);
        environment.add(exploringRobot);
        return environment;
	}
}
