package de.marcusjanke.examples.jersey2springexample.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Marcus Janke
 *
 */
@XmlRootElement
public class Car {

	private Long id;
	private String type;

	public Car() {
		super();
	}

	public Car(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
