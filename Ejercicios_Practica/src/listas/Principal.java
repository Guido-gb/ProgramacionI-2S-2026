package listas;

public class Principal {
	public static void main(String[] args) {
		ListaInt lista = new ListaInt();
		lista.agregarAtras(10);
		lista.agregarAtras(15);
		lista.agregarAtras(23);
		lista.agregarAtras(46432);
		lista.agregarAtras(4654);
		lista.agregarAtras(-10);
		lista.imprimir();
		lista.quitar2(230);
		lista.imprimir();
		System.out.println("Largo de la lista: " + lista.largo());
		
		
	}
}
