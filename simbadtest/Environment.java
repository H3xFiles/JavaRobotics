package nl.vu.cs.s2.simbadtest;

import java.awt.Color;

import javax.vecmath.*;
import java.util.*;
import simbad.sim.*;

public class Environment extends EnvironmentDescription {
	int FIELD_SIZE = 25;
	int EXT_WALL_SIZE = 2;
	
	public Environment() {
        this.setWorldSize(FIELD_SIZE);
        buildScene();
        buildBorderWalls ();
        MathRand numMinerals = new MathRand();
        addMinerals(numMinerals.MathRand(10, 30));
        addNaturalObstacles(numMinerals.MathRand(10, 30));
        
	}   
	
	private void buildScene() {
		// turn on the lights
	       this.light1IsOn = true;
	       this.light2IsOn = true;

	    // getHSBColor take following parameters int hue, saturation, int brightness
	       this.ambientLightColor = new Color3f(Color.getHSBColor(0, 200, 100));
	       this.floorColor = new Color3f(Color.getHSBColor(0, 360, 100));
	       
	        // enable the physics engine in order to have better physics effects on the objects
	        this.setUsePhysics(true);
	        
	        // show the axes so that we know where things are
	        this.showAxis(false);
	}
	
	private void buildBorderWalls () {
	/*
	 * This functions build the border of the map.
	 * the constructor Wall() take these parameters:
	 *        vector3d position,
	 *        float length,
	 *        float height, 
	 *        Environmental description
	 */
    Wall w1 = new Wall(new Vector3d(-(FIELD_SIZE/2), 0, 0), FIELD_SIZE, EXT_WALL_SIZE, this);
    w1.setColor(new Color3f(Color.DARK_GRAY));
    w1.rotate90(1);
    add(w1);
    
    Wall w2 = new Wall(new Vector3d((FIELD_SIZE/2), 0, 0), FIELD_SIZE, EXT_WALL_SIZE, this);
    w2.setColor(new Color3f(Color.DARK_GRAY));
    w2.rotate90(1);
    add(w2);
    
    Wall w3 = new Wall(new Vector3d(0, 0, (FIELD_SIZE/2)), FIELD_SIZE, EXT_WALL_SIZE, this);
    w3.setColor(new Color3f(Color.DARK_GRAY));
    add(w3);     Point3d loc = new Point3d();

    
    Wall w4 = new Wall(new Vector3d(0, 0, -(FIELD_SIZE/2)), FIELD_SIZE, EXT_WALL_SIZE, this);
    w4.setColor(new Color3f(Color.DARK_GRAY));
    add(w4);
}
	
public Vector3d coords(int x, int y) {
        return new Vector3d(-y, 0, -x);
    }

        	
private void addMinerals(int totNumBox) {
	/*
	 * In this function the x, y coords are generated randomly at each loop cycle
	 * coords function take 2 parameters:
	 * (-(FIELD_SIZE/2))+EXT_WALL_SIZE for the lower and left side of the axes in respect of x,y
	 * (FIELD_SIZE/2)-EXT_WALL_SIZE for the upper and right side of the axes in respect of x,y
	 * 
	 * The variable Vector3f take 2 parameters height and width that in this case are random.
	 */
		for(int currNumBox = 0; currNumBox<totNumBox; currNumBox++) {
			MathRand x_coord = new MathRand();
			MathRand y_coord = new MathRand();
			MathRand shape = new MathRand();
			
			 Box box = new Box(coords(
					 x_coord.MathRand(((-(FIELD_SIZE/2))+EXT_WALL_SIZE),(FIELD_SIZE/2)-EXT_WALL_SIZE),
					 y_coord.MathRand(((-(FIELD_SIZE/2))+EXT_WALL_SIZE),(FIELD_SIZE/2)-EXT_WALL_SIZE)), 
					 new Vector3f(shape.MathRand(1, 2), 1, shape.MathRand(1, 2)), this);
		     box.setColor(new Color3f(Color.getHSBColor(0.55f,1f,0.4f)));
		     box.hashCode();
		     
		     add(box);
		}	
	}

private void addNaturalObstacles(int totNumBox) {
		for(int currNumBox = 0; currNumBox<totNumBox; currNumBox++) {
			MathRand x_coord = new MathRand();
			MathRand y_coord = new MathRand();
			MathRand shape = new MathRand();
			
			 Box box = new Box(coords(
					 x_coord.MathRand(((-(FIELD_SIZE/2))+EXT_WALL_SIZE),(FIELD_SIZE/2)-EXT_WALL_SIZE),
					 y_coord.MathRand(((-(FIELD_SIZE/2))+EXT_WALL_SIZE),(FIELD_SIZE/2)-EXT_WALL_SIZE)), 
					 new Vector3f(shape.MathRand(2, 5), 1, shape.MathRand(2, 5)), this);
		     box.setColor(new Color3f(Color.getHSBColor(0.0f,0.5f,0.4f)));
		     box.hashCode();
		     
		     add(box);
		}	
	}
}
     
      

    

