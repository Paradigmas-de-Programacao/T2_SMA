package game;

import behaviours.CreateWorkers;
import jade.core.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;


public class Player extends Agent{

	private static final long serialVersionUID = 1L;

	public int zerglings = 0;
	public int minerals = 0;

	protected void setup(){
		
		System.out.println("Let's Play Starcraft, Baby !");
		
		System.out.println("Registrando player no DF !");
		DFAgentDescription dfd = new DFAgentDescription();
		dfd.setName(getAID());
		ServiceDescription sd = new ServiceDescription();
		sd.setName(getName());
		sd.setType("Player");
		dfd.addServices(sd);
		
		try{
			DFService.register(this, dfd);

			CreateWorkers b =  new CreateWorkers(this, 2000);
			addBehaviour(b);
		}catch(FIPAException e){
			e.printStackTrace();
			doDelete();
		}
		
	}
}
