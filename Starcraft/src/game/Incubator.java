package game;

public class Incubator {
	
	private static Incubator INSTANCE;
	
	public static String name;
	public static int qntMinerals = 0;
	
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
	
	public String getIncubatorName(){
		return name;
	}
	
	public void setQntMinerals(int pqntMinerals){
		qntMinerals = pqntMinerals;
	}
}
