package juego;

public class Carta {
	int palo;
	int numero;
	
	public Carta(int palo, int numero) {
		this.palo = palo;
		this.numero = numero;
	}
	
	public void mostrar() {
		String[] palos = {"","espada","oro","copa","basto"};
		System.out.println(this.numero+ " de " + palos[this.palo]);
	}
}