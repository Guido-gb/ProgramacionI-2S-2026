package objetos_parcial_SISTEMADERED;

public class PC {
	String marca; int cantMemoriaRam;
	String procesador;
	SistemaOperativo so;
	double almacenamientoTotal;
	
	public boolean esSegura() {
		for(Usuario u:so.usuarios) {
			if(u.contrasenia.length() < 10) {
				return false;
			}
		}
		return true;
	}
}
