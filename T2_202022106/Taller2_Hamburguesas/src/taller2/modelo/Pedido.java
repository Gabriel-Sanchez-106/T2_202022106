package taller2.modelo;

import java.io.*;
import java.util.*;

public class Pedido {
	
	List<Producto> cosas ;
	static int numPedidos=1;
	int idPedido;
	String nameCliente;
	String dirCliente;
	
	
	public Pedido(String name, String dir) {
		
		this.dirCliente = dir;
		this.nameCliente = name;
		this.idPedido = numPedidos ;
		numPedidos+=1;
		this.cosas= new ArrayList<Producto>();
		
	}
	
	public int getPedido() {
		return idPedido;
		
	}
	
	public void agregarProducto(Producto NewItem) {
		cosas.add(NewItem) ;
		
		
	}
	
	private int getPNP() {
		
		int val=0 ;
		Integer i=0 ;
		while (i< cosas.size()) {
			
			Producto main = cosas.get(i) ;
			val+= main.getPrecio() ;
			
			i+=1 ;	
		}
		
		return val ;
		
	}
	
	public String getNAME() {
		return this.nameCliente;
	}
	
	private String getDIR() {
		return this.dirCliente;
	}
	
	private int getPTP() {
		
		int val = this.getPNP() + this.getPIVAP() ;
		return val ;
		
	}
	
	private int getPIVAP() {
		
		int val = this.getPNP() ;
		return (int)(val*0.19) ;
		
	}
	
	public String generarFactura() {
		
		String r= "" ;
		int i=0 ;
		while (i<cosas.size()) {
			
			Producto main = cosas.get(i) ;
			String txt =main.generarTextoFactura();
			r=r+txt+"\n" ;
			
			i+=1 ;					
		}
		r=r+"Precio Neto : "+this.getPNP()+"\n";
		r=r+"Valor IVA   : "+this.getPIVAP()+"\n";
		r=r+"Precio Total: "+this.getPTP()+"\n";
		r=r+"Nombre Cliente: "+this.getNAME()+"\n"; 
		r=r+"Direccion Cliente: "+this.getDIR()+"\n"; 
		return r ;
		
	}
	
	public void guardarFactura() {
		
		 try {
		      File myObj = new File("data/factura"+this.idPedido+".txt");
		      if (myObj.createNewFile()) {
		        System.out.println("Factura creada con éxito ");
		      } else {
		        System.out.println("Factura encontrara, reemplazando...");
		      }
		 	} catch (Exception e) {
		    	  System.out.println("Unexpected");
		 	}
		 
		 try {
		      FileWriter myWriter = new FileWriter("data/factura"+this.idPedido+".txt");
		      String r = this.generarFactura() ;
		  
		      myWriter.write(r);
		      myWriter.close();
		      System.out.println("Factura redactada exitosamente");
		    } catch (IOException e) {
		      System.out.println("Unexpected");
		    }
		       
	}
	
}
