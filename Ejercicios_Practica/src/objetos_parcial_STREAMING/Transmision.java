package objetos_parcial_STREAMING;

public class Transmision {
	String titulo;
	String categoria;
	Usuario antitrion;
	Usuario[] espectadores;
	Vista[] vistas;
	Chat[] chats;
	boolean estaActiva;
	
	public boolean superaMinutos(int minMinutos) {
		for(Vista v:this.vistas) {
			if(v.minutosVisualizados < minMinutos) {
				return false;
			}
		}
		return true;
	}

	public boolean estaReaccion(String tipoReaccion) {
		for(Vista v:this.vistas) {
			for(Reaccion r:v.reacciones) {
				if(r.tipo.equals(tipoReaccion)){
					return true;
				}
			}
		}
		return false;
	}
}
