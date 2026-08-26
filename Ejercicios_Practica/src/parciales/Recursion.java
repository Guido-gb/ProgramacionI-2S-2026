package parciales;


public class Recursion {
	public static void main(String[] args) {
		String prueba = "bcd";
		System.out.println(repetirLetras(prueba));
	}
	
	public static String espejar(String s) {
		if(s.isEmpty()) {
			return s;
		}
		return s.charAt(0) + espejar(s.substring(1)) + s.charAt(0);
	}
	
	public static String repetirLetras(String s) {
		if(s.length() < 2) {
			return s;
		}
		
		if(esVocal(s.charAt(0)) && esVocal(s.charAt(1))) {
			return "" + s.charAt(0) + s.charAt(0) 
			+ repetirLetras(s.substring(1));
		}
		
		if(!esVocal(s.charAt(0)) && !esVocal(s.charAt(1))) {
			return "" + s.charAt(0) + s.charAt(0) + s.charAt(0) 
			+ repetirLetras(s.substring(1));
		}
		
		return s.charAt(0) + repetirLetras(s.substring(1));
	}
	
	public static boolean esVocal(char caracter) {
		String vocales = "aeiou";
		vocales += vocales.toUpperCase();
		return vocales.indexOf(caracter) != -1;
	}
}
