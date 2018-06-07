package units;

import behaviours.ZerglingBehaviour;
import jade.core.Agent;
import jade.core.behaviours.ParallelBehaviour;

public class Zergling extends Agent{

	private static final long serialVersionUID = 1L;
	
	public static final String PATROL_BEHAVIOUR = "Patrol";
	public static final String BATTLE_BEHAVIOUR = "Battle";
	public static final Long PATROL_TIME = 1000l;
	
	@Override
	protected void setup() {
		ZerglingBehaviour z = new ZerglingBehaviour();
<<<<<<< HEAD
		System.out.println("Zergling iniciando sua Máquina de Estados !");
		
		this.addBehaviour(z);
=======
		System.out.println("Zergling start your State Machine !");
>>>>>>> 5ab3026b30a66f25b105420c6a8d2b5674c3a98d
	}

}
	