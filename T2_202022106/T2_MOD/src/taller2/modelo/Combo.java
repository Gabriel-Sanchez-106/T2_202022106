package taller2.modelo;

import java.util.*;

public class Combo implements Producto {
	
	List<String> objetos ;
	int porcentaje;
	int costo;
	int calorias;
	String nombre;
	
	public Combo(String name, int valor, int porcentaje, int cal) {
		this.costo = valor ;
		this.nombre = name ;
		this.porcentaje = porcentaje;
		this.calorias = cal;
		this.objetos= new ArrayList<String>();
	}
	
	public void agregarObjACombo(Producto itemC) {
		
		int costoneto=itemC.getPrecio();
		costo+=(100-porcentaje)*(costoneto)/100;
		calorias+=itemC.getCal();
		this.objetos.add(itemC.getNombre());
		
	}

	public int getPrecio() {
		return costo ;
		
	}
	
	public String generarTextoFactura() {
		return ("P: "+ nombre +", V: "+ costo + " [Cal: "+ calorias + " ]");
		
	}
	
	public String getNombre() {
		return nombre ;
		
	}
	
	public int getCal() {
		return calorias ;
		
	}
}
