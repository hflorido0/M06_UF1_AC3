package model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="jugadores")
public class Jugadores {
	
	@XmlElement(name="jugador")
	private ArrayList<Jugador> jugadores;
	
	public Jugadores () {};
	
	public Jugadores (ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	@Override
	public String toString() {
		return "Jugadores [jugadores=" + jugadores + "]";
	}
	
	
}
