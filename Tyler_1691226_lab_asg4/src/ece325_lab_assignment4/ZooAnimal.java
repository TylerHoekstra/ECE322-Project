package ece325_lab_assignment4;

import java.time.LocalDate;

/**
 * Finish the implementation of this class. No need to add any instance
 * variables or methods.
 *
 */
public class ZooAnimal {
	/**
	 * The last date on which this animal was fed.
	 */
	private LocalDate lastFeed;

	/**
	 * The name of the animal.
	 */
	private String name;

	public ZooAnimal(String name) {
		this.name = name;
	}

	public LocalDate getLastFeed() {
		return lastFeed;
	}

	/**
	 * Returns true iff the animal was fed already today.
	 * 
	 * @return true if the animal was fed today
	 */
	public boolean isFedAlready() {
		LocalDate today = java.time.LocalDate.now(); // Find date of today
		if (lastFeed == null) // If lastFeed == null it means the animal has never been fed.
			return false;
		else if ((today.getYear() - lastFeed.getYear() == 0) && (today.getDayOfYear() - lastFeed.getDayOfYear() < 1))
			return true; // Only checks the calendar day, not a 24 hour period.
		else
			return false;
	}

	public void feed() throws AlreadyFedException {
		/*
		 * feed() takes no input and can throw the AlreadyFedException if feed() is
		 * called on an animal that has been previously fed in the current calendar day.
		 */
		try {
			if (!this.isFedAlready()) {
				lastFeed = java.time.LocalDate.now();
				System.out.println(this.getName() + " has been fed.");
			} else
				// If already fed throw an AlreadyFedException
				throw new AlreadyFedException(this.getName() + " has already been fed today");
			;
		} catch (AlreadyFedException afe) {
			// afe.printStackTrace(); Stack Trace
			// The system outputs a string to stdout saying the animal has already been fed.
			System.out.println(this.getName() + " was not fed because it was already fed today!");
		}

	}

	public String getName() {
		// Getter for name
		return name;
	}
}
