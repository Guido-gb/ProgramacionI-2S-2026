package listas;

public class Principal {
	public static void main(String[] args) {
		ListaInt lista = new ListaInt();
		lista.agregarAtras(7);
		lista.agregarAtras(2);
		lista.agregarAtras(8);
		lista.agregarAtras(2);
		lista.agregarAtras(3);
		lista.agregarAtras(11);
		lista.imprimir();
		//System.out.println("El mayor par es " + lista.mayorPar());
		//lista.generarMenoresAlMayorPar2().imprimir();
		System.out.println(lista.estaEnPos(0, 7));
	}
}
