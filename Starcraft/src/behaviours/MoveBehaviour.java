package behaviours;

import jade.core.behaviours.OneShotBehaviour;

public class MoveBehaviour extends OneShotBehaviour {

    public void action() {
        System.out.println("Zergling está se movendo !");
    }

    @Override
    public int onEnd() {
        System.out.println("Parando de se mover !");
        return 1;
    }
}
