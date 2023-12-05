package test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.Test;
//import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

import ece325_lab_assignment4.AlreadyFedException;
import ece325_lab_assignment4.Artist;
import ece325_lab_assignment4.NotPlayingException;
import ece325_lab_assignment4.ZooAnimal;

import org.junit.jupiter.api.BeforeEach;

class ArtistTest {
	
	Artist artist;
	
	@BeforeEach
	public void setup() {
		artist = new Artist();
		
	}
	
	@Test
	public void testGetSetisPlaying() {
		assertFalse(artist.isPlaying());
		
		while (!artist.isPlaying()) {
			artist.startPlaying();
		}
		assertTrue(artist.isPlaying());
		artist.stopPlaying();
		assertFalse(artist.isPlaying());
	}
	
	@Test
	public void testArtistFeed() throws AlreadyFedException, NotPlayingException {
		ZooAnimal mockAnimal = mock(ZooAnimal.class);
		while (!artist.isPlaying()) {
			artist.startPlaying();
		}
		artist.feed(mockAnimal);
		verify(mockAnimal, times(1)).feed();
	}

}
