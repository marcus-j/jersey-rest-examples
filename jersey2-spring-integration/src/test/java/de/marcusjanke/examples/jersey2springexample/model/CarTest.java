package de.marcusjanke.examples.jersey2springexample.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.marcusjanke.examples.jersey2springexample.model.Car;

public class CarTest {

	private final static Long MOCK_ID = 7l;
	private final static String MOCK_TYPE = "BMW";

	@Test
	public void testCarInstantiation() {
		final Car car = new Car(MOCK_ID, MOCK_TYPE);
		assertNotNull("car should not be null.", car);
		assertEquals("car id does not match.", MOCK_ID, car.getId());
		assertEquals("car type does not match.", MOCK_TYPE, car.getType());
	}
	
	@Test
	public void testTransactionEquals() {
		final Car car1 = new Car(MOCK_ID, MOCK_TYPE);
		final Car car2 = new Car(MOCK_ID, MOCK_TYPE);
		assertEquals("car equals should be true.", car1, car2);
	}
	
	@Test
	public void testTransactionNotEqualsId() {
		final Car car1 = new Car(1l, MOCK_TYPE);
		final Car car2 = new Car(2l, MOCK_TYPE);
		assertNotEquals("car equals should be false.", car1, car2);
	}
	
	@Test
	public void testTransactionNotEqualsType() {
		final Car car1 = new Car(MOCK_ID, "BMW");
		final Car car2 = new Car(MOCK_ID, "Audi");
		assertNotEquals("car equals should be false.", car1, car2);
	}

	@Test
	public void testTransactionHashCode() {
		final Car car1 = new Car(MOCK_ID, MOCK_TYPE);
		final Car car2 = new Car(MOCK_ID, MOCK_TYPE);
		assertEquals("car hashCode should be true.", car1.hashCode(), car2.hashCode());
	}
}
