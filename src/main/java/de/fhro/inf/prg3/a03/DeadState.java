package de.fhro.inf.prg3.a03;

public class DeadState extends State {

    @Override
    State successor() {
        return this;
    }

    DeadState(Animal animal, int t) {
        super(animal, t);
    }

}
