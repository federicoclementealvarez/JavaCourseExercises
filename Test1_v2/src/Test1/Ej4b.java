package Test1;

import java.util.Scanner;
import java.util.LinkedList;

public class Ej4b {

	public static void main(String[] args) {
		
		LinkedList<Integer> lista = new LinkedList<>();
		int limite= 5;
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese el número especial: ");
		int numeroEspecial = Integer.parseInt(lector.nextLine());
		System.out.println();
		for (int i=0;i<limite;i++) {
			System.out.println("Ingrese el número "+(i+1)+": ");
			int numeroIngresado = Integer.parseInt(lector.nextLine());
			if (numeroIngresado>numeroEspecial) {
				lista.add(numeroIngresado);
			}
		}
		lector.close();
		System.out.println();
		System.out.println("Lista especial:");
		for (int numeroMayor : lista) {
			System.out.println(numeroMayor);
		}
		
	}

}
