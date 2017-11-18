package behaviours;

import game.Incubator;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;

public class CollectGas extends TickerBehaviour {

	public CollectGas(Agent a, long period) {
		super(a, period);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void onTick() {
		
		ACLMessage  msg = new ACLMessage(ACLMessage.INFORM);
		msg.setContent("Estou coletando gas !");
		msg.addReceiver(new AID("Player", AID.ISLOCALNAME));
		myAgent.send(msg);
		
		Incubator.getInstance().setQntGas(Incubator.getInstance().getQntGas() + 3);
		System.out.println("Gas: " + Incubator.getInstance().getQntGas());

	}
	
}
