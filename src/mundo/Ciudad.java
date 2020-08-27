package mundo;

import java.util.ArrayList;

public class Ciudad {

	String identificador;
	
	String nombre;
	
	ArrayList<Barrio> barrios;
	
	public Ciudad(String identificador, String nombre) {
		
		this.identificador = identificador;
		this.nombre= nombre;
		barrios = new ArrayList<Barrio>();
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Barrio> getBarrios() {
		return barrios;
	}

	public void setBarrios(ArrayList<Barrio> barrios) {
		this.barrios = barrios;
	}
}
