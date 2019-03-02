package nl.vu.cs.Mining;

import java.awt.Color;

import javax.vecmath.*;
import java.util.*;
import simbad.sim.*;

public class Environment extends EnvironmentDescription {
	static final int FIELD_SIZE = 25;
	static final int EXT_WALL_SIZE = 2;
	public static Map<Integer, Tuple3d> mineralPosition = new HashMap<Integer, Tuple3d>();
	public static Map<Integer, Tuple3d> mountainPosition = new HashMap<Integer, Tuple3d>();

	public Environment() {
		this.setWorldSize(FIELD_SIZE);
		buildScene();
		buildBorderWalls();
		MathRand chaos = new MathRand();
		addMinerals(chaos.MathRand(10, 15));
		addNaturalObstacles(chaos.MathRand(15, 30));
	}


	private void buildScene() {
		// turn on the lights
		this.light1IsOn = true;
		this.light2IsOn = true;

		// getHSBColor take following parameters int hue, saturation, int brightness
		this.ambientLightColor = new Color3f(Color.getHSBColor(0, 200, 100));
		this.floorColor = new Color3f(Color.getHSBColor(0, 360, 100));

		// enable the physics engine in order to have better physics effects on the
		// objects
		this.setUsePhysics(true);

		// show the axes so that we know where things are
		this.showAxis(false);
	}

	/*
	 * This functions build the border of the map. the constructor Wall() take these
	 * parameters: vector3d position, float length, float height, Environmental
	 * description
	 */
	private void buildBorderWalls() {
		Wall w1 = new Wall(Coordinates.setCoords(0, (FIELD_SIZE / 2)), FIELD_SIZE, EXT_WALL_SIZE, this);
		w1.setColor(new Color3f(Color.DARK_GRAY));
		w1.rotate90(1);
		add(w1);

		Wall w2 = new Wall(Coordinates.setCoords(0, -(FIELD_SIZE / 2)), FIELD_SIZE, EXT_WALL_SIZE, this);
		w2.setColor(new Color3f(Color.DARK_GRAY));
		w2.rotate90(1);
		add(w2);

		Wall w3 = new Wall(Coordinates.setCoords((FIELD_SIZE / 2), 0), FIELD_SIZE, EXT_WALL_SIZE, this);
		w3.setColor(new Color3f(Color.DARK_GRAY));
		add(w3);

		Wall w4 = new Wall(Coordinates.setCoords(-(FIELD_SIZE / 2), 0), FIELD_SIZE, EXT_WALL_SIZE, this);
		w4.setColor(new Color3f(Color.DARK_GRAY));
		add(w4);
	}

	/*
	 * In this function the x, y coords are generated randomly at each loop cycle
	 * coords function take 2 parameters: (-(FIELD_SIZE/2))+EXT_WALL_SIZE for the
	 * lower and left side of the axes in respect of x,y
	 * (FIELD_SIZE/2)-EXT_WALL_SIZE for the upper and right side of the axes in
	 * respect of x,y
	 */


	/*
	 * In these two functions addMinerals and addNaturalObstacles use the function
	 * getRandCoord to get a random coordinate in the map and add a box
	 */
	private void addMinerals(int totNumBox) {
		for (int currNumBox = 0; currNumBox < totNumBox; currNumBox++) {
			Vector3d coords = Coordinates.getRandCoord();
			//here the size of the box is set to 1,1,1
			Box minerals = new Box(coords, new Vector3f(1, 1, 1), this);
			minerals.setColor(new Color3f(Color.getHSBColor(0.55f, 1f, 0.4f)));
			add(minerals);
			int hashCurrentLoc = coords.hashCode();
			mineralPosition.put(hashCurrentLoc, coords);
		}
	}


	private void addNaturalObstacles(int totNumBox) {		
		for (int currNumBox = 0; currNumBox < totNumBox; currNumBox++) {
			MathRand shape = new MathRand();
			Vector3d coords = Coordinates.getRandCoord();
			//here the size of the box is random
			Box mountains = new Box(coords, new Vector3f(shape.MathRand(1, 3), 1, shape.MathRand(2, 4)), this);
			mountains.setColor(new Color3f(Color.getHSBColor(0.0f, 0.5f, 0.4f)));
			add(mountains);
			int hashCurrentLoc = coords.hashCode();
			mountainPosition.put(hashCurrentLoc, coords);
		}
	}
}
