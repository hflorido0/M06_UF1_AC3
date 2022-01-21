package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="temtem")
public class Temtem {

	@XmlAttribute(name="id")
	private String id;
	
	@XmlElement(name="nombre")
	private String nombre;

	@XmlElement(name="tipo")
	private String tipo;
	
	@XmlElement(name="atributo")
	private ArrayList<Atributo> atributos;
	
	public Temtem() {};

	public Temtem(String id, String nombre, String tipo,
			ArrayList<Atributo> atributos) {
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.atributos = atributos;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	@Override
	public String toString() {
		return "Temtem [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo
				+ ", atributos=" + atributos + "]";
	}
	
}
