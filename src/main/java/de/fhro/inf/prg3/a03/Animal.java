package de.fhro.inf.prg3.a03;

import java.util.Arrays;


/**
 * @author Peter Kurfer
 * Created on 10/7/17.
 */
public class Animal {

	private State currentState;

	// currentState durations (set via constructor), ie. the number of ticks in each currentState
	private final int sleep;
	private final int awake;
	private final int digest;

	private final String name;

	// money you make, when people watch your animal
	private final int collectionAmount;
	private final GenusSpecies genusSpecies;

	// those species this animal likes to eat
	private final GenusSpecies[] devours;

	public Animal(GenusSpecies genusSpecies, String name, GenusSpecies[] devours, int sleep, int awake, int digest, int collectionAmount) {
		this.name = name;
		this.genusSpecies = genusSpecies;
		this.devours = devours;
		this.sleep = sleep;
		this.awake = awake;
		this.digest = digest;
		this.collectionAmount = collectionAmount;

		Arrays.sort(this.devours);

		this.currentState = new SleepingState(this, 0);
	}

	public void tick(){
		currentState = currentState.tick();
	}

	public void feed(){
		if (!currentState.getClass().equals(HungryState.class))
			throw new IllegalStateException("Can't stuff a cat...");

		currentState = new DigestingState(this, 0);
		State.logger.info("You feed the cat...");

	}

	public boolean devours(Animal other){
		return Arrays.binarySearch(this.devours, other.genusSpecies) >= 0;
	}

	public String getName() {
		return name;
	}

	public int collect() {
		if(!isPlayful()){
			throw new IllegalStateException("One does not simply collect if the animal is not playful!");
		}
		return collectionAmount;
	}

	public boolean isAsleep() {
		return currentState.getClass().equals(SleepingState.class);
	}

	public boolean isPlayful() {
		return currentState.getClass().equals(PlayfulState.class);
	}

	public boolean isHungry() {
		return currentState.getClass().equals(HungryState.class);
	}

	public boolean isDigesting() {
		return currentState.getClass().equals(DigestingState.class);
	}

	public boolean isDead() {
		return currentState.getClass().equals(DeadState.class);
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public int getSleep() {
		return sleep;
	}

	public int getAwake() {
		return awake;
	}

	public int getDigest() {
		return digest;
	}
}
