package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="alta")
public class Alta {
	
	@XmlAttribute(name="ciudad")
	private String ciudad;
	
	@XmlValue
	private String fecha;

	public Alta() {};
	
	public Alta(String ciudad, String fecha) {
		this.ciudad = ciudad;
		this.fecha = fecha;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getFecha() {
		return fecha;
	}

	@Override
	public String toString() {
		return "Alta [ciudad=" + ciudad + ", fecha=" + fecha + "]";
	}
	
}
