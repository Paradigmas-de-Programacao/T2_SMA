package behaviours;

import game.Incubator;
import game.Player;
import jade.core.AID;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.TickerBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class CreateWorkers extends TickerBehaviour{
	
	private Player player;
	public ContainerController containerController;
	private final int qntZerglings = 10;
	
	public CreateWorkers(Agent a, long period) {
		super(a, period);
		this.player = (Player) a;
		
		Runtime rt = Runtime.instance();
		Profile p = new ProfileImpl();
		p.setParameter(Profile.CONTAINER_NAME, "Coletores de Minérios");
		p.setParameter(Profile.MAIN_HOST, "localhost");
		
		containerController = rt.createAgentContainer(p);
	}

	private static final long serialVersionUID = 1L;

	protected void onTick() {
	
		if(player.zerglings >= qntZerglings){
			stop();
		}else{
			player.zerglings++;
	
			try {
				ACLMessage  msg = new ACLMessage(ACLMessage.INFORM);
				
				msg.setPerformative(ACLMessage.INFORM);
				
				if(Incubator.getInstance().getQntMinerals()/3 > Incubator.getInstance().getQntGas()){
					msg.setContent("Collect Gas !");
				}else{
					msg.setContent("Collect Minerals !");
				}
				
				msg.setConversationId("work");
				
				AgentController ac = containerController.createNewAgent("Zergling" + player.zerglings, "units.Zerglings", new Object[]{});
				ac.start();

				msg.addReceiver(new AID("Zergling"+player.zerglings, AID.ISLOCALNAME));
				myAgent.send(msg);
			} catch (StaleProxyException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	public void stop() {
		System.out.println("No more Zangoes !");
		super.stop();
	}

}
