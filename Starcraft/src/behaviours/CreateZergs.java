package behaviours;

import game.Incubator;
import jade.core.behaviours.CyclicBehaviour;

public class CreateZergs extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	private final int costOverlord = 50;

	@Override
	public void action() {
		// Comportamentos disparados quando determinadas condições são alcançadas
		
		// Cria OverLord
		if(Incubator.getInstance().getQntMinerals() >= costOverlord){
			CreateOverlord c = new CreateOverlord();
			Incubator.getInstance().setQntMinerals(Incubator.getInstance().getQntMinerals() - costOverlord);
			myAgent.addBehaviour(c);
		}
		
	}

}
