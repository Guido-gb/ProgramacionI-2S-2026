package objetos__ejercicio_UNGS;

public class Comision {
	String materia;
	int numero;
	Docente[] docentes;
	Estudiante[] inscriptos;
	int[] calificaciones;
	
	public boolean esta(Estudiante e) {
		for(Estudiante es:this.inscriptos) {
			if(es.equals(e)) {
				return true;
			}
		}
		return false;
	}

	public boolean esta(Docente d) {
		for(Docente doc:this.docentes) {
			if(d.equals(doc)) {
				return true;
			}
		}
		return false;
	}

	public int mejores() {
		int mejorNota= this.calificaciones[0];
		for(int pos=0;pos < this.calificaciones.length;pos++) {
			if(mejorNota < this.calificaciones[pos]) {
				mejorNota = this.calificaciones[pos];
			}
		}
		int cantAlumnos=0;
		for(int pos=0;pos < this.calificaciones.length;pos++) {
			if(mejorNota == this.calificaciones[pos]) {
				cantAlumnos++;
			}
		}
		return cantAlumnos;
	}
}
