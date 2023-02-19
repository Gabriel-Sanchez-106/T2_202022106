package taller2.modelo;

import java.io.*;
import java.util.*;

public class Restaurante {
	
	Pedido current ;
	ArrayList<Pedido> pedidos ;
	HashMap<String,ProductoMenu> menu ;
	HashMap<String,Combo> combos ;
	HashMap<String,Ingrediente> ingredientes ;
	HashMap<String,Bebidas> bebidas ;

	public Restaurante() {
		pedidos= new ArrayList<Pedido>();
		menu   = new HashMap<String,ProductoMenu>();
		combos = new HashMap<String,Combo>();
		ingredientes = new HashMap<String,Ingrediente>();
		bebidas = new HashMap<String, Bebidas>();
	}
	
	public void iniciarPedido(String nc, String dc) {
		
		Pedido main = new Pedido(nc, dc) ;
		current = main ;
		
				
	}
	
	public void cerrarYGuardarPedido() {

		Pedido temp = new Pedido(current.getDIR() , current.getNAME() , current.getPedido(), current.getCosas()) ;
		pedidos.add(temp) ;
		current.guardarFactura();
		current = null ;
	}
	
	public Pedido getPedidoID(int id) {
		
		return pedidos.get(id);
	}
	
	public Pedido getPedidoEnCurso() {
		
		return current;
	}
	
	public boolean hayPedido() {
		
		if (current == null) {
			return false;
		} else {
			return true;
		}
		
	}
	
	public ArrayList<Producto> getMenuBase() {
		ArrayList<Producto> productos = new ArrayList<>(combos.values());
		productos.addAll(bebidas.values());
		productos.addAll(menu.values());
		return productos ;
	}
	
	public HashMap<String,ProductoMenu> getMenuAj() {
		return menu ;
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		ArrayList<Ingrediente> ing = new ArrayList<>(ingredientes.values());
		return ing ;
		
	}
	
	public void cargarInfoRestaurante() {
		
		current = null;
		cargarMenu();
		cargarBebidas();
		cargarIngredientes();
		cargarCombos() ;
		
	}
	
	private void cargarIngredientes() {

		try {
			BufferedReader br = new BufferedReader(new FileReader("data/ingredientes.txt"));
			String linea = br.readLine() ;
		
			while (linea != null) {
				String[] partes = linea.split(";") ;
			
				String add = partes[0];
				int costo = Integer.parseInt(partes[1]) ;
				int cal = Integer.parseInt(partes[2]) ;
				
				Ingrediente lec = new Ingrediente(add, costo, cal) ;
				
				ingredientes.put(add,lec) ;
				
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Unexpected, ingredientes") ;
		}
	}			
	
	private void cargarMenu() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/menu.txt"));
			String linea = br.readLine() ;
			
			while (linea != null) {
				String[] partes = linea.split(";") ;
			
				String obj = partes[0];
				int costo = Integer.parseInt(partes[1]) ;
				int cal = Integer.parseInt(partes[2]) ;
				
				ProductoMenu lec = new ProductoMenu(obj, costo, cal) ;
				menu.put(obj,lec) ;
				
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Unexpected, menu") ;
		}
	}
	private void cargarBebidas() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/bebidas.txt"));
			String linea = br.readLine() ;
			
			while (linea != null) {
				String[] partes = linea.split(";") ;
			
				String obj = partes[0];
				int costo = Integer.parseInt(partes[1]) ;
				int cal = Integer.parseInt(partes[2]) ;
				
				Bebidas lec = new Bebidas(obj, costo, cal) ;
				bebidas.put(obj,lec) ;
				
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println("Unexpected, menu") ;
		}
	}	
		
	private void cargarCombos() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/combos.txt"));
			String linea = br.readLine() ;
		
			while (linea != null) {
				String[] partes = linea.split(";") ;
			
				String nombre = partes[0];
				partes[1]=partes[1].replace("%", "");
				
				int porcentaje = Integer.parseInt(partes[1]) ;
				
				int i=2;
				Combo lec = new Combo(nombre, 0, porcentaje, 0);
				while (i<partes.length){
					String name = partes[i];
					
					if(menu.containsKey(name)) {
						ProductoMenu obj=menu.get(partes[i]);
						lec.agregarObjACombo(obj);
					}else {
						Bebidas obj=bebidas.get(partes[i]);
						lec.agregarObjACombo(obj);
					}

					i+=1;
				}
				
				combos.put(nombre, lec) ;
				
				linea = br.readLine() ;
				
			}
			br.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Unexpected, combos") ;
		}
	}
	
	public boolean verificar() {
		
		for (Pedido main: pedidos) {

			boolean a = current.getNAME().equals(main.getNAME()) ;
			boolean b = current.getDIR().equals(main.getDIR()) ;

			if(a && b) {
				return true ;
			}

		}
		return false;
	}
}
