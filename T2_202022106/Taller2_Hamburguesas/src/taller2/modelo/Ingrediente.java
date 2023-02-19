package taller2.modelo;

public class Ingrediente {
	
	String nombre;
	int costo;

	public Ingrediente(String name, int add) {
		this.costo = add ;
		this.nombre = name ;
		
	}
	
	public String getNombre() { 
		return nombre ;
	}

	public int getCostoAdicional() {
		return costo ;
	}
}
