package objetos_parcial_VIDEOJUEGOS;

public class Nivel {
	String nombre;
	int dificultad; //de 1 a 10
	Item[] items;
	Enemigo[] enemigos;
	
	public boolean lleno(String tipo) {
		for(Enemigo e:this.enemigos) {
			if(!e.tipo.equals(tipo)) {
				return false;
			}
		}
		return true;
	}
}
