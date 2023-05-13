package ui;


import java.util.Scanner;
import entities.*;
import logic.Login;
import java.util.LinkedList;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Persona p=login();
		System.out.println("Bienvenido "+p.getNombre()+" "+p.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(this.getAll());
			break;
			
		case "find":
			System.out.println(this.getByDoc());
			break;
			
		case "search":
			System.out.println(this.getByAp());
	
			break;
			
		case "new":
			System.out.println(this.add());
			
			break;
			
		case "edit":
			System.out.println(this.update());
			break;
			
		case "delete":
			this.deleteByDoc();
			System.out.println("<Persona eliminada exitosamente>");
			break;
			
		case "exit":
			System.out.println("Terminando la aplicación...");
			break;
			
		default: break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("list\t\tlistar todos");
		System.out.println("find\t\tbuscar por tipo y nro de documento"); //solo debe devolver 1
		System.out.println("search\t\tlistar por apellido"); //puede devolver varios
		System.out.println("new\t\tcrea una nueva persona y asigna un rol existente");
		System.out.println("edit\t\tbusca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("delete\t\tborra por tipo y nro de documento");
		System.out.println("exit\t\tsalir de la aplicación");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona p=new Persona();
		
		System.out.print("Email: ");
		p.setEmail(s.nextLine());
		
		System.out.print("Password: ");
		p.setPassword(s.nextLine());
		
		p=ctrlLogin.validate(p);
		
		return p;
		
	}
	
	private LinkedList<Persona> getAll(){
		return(ctrlLogin.getAll());
	}
	
	private Persona getByDoc() {
		System.out.println();
		Persona p=new Persona();
		Documento d=new Documento();
		p.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipo(s.nextLine());

		System.out.print("Nro doc: ");
		d.setNro(s.nextLine());
		
		return ctrlLogin.getByDocumento(p);
	}
	
	private LinkedList<Persona> getByAp(){
		Persona pers = new Persona();
		System.out.println("Apellido a buscar:");
		pers.setApellido(s.nextLine());
		return(ctrlLogin.getByAp(pers));
	}
	
	private Persona add() {
		return(ctrlLogin.add(this.persDataInput()));
	}
	
	private Persona persDataInput() {
		String selection=null;
		boolean habilitado;
		
		Persona pers = new Persona();
		Documento doc = new Documento();
		pers.setDocumento(doc);
		System.out.println("Nombre:");
		pers.setNombre(s.nextLine());
		System.out.println("Apellido:");
		pers.setApellido(s.nextLine());
		System.out.println("Tipo de documento:");
		doc.setTipo(s.nextLine());
		System.out.println("Número de documento:");
		doc.setNro(s.nextLine());
		System.out.println("Email:");
		pers.setEmail(s.nextLine());
		System.out.println("Contraseña:");
		pers.setPassword(s.nextLine());
		System.out.println("Teléfono:");
		pers.setTel(s.nextLine());
		
		System.out.println("¿Está habilitado? S/N: ");
		selection=s.nextLine();
		if (selection.equalsIgnoreCase("S")) {
			habilitado=true;
		}
		else {
			habilitado=false;
		}
		pers.setHabilitado(habilitado);
		
		this.rolDataInput(pers);
		
		return(pers);
	}
	
	private void rolDataInput(Persona pers) {
		boolean option;
		do {
			Rol rol = new Rol();
			String selection=null;
			System.out.println("Ingrese el id del rol:");
			rol.setId(Integer.parseInt(s.nextLine()));
			rol=ctrlLogin.getById(rol);
			pers.addRol(rol);
			System.out.println();
			System.out.println("¿Desea agregar otro rol? S/N:");
			selection=s.nextLine();
			if (selection.equalsIgnoreCase("S")) {
				option=true;
			}
			else {
				option=false;
			}
		}while (option);
	}
	
	private Persona update() {
		int id = this.getByDoc().getId();
		Persona pers = persDataInput();
		pers.setId(id);
		return(ctrlLogin.update(pers));
	}
	
	private void deleteByDoc() {
		ctrlLogin.delete(this.getByDoc());
	}
	
}