package juego;

public class ManoJugador {
	Carta[] cartas;
	
	public ManoJugador() {
		this.cartas = new Carta[40];
	}
	
	public void mostrar() {
		for(int ite =0;ite< 40;ite++) {
			if(this.cartas[ite] != null) {
				System.out.print(ite + ". ");
				this.cartas[ite].mostrar();
			}
		}
	}

	public void recibirCarta(Carta carta) {
		for(int pos=0; pos < 40;pos++) {
			if(this.cartas[pos] == null) {
				this.cartas[pos] = carta;
				return;
			}
		}
	}
	
	public int numCartas() {
		int cont=0;
		for(int pos=0; pos < 40;pos++) {
			if(this.cartas[pos] != null) {
				cont++;
			}
		}
		return cont;
	}

	public Carta jugarCarta(int n) {
		int cont=0;
		for(int pos=0;pos<40;pos++) {
			if(this.cartas[pos] != null) {
				cont++;
			}
			if(cont == n) {
				Carta devolver = this.cartas[pos];
				this.cartas[pos] = null;
				return devolver;
			}
		}
		return null;
	}
}
