package de.marcusjanke.examples.jersey2springexample.resources;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.marcusjanke.examples.jersey2springexample.data.CarRepository;
import de.marcusjanke.examples.jersey2springexample.data.CarRepositoryException;
import de.marcusjanke.examples.jersey2springexample.model.Car;
import de.marcusjanke.examples.jersey2springexample.model.ServiceStatusMessage;

/**
 * 
 * @author Marcus Janke
 *
 */
@Component
@Singleton
@Path("/carservice")
public class CarResource {

	@Autowired
	CarRepository carRepository;
	
	private Logger logger = LoggerFactory.getLogger(CarResource.class);

	public CarResource() {
		super();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/car/{id}")
	public Response getCarById(@PathParam("id") long id) {
		final Car car;
		try {
			car = carRepository.getCarById(id);
			logger.info("Retrieval of car by id succeeded.");
		} catch (CarRepositoryException e) {
			logger.error("Retrieval of car by id failed.");
			return Response.status(Status.NOT_FOUND).entity(ServiceStatusMessage.NOT_FOUND).build();
		}
		return Response.ok().entity(car).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/car/{id}")
	public Response addTransactionById(@PathParam("id") long id,
			Car car) {
		try {
			car.setId(id);
			carRepository.addCar(car);
			logger.info("Adding a car succeeded.");
		} catch (CarRepositoryException e) {
			logger.error("Adding a car failed.");
			return Response.status(Status.CONFLICT).entity(ServiceStatusMessage.INTERNAL_ERROR).build();
		}
		return Response.ok().entity(ServiceStatusMessage.OK).build();
	}
}