package de.fhro.inf.prg3.a03;

public class HungryState extends State {

    @Override
    State successor() {
        logger.info("I've starved for a too long time...good bye...");
        return new DeadState(animal, 0);
    }

    HungryState(Animal animal, int t){
        super(animal, t);
        duration = animal.getAwake();
    }
}
