package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="objeto")
public class Objeto {
	
	@XmlAttribute(name="name")
	private String name;
	
	@XmlElement(name="cantidad")
	private String cantidad;

	public Objeto() {};
	
	public Objeto(String name, String cantidad) {
		this.name = name;
		this.cantidad = cantidad;
	}

	public String getName() {
		return name;
	}

	public String getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "Objeto [name=" + name + ", cantidad=" + cantidad + "]";
	}
	
}
