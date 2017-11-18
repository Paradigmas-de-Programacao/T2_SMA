package units;

import jade.core.Agent;
import behaviours.CollectMinerals;

public class Zerglings extends Agent{

	private static final long serialVersionUID = 1L;
	
	protected void setup(){
		System.out.println("Zergling Born!");
		CollectMinerals fm =  new CollectMinerals(this,3000);
		addBehaviour(fm);
	}
}
