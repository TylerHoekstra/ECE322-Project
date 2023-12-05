package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import org.mockito.Mockito.*

import ece325_lab_assignment4.Zoo;
import ece325_lab_assignment4.ZooAnimal;

class ZooTest {
	
	Zoo zoo;
	ArrayList<ZooAnimal> animals;
	ZooAnimal mockAnimal;

	@BeforeEach
	void setUp() throws Exception {
		zoo = new Zoo();
		mockAnimal = mock(ZooAnimal.class);
		animals = spy(new ArrayList<>());
		animals.add(mockAnimal);
	}

	@Test
	void testGetRandomAnimalToComeToStage() {
		
		 try {
	            java.lang.reflect.Field field = Zoo.class.getDeclaredField("animals");
	            field.setAccessible(true);
	            field.set(zoo, animals);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace();
	        }
		 when(mockAnimal.getName()).thenReturn("Mocked Animal");
		 ZooAnimal res = zoo.getRandomAnimalToComeToStage();
		 verify(animals).get(anyInt());
		 verify(mockAnimal).getName();
	}
	
	@Test
	void testAllAnimalsFed() {
		assertFalse(zoo.allAnimalsFed());
		try {
            java.lang.reflect.Field field = Zoo.class.getDeclaredField("animals");
            field.setAccessible(true);
            field.set(zoo, animals);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
		mockAnimal.feed();
		assertTrue(zoo.allAnimalsFed());
	}
}
