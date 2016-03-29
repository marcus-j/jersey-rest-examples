package de.marcusjanke.examples.jersey2springexample.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import de.marcusjanke.examples.jersey2springexample.model.Car;

/**
 * 
 * @author Marcus Janke
 *
 */
public class InMemoryCarRepository implements CarRepository {

	private Map<Long, Car> cars = new ConcurrentHashMap<Long, Car>();

	@Override
	public synchronized void addCar(final Car car)
			throws CarRepositoryException {
		if (cars.containsKey(car.getId())) {
			throw new CarRepositoryException(
					"Duplicate id. Cannot add car.");
		} else {
			cars.put(car.getId(), car);
		}
	}
	
	@Override
	public Car getCarById(final long id)
			throws CarRepositoryException {
		if (cars.containsKey(id)) {
			return cars.get(id);
		} else {
			throw new CarRepositoryException("Unknown car id.");
		}
	}
}
