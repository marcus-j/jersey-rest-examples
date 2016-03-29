package de.marcusjanke.examples.jersey2springexample.data;

import static org.junit.Assert.*;

import org.junit.Test;

import de.marcusjanke.examples.jersey2springexample.data.CarRepository;
import de.marcusjanke.examples.jersey2springexample.data.CarRepositoryException;
import de.marcusjanke.examples.jersey2springexample.data.InMemoryCarRepository;
import de.marcusjanke.examples.jersey2springexample.model.Car;

public class InMemoryCarRepositoryTest {

	@Test
	public void testAddCarValidWithoutParent() throws CarRepositoryException {
		final CarRepository carRepository = new InMemoryCarRepository();
		carRepository.addCar(new Car(0l, "BMW"));
		assertEquals("Transaction not added.", new Car(0l, "BMW"), carRepository.getCarById(0l));
	}

	@Test(expected = CarRepositoryException.class)
	public void testAddCarDuplicate() throws CarRepositoryException {
		final CarRepository carRepository = new InMemoryCarRepository();
		carRepository.addCar(new Car(0l, "BMW"));
		carRepository.addCar(new Car(0l, "BMW"));
	}

	@Test(expected = CarRepositoryException.class)
	public void testGetUnknownCarById() throws CarRepositoryException {
		final CarRepository carRepository = new InMemoryCarRepository();
		carRepository.getCarById(0l);
	}
}
