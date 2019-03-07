package nl.vu.cs.Mining;

import java.util.HashMap;
import java.util.Map;

import javax.vecmath.Tuple3d;
import javax.vecmath.Vector3d;
import simbad.sim.EnvironmentDescription;

enum MissionType {
	ExploringMission, CommercialMission
}

public class MissionConfiguration {
	private final static int MIN_CLIENT_REQUEST = 1;
	private final static int MAX_CLIENT_REQUEST = 10;
	private final static int OBJECTIVE = 10;
	private MissionType type;
	public int objective;
	public int collectedMinerals = 0;
    public static Map<Integer, Boolean> minersList= new HashMap<Integer, Boolean>();

    
	public MissionConfiguration() {
		this.type = getRandomMissionType();
		this.objective = setObjective();
	}

	private MissionType getRandomMissionType() {
		MissionType[] values = MissionType.values();
		return values[(int) Math.random() * values.length];
	}

	private int setObjective() {
		int objective = 0;
		if (this.type == MissionType.ExploringMission)
			objective = OBJECTIVE;
		else
			objective = new Utility().mathRand(MIN_CLIENT_REQUEST, MAX_CLIENT_REQUEST);
		return objective;
	}

	public EnvironmentDescription configure() {
		EnvironmentDescription environment = new Environment();

		Robot exploringRobot = Explorer.getInstance();
		Robot miningRobot = new Miner(new Vector3d(1, 0, 0), "Mining Robot", (Subject) exploringRobot);

		minersList.put(miningRobot.id, miningRobot.busy);
		
		environment.add(exploringRobot);
		environment.add(miningRobot);
		return environment;
	}
}
