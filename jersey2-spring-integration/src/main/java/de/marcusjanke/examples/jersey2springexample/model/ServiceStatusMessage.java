package de.marcusjanke.examples.jersey2springexample.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.util.Assert;

/**
 * 
 * @author Marcus Janke
 *
 */
@XmlRootElement
public class ServiceStatusMessage {

	public final static ServiceStatusMessage OK = new ServiceStatusMessage("OK");
	public final static ServiceStatusMessage NOT_FOUND = new ServiceStatusMessage("Not found");
	public final static ServiceStatusMessage INTERNAL_ERROR = new ServiceStatusMessage("Internal error");

	private String status;

	public ServiceStatusMessage() {
		super();
	}

	public ServiceStatusMessage(final String status) {
		super();
		setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(final String status) {
		Assert.notNull(status, "Status message cannot be null");
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(status);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceStatusMessage other = (ServiceStatusMessage) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}
