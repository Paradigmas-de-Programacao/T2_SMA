package game;

import jade.core.AID;
import jade.core.Profile;
import jade.core.ProfileImpl;

import java.util.ArrayList;
import java.util.List;

import jade.core.AID;
import jade.core.Runtime;
import jade.wrapper.ContainerController;
import units.Zergling;

import java.util.ArrayList;
import java.util.List;

public class Incubator {
	
	private static Incubator INSTANCE;
	
	public static int qntMinerals = 0;
	public static int qntGas = 0;
	public static int currentSupplies = 0;
	public static int totalSupplies = 2;
	
	public static int qntOverlords = 1;
	public static int qntZerglings = 0;

	public static ContainerController overlordContainerController;
	public static ContainerController zerglingContainerController;
	
	public final long SPAWN_ENEMY_TIME = 3000;
	public final int QNT_ENEMYS = 5;

<<<<<<< HEAD
	public final int MAP_DIMENSIONS = 10;
	
	private List<AID> workersAID = new ArrayList<AID>();
	
	//Mapa do jogo
	private int[][] map = new int[MAP_DIMENSIONS][MAP_DIMENSIONS];
=======
	private List<AID> zerglingAgents = new ArrayList<AID>();

>>>>>>> 5ab3026b30a66f25b105420c6a8d2b5674c3a98d

	private Incubator(){
		Runtime rt = Runtime.instance();
		
		Profile pOverlord = new ProfileImpl();
		pOverlord.setParameter(Profile.CONTAINER_NAME, "Overlord_Nest");
		pOverlord.setParameter(Profile.MAIN_HOST, "localhost");
		overlordContainerController = rt.createAgentContainer(pOverlord);
		
		Profile pZergling = new ProfileImpl();
		pZergling.setParameter(Profile.CONTAINER_NAME, "Zerglings_Nest");
		pZergling.setParameter(Profile.MAIN_HOST, "localhost");
		zerglingContainerController = rt.createAgentContainer(pZergling);
	}
	
	public static synchronized Incubator getInstance(){
		if(INSTANCE == null){
			INSTANCE = new Incubator();
		}
		
		return INSTANCE;
	}
	
	public ContainerController getZerglingContainerController(){
		return zerglingContainerController;
	}
	
	public int getQntZerglings(){
		return qntZerglings;
	}
	
	public void setQntZerglings(int pqntZerglings){
		qntZerglings = pqntZerglings;
	}
	
	
	public ContainerController getOverlordContainerController(){
		return overlordContainerController;
	}
	
	public int getQntOverlords(){
		return qntOverlords;
	}
	
	public void setQntOverlords(int pqntOverlords){
		qntOverlords = pqntOverlords;
	}
	
	public int getQntMinerals(){
		return qntMinerals;
	}
	
	public void setQntMinerals(int pqntMinerals){
		qntMinerals = pqntMinerals;
	}
	
	public int getQntGas(){
		return qntGas;
	}
	
	public void setQntGas(int pqntGas){
		qntGas = pqntGas;
	}
	
	public int getTotalSupplies(){
		return totalSupplies;
	}
	
	public void setTotalSupplies(int pTotalSupplies){
		totalSupplies = pTotalSupplies;
	}
	
	public int getCurrentSupplies(){
		return currentSupplies;
	}
	
	public void setCurrentSupplies(int pCurrentSupplies){
		currentSupplies = pCurrentSupplies;
	}
<<<<<<< HEAD
	
	public List<AID> getWorkersAID() {
		return workersAID;
	}
	
	public int getMapPosition(int i, int j) {
		return map[i][j];
	}
	
	public int[][] getMap() {
		return map;
	}
	
	public void setEnemy(int i, int j) {
		map[i][j] = 1;
	} 
	
	public void printMap() {
		System.out.println("================= MAPA =================");
		
		for(int i = 0; i < MAP_DIMENSIONS; i++) {
			for(int j = 0; j < MAP_DIMENSIONS; j++) {
				System.out.print("[" + getMapPosition(i, j) + "]" + " ");
			}
			System.out.println("\n");
		}
		
		System.out.println("========================================");
	}
	
=======

	public List<AID> getZerglingAgents() {
		return zerglingAgents;
	}
>>>>>>> 5ab3026b30a66f25b105420c6a8d2b5674c3a98d
}
