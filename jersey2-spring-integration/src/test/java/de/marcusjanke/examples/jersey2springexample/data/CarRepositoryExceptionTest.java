package de.marcusjanke.examples.jersey2springexample.data;

import static org.junit.Assert.*;

import org.junit.Test;

import de.marcusjanke.examples.jersey2springexample.data.CarRepositoryException;

public class CarRepositoryExceptionTest {

	private final static String MOCK_EXCEPTION_MESSAGE = "ExceptionMessage";

	@Test
	public void testTransactionRepositoryExceptionInstantiation() {
		final CarRepositoryException exception = new CarRepositoryException(MOCK_EXCEPTION_MESSAGE);
		assertEquals("CarRepositoryException message does not match.", exception.getMessage(), MOCK_EXCEPTION_MESSAGE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testServiceStatusInstantiationMessageNotNull() {
		@SuppressWarnings("unused")
		final CarRepositoryException exception = new CarRepositoryException(null);
	}

}
