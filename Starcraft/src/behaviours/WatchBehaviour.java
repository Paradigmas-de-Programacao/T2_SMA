package behaviours;

import jade.core.behaviours.CyclicBehaviour;

public class WatchBehaviour extends CyclicBehaviour{

	@Override
	public void action() {
		System.out.println("Zerg está patrulhando !");
	}

}
