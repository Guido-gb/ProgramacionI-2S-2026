package parciales;


public class Recursion {
	public static void main(String[] args) {
		String prueba = "lago";
		System.out.println(eliminarConsonantesParesDesde(prueba,0));
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
	
	public static String reemplazarCaracter(String s,char original, char nuevo) {
		if(s.isEmpty()) {
			return s;
		}
		if(s.charAt(0) == original) {
			return nuevo 
					+ reemplazarCaracter(s.substring(1), original, nuevo);
		}
		return s.charAt(0) 
				+ reemplazarCaracter(s.substring(1), original, nuevo);
		
	}
	
	public static String duplicarDesde(String s, int pos) {
		if(s.isEmpty()) {
			return s;
		}
		if(pos == 0) {
			return "" + s.charAt(0) + s.charAt(0) 
			+ duplicarDesde(s.substring(1), pos);
		}
		return s.charAt(0) + duplicarDesde(s.substring(1), pos-1);
	}
	
	public static boolean tieneMasDeNVocales(String s, int n) {
		if(s.isEmpty()) {
			return false;
		}
		if(n == 0 && esVocal(s.charAt(0))) {
			return true;
		}
		if(esVocal(s.charAt(0))) {
			return tieneMasDeNVocales(s.substring(1), n-1);
		}
		return tieneMasDeNVocales(s.substring(1), n);
	}
	
	public static String eliminarLetraEntreIguales(String s, char a) {
		if(s.length() < 3) {
			return s;
		}
		if(s.charAt(1) == a && s.charAt(0) == s.charAt(2)) {
			return s.charAt(0) 
					+ eliminarLetraEntreIguales(s.substring(2), a);
		}
		return s.charAt(0) 
				+ eliminarLetraEntreIguales(s.substring(1), a);
	}
	
	public static String cambiarConsonante(String s, char r) {
		if(s.length() < 2) {
			return s;
		}
		if(!esVocal(s.charAt(0)) && !esVocal(s.charAt(1))) {
			return "" + s.charAt(0) + r 
					+ cambiarConsonante(s.substring(2), r);
		}
		return s.charAt(0) + cambiarConsonante(s.substring(1),r);
	}
	
	public static String invertirDesde(String s, int pos) {
		if(s.isEmpty()) {
			return s;
		}
		if(pos == 0) {
			return invertirDesde(s.substring(1), 0) + s.charAt(0);
		}
		return s.charAt(0) + invertirDesde(s.substring(1), pos-1);
	}
	
	public static String eliminarConsonantesParesDesde(String s, int desde) {
		if(s.length() < 2) {
			if(s.isEmpty()) {
				return "";
			}
			if(!esVocal(s.charAt(0))){
				return "";
			}
			return s;
		}
		if(desde <= 0 && !esVocal(s.charAt(0))) {
			return s.charAt(1)  
					+ eliminarConsonantesParesDesde(s.substring(2), desde-2);
		}
		return "" + s.charAt(0) + s.charAt(1)  
		+ eliminarConsonantesParesDesde(s.substring(2), desde-2);
	}
}