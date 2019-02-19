package nl.vu.cs.s2.simbadtest;

import java.awt.Color;

import javax.vecmath.*;
import java.util.*;
import javax.media.j3d.*;
import simbad.sim.*;

public class Environment extends EnvironmentDescription {
	static final int FIELD_SIZE = 25;
	static final int EXT_WALL_SIZE = 2;

	public Environment() {
		this.setWorldSize(FIELD_SIZE);
		buildScene();
		buildBorderWalls();
		MathRand chaos = new MathRand();
		addMinerals(chaos.MathRand(5, 8));
		addNaturalObstacles(chaos.MathRand(10, 15));
	}

	public Vector3d setCoords(int x, int y) {
		return new Vector3d(-y, 0, -x);
	}
	
	public Point3d getCoords(Vector3d object) {
		Point3d loc = new Point3d();
		this.getCoords(object);
		return loc;
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

	private void buildBorderWalls() {
		/*
		 * This functions build the border of the map. the constructor Wall() take these
		 * parameters: vector3d position, float length, float height, Environmental
		 * description
		 */
		Wall w1 = new Wall(setCoords(0, (FIELD_SIZE / 2) + 1), FIELD_SIZE + 1, EXT_WALL_SIZE, this);
		w1.setColor(new Color3f(Color.DARK_GRAY));
		w1.rotate90(1);
		add(w1);

		Wall w2 = new Wall(setCoords(0, -(FIELD_SIZE / 2) - 1), FIELD_SIZE + 1, EXT_WALL_SIZE, this);
		w2.setColor(new Color3f(Color.DARK_GRAY));
		w2.rotate90(1);
		add(w2);

		Wall w3 = new Wall(setCoords((FIELD_SIZE / 2) + 1, 0), FIELD_SIZE + 1, EXT_WALL_SIZE, this);
		w3.setColor(new Color3f(Color.DARK_GRAY));
		add(w3);

		Wall w4 = new Wall(setCoords(-(FIELD_SIZE / 2) - 1, 0), FIELD_SIZE + 1, EXT_WALL_SIZE, this);
		w4.setColor(new Color3f(Color.DARK_GRAY));
		add(w4);
	}

	
	private Vector3d getRandCoord() {
		/*
		 * In this function the x, y coords are generated randomly at each loop cycle
		 * coords function take 2 parameters: (-(FIELD_SIZE/2))+EXT_WALL_SIZE for the
		 * lower and left side of the axes in respect of x,y
		 * (FIELD_SIZE/2)-EXT_WALL_SIZE for the upper and right side of the axes in
		 * respect of x,y
		 */
		MathRand x_coord = new MathRand();
		MathRand y_coord = new MathRand();
		Vector3d coords = setCoords(x_coord.MathRand(((-(FIELD_SIZE / 2)) + EXT_WALL_SIZE), (FIELD_SIZE / 2) - EXT_WALL_SIZE),
				y_coord.MathRand(((-(FIELD_SIZE / 2)) + EXT_WALL_SIZE), (FIELD_SIZE / 2) - EXT_WALL_SIZE));
		return coords;
	}
	private void addMinerals(int totNumBox) {
	//The variable Vector3f take 2 parameters height and width that in this case are random.
		for (int currNumBox = 0; currNumBox < totNumBox; currNumBox++) {
			Vector3d coords = getRandCoord();
			//this is to ensure that the structure won´t overlap with the starting point
			while(coords.x == 0 && coords.y == 0) {
				coords = getRandCoord();
				System.out.println("Rerolling Mine coord: "+ coords);
			}
			Box minerals = new Box(coords,new Vector3f(1, 1, 1), this);
			minerals.setColor(new Color3f(Color.getHSBColor(0.55f, 1f, 0.4f)));
			add(minerals);

		}
	}

	private void addNaturalObstacles(int totNumBox) {
		for (int currNumBox = 0; currNumBox < totNumBox; currNumBox++) {
			MathRand shape = new MathRand();
			Vector3d coords = getRandCoord();
			while(coords.x == 0 && coords.y == 0) {
				coords = getRandCoord();
				System.out.println("Rerolling Mountains coord: "+ coords);
			}
			Box mountains = new Box(coords,new Vector3f(shape.MathRand(2, 5), 1, shape.MathRand(2, 5)), this);
			mountains.setColor(new Color3f(Color.getHSBColor(0.0f, 0.5f, 0.4f)));
			add(mountains);

		}
	}
}
