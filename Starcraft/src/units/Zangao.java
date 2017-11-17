package units;

import game.Mine;
import jade.core.Agent;
import behaviours.CollectMinerals;

public class Zangao extends Agent{

	private static final long serialVersionUID = 1L;
	private Mine mine;
	
	protected void setup(){
		System.out.println("Zangao Born!");
		CollectMinerals fm =  new CollectMinerals(this,3000);
		addBehaviour(fm);
	}
}
