package ejercicios;

import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ingresa tu nombre");
		String nombre = scan.nextLine();
		Saludar(nombre);
		System.out.println("ingresa el 1er numero entero");
		int numero1 = scan.nextInt();
		System.out.println("ingresa el 2do numero entero");
		int numero2 = scan.nextInt();
		System.out.println("La suma de " + numero1 + " y " + numero2 + " es " + suma(numero1, numero2));
	}
	
	public static void Saludar(String nombre) {
		System.out.println("Hola " + nombre + ". Como estas?");
	}
	
	public static int suma(int num1, int num2) {
		return num1 + num2;
	}
	
	public static double suma(double num1, double num2) {
		return num1 + num2;
	}
}