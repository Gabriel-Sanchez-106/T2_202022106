package taller2.modelo;

public class Ingrediente {
	
	String nombre;
	int costo;
	int calorias;

	public Ingrediente(String name, int add, int cal) {
		this.costo = add ;
		this.nombre = name ;
		this.calorias = cal;
		
	}
	
	public String getNombre() { 
		return nombre ;
	}

	public int getCostoAdicional() {
		return costo ;
	}
	
	public int getCal() {
		return calorias;
	}
}
