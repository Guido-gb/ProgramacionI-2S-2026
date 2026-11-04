package objetos_parcial_VIDEOJUEGOS;

import objetos.Fecha;

public class Partida {
	Fecha fechaPartida;
	Nivel[] nivelesSuperados;
	int puntajeObtenido;
	int cantidadIntentos;
	
	public boolean superada(Nivel[] niveles) {
		for(Nivel n:niveles) {
			if(!nivelesSuperado(n)) {
				return false;
			}
			
		}
		return true;
	}

	public boolean nivelesSuperado(Nivel n) {
		for(Nivel nS: this.nivelesSuperados) {
			if(n.equals(nS)) {
				return true;
			}
		}
		return false;
	}
	
	
}
