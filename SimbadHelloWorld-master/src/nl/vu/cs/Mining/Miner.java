package nl.vu.cs.Mining;

import javax.vecmath.Vector3d;

import java.util.Iterator;
import java.util.Map;

import javax.vecmath.Point3d;
import javax.vecmath.Tuple3d;

// The Miner robot observes the Explorer robot, so that it can mine minerals.
public class Miner extends Robot implements Observer {
	Subject subject;

	public Miner(Vector3d position, String name, Subject subject) {
		super(position, name);
		this.subject = subject;
	}

	// The robot will go to the position where a mineral was found.
//	    private void goToMineThisMineral(Point3d mineralPosition) {
//	        for (int i = 0; i < this.visitedPosition.size(); i++) {
//	            if (this.visitedPosition.containsKey(mineralPosition)) {
//	                this.setTranslationalVelocity(0);
//	                System.out.println("I have reached my goal");
//	            }
//	        }
//	    }

	public void performBehavior() {
		boolean mining = false;
		if (Explorer.pending == 1) {
			Point3d position = new Point3d(0, 0, 0);
			Iterator it = Explorer.assignedPosition.entrySet().iterator();
			System.out.println("Going ...");
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				if (pair.getKey() == "Pending") {
					position = (Point3d) pair.getValue();
					System.out.println("The positions is: " + position);
					break;
				}
			}

			Vector3d vectPos = new Vector3d((double) position.x, (double) position.z, (double) position.y);
			this.moveToPosition(vectPos);

			Explorer.pending = 0;
			mining = true;
		}
		if ((mining == true) || (this.getCounter() % 100 == 0)) {
			this.setRotationalVelocity(0);
			this.setTranslationalVelocity(0);
			System.out.println("Mining...");
		} else {
			this.move();
		}
		mining = false;

	}

	public void update(Point3d position) {
		if (this.subject.getState() == 0) {
			System.out.println("Task has been received by the Miner robot.\n");

		}
	}
}