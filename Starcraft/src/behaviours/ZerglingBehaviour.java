package behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
<<<<<<< HEAD
import units.Zergling;
=======
import jade.core.behaviours.ParallelBehaviour;
>>>>>>> 5ab3026b30a66f25b105420c6a8d2b5674c3a98d

public class ZerglingBehaviour extends FSMBehaviour{

	@Override
	public void onStart() {

		//Estado de patrulha, o zergling observa por inimigos no mapa
		WatchBehaviour watch = new WatchBehaviour();
<<<<<<< HEAD
		registerFirstState(watch, Zergling.PATROL_BEHAVIOUR);
		
		//Estado de batalha, o zergling encontrou inimigos e vão lutar
		BattleBehaviour battle = new BattleBehaviour();
		registerState(battle, Zergling.BATTLE_BEHAVIOUR);
		
		//Transição entre estado de patrulha para estado de batalha
//		registerDefaultTransition(Zergling.PATROL_BEHAVIOUR, Zergling.BATTLE_BEHAVIOUR);
		registerDefaultTransition(Zergling.PATROL_BEHAVIOUR, Zergling.BATTLE_BEHAVIOUR);
	}
		
	@Override	
	public int onEnd() {
		System.out.println("Goodbye Zergling ! Rest in Peace !");
		myAgent.doDelete();
		return super.onEnd();
	}	
	
=======

		// Estado de movimentação, o zergling anda sem parar pelo mapa
		MoveBehaviour move = new MoveBehaviour();

		//Estado de batalha, o zergling encontrou inimigos e vão lutar
		BattleBehaviour battle = new BattleBehaviour();

		ParallelBehaviour parallelBehaviour = new ParallelBehaviour(ParallelBehaviour.WHEN_ALL);
		parallelBehaviour.addSubBehaviour(watch);
		parallelBehaviour.addSubBehaviour(move);

		registerFirstState(parallelBehaviour, "Watchmen");
		registerLastState(battle, "Battle");

		// --- Transições de estados --
		/* Passando do estado de vigilância para o estado de batalha
		após o onEnd do parallelBehavior retornar */
		registerTransition("Watchmen", "Battle", 0);

	}

>>>>>>> 5ab3026b30a66f25b105420c6a8d2b5674c3a98d
}
