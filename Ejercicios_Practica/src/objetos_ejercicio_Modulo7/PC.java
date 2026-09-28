package objetos_ejercicio_Modulo7;

public class PC {
	String serial;
	String modelo;
	String OS;
	Componente[] componentes;
	
	public boolean todosMalos() {
		for(Componente c:this.componentes) {
			if(c.marca.calidad > 1) {
				return false;
			}
		}
		return true;
	}

	public boolean sosGamaAlta() {
		for(Componente c:this.componentes) {
			if(c.marca.calidad < 4) {
				return false;
			}
		}
		return true;
	}

	public boolean tusCompSon(Marca[] ciertasMarcas) {
		for(Componente c:this.componentes) {
			if(!c.sosDe(ciertasMarcas)) {
				return false;
			}
		}
		return true;
	}
}