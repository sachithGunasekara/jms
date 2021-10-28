package app.jms.simple.model;

import java.io.Serializable;

public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6234349715088281640L;
	private String id;
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
}
