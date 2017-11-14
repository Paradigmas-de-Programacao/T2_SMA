package units;

import game.Mine;
import jade.core.Agent;
import behaviours.FindMine;

public class Zangao extends Agent{

	private static final long serialVersionUID = 1L;
	private Mine mine;
	
	protected void setup(){
		System.out.println("Zangao Born!");
		FindMine fm =  new FindMine();
		addBehaviour(fm);
	}
}
