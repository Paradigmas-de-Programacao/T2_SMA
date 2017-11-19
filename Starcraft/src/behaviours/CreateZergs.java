package behaviours;

import game.Incubator;
import jade.core.behaviours.CyclicBehaviour;

public class CreateZergs extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	private final int costMineralsOverlord = 50;
	private final Incubator incubator = Incubator.getInstance();
	private final int suppliesTotalLimit = 200;
	
	private final int costMineralsZergling = 50;
	private final int costSuppliesZergling = 1;
	
	@Override
	public void action() {
		
		
		//S� podem ser criadas unidades quando os suprimentos atuais n�o estiverem totalmente gastos, e somente ser� poss�vel criar unidades
		//caso o custo delas n�o cause um excesso de suprimentos em rela��o ao total.
		
		if(incubator.getCurrentSupplies() < incubator.getTotalSupplies()){
			
			//Cria Zergling
			if(incubator.getQntMinerals() >= costMineralsZergling && (incubator.getCurrentSupplies() + costSuppliesZergling) <= incubator.getTotalSupplies()){
				CreateZerglings z = new CreateZerglings();
				incubator.setQntMinerals(incubator.getQntMinerals() - costMineralsZergling);
				incubator.setCurrentSupplies(incubator.getCurrentSupplies() + costSuppliesZergling);
				System.out.println("Suprimentos:" + incubator.getCurrentSupplies() + "/" + incubator.getTotalSupplies());
				myAgent.addBehaviour(z);
			}
		}else{
			//Suprimentos esgotados, � necess�rio criar um novo Overlord. Um Overlord n�o consome suprimentos, mas aumenta o seu limite de suprimentos dispon�veis
			if(incubator.getQntMinerals() >= costMineralsOverlord){
				CreateOverlord c = new CreateOverlord();
				incubator.setQntMinerals(incubator.getQntMinerals() - costMineralsOverlord);
				myAgent.addBehaviour(c);
			}
			
		}
	}

}
