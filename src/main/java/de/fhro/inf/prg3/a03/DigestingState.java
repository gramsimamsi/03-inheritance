package de.fhro.inf.prg3.a03;

public class DigestingState extends State {

    @Override
    State successor() {
        logger.info("Getting in a playful mood!");
        return new PlayfulState(animal, t);
    }

    DigestingState(Animal animal, int t) {
        super(animal, t);
        duration = animal.getDigest();
    }
}
