package ej5aIndex;

import ej5aEntidades.*;
import java.util.Scanner;
public class index {
	
	static Scanner lector = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		boolean another;
		String opcion;
		Empleado[] arregloEmpleados = new Empleado[20];
		int cantEmpleados=0;
		
		do {
			System.out.println("Ingrese:    (A) - Administrativo // (V) - Vendedor");
			opcion = lector.nextLine();
			Empleado emp = createEmp(opcion);
			arregloEmpleados[cantEmpleados] = emp;
			cantEmpleados++;
			System.out.println();
			System.out.println("¿Desea cargar otro empleado?  (S)//(N)");
			opcion = lector.nextLine();
			if (opcion.equals("S")){
				another=true;
			}
			else {
				another=false;
			}
		}while(another==true && cantEmpleados<20);
		
		lector.close();
		
		System.out.println();
		System.out.println();
		System.out.println("Empleados:");
		
		for (int i=0;i<cantEmpleados;i++) {
			
			System.out.println(arregloEmpleados[i].getDni()+" - "+arregloEmpleados[i].getApellido()+", "+arregloEmpleados[i].getNombre()+" - Sueldo de $"+arregloEmpleados[i].getSueldo());
		}
		
	}

	
	private static Empleado createEmp(String opcion) {
		int dni;
		String nombre;
		String apellido;
		String email;
		float sueldoBase;
		System.out.println("Ingrese dni: ");
		dni=Integer.parseInt(lector.nextLine());
		System.out.println("Ingrese nombre: ");
		nombre=lector.nextLine();
		System.out.println("Ingrese apellido: ");
		apellido=lector.nextLine();
		System.out.println("Ingrese email: ");
		email=lector.nextLine();
		System.out.println("Ingrese sueldo base: ");
		sueldoBase=Float.parseFloat(lector.nextLine());
		if (opcion.equals("A")){
			return(createAdm(dni,nombre,apellido,email,sueldoBase));
		}
		else /*(opcion es "V")*/ {
			return(createVend(dni,nombre,apellido,email,sueldoBase));
		}
	}


	private static Empleado createAdm(int dni, String nombre, String apellido, String email, float sueldoBase) {
		float hsExtra;
		float hsMes;
		System.out.println("Ingrese horas extra: ");
		hsExtra=Float.parseFloat(lector.nextLine());
		System.out.println("Ingrese horas mes: ");
		hsMes=Float.parseFloat(lector.nextLine());
		Empleado admin = new Administrativo(dni,nombre,apellido,email,sueldoBase,hsExtra,hsMes);
		return(admin);
	}
	
	
	private static Empleado createVend(int dni, String nombre, String apellido, String email, float sueldoBase) {
		float porcenComision;
		float totalVentas;
		System.out.println("Ingrese el porcentaje de comisión: ");
		porcenComision=Float.parseFloat(lector.nextLine());
		System.out.println("Ingrese el total de ventas: ");
		totalVentas=Float.parseFloat(lector.nextLine());
		Empleado vend = new Vendedor (dni,nombre,apellido,email,sueldoBase,porcenComision,totalVentas);
		return(vend);
	}
	
}
