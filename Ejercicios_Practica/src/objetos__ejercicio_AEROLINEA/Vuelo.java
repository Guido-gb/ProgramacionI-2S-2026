package objetos__ejercicio_AEROLINEA;

public class Vuelo {
	Avion avion;
	Tripulante[] tripulacion;
	
	public boolean esta(Tripulante t) {
		for(Tripulante tri:this.tripulacion) {
			if(tri.equals(t))
				return true;
		}
		return false;
	}
}
 