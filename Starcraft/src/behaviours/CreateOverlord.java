package behaviours;

import game.Incubator;
import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class CreateOverlord extends OneShotBehaviour {

	private static final long serialVersionUID = 1L;
	private static final int qntSuppliesUp = 10;
	
	public CreateOverlord(){

	}
	
	@Override
	public void action() {
		System.out.println("Create a Overlord ! Supplies UP !");
		
		try {
		
			AgentController ac = Incubator.getInstance().getOverlordContainerController().createNewAgent("Overlord" + Incubator.getInstance().getQntOverlords(), "units.Overlord", new Object[]{});
			ac.start();

			Incubator.getInstance().setQntOverlords(Incubator.getInstance().getQntOverlords() + 1);
			
			Incubator.getInstance().setTotalSupplies(Incubator.getInstance().getTotalSupplies() + qntSuppliesUp);
			System.out.println("Total Supplies: " + Incubator.getInstance().getTotalSupplies());
		} catch (StaleProxyException e) {
			e.printStackTrace();
		}
	}

}
