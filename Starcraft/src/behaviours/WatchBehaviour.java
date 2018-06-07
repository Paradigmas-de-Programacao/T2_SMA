package behaviours;

import game.Incubator;
import jade.core.behaviours.SimpleBehaviour;

public class WatchBehaviour extends SimpleBehaviour{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

//	@Override
//	public int onEnd() {
//		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
//		msg.setPerformative(ACLMessage.INFORM);
//		msg.setContent("Estamos sendo atacados ! Run to the hills !");
//		msg.setConversationId("underAttack");
//
//		msg.addReceiver();
//		myAgent.send(msg);
//
//		return super.onEnd();
//	}
}
