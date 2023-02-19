package taller2.modelo;

public class Bebidas implements Producto {
	
	String nombre;
	int precio;
	int calorias;

	public Bebidas(String name, int price , int cal) {
		this.nombre = name;
		this.precio = price;
		this.calorias=cal;
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public int getCal() {
		return calorias;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String generarTextoFactura() {
		return ("P: "+ nombre +", V: "+ precio+" [Cal: "+calorias+" ]");
		
	}
	

}
