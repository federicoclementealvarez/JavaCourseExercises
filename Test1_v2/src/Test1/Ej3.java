package Test1;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		ArrayList<String> lista = new ArrayList<>();
		Scanner lector = new Scanner(System.in);
		for (int i=0;i<10;i++) {
			System.out.println("Ingrese la palabra número "+(i+1)+": ");
			lista.add(lector.nextLine());
		}
		System.out.println();
		System.out.println("Ingrese la palabra a buscar: ");
		String palabraBuscada = lector.nextLine();
		lector.close();
		System.out.println();
		System.out.println("¿La palabra buscada se encuentra en la lista? " + lista.contains(palabraBuscada));

	}

}
