package taller2.modelo;

public class ProductoMenu implements Producto {
	
	String nombre;
	int precio;
	int calorias;

	public ProductoMenu(String name, int price , int calorias ) {
		this.nombre = name;
		this.precio = price;
		this.calorias = calorias;
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public int getCal() {
		return calorias ;
	}
	
	public String generarTextoFactura() {
		return ("P: "+ nombre +", V: "+ precio + " [Cal: "+ calorias + " ]");
		
	}
	

}
