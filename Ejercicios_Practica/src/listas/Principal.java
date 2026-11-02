package listas;

public class Principal {
	public static void main(String[] args) {
		ListaInt lista = new ListaInt();
		//5, 4, 15, 7, 80, 35
		lista.agregarAtras(5);
		lista.agregarAtras(4);
		lista.agregarAtras(15);
		lista.agregarAtras(7);
		lista.agregarAtras(80);
		lista.agregarAtras(35);
		lista.imprimir();
		//System.out.println("El mayor par es " + lista.mayorPar());
		//lista.generarMenoresAlMayorPar2().imprimir();
		System.out.println(lista.nodosMayoresA(10));
	}
}
