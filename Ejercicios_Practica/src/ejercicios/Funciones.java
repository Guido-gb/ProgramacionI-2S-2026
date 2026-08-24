package ejercicios;

import java.util.Scanner;

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
	
	public static void imprimirArray(int[] a) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
			if(i !=  a.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(" ]");
	}
	
	public static void imprimirArray(double[] a) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
			if(i !=  a.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(" ]");
	}
	
	public static void imprimirArray(String[] a) {
		System.out.print("[ ");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
			if(i !=  a.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println(" ]");
	}
	
	public static int[] agrandar(int[] a, int n) {
		int[] nuevo = new int[a.length+1];
		for(int i=0;i<a.length;i++) {
			nuevo[i] = a[i];
		}
		nuevo[a.length] = n;
		
		return nuevo;
	}
	
	public static int[] pedirArray(int n) {
		int[] nuevo = new int[n];
		Scanner teclado = new Scanner(System.in);
		
		for(int i=0;i<n;i++) {
			System.out.println("ingrese el numero " + (i+1) + " de " + n);
			nuevo[i] = teclado.nextInt();
		}
		
		return nuevo;
	}
	
	public static int[] rango(int m, int n) {
		int[] nuevo = new int[n-m+1];
		
		for(int i=0;i<nuevo.length;i++) {
			nuevo[i] = m+i;
		}
		
		return nuevo;
	}
	
	public static int cantidadDeRepetidos(int[] a) {
		int cont=0;
		for(int i=0;i<a.length;i++) {
			if(cantApariciones(a, a[i]) > 1) {
				cont++;
			}
		}
		
		return cont;
	}
	
	
	public static int cantApariciones(int[] a, int num) {
		int cont=0;
		
		for(int i=0;i<a.length;i++) {
			if(a[i] == num) {
				cont++;
			}
		}
		
		return cont;
	}
	
	public static int[] sinRepetidos(int[] a) {
		int[] aux = new int[a.length];
		int k =0;
		boolean bandera;
		for(int i=0;i<a.length-1;i++) {
			bandera = false;
			for(int j=i+1;j<a.length;j++) {
				if(a[i] == a[j]) {
					bandera = true;
				}
			}
			if(!bandera) {
				aux[k] = a[i];
				k++;
			}
		}
		aux[k] = a[a.length-1];
		int[] salida = new int[k+1];
		for(int i=0;i<k+1;i++) {
			salida[i] = aux[i];
		}
		return salida;
	}
	
}