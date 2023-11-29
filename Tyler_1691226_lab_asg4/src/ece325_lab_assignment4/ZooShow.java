package ece325_lab_assignment4;

public class ZooShow {

	public static void main(String[] args) throws AlreadyFedException, NotPlayingException {
		// create the artist
		Artist artist = new Artist();

		// create the zoo
		Zoo theZoo = new Zoo();

		// while there are animals that still need feeding,
		// randomly select an animal from the zoo
		// feed it
		ZooAnimal animal;

		// Attempt to feed animals until all animals are fed
		while (!theZoo.allAnimalsFed()) {
			// Get a random animal to come to the stage
			animal = theZoo.getRandomAnimalToComeToStage();
			// Now that an animal has come up to the stage asking for food attempt to start
			// playing music, if already playing their is no reason to call it again as it
			// will do nothing
			if (!artist.isPlaying())
				artist.startPlaying();
			// Attempt to feed the animal
			artist.feed(animal);
		}

		// stop playing when all animals are fed
		artist.stopPlaying();
	}
}
