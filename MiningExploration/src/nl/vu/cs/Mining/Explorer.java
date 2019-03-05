package nl.vu.cs.Mining;

//import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;
import javax.vecmath.Point3d;
import java.awt.image.BufferedImage;
//import java.util.*;

import simbad.sim.*;

public class Explorer extends Robot {
	private static Explorer exploringRobot = new Explorer(new Vector3d(0, 0, 0), "Explorer Robot");
	
//	CameraSensor camera;
//	BufferedImage cameraImage;
	
	private Explorer(Vector3d position, String name) {
		super(position, name);
//		camera = RobotFactory.addCameraSensor(this);
//		cameraImage = camera.createCompatibleImage();
	}
	
//	private Explorer(Subject subject) {
//		
//	}
	
	public static Explorer getInstance() {
		return exploringRobot;
	}
	
	private void addTask(Point3d task, TaskStatus status) {
		MissionConfiguration mission = MissionConfiguration.getInstance();
		if (status == TaskStatus.NewTask);
			mission.tasks.add(task);
	}
	
	private void assignTask() {
		MissionConfiguration mission = MissionConfiguration.getInstance();
		if (mission.tasks.size() > 0 && mission.getTask() == null) {
			mission.setNextTask(mission.tasks.get(0));
			System.out.println("A task has been assigned.\n");
		}
		// Assign the task to a Miner Robot.
	}
	
	private void detectObject() {
		if (this.collisionDetected()) {
			this.addTask(this.getPosition(), TaskStatus.NewTask);
			System.out.println("A picture has been taken.\n");
//			System.out.println(this.getPosition());
		}
//		camera.copyVisionImage(cameraImage);
//		Point3d position = this.getPosition();
//		addTask(position);
//		camera.copyVisionImage(cameraImage);
	}
	
	public void performBehavior() {
        this.move();
//        if (this.getCounter() % 300 == 0) {
        this.detectObject();
        this.assignTask();
//        }
	}
}
