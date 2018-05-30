package behaviours;

import jade.core.behaviours.Behaviour;
import jade.core.behaviours.FSMBehaviour;

public class ZerglingBehaviour extends FSMBehaviour{
	
	@Override
	public void onStart() {
		//Estado de patrulha, o zergling procura por inimigos no mapa
		WatchBehaviour watch = new WatchBehaviour();
		registerFirstState(watch, "Patrol");
		
		//Estado de batalha, o zergling encontrou inimigos e vão lutar
		BattleBehaviour battle = new BattleBehaviour();
		registerState(battle, "Battle");
		
	}
	
	@Override	
	public int onEnd() {
		System.out.println("Goodbye Zergling ! Rest in Peace !");
		return super.onEnd();
	}	
	
}
