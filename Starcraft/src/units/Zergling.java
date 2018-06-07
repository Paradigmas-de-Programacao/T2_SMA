package units;

import behaviours.ZerglingBehaviour;
import jade.core.Agent;

public class Zergling extends Agent{

	private static final long serialVersionUID = 1L;
	
	public static final String PATROL_BEHAVIOUR = "Patrol";
	public static final String BATTLE_BEHAVIOUR = "Battle";
	public static final Long PATROL_TIME = 1000l;
	
	@Override
	protected void setup() {
		ZerglingBehaviour z = new ZerglingBehaviour();
		System.out.println("Zergling iniciando sua Máquina de Estados !");
		
		this.addBehaviour(z);
	}
}
	