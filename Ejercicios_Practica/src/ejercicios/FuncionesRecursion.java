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
	
	
}
