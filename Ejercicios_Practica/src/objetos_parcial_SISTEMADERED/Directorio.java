package objetos_parcial_SISTEMADERED;

public class Directorio {
	String nombre;
	Archivo[] archivos;
	
	public double peso() {
		double suma=0;
		for(Archivo ar:this.archivos) {
			suma+= ar.peso;
		}
		return suma;
	}

	public boolean tener(String extension) {
		for(Archivo ar:this.archivos) {
			if(ar.extension.equals(extension)) {
				return true;
			}
		}
		return false;
	}
}
