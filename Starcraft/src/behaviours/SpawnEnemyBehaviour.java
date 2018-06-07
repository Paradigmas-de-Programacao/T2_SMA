package behaviours;

import java.util.Random;

import game.Incubator;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class SpawnEnemyBehaviour extends TickerBehaviour {

	Incubator incubator = Incubator.getInstance();
	
	public SpawnEnemyBehaviour(Agent a, long period) {
		super(a, period);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onTick() {
		Random gerador = new Random();
		
		for(int enemys = 0; enemys < incubator.QNT_ENEMYS; enemys++) {
			
		}
		
		Integer i = gerador.nextInt(incubator.MAP_DIMENSIONS);
		Integer j = gerador.nextInt(incubator.MAP_DIMENSIONS);
		incubator.setEnemy(i, j);
		
		incubator.printMap();
	}

}
