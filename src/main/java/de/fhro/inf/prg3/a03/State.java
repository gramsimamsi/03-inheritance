package de.fhro.inf.prg3.a03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class State {

    public static final Logger logger = LogManager.getLogger();

    Animal animal;
    int t;
    int duration;

    abstract State successor();

    final State tick(){

        logger.info("tick()");
        if(++t == duration)
            return successor();
        else
            return this;
    }

    State(Animal animal, int t){
        this.t = t;
        this.animal = animal;
    }

}
