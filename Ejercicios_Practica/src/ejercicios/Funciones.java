package ejercicios;

public class Funciones {
	// Saluda a la persona por su nombre
	public static void Saludar(String nombre) {
		System.out.println("Hola " + nombre + ". Como estas?");
	}
	
	// Suma dos numeros enteros
	public static int suma(int num1, int num2) {
		return num1 + num2;
	}
	
	//Suma dos numeros con coma
	public static double suma(double num1, double num2) {
		return num1 + num2;
	}
	
	// Imprime la palabra separada por /
	public static void imprimirPalabra(String palabra){
		for(int i =0; i<palabra.length(); i++) {
			System.out.print(palabra.charAt(i) + " / ");
		}
	}
}
