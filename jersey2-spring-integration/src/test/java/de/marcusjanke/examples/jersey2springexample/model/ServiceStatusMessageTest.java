package de.marcusjanke.examples.jersey2springexample.model;

import static org.junit.Assert.*;

import org.junit.Test;

import de.marcusjanke.examples.jersey2springexample.model.ServiceStatusMessage;

public class ServiceStatusMessageTest {
	
	private final static String MOCK_STATUS_MESSAGE = "StatusMessage";

	@Test
	public void testServiceStatusInstantiation() {
		final ServiceStatusMessage status = new ServiceStatusMessage(MOCK_STATUS_MESSAGE);
		assertEquals("ServiceStatusMessage status does not match.", status.getStatus(), MOCK_STATUS_MESSAGE);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testServiceStatusInstantiationMessageNotNull() {
		@SuppressWarnings("unused")
		final ServiceStatusMessage status = new ServiceStatusMessage(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testServiceStatusSetMessageNotNull() {
		final ServiceStatusMessage status = new ServiceStatusMessage(MOCK_STATUS_MESSAGE);
		status.setStatus(null);
	}	

	@Test
	public void testServiceStatusEquals() {
		final ServiceStatusMessage status1 = new ServiceStatusMessage(MOCK_STATUS_MESSAGE);
		final ServiceStatusMessage status2 = new ServiceStatusMessage("StatusMessage");
		assertEquals("ServiceStatusMessage equals should be true.", status1, status2);
	}

	@Test
	public void testServiceStatusNotEquals() {
		final ServiceStatusMessage status1 = new ServiceStatusMessage("StatusMessage1");
		final ServiceStatusMessage status2 = new ServiceStatusMessage("StatusMessage2");
		assertNotEquals("ServiceStatusMessage equals should be false.", status1, status2);
	}

	@Test
	public void testServiceStatusHashCode() {
		final ServiceStatusMessage status1 = new ServiceStatusMessage("StatusMessage");
		final ServiceStatusMessage status2 = new ServiceStatusMessage("StatusMessage");
		assertEquals("ServiceStatusMessage hashCode should be true.", status1.hashCode(), status2.hashCode());
	}
}
