package objetos__ejercicio_AEROLINEA;

public class Aerolinea {
	Vuelo[] vuelos;

	public int vuelosEn(Tripulante t, String tipoAvion) {
		int cont=0;
		for(Vuelo v:this.vuelos) {
			if(v.esta(t) && v.avion.tipo.equals(tipoAvion))
				cont++;
		}
		return cont;
	}
	
	public int antiguedadPromedio(String tipoAvion) {
		int suma=0;
		int cantidad=0;
		for(Vuelo v:this.vuelos) {
			if(v.avion.tipo.equals(tipoAvion)) {
				for(Tripulante t:v.tripulacion) {
					suma+=t.antiguedad;
					cantidad++;
				}
			}
		}
		return suma / cantidad;
	}
	
	public Vuelo elMasInspeccionado() {
		Vuelo max = this.vuelos[0];
		for(Vuelo v:this.vuelos) {
			if(v.cantInspectores() > max.cantInspectores())
				max = v;
		}
		return max;
	}
	
	public boolean hayVueloSobrecargado() {
		for(Vuelo v:this.vuelos) {
			if(v.cantAeromozos() * 10 > v.avion.capacidad)
				return true;
		}
		return false;
	}
	
	public Tripulante elMasViajero() {
		Tripulante max = this.vuelos[0].tripulacion[0];
		for(Vuelo v:this.vuelos) {
			for(Tripulante t:v.tripulacion) {
				if(cantVuelos(t) > cantVuelos(max))
					max = t;
			}
		}
		return max;
	}

	public int cantVuelos(Tripulante t) {
		int cont=0;
		for(Vuelo v:this.vuelos) {
			for(Tripulante tri:v.tripulacion) {
				if(tri.equals(t))
					cont++;
			}
		}
		return cont;
	}
}