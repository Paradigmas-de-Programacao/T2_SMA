package units;

import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import behaviours.CollectGas;
import behaviours.CollectMinerals;

public class Zerglings extends Agent{

	private static final long serialVersionUID = 1L;
	
	protected void setup(){
		System.out.println("Zergling Born!");
		CollectMinerals fm =  new CollectMinerals(this,3000);
		CollectGas fg = new CollectGas(this, 3000);
		
		ACLMessage command = receive();
		
		while(command == null){
			command = receive();
		}

		String content = command.getContent();
		
		if(content.equalsIgnoreCase("Collect Minerals !")){
			System.out.println("I receive the order to collect minerals !");
			addBehaviour(fm);
		}else{
			System.out.println("I receive the order to collect gas !");
			addBehaviour(fg);
		}
	}
}
