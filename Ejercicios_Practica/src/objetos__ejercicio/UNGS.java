package objetos__ejercicio;

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
}
