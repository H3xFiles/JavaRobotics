package nl.vu.cs.Mining;

	import javax.vecmath.Vector3d;
	import javax.vecmath.Point3d;

	public class Miner extends Robot {
		public Miner(Vector3d position, String name) {
			super(position, name);
		}
		
//		public Miner(Subject subject) {
//			this.subject = subject;
//			subject.attach(this);
//		}
//		
//		public void update() {
//			if (this.subject.getState == 0) {
//				
//			}
//		}
		
		private void mineMineral(Point3d position) {
			// Currently, the Miner is able to get the position of the mineral.
			// However, the Miner is not able to get to that specific location.
			// Idea: We need to implement the Adapter Design Pattern with respect to the coordinate system.
			// Once we have done that, we can make him move in a direction, such that its movement resembles a straight line.
			// Hereafter, we can know in which direction the Miner should turn to make sure that it is facing the position
			// of the mineral. Then, we can try to let the Miner get to that position.
			
			// Another approach would be to let the Miner follow the Explorer. This means that the Miner traverses the exact
			// same path as the Explorer. Whenever the Explorer detects an object (assuming it is a mineral), the Explorer
			// will be able to mine the mineral. For this approach to work, the Miner should start moving few seconds later
			// than the Explorer. Since we know the "delay" of the Miner, we can use this to wait for the Miner to get to the
			// position that the Explorer already visited (and where it detected an object) according to the delay time.
			Point3d myPosition = this.getPosition();
			this.setRotationalVelocity(Math.PI / 2);
			this.setTranslationalVelocity(2);
			
			double horizontal = position.distance(myPosition);
			double manhattan = position.distanceL1(myPosition);
			System.out.println(horizontal);
			System.out.println(manhattan);
			
			this.setTranslationalVelocity(5);
//			System.out.println(this.getPosition());
			// Notifying about the mining.
		}

		public void performBehavior() {
	        MissionConfiguration mission = MissionConfiguration.getInstance();
	        Point3d task = mission.getTask();
	        if (task != null)
	        	this.mineMineral(task);
	        else
	        	this.move();
		}
	}