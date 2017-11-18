package game;

public class Incubator {
	
	private static Incubator INSTANCE;
	
	public static int qntMinerals = 0;
	public static int qntGas = 0;
	public static int currentSupplies = 0;
	public static int totalSupplies = 10;
	
	private Incubator(){
		
	}
	
	public static synchronized Incubator getInstance(){
		if(INSTANCE == null){
			INSTANCE = new Incubator();
		}
		
		return INSTANCE;
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
