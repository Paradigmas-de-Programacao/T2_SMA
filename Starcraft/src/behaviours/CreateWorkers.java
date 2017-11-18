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
	private final int qntDrones = 5;
	
	public CreateWorkers(Agent a, long period) {
		super(a, period);
		this.player = (Player) a;
		
		Runtime rt = Runtime.instance();
		Profile p = new ProfileImpl();
		p.setParameter(Profile.CONTAINER_NAME, "Mine");
		p.setParameter(Profile.MAIN_HOST, "localhost");
		
		containerController = rt.createAgentContainer(p);
	}

	private static final long serialVersionUID = 1L;

	protected void onTick() {
	
		if(player.drones >= qntDrones){
			stop();
		}else{
			player.drones++;
	
			try {
				ACLMessage  msg = new ACLMessage(ACLMessage.INFORM);
				
				msg.setPerformative(ACLMessage.INFORM);
				
				if(Incubator.getInstance().getQntMinerals()/3 > Incubator.getInstance().getQntGas()){
					msg.setContent("Collect Gas !");
				}else{
					msg.setContent("Collect Minerals !");
				}
				
				msg.setConversationId("work");
				
				AgentController ac = containerController.createNewAgent("Drone" + player.drones, "units.Drones", new Object[]{});
				ac.start();

				msg.addReceiver(new AID("Drone"+player.drones, AID.ISLOCALNAME));
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
