package ece325_lab_assignment4;

import java.lang.Math;

/**
 * The artist/band that is performing. You must finish this class.
 * 
 * @author corpaul
 *
 */
public class Artist implements ZooPerformer {
	/**
	 * Indicates whether the artist is currently playing (= performing).
	 */
	private boolean isPlaying;

	public Artist() {
		// By default the artists is not playing music.
		isPlaying = false;
	}

	/**
	 * feed() takes the input of a zoo animal and attempts to feed it. The method
	 * can throw either a NotPlayingException if you attempt to feed an animal
	 * without playing music first, and can throw an AlreadyFedException by calling
	 * animal.feed() while the animal is already fed.
	 * 
	 */
	public void feed(ZooAnimal animal) throws AlreadyFedException, NotPlayingException {
		//
		// did we already feed this animal today?
		// Try catch statement to catch NotPlayingException. The AlreadyFedException is
		// thrown by ZooAnimal.feed().
		try {
			if (isPlaying) {
				animal.feed();
			} else
				throw new NotPlayingException("You are not playing any music");
		} catch (NotPlayingException npe) {
			// npe.printStackTrace(); The stack trace if the exception is not handled
			// correctly.
			// The system outputs a string to stdout saying you must begin playing music
			System.out.println("You must begin playing music before you try to feed the " + animal.getName() + "!");
		}
	}

	public boolean isPlaying() {
		// Getter for isPlaying.
		return isPlaying;
	}

	/**
	 * Sometimes, artists get distracted, so there is a 50% chance that they start
	 * playing when you call this method.
	 * 
	 */
	public void startPlaying() {
		// if we are already playing, don't risk getting distracted again
		// Half the time when startPlaying() is called it will do nothing, the other
		// half of the time it will set isPlaying to true.
		double chance = Math.random();
		if (chance < 0.5) {
			isPlaying = true;
			System.out.println("Now Playing Music!");
		}
	}

	public void stopPlaying() {
		// Sets isPlaying to false.
		isPlaying = false;
		System.out.println("No Longer Playing Music!");
	}

}
