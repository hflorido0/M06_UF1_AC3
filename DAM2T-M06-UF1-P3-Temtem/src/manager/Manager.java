package manager;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dao.JaxbMarshaller;
import dao.JaxbUnMarshaller;
import dao.Reader;
import model.Atributo;
import model.Jugador;
import model.Jugadores;
import model.Temtem;

public class Manager {
	private static Manager manager;
	private Reader reader;
	private Jugadores jugadores;
	private ArrayList<Temtem> temtems;

	private Manager () {
		this.reader = new Reader("files/acciones.txt");
		this.temtems = new ArrayList<>();
	}
	
	public static Manager getInstance() {
		if (manager == null) {
			manager = new Manager();
		}
		return manager;
	}

	public void init() {
		JaxbUnMarshaller unMarshaller = new JaxbUnMarshaller();
		jugadores = (Jugadores) unMarshaller.init(Jugadores.class, "files/entrada.xml");
		volcadoTemtem();
		readFile(jugadores);
		(new JaxbMarshaller()).init(Jugadores.class, jugadores, "files/salida.xml");
	}
	
	private void volcadoTemtem() {
		for (Jugador j : jugadores.getJugadores()) {
			this.temtems.addAll(j.getTemtems());
		}
	}

	public void readFile(Jugadores jugadores) {
		String line;
		boolean fin = false;
		while (!fin) {
			line = reader.read();
			System.out.println(line);
			fin = acciones(line.split(" "));
		}
	}
	
	private boolean acciones(String[] split) {
		switch (split[0]) {
			case "M":
				if (split.length != 2) System.out.println("Accion erronea");
				else show(split[1]);
				break;
			case "P":
				if (split.length != 2) System.out.println("Accion erronea");
				else character(split[1]);
				break;
			case "B":
				if (split.length != 3) System.out.println("Accion erronea");
				else delete(split[1], split[2]);
				break;
			case "A":
				if (split.length != 12) System.out.println("Accion erronea");
				else add(split[1], split[2], split[3], split[4], split[5], split[6], 
						split[7], split[8], split[9], split[10], split[11]);
				break;
			case "S":
				return true;
			default:
				System.out.println("Accion erronea");
		}
		return false;
	}

	private void add(String pj, String id, String nombre, String tipo, String ps,
			String atq, String satq, String sta, String vel,
			String def, String sdef) {
		
		Jugador j = getJugadorById(pj);
		if (j == null) System.out.println("Jugador no encontrado");
		else {
			ArrayList<Atributo> atributos = new ArrayList<>();
			atributos.add(new Atributo("PS", ps));
			atributos.add(new Atributo("ATQ", atq));
			atributos.add(new Atributo("SATQ", satq));
			atributos.add(new Atributo("STA", sta));
			atributos.add(new Atributo("VEL", vel));
			atributos.add(new Atributo("DEF", def));
			atributos.add(new Atributo("SDEF", sdef));
			
			j.getTemtems().add(new Temtem(id, nombre, tipo, atributos));
			System.out.println("Temtem anadido");
		}
		
	}

	private void delete(String idPj, String idTemtem) {
		Jugador j = getJugadorById(idPj);
		if (j == null) System.out.println("Jugador no encontrado");
		else {
			Temtem t = getTemtemById(j.getTemtems(), idTemtem);
			if (t == null) System.out.println("Temtem no encontrado");
			else {
				j.getTemtems().remove(t);
				System.out.println("Temtem borrado");
			}
		}
	}

	private void character(String id) {
		Jugador j = getJugadorById(id);
		if (j != null) System.out.println(j.toString());
		else System.out.println("Jugador no encontrado");
	}

	private void show(String id) {
		Temtem t = getTemtemById(this.temtems, id);
		if (t != null) {
			showImage(t.getNombre());
			for (Atributo a : t.getAtributos()) {
				System.out.println(a.getId() + " - " + a.getAtributo());
			}
		}
		else System.out.println("Temtem no encontrado");
	}
	
	private Temtem getTemtemById(ArrayList<Temtem> temtems, String id) {
		for (Temtem t : temtems) {
			if (t.getId().equals(id)) return t;
		}
		return null;
	}
	
	private Jugador getJugadorById(String id) {
		for (Jugador j : this.jugadores.getJugadores()) {
			if (j.getId().equals(id)) return j;
		}
		return null;
	}

	public void showImage(String temtem) {
		JFrame f = new JFrame();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        f.setUndecorated(true);

        ImageIcon image = new ImageIcon("files/" + temtem + ".jpg");

        JLabel lbl = new JLabel(image);

        f.getContentPane().add(lbl);

        f.setSize(image.getIconWidth(), image.getIconHeight());

        int x = (screenSize.width - f.getSize().width)/2;
        int y = (screenSize.height - f.getSize().height)/2;

        f.setLocation(x, y);
        f.setVisible(true);
        
        
        f.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				f.dispose();
				f.setVisible(false);
			}
            
        });
        
        try {
			System.in.read();
		} catch (IOException e1) {
			System.out.println("ERROR");
		}
	}
	
}
