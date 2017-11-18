package game;

import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;

public class Incubator {
	
	private static Incubator INSTANCE;
	
	public static int qntMinerals = 0;
	public static int qntGas = 0;
	public static int currentSupplies = 0;
	public static int totalSupplies = 10;
	public static int qntOverlords = 1;
	
	public static ContainerController overlordContainerController;

	private Incubator(){
		Runtime rt = Runtime.instance();
		Profile pOverlord = new ProfileImpl();
		pOverlord.setParameter(Profile.CONTAINER_NAME, "Overlord_Nest");
		pOverlord.setParameter(Profile.MAIN_HOST, "localhost");
		overlordContainerController = rt.createAgentContainer(pOverlord);

	}
	
	public static synchronized Incubator getInstance(){
		if(INSTANCE == null){
			INSTANCE = new Incubator();
		}
		
		return INSTANCE;
	}
	
	public ContainerController getContainerController(){
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
	
}
