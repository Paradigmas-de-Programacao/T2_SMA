package behaviours;

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
		System.out.println("Iniciando a coleta dos minerais");
		
		ACLMessage  msg = new ACLMessage(ACLMessage.INFORM);
		//Preenchendo mensagem
//		msg.setPerformative(ACLMessage.INFORM);
		msg.setContent("Estou coletando minerais !");
		msg.addReceiver(new AID("Player", AID.ISLOCALNAME));
		System.out.println("Enviando msg: " + msg.getContent());
		myAgent.send(msg);

	}

		
}
