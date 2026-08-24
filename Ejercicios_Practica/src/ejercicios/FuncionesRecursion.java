package ejercicios;

public class FuncionesRecursion {
	
	public static int factorial(int n){
	    if(n == 0){
	      return 1;
	    }
	    return n * factorial(n-1);
	  }
	  
	  public static String resto(String s){
	    return s.substring(1);
	  }
	  
	  public static int longitud(String s){
	    if(s.isEmpty()){
	      return 0;
	    }
	    return 1 + longitud(resto(s));
	  }
	  
	public static void imprimirEspaciado(String s) {
		if(s.isEmpty()) {
			return;
		}
		System.out.print(s.charAt(0) + " ");
		imprimirEspaciado(s.substring(1));
		// s.substring(1) == resto(s)
	}
	
	public static void imprimirEspaciadoCon(String s) {
		if(s.length() == 1) {
			System.out.println(s);
			return;
		}
		System.out.print(s.charAt(0) + "*");
		imprimirEspaciadoCon(s.substring(1));
		// s.substring(1) == resto(s)
	}
	
	public static String reverso(String s) {
		if(s.isEmpty()) {
			return s;
		}
		//return s.charAt(s.length()-1) + reverso(s.substring(0, s.length()-1));
		return reverso(resto(s)) + s.charAt(0);
	}
	
	public static String combinar(String s, String t) {
		if(s.isEmpty() || t.isEmpty()) {
			return t + s;
		}
		if(s.charAt(0) < t.charAt(0)) {
			return s.charAt(0) + combinar(s.substring(1), t.substring(1));
		}
		return t.charAt(0) + combinar(s.substring(1), t.substring(1));
	}
	
	public static boolean esAbecedaria(String s, int cont) {
		s = s.toLowerCase().replace('ñ', 'n').replace('á', 'a')
				.replace('é', 'e').replace('í', 'i')
				.replace('ó', 'o').replace('ú', 'u');
		if(s.length() <= 1) {
			System.out.println(cont);
			return true;
		}
		
		if(s.charAt(0) <= s.charAt(1)) {
			return esAbecedaria(s.substring(1),cont+1);
		}
		return false;
	}
	
	public static boolean esAbecedaria(String s) {
		return esAbecedaria(s, 0);
	}
}










