package excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		boolean ok = false;
		Scanner scan = new Scanner(System.in);
		String s = "";
		while(!ok) {
			try {
				System.out.println("Ingrese una palabra");
				s = scan.nextLine();
				System.out.println(caracterMasRepetido(s));
				System.out.println("Ingrese un numero");
				int n = scan.nextInt();
				System.out.println("El caracter numero " + n + " de " + s + " es:" + s.charAt(n)); 
				
			}catch(InputMismatchException e) {
				System.out.println("No ingreso un numero");
			}catch(StringIndexOutOfBoundsException e){
				System.out.println("Ingrese un numero desde 0 a " + (s.length()-1) );
			}catch(RuntimeException e) {
				System.out.println("La cadena no puede estar vacia" + e.toString());
			}finally {
			}
				scan.nextLine();
		}
		scan.close();
	}
	
	public static char caracterMasRepetido(String s) {
		if(s.isEmpty()) {
			throw new RuntimeException("String vacio!");
		}
		char max = s.charAt(0);
		for(int ite=0;ite< s.length();ite++) {
			if(cantApar(max, s) < cantApar(s.charAt(ite), s)) {
				max = s.charAt(ite);
			}
		}
		return max;
	}
	
	public static int cantApar(char c, String s) {
		int cont =0;
		for(int x=0;x<s.length();x++) {
			if(c == s.charAt(x)) {
				cont++;
			}
		}
		return cont;
	}

}
