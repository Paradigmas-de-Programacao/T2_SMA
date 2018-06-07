package behaviours;

import game.Incubator;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.SimpleBehaviour;
import jade.core.behaviours.TickerBehaviour;

public class WatchBehaviour extends SimpleBehaviour{

	Incubator incubator = Incubator.getInstance();
	private Boolean finish = false;
	
	@Override
	public void action() {
		System.out.println("Zerg está patrulhando !");
		
		for(int i = 0; i < incubator.MAP_DIMENSIONS; i++) {
			for(int j = 0; j < incubator.MAP_DIMENSIONS; j++) {
				if(incubator.getMapPosition(i, j) == 1) {
					System.out.println("Inimigo encontrado !\n");
					finish = true;
					done();
				}
			}
		}
	}

	@Override
	public boolean done() {
		return finish;
	}

}
