package taller2.modelo;

public class ProductoMenu implements Producto {
	
	String nombre;
	int precio;

	public ProductoMenu(String name, int price ) {
		this.nombre = name;
		this.precio = price;
		
	}
	
	public String getNombre() {
		return nombre;
		
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String generarTextoFactura() {
		return ("P: "+ nombre +", V: "+ precio);
		
	}
	

}
