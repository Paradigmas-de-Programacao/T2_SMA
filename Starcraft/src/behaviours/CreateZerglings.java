package behaviours;

import game.Incubator;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.tools.logging.LogManagerAgent;
import jade.wrapper.AgentController;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;

public class CreateZerglings extends OneShotBehaviour{

	private static final long serialVersionUID = 1L;
	private Incubator incubator = Incubator.getInstance();
	private final int zerglingSuppliesCost = 1;

	@Override
	public void action() {
		System.out.println("Create Zerglings ! Your army is ready to fight !");
		
		try {

			zergling.na
			AgentController ac = incubator.getZerglingContainerController().createNewAgent("Zergling" + incubator.getQntZerglings(), "units.Zergling", new Object[]{});
			ac.start();

			incubator.getZerglingAgents().add(ac)
			incubator.setQntZerglings(incubator.getQntZerglings() + 1);

			System.out.println("Qnt Zerglings: "+ incubator.getQntZerglings());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
