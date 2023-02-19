package taller2.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import taller2.procesamiento.*;

public class Aplicacion {
	
	private CalculadoraBase main ;
	private String nc;
	private String dc;

	public Aplicacion() {
		// TODO Auto-generated constructor stub
	}
	
	public void ejecutarAplicacion()
	{
		System.out.println("Aplicación Hamburguesas\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{	
				
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCargarDatos();
				else if (opcion_seleccionada == 2 && main != null && nc != null && dc != null)
					ejecutarMostrarMenu();
				else if (opcion_seleccionada == 3 && main != null && nc != null && dc != null)
					ejecutarAgregarElemento();
				else if (opcion_seleccionada == 4 && main != null && nc != null && dc != null)
					ejecutarCerrarActual();
				else if (opcion_seleccionada == 5 && main != null )
					ejecutarConsultaID();
				else if (opcion_seleccionada == 6)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
				else if (main == null)
				{
					System.out.println("No se han cargado los datos");
				}
				else
				{
					System.out.println("Por favor seleccione una opción válida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public void mostrarMenu()
	{
		
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Cargar datos cliente");
		System.out.println("2. Mostrar menú");
		System.out.println("3. Agregar elemento al pedido actual");
		System.out.println("4. Cerrar un pedido y guardar factura");
		System.out.println("5. Consultar pedido según id");
		System.out.println("6. Salir de la aplicación \n");
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	public void ejecutarCargarDatos() 
	{
		main=  new CalculadoraBase();
		nc = (input("Escriba su nombre    "));
		dc = (input("Escriba su dirección "));
		System.out.println("Datos cargados exitosamente!");
	}
	
	public void ejecutarMostrarMenu()
	{
		System.out.println(main.formatoMenu());
	}
	
	public void ejecutarAgregarElemento() {
		
		int elemento = Integer.parseInt(input("Escriba el número del elemento que desea añadir" ));
		
		if (elemento<4) {
			main.agregar(elemento, nc, dc) ;
		
		} else {
			int a = Integer.parseInt(input("¿Desea añadir o eliminar algún ingrediente? 0-NO , 1-SI "));
			
			if (a==0) {
				main.agregar(elemento, nc, dc);
			} else if(a==1) {
				String ingredientes = main.textIng() ;
				System.out.println(ingredientes);
				int i = Integer.parseInt(input("Escriba el número de elementos que quiere modificar "));
				
				int k=1;
				
				ArrayList<Integer> sigma = new ArrayList<Integer>();
				ArrayList<Integer> pi = new ArrayList<Integer>();
				while (k<=i) {
					
					int j = Integer.parseInt(input("Escriba el número del ingrediente que quiere modificar "));
					int l = Integer.parseInt(input("0-ELIMINAR , 1-AÑADIR "));
					sigma.add(j);
					pi.add(l);
					k+=1;
				}
				
				main.agregar2(elemento, nc, dc, sigma, pi);
			} else {
				System.out.println("Opcion invalida");
			}
		
		}
		System.out.println("Alterado Correctamente!");
	}
	public void ejecutarCerrarActual() {
		int a=main.recordarme();
		System.out.println("El id de su pedido es: "+a );
		main.cerrarYguardar();
		nc = null ;
		dc = null ;
	}
	
	public void ejecutarConsultaID() {
		
		int id = Integer.parseInt(input("Escriba el id a consultar: "));
		main.buscarID(id) ;
	}
	
	public static void main(String[] args)
	{
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
	}

}

