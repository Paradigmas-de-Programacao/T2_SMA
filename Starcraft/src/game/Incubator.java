package game;

import jade.core.AID;
import jade.core.Profile;
import jade.core.ProfileImpl;
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

	private List<AID> zerglingAgents = new ArrayList<AID>();


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

	public List<AID> getZerglingAgents() {
		return zerglingAgents;
	}
}
