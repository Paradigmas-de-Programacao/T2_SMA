package behaviours;

import game.Player;
import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.TickerBehaviour;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class CreateWorkers extends TickerBehaviour{
	
	private Player player;
	public ContainerController containerController;
	
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
		if(player.zerglings >= 3){
			stop();
		}else{
			player.zerglings++;
			
			try {
				AgentController ac = containerController.createNewAgent("Zergling" + player.zerglings, "units.Zerglings", new Object[]{});
				ac.start();
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
