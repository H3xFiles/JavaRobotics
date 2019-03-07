package nl.vu.cs.Mining;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.awt.image.ColorModel;
import java.awt.image.DataBufferByte;

import javax.vecmath.Vector3d;

import simbad.sim.CameraSensor;
import simbad.sim.RobotFactory;

import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Tuple3d;

// The Explorer robot searches for minerals (exploring) and it keeps track of the mission.
public class Explorer extends Robot implements Subject, TaskHandler{
	private static Robot exploringRobot = new Explorer(); // Attribute needed for the Singleton Design Pattern.
	private MissionConfiguration mission = new MissionConfiguration(); // Instance to keep track of the mission.
	// These are the attributes that are needed for the Observer Design Pattern:
	private List<Observer> observers = new ArrayList<Observer>();
	public int debug = 0;
	public static Map<Integer, Tuple3d> mineralFoundPosition = new HashMap<Integer, Tuple3d>();
	public static Map<String, Tuple3d> assignedPosition = new HashMap<String, Tuple3d>();
	private int state = 0;
	public static int pending = 0;
	private static TaskHandler successor;

	public CameraSensor camera1;
	public BufferedImage bfImage1;
//	AnalyzePictures anp = new AnalyzePictures();

	private Explorer() {
		super(new Vector3d(0, 0, 0), "Explorer Robot");
		this.setColor(new Color3f(64, 128, 128));
		if (debug == 1) {
			this.camera1 = RobotFactory.addCameraSensor(this);
		}
	}

	public static Robot getInstance() {
		return exploringRobot;
	}

	// These are the functions that are needed for the Observer Design Pattern:
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) {
		observers.add(observer);
	}

	public void notifyAllObservers() {
		for (Observer observer : observers) {
			System.out.println("Mineral found.\n");
			observer.update(this.getPosition());
		}
	}

	// Evaluate whether the mission is completed. If so, then display a
	// notification.
	private void evaluateMission() {
		if (this.mission.collectedMinerals >= this.mission.objective)
			System.out.println("Mission has been completed.");
	}

	// This function detects after a certain amount of time whether there is a
	// mineral.
	private void searchMinerals() {
		if (debug == 1) {
			if (this.getCounter() % 300 == 0) {
				System.out.println("A picture has been taken.\n");
				byte[] pixels = ((DataBufferByte) bfImage1.getRaster().getDataBuffer()).getData();
			}
		}
		if (this.collisionDetected()) {
			System.out.println("Mineral Found");
			this.setState(0); // State 0 implies that a mineral has been found.]
			System.out.println("Get the position ...");
			Point3d position = getPosition();
			System.out.println("Hash the position ...");
			int hashpos = position.hashCode();
			System.out.println("Add to the map ...");
			mineralFoundPosition.put(hashpos, position);
			System.out.println("Checking for a free miner ...");
			checkStatus(position);
		} else {
			this.setState(1); // State 1 implies that there is no minerals to be mined yet.
		}
	}
	
	public static void setUpChain() {
		Task task = new Task();
		task.setSuccessor(successor);
	}

	private void checkResponsabilities(Map mp, Point3d position) {
			assignedPosition.clear();
			Iterator it = mp.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				if ((boolean) pair.getValue() == false) {
					System.out.println("Found " + pair.getKey());
					System.out.println("sending the position ...");
					assignedPosition.put("Pending", position);
					this.mission.collectedMinerals+=1;
					pending = 1;
					break;
				}
			}
	}
	
	private void checkStatus(Point3d position) {
		if (state == 0) {
			checkResponsabilities(MissionConfiguration.minersList, position);
		}
	}

	public void performBehavior() {
		getInstance().move();
		this.evaluateMission();
		if (debug == 1) {
			this.camera1.copyVisionImage(this.bfImage1);
		}
		if (this.getCounter() % 10 == 0) {
			searchMinerals();
		}
	}

	@Override
	public void setSuccessor(TaskHandler successor) {
		// TODO Auto-generated method stub
		
	}
}
