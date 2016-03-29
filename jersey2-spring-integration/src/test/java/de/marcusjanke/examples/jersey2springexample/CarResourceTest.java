package de.marcusjanke.examples.jersey2springexample;

import static org.junit.Assert.*;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import de.marcusjanke.examples.jersey2springexample.app.App;
import de.marcusjanke.examples.jersey2springexample.model.Car;
import de.marcusjanke.examples.jersey2springexample.model.ServiceStatusMessage;

public class CarResourceTest extends JerseyTest {
	
	@Override
	protected Application configure() {
		return new App();
	}
    
    @Test
	public void testAddTransactionOk() {
    	final String resourcePath = "carservice/car/1";
		final Car car = new Car();
		car.setType("BMW");
    	Response response = target(resourcePath).request().post(Entity.json(car));
		assertEquals(ServiceStatusMessage.OK, response.readEntity(ServiceStatusMessage.class));
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
    
    @Test
	public void testAddTransactionConflict() {
    	final String resourcePath = "carservice/car/2";
		final Car carIn = new Car();
		carIn.setType("BMW");
		//Add car once
    	Response response1 = target(resourcePath).request().post(Entity.json(carIn));
		assertEquals(ServiceStatusMessage.OK, response1.readEntity(ServiceStatusMessage.class));
		assertEquals(Status.OK.getStatusCode(), response1.getStatus());
		//Try to add same car once more
    	Response response2 = target(resourcePath).request().post(Entity.json(carIn));
		assertEquals(ServiceStatusMessage.INTERNAL_ERROR, response2.readEntity(ServiceStatusMessage.class));
		assertEquals(Status.CONFLICT.getStatusCode(), response2.getStatus());
	}
    
    @Test
	public void testGetTransactionFound() {
    	final String resourcePath = "carservice/car/3";
		final Car carIn = new Car();
		carIn.setType("BMW");
    	target(resourcePath).request().post(Entity.json(carIn));
    	carIn.setId(3l);
		final Car carOut = target(resourcePath).request().get(Car.class);
		assertEquals(carIn, carOut);
	}
    
    @Test
	public void testGetTransactionNotFound() {
    	final String resourcePath = "carservice/car/4";
		final Car carIn = new Car();
		carIn.setType("BMW");
    	target(resourcePath).request().post(Entity.json(carIn));
    	final String otherResourcePath = "carservice/car/2";
		final Response response = target(otherResourcePath).request().get();
		assertEquals(ServiceStatusMessage.NOT_FOUND, response.readEntity(ServiceStatusMessage.class));
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
}