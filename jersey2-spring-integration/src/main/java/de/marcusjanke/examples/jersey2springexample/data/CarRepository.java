package de.marcusjanke.examples.jersey2springexample.data;

import de.marcusjanke.examples.jersey2springexample.model.Car;

/**
 * 
 * @author Marcus Janke
 *
 */
public interface CarRepository {

	public void addCar(final Car car) throws CarRepositoryException;
	
	public Car getCarById (final long carId) throws CarRepositoryException;
}
