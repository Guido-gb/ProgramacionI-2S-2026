package objetos__ejercicio_UNGS;

public class UNGS {
	Comision[] comisiones;
	
	boolean cursaCon(Estudiante e, Docente d) {
		for(Comision c:this.comisiones) {
			if(c.esta(e) && c.esta(d)) {
				return true;
			}
		}
		return false;
	}
	
	boolean suficientesDocentes() {
		for(Comision c:this.comisiones) {
			if(c.inscriptos.length > 20 * c.docentes.length) {
				return false;
			}
		}
		return true;
	}
	
	Estudiante elMasEstudioso() {
		Estudiante supremo = this.comisiones[0].inscriptos[0];
		for(Comision c:this.comisiones) {
			for(Estudiante e:c.inscriptos) {
				if(cantAprobadas(e) > cantAprobadas(supremo)) {
					supremo = e;
				}
			}
		}
		return supremo;
	}

	public int cantAprobadas(Estudiante e) {
		int cont =0;
		for(Comision c:this.comisiones) {
			for(int pos=0; pos < c.inscriptos.length;pos++) {
				if(c.inscriptos[pos].equals(e) 
						&& c.calificaciones[pos] >= 4) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	int losMejores() {
		int cont=0;
		for(Comision c: this.comisiones) {
			cont = cont+c.mejores();
		}
		return cont;
	}
	
	int alumnosDe(Docente d) {
		int cont=0;
		for(Comision c:this.comisiones) {
			if(c.esta(d)) {
				cont+=c.inscriptos.length;
			}
		}
		return cont;
	}
	
	int unicaComision() {
		int cont=0;
		for(Comision c:this.comisiones) {
			if(esUnica(c.materia)) {
				cont++;
			}
		}
		return cont;
	}

	public  boolean esUnica(String mat) {
		int cont=0;
		for(Comision c:this.comisiones) {
			if(c.materia.equals(mat)) {
				cont++;
			}
		}
		return cont == 1;
	}
}