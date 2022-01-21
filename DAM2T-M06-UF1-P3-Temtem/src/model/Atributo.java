package model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name="atributo")
public class Atributo {
	
	@XmlAttribute(name="id")
	private String id;
	
	@XmlValue
	private String atributo;
	
	public Atributo() {};

	public Atributo(String id, String atributo) {
		this.id = id;
		this.atributo = atributo;
	}

	public String getId() {
		return id;
	}

	public String getAtributo() {
		return atributo;
	}

	@Override
	public String toString() {
		return "Atributo [id=" + id + ", atributo=" + atributo + "]";
	}

}
