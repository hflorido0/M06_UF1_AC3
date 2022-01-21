package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="product")
public class Jugador {
	
	@XmlAttribute(name="id")
	private String id;
	
	@XmlElement(name="nombre")
	private String nombre;
	
	@XmlElement(name="alta")
	private Alta alta;
	
	@XmlElementWrapper(name="objetos")
	@XmlElement(name="objeto")
	private ArrayList<Objeto> objetos;
	
	@XmlElementWrapper(name="temtems")
	@XmlElement(name="temtem")
	private ArrayList<Temtem> temtems;
	
	public Jugador() {};
	
	public Jugador(String id, Alta alta, ArrayList<Objeto> objetos,
			ArrayList<Temtem> temtems) {
		this.id = id;
		this.alta = alta;
		this.objetos = objetos;
		this.temtems = temtems;
	}
	
	public ArrayList<Temtem> getTemtems() {
		return temtems;
	}
	
	public String getId() {
		return id;
	}
	
	public Alta getAlta() {
		return alta;
	}
	
	public ArrayList<Objeto> getObjetos() {
		return objetos;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre= " + nombre + ", alta=" + alta + ", objetos=" + countObjetos()
				+ ", temtems=" + countTemtems() + "]";
	}

	private int countObjetos() {
		int count = 0;
		for (Objeto o : this.objetos) {
			count += Integer.parseInt(o.getCantidad());
		}
		return count;
	}

	private int countTemtems() {
		return this.temtems.size();
	}
	
}
