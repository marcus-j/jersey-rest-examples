package de.marcusjanke.examples.jersey2swagger.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import de.marcusjanke.examples.jersey2swagger.services.RandomNameService;

/**
 * Service interface implementation with Spring component annotation for resource injection
 * @author Marcus Janke
 *
 */
@Component
public class MyRandomNameService implements RandomNameService {

	private final List<String> randomNames;	
	private final Logger logger = LoggerFactory.getLogger(MyRandomNameService.class);
	
	public MyRandomNameService() {
		randomNames = Arrays.asList("Joe", "Danny", "Julia");
		logger.info("MyRandomNameService created.");
	}

	public String getRandomName() {
		return randomNames.get(new Random().nextInt(randomNames.size()));
	}

}
