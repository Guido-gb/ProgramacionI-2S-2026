package objetos_parcial_VIDEOJUEGOS;

public class Usuario {
	String nickname;
	Partida[] historialPartidas;
	
	public boolean esGanador(Nivel[] niveles) {
		for(Partida p : this.historialPartidas) {
			if(p.superada(niveles)) {
				return true;
			}
		}
		return false;
	}
}
