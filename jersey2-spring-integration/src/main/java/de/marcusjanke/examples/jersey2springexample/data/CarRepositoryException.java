package de.marcusjanke.examples.jersey2springexample.data;

import org.springframework.util.Assert;

/**
 * 
 * @author Marcus Janke
 *
 */
public class CarRepositoryException extends Exception {

	private static final long serialVersionUID = 1034725553489604879L;

	public CarRepositoryException(String message) {
		super(message);
		Assert.notNull(message, "Message cannot be null.");
	}
}
