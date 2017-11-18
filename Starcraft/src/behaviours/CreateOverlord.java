package behaviours;

import game.Incubator;
import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class CreateOverlord extends OneShotBehaviour {

	private static final long serialVersionUID = 1L;
	
	public CreateOverlord(){

	}
	
	@Override
	public void action() {
		System.out.println("CRIA UM OVERLORD FILHO DA PUTA !");
		
		try {
		
			AgentController ac = Incubator.getInstance().getContainerController().createNewAgent("Overlord" + Incubator.getInstance().getQntOverlords(), "units.Overlord", new Object[]{});
			ac.start();

			Incubator.getInstance().setQntOverlords(Incubator.getInstance().getQntOverlords() + 1);
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
	}

}
