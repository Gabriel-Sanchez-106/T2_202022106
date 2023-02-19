package taller2.modelo;

import java.util.*;

public class ProductoAjustado implements Producto {
	
	ProductoMenu main ;
	String nombre;
	int precio;
	List<Ingrediente> movil;
	List<Ingrediente> movilq;
	
	public ProductoAjustado(ProductoMenu base) {
		this.nombre = base.getNombre() ;
		this.precio = base.getPrecio() ;
		movil = new ArrayList<Ingrediente>();
		movilq= new ArrayList<Ingrediente>();
	}

	public String getNombre() {
		return nombre ;		
	}
	
	public int getPrecio() {
		return precio ;
	}
	
	public String generarTextoFactura() {
		String y = "P: "+this.nombre+" V: "+this.precio+"\n";
		
		int i=0;
		
		while (i<movil.size()) {
			y=y+"SI: "+movil.get(i).getNombre()+"\n";
			i+=1;
		}
		
		int j=0;
		
		while (j<movilq.size()) {
			y=y+"NO: "+movilq.get(j).getNombre()+"\n";
			j+=1;
		}
		
		return y;		
	}
	
	public void elecciones(Ingrediente main) {
		
		precio+= main.getCostoAdicional();
		movil.add(main) ;
		
	}
	
	public void eleccionesq(Ingrediente main) {
		movilq.add(main);
	}
}
