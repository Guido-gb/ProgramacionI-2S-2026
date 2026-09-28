package objetos_ejercicio_Modulo7;

public class Componente {
	String nombre;
	String tipo;
	Marca marca;
	
	public boolean sosDe(Marca[] ciertasMarcas) {
		for(Marca m:ciertasMarcas) {
			if(m.equals(this.marca)) {
				return true;
			}
		}
		return false;
	}
}
