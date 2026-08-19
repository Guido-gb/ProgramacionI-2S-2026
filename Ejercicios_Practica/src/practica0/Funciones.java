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
