package listas;

public class Principal {
	public static void main(String[] args) {
		ListaInt lista = new ListaInt();
		lista.agregarAtras(1);
		lista.agregarAtras(3);
		lista.agregarAtras(5);
		lista.imprimir();
		lista.obtenerMenoresAlPromedioPares().imprimir();
	}
}
