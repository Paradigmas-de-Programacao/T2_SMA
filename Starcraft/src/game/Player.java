package game;

import behaviours.CreateWorkers;
import jade.core.*;


public class Player extends Agent{

	public int zangoes = 0;
	
	private static final long serialVersionUID = 1L;

	protected void setup(){
		
		System.out.println("Let's Play Starcraft, Baby !");
		CreateWorkers b =  new CreateWorkers(this, 2000);
		addBehaviour(b);
	}
}
