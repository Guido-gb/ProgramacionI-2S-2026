package objetos_parcial_VIDEOJUEGOS;

import java.util.LinkedList;

public class Videojuego {
	Nivel[] niveles;
	Usuario[] usuarios;
	
	public int cantNivelesLlenosDe(String tipo) {
		int cont=0;
		for(Nivel n:this.niveles) {
			if(n.lleno(tipo)) {
				cont++;
			}
		}
		return cont; 
	}
	
	public LinkedList<Usuario> usuariosGanadores(){
		LinkedList<Usuario> uGanadores = new LinkedList<Usuario>();
		for(Usuario u :this.usuarios) {
			if(!uGanadores.contains(u) && u.esGanador(this.niveles)) {
				uGanadores.add(u);
			}
		}
		return uGanadores;
	}
}






