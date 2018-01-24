package de.fhro.inf.prg3.a03;

public class PlayfulState extends State {

    @Override
    State successor() {
        logger.info("Yoan... getting tired!");
        return new SleepingState(animal, 0);
    }

    PlayfulState(Animal animal, int t) {
        super(animal, t);
        duration = animal.getAwake();
    }
}
