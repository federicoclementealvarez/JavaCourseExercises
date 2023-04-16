package Test1;

import java.util.Scanner;

public class Ej4 {

	public static void main(String[] args) {
		
		int longitudArray=5;
		int[] lista = new int[longitudArray];
		int cantMayores=0;
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese el número especial: ");
		int numeroEspecial = Integer.parseInt(lector.nextLine());
		System.out.println();
		for (int i=0;i<longitudArray;i++) {
			System.out.println("Ingrese el número "+(i+1)+": ");
			int numeroIngresado = Integer.parseInt(lector.nextLine());
			if (numeroIngresado>numeroEspecial) {
				lista[cantMayores] = numeroIngresado;
				cantMayores+=1;
			}
		}
		lector.close();
		System.out.println();
		System.out.println("Lista especial:");
		for (int i=0;i<=(cantMayores-1);i++) {
			System.out.println(lista[i]);
		}
		
	}

}
