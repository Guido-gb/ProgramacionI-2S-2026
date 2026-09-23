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
		
	}
}