package behaviours;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.ParallelBehaviour;

public class ZerglingBehaviour extends FSMBehaviour{

	@Override
	public void onStart() {

		//Estado de patrulha, o zergling observa por inimigos no mapa
		WatchBehaviour watch = new WatchBehaviour();

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

}
