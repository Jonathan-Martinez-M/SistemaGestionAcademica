package mundo;

public class Barrio {
	
	String identificadorCiudad;
	
	String nombre;

	public Barrio(String identificadorCiudad, String nombre) {
		
		this.identificadorCiudad = identificadorCiudad;
		this.nombre = nombre;
	}

	public String getIdentificadorCiudad() {
		return identificadorCiudad;
	}

	public void setIdentificadorCiudad(String identificadorCiudad) {
		this.identificadorCiudad = identificadorCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
