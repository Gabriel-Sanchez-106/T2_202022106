package taller2.modelo;

import java.util.*;

public class Combo implements Producto {
	
	List<String> objetos ;
	int porcentaje;
	int costo;
	String nombre;
	
	public Combo(String name, int valor, int porcentaje) {
		this.costo = valor ;
		this.nombre = name ;
		this.porcentaje = porcentaje;
		this.objetos= new ArrayList<String>();
	}
	
	public void agregarObjACombo(Producto itemC) {
		
		int costoneto=itemC.getPrecio();
		costo+=(100-porcentaje)*(costoneto)/100;
		this.objetos.add(itemC.getNombre());
		
	}

	public int getPrecio() {
		return costo ;
		
	}
	
	public String generarTextoFactura() {
		return ("P: "+nombre+ ", V:"+ costo);
		
	}
	
	public String getNombre() {
		return nombre ;
		
	}
}
