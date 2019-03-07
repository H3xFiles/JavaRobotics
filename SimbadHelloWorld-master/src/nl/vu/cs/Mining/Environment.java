package nl.vu.cs.Mining;

import javax.vecmath.Vector3d;
import simbad.sim.Box;
import javax.vecmath.Vector3f;
import simbad.sim.Wall;
import javax.vecmath.Color3f;
import java.awt.Color;
import java.util.HashMap;
import javax.vecmath.Tuple3d;
import java.util.Map;
import simbad.sim.EnvironmentDescription;

public class Environment extends EnvironmentDescription
{
    static final int FIELD_SIZE = 25;
    static final int EXT_WALL_SIZE = 2;
    public static Map<Integer, Tuple3d> mineralPosition;
    public static Map<Integer, Tuple3d> mountainPosition;
    
    static {
        Environment.mineralPosition = new HashMap<Integer, Tuple3d>();
        Environment.mountainPosition = new HashMap<Integer, Tuple3d>();
    }
    
    public Environment() {
        this.setWorldSize(25.0f);
        this.buildScene();
        this.buildBorderWalls();
        this.addMinerals(new Utility().mathRand(10, 15));
        this.addMountains(new Utility().mathRand(15, 30));
    }
    
    private void buildScene() {
        this.light1IsOn = true;
        this.light2IsOn = true;
        this.ambientLightColor = new Color3f(Color.getHSBColor(0.0f, 200.0f, 100.0f));
        this.floorColor = new Color3f(Color.getHSBColor(0.0f, 360.0f, 100.0f));
        this.setUsePhysics(true);
        this.showAxis(false);
    }
    
    private void buildBorderWalls() {
        final Wall w1 = new Wall(new Utility().setCoords(0, 12), 25.0f, 2.0f, (EnvironmentDescription)this);
        w1.setColor(new Color3f(Color.DARK_GRAY));
        w1.rotate90(1);
        this.add((Object)w1);
        final Wall w2 = new Wall(new Utility().setCoords(0, -12), 25.0f, 2.0f, (EnvironmentDescription)this);
        w2.setColor(new Color3f(Color.DARK_GRAY));
        w2.rotate90(1);
        this.add((Object)w2);
        final Wall w3 = new Wall(new Utility().setCoords(12, 0), 25.0f, 2.0f, (EnvironmentDescription)this);
        w3.setColor(new Color3f(Color.DARK_GRAY));
        this.add((Object)w3);
        final Wall w4 = new Wall(new Utility().setCoords(-12, 0), 25.0f, 2.0f, (EnvironmentDescription)this);
        w4.setColor(new Color3f(Color.DARK_GRAY));
        this.add((Object)w4);
    }
    
    private void addMinerals(final int totNumBox) {
        for (int currNumBox = 0; currNumBox < totNumBox; ++currNumBox) {
            final Vector3d coords = new Utility().getRandCoord();
            final Box minerals = new Box(coords, new Vector3f(1.0f, 1.0f, 1.0f), (EnvironmentDescription)this);
            minerals.setColor(new Color3f(Color.getHSBColor(0.55f, 1.0f, 0.4f)));
            this.add((Object)minerals);
            final int hashCurrentLoc = coords.hashCode();
            Environment.mineralPosition.put(hashCurrentLoc, (Tuple3d)coords);
        }
    }
    
    private void addMountains(final int totNumBox) {
        for (int currNumBox = 0; currNumBox < totNumBox; ++currNumBox) {
            final Vector3d coords = new Utility().getRandCoord();
            final Box mountains = new Box(coords, new Vector3f((float)new Utility().mathRand(1, 3), 1.0f, (float)new Utility().mathRand(2, 4)), (EnvironmentDescription)this);
            mountains.setColor(new Color3f(Color.getHSBColor(0.0f, 0.5f, 0.4f)));
            this.add((Object)mountains);
            final int hashCurrentLoc = coords.hashCode();
            Environment.mountainPosition.put(hashCurrentLoc, (Tuple3d)coords);
        }
    }
}
