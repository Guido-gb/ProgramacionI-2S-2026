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

	public int cantInspectores() {
		int cont=0;
		for(Tripulante t:this.tripulacion) {
			if(t.cargo.equals("Inspector"))
				cont++;
		}
		return cont;
	}

	public int cantAeromozos() {
		int cont=0;
		for(Tripulante t:this.tripulacion) {
			if(t.cargo.equals("Aeromozo"))
				cont++;
		}
		return cont;
	}
}
 