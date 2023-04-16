package Test1;

import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		/*System.out.println("Holis");
		String[] arreglo = new String[10];
		Scanner lector = new Scanner(System.in);
		for (int i=0; i<10;i++) {
			System.out.println("Ingrese el siguiente elemento: ");
			arreglo[i] = lector.nextLine();
		}
		lector.close();
		System.out.println();
		for (int i=9;i>=0;i--) {
			System.out.println((i+1)+"°: "+arreglo[i]);
		}*/
		String opcion;
		Scanner lector = new Scanner(System.in);
		opcion=lector.nextLine();
		System.out.println((opcion.equals("A")));
		
	}
}
