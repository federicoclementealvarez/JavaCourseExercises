package Test1;

public class Ej1 {

	public static void main(String[] args) {
		int cont=1;
		for (int i=0;i<20;i+=2) {
			System.out.println(cont+"° par: "+i);
			cont++;
		}
		System.out.println();
		cont=1;
		for (int i=1;i<21;i+=2) {
			System.out.println(cont+"° impar: "+i);
			cont++;
		}
	}

}
