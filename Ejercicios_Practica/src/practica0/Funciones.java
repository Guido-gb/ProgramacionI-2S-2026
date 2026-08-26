package practica0;

public class Funciones {
	/*
	 * Escribir un metodo static int cantidadVocales(String s) que dada una cadena que contienes
	 * solo letras minusculas sin acentuar, devuelve la cantidad de vocales en dicha cadena.
	*/
	public static int cantidadVocales(String s) {
		int cont= 0;
		for(int x = 0; x < s.length();x++) {
			if(esVocal(s.charAt(x))) {
				cont++;
			}
		}
		return cont;
	}
	
	// Ejercicio 23
	
	static boolean puedenColocarse(String a, String b, String c) {
		int posA = sePuedenCruzar(b, a);
		if(posA < 0) {
			return false;
		}
		int posC = sePuedenCruzar(b, c);
		if(posC < 0) {
			return false;
		}
		if(posA >= posC) {
			return false;
		}
		if(posC - posA < 2) {
			return false;
		}
		
		return true;
	}
	
	public static int sePuedenCruzar(String ver,String hor) {
		
		for(int i=0;i<ver.length();i++) {
			if(hor.indexOf(ver.charAt(i)) >= 0) {
				return i;
			}
		}
		return -1;
	}
	
	
	
	//Dice si un caracter es vocal o no
	public static boolean esVocal(char caracter) {
		String vocales = "aeiou";
		vocales += vocales.toUpperCase();
		return vocales.indexOf(caracter) != -1;
	}
	
	/*
	 * Escribir el metodo static boolean esCapicua(String s) que dada una cadena, devuelve true
	 * si la cadena es igual de atras hacia adelante o de adelante hacia atras. En caso contrario, devuelve
	 * false.
	 */
	
	public static boolean esCapicua(String s) {
		for(int ite =0; ite < s.length() / 2 ;ite++) {
			if( s.charAt(ite) != s.charAt(s.length()-1-ite)) {
				return false;
			}
		}
		return true;
	}
}
