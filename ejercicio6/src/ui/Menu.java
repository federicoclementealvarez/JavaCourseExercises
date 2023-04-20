package ui;

import java.util.Scanner;
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
				System.out.println(this.list());
				break;
			case "search":
				System.out.println(this.search());
				break;
			/*case "new":
				System.out.println(this.nuevo());
				break;
			case "delete":
				System.out.println(this.delete());
				break;
			case "update":
				System.out.println(this.update());
				break;*/
		}	
		System.out.println();
		System.out.println("Oprima <<ENTER>> para continuar:");
		lector.nextLine();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}
	
	private String list() {
		return(instLogin.list().toString());
	}
	
	private String search() {
		Producto prod = new Producto();
		System.out.println("Ingrese ID del producto: ");
		prod.setId (Integer.parseInt(lector.nextLine()));
		return(instLogin.search(prod).toString());
	}
}
