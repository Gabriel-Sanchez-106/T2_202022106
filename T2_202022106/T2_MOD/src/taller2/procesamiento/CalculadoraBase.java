package taller2.procesamiento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import taller2.modelo.*;

public class CalculadoraBase {
	
	Restaurante restaurante;
	
	public CalculadoraBase() {
		restaurante= new Restaurante();
		restaurante.cargarInfoRestaurante();
	}

	
	public String formatoMenu() {
		
		ArrayList<Producto> main = restaurante.getMenuBase();
		int i=0 ;
		String r="";
		while (i< main.size()) {
			Producto alpha=main.get(i) ;
			String txt =alpha.generarTextoFactura();
			r=r+i+": "+txt+"\n" ;
			
			i+=1 ;					
		}
		return r;
		
	}
	
	public String textIng() {
		
		ArrayList<Ingrediente> main = restaurante.getIngredientes();
		int i=0 ;
		String r="";
		while (i< main.size()) {
			Ingrediente alpha=main.get(i) ;
			String txt =alpha.getNombre();
			int cst = alpha.getCostoAdicional();
			r=r+i+": "+txt+"---"+cst+"\n" ;
			
			i+=1 ;					
		}
		return r;
	}
		

	
	public void agregar(int num, String nc, String dc) {
		
		ArrayList<Producto> cosas = restaurante.getMenuBase();
		
		if (restaurante.hayPedido()) {
		Pedido current	=restaurante.getPedidoEnCurso();
		current.agregarProducto(cosas.get(num));
		
		} else {
		restaurante.iniciarPedido(nc, dc);
		Pedido current = restaurante.getPedidoEnCurso();
		current.agregarProducto(cosas.get(num));
		}	
	}
	
	public void agregar2(int num, String nc, String dc, ArrayList<Integer> sigma, ArrayList<Integer> pi) {
		ArrayList<Producto> cosas = restaurante.getMenuBase();
		
		if (restaurante.hayPedido()) {
			Pedido current	=restaurante.getPedidoEnCurso();
			String omega = cosas.get(num).getNombre();
			ProductoMenu beta = restaurante.getMenuAj().get(omega);
			ProductoAjustado alpha = new ProductoAjustado(beta);
			
			int i=0;
			while (i<sigma.size()) {
				int k = sigma.get(i);
				int l = pi.get(i);
				Ingrediente delta=restaurante.getIngredientes().get(k);
				
				if (l==1) {
					alpha.elecciones(delta);
				
				}else {
					alpha.eleccionesq(delta);
				}
				i+=1;
				
			}
			
			current.agregarProducto(alpha);
			
			
		} else {
			restaurante.iniciarPedido(nc, dc);
			Pedido current	=restaurante.getPedidoEnCurso();
			String omega = cosas.get(num).getNombre();
			ProductoMenu beta = restaurante.getMenuAj().get(omega);
			ProductoAjustado alpha = new ProductoAjustado(beta);
			
			int i=0;
			while (i<sigma.size()) {
				int k = sigma.get(i);
				int l = pi.get(i);
				Ingrediente delta=restaurante.getIngredientes().get(k);
				
				if (l==1) {
					alpha.elecciones(delta);
				
				} else {
					alpha.eleccionesq(delta);
				}
				i+=1;
				
			}	
			current.agregarProducto(alpha);
			}
	}
	public void cerrarYguardar() {
		restaurante.cerrarYGuardarPedido();
	}
	
	public int recordarme() {
		Pedido ac=restaurante.getPedidoEnCurso();
		return ac.getPedido();
	}
	
	public boolean verificar() {
		boolean ans = restaurante.verificar() ;
		return ans;
	}
	
	public void buscarID(int id) {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/factura"+id+".txt"));
			String linea = br.readLine() ;
		
			while (linea != null) {
				System.out.println(linea);			
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Unexpected, factura no encontrada") ;
		}
		
	}
}
