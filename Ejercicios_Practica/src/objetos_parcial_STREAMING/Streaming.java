package objetos_parcial_STREAMING;

import java.util.LinkedList;

public class Streaming {
	String nombre;
	Usuario[] usuarios;
	Transmision[] transmisiones;
	
	public int cantTransmisionesActivas(String categoria) {
		int cont =0;
		for(Transmision t: this.transmisiones) {
			if(t.estaActiva && t.categoria.equals(categoria)) {
				cont++;
			}
		}
		return cont;
	}
	
	public LinkedList<Transmision> audienciaFiel(int minMinutos, String tipoReaccion){
		LinkedList<Transmision> audenciaFiel = new LinkedList<Transmision>();
		for(Transmision t: this.transmisiones) {
			if(audenciaFiel.contains(t) && t.superaMinutos(minMinutos) && t.estaReaccion(tipoReaccion)) {
				audenciaFiel.add(t);
			}	
		}
		return audenciaFiel;
	}
}
