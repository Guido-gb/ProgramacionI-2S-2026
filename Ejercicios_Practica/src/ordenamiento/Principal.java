package ordenamiento;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		int[] a = {5,4,2,12,8,7,9};
		ordenarPorBurbujeo(a);
	}
	
	static void ordenarPorBurbujeo(int a[]) 
	{
		Scanner c = new Scanner(System.in);
		for (int i = a.length-1; i > 0; i--){
			mostrar(a);
			c.nextLine();
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j+1]) {
					swap(a,j,j+1);
				}
				mostrar(a);
				c.nextLine();
           }
		}
		
	}

	static void ordenarPorInsercion(int a[]) 
	{
		Scanner c = new Scanner(System.in);
	      for (int i = 1; i < a.length; i++) 
	      {
	    	  mostrar(a);
	    	  c.nextLine();
	    	  
	            int pos = 0;
	            while (pos < i && a[pos] < a[i])
	                  pos++;
	               
	            int temp = a[i];
	            for (int j = i-1; j >= pos; j--)
	                  a[j+1] = a[j];

	             a[pos] = temp;
	       }
	      mostrar(a);
	}
	
	static void ordenarPorSeleccion(int a[]) 
	{
		Scanner c = new Scanner(System.in);
	      for (int i = 0; i < a.length - 1; i++) 
	      {
	    	  mostrar(a);
	    	  c.nextLine();
	            int menor = i;
	            for (int j = i + 1; j < a.length; j++) 
	            {
	                  if (a[j] < a[menor])
	                        menor = j;
	            }

	            swap(a, i, menor);
	      }
	      mostrar(a);
	}

	
	private static void swap(int[] a, int i, int menor) {
		int aux=a[menor];
		a[menor] = a[i];
		a[i]=aux;
		
	}

	static void mostrar(int[] a) {
		System.out.print("[ ");
		for(int x=0; x< a.length-1;x++) {
			System.out.print(a[x] + ", ");
		}
		System.out.println(a[a.length-1] + " ]");
	}

}
