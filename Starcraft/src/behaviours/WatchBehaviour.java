package behaviours;

import game.Incubator;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class WatchBehaviour extends CyclicBehaviour{

	@Override
	public void action() {
		System.out.println("Zerg está patrulhando !");
	}

	@Override
	public int onEnd() {
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.setPerformative(ACLMessage.INFORM);
		msg.setContent("Estamos sendo atacados ! Run to the hills !");
		msg.setConversationId("underAttack");

		msg.addReceiver();
		myAgent.send(msg);

		return super.onEnd();
	}
}
