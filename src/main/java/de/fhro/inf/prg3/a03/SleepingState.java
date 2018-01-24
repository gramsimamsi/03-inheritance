package de.fhro.inf.prg3.a03;

public class SleepingState extends State {

    @Override
    State successor() {
        logger.info("Yoan... getting hungry!");
        return new HungryState(animal, 0);
    }

    SleepingState(Animal animal, int t) {
        super(animal, t);
        duration = animal.getSleep();
    }
}
