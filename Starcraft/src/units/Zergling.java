package units;

import behaviours.ZerglingBehaviour;
import jade.core.Agent;

public class Zergling extends Agent{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void setup() {
		ZerglingBehaviour z = new ZerglingBehaviour();
		System.out.println("Zergling start your State Machine !");
		
		this.addBehaviour(z);
	}
}
