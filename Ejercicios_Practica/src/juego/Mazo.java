package juego;

public class Mazo {
	Carta[] cartas;
	int repartidas;
	
	public Mazo() {
		this.cartas = new Carta[40];
		this.repartidas=0;
 		int k = 0; 
		for (int p = 1; p <= 4; p++) { 
			for (int n = 1; n <= 12; n++) {
				if( n != 8 && n != 9 ) {
					this.cartas[k++] = new Carta(p, n); 
				}
			}
		}
	}
	
	public void mostrar() {
		for(int ite =this.repartidas;ite< 40;ite++) {
			System.out.print((ite+1-this.repartidas) + ". ");
			this.cartas[ite].mostrar();
		}
	}
	
	public void mezclar() {
		Carta aux;
		for(int ite=0;ite<10000;ite++) {
			int num1= this.repartidas + (int) (Math.random() * (40 - this.repartidas));
			int num2= this.repartidas + (int) (Math.random() * (40 - this.repartidas));
			aux = this.cartas[num1];
			this.cartas[num1] = this.cartas[num2];
			this.cartas[num2] = aux;
		}
	}
	
	public Carta darCarta() {
		return this.cartas[repartidas++];
	}
	
	public Carta[] cartasRestantes() {
		Carta[] restantes = new Carta[40-this.repartidas];
		for(int pos=0; pos < restantes.length;pos++) {
			restantes[pos] = this.cartas[pos+this.repartidas];
		}
		return restantes;
	}
}