package behaviours;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;
import units.Zergling;

public class ZerglingBehaviour extends FSMBehaviour{
	
	@Override
	public void onStart() {
		//Estado de patrulha, o zergling procura por inimigos no mapa
		WatchBehaviour watch = new WatchBehaviour();
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
	
}
