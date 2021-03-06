package behaviours;

import game.Incubator;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class CollectMinerals extends TickerBehaviour{

	
	public CollectMinerals(Agent a, long period) {
		super(a, period);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void onTick() {
		
		ACLMessage  msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent("Estou coletando minerais !");
		msg.addReceiver(new AID("Player", AID.ISLOCALNAME));
		myAgent.send(msg);
		
		Incubator.getInstance().setQntMinerals(Incubator.getInstance().getQntMinerals() + 5);
		System.out.println("Minerals: " + Incubator.getInstance().getQntMinerals());

	}

		
}
