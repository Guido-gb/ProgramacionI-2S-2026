package ejercicios;

public class Principal {
	
	public static void main(String[] args) {
		/*Scanner scan = new Scanner(System.in);
		System.out.println("ingresa tu nombre");
		String nombre = scan.nextLine();
		Funciones.Saludar(nombre);
		System.out.println("ingresa el 1er numero entero");
		int numero1 = scan.nextInt();
		System.out.println("ingresa el 2do numero entero");
		int numero2 = scan.nextInt();
		System.out.println("La suma de " + numero1 + " y " + numero2 + " es " + Funciones.suma(numero1, numero2));
		scan.close();
		int[] ejemplo = {1,20,56,567,12,96,754};
		double[] ejemplo2 = {12.3,26.4,2346.467,4567.77,34.0};
		String[] ejemplo3 = {"sdh", "Hola", "Mundo","Como", "estas"};
		int[] ejemplo4 = Funciones.agrandar(ejemplo, 10);
		Funciones.imprimirArray(ejemplo);
		Funciones.imprimirArray(ejemplo4);
		System.out.println(ejemplo);
		System.out.println(ejemplo4);
		ejemplo = ejemplo4;
		Funciones.imprimirArray(ejemplo);
		Funciones.imprimirArray(ejemplo4);
		System.out.println(ejemplo);
		System.out.println(ejemplo4);
		*/
		int[] resultado = {1,20,56,567,12,96,754,1,1,1,1,1,1,20};
		Funciones.imprimirArray(resultado);
		int[] resul = Funciones.sinRepetidos(resultado);
		Funciones.imprimirArray(resul);
	}
}