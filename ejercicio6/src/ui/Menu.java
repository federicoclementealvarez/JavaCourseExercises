package ui;

import java.util.Scanner;
import java.util.LinkedList;
import entities.*;
import logic.*;


public class Menu {

	Scanner lector = null;
	Login instLogin = new Login();
	
	public void start(){
		String opcion;
		lector = new Scanner(System.in);
		
		do {
			opcion=mostrador();
			elector (opcion);
		}while (!opcion.equalsIgnoreCase("exit"));
		
		lector.close();
	}
	
	private String mostrador() {
		System.out.println("Menú Productos:");
		System.out.println();
		System.out.println("\tlist\t-\tListar todos los productos");
		System.out.println("\tsearch\t-\tObtener los datos de un producto según su ID");
		System.out.println("\tnew\t-\tCargar nuevo producto");
		System.out.println("\tdelete\t-\tEliminar un producto de la base de datos");
		System.out.println("\tupdate\t-\tModificar los datos de un producto");
		System.out.println("\texit\t-\tSalir de la aplicación");
		System.out.println();
		System.out.println("Ingrese una opción:");
		return(lector.nextLine());
	}
	
	private void elector(String opcion) {
		
		switch (opcion) {
			
			case "list":
				System.out.println(this.list().toString());
				break;
			case "search":
				System.out.println(this.search().toString());
				break;
			case "new":
				System.out.println(this.nuevo().toString());
				break;
			case "delete":
				System.out.println(this.delete());
				break;
			case "update":
				System.out.println(this.update());
				break;
		}	
		System.out.println();
		System.out.println("Oprima <<ENTER>> para continuar:");
		lector.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}
	
	private LinkedList<Producto> list() {
		return(instLogin.list());
	}
	
	private Producto search() {
		Producto prod = new Producto();
		System.out.println("Ingrese ID del producto: ");
		prod.setId (Integer.parseInt(lector.nextLine()));
		return(instLogin.search(prod));
	}
	
	private Producto nuevo() {
		Producto prod = new Producto();
		prod = cargarDatos();
		return(instLogin.nuevo(prod));
	}
	
	private String delete() {
		Producto prod = new Producto();
		System.out.println("Ingrese el ID del producto a eliminar:");
		prod.setId(Integer.parseInt(lector.nextLine()));
		instLogin.delete(prod);
		return ("El registro se ha eliminado exitosamente");
	}
	
	private String update() {
		Producto prod = new Producto();
		int ID;
		prod=this.search();
		System.out.println(prod.toString());
		ID = prod.getId();
		//System.out.println("Pasó");
		prod = cargarDatos();
		prod.setId(ID);
		instLogin.update(prod);
		return("Registro actualizado existosamente");
	}
	
	private Producto cargarDatos(){
		Producto prod = new Producto();
		String selection;
		boolean shipping;
		System.out.println("Ingrese nombre del producto: ");
		prod.setName (lector.nextLine());
		System.out.println("Ingrese descripción del producto: ");
		prod.setDescription (lector.nextLine());
		System.out.println("Ingrese precio del producto: ");
		prod.setPrice (Double.parseDouble(lector.nextLine()));
		System.out.println("Ingrese stock del producto: ");
		prod.setStock (Integer.parseInt(lector.nextLine()));
		System.out.println("¿Incluye envío? S/N: ");
		selection=lector.nextLine();
		if (selection.equalsIgnoreCase("S")) {
			shipping=true;
		}
		else {
			shipping=false;
		}
		prod.setShippingIncluded(shipping);
		return(prod);
	}
}
