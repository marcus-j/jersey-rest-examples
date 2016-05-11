package de.marcusjanke.examples.jersey2swagger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.marcusjanke.examples.jersey2swagger.services.RandomNameService;

/**
 * Sample JAX-RS resource with Spring annotated injections
 * @author Marcus Janke
 *
 */
@Component
@Path("/greet")
public class GreetResource {
	
	@Autowired
	private RandomNameService randomNameService;
	private final Logger logger = LoggerFactory.getLogger(GreetResource.class);
	
	public GreetResource() {
		logger.info("GreetResource created.");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/person")
	public Response getRandomNameGreeting() {
		return Response.ok().entity(String.format("Hello %s!", randomNameService.getRandomName())).build();
	}
}
