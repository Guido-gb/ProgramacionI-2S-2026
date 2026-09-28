package objetos_ejercicio_Modulo7;

public class Modulo7 {
	Laboratorio[] labos;
	
	public int componentesPorMarca(Marca m){
		int cont=0;
		for(Laboratorio l:this.labos) {
			for(PC c:l.computadoras) {
				for(Componente com:c.componentes) {
					if(com.marca.equals(m)) {
						cont++;
					}
				}
			}
		}
		return cont;
	}
	
	public int pcsConMinimaCalidad() {
		int cont=0;
		for(Laboratorio l:this.labos) {
			for(PC c:l.computadoras) {
				if(c.todosMalos()) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	public int pcsConMinimaCalidad2() {
		int cont=0;
		for(Laboratorio l:this.labos) {
			for(PC c:l.computadoras) {
				boolean todosMalos = true;
				for(Componente com:c.componentes) {
					if(com.marca.calidad > 1) {
						todosMalos = false;
					}
				}
				if(todosMalos) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	public boolean gamaAlta() {
		for(Laboratorio l:this.labos) {
			for(PC pc:l.computadoras){
				if(pc.sosGamaAlta()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public int pcCompuestasPor(Marca[] ciertasMarcas){
		int cont=0;
		for(Laboratorio l:this.labos) {
			for(PC pc:l.computadoras){
				if(pc.tusCompSon(ciertasMarcas)) {
					cont++;
				}
			}
		}
		return cont;
	}
	
	public Marca marcaMasUsada() {
		Marca max = this.labos[0].computadoras[0].componentes[0].marca;
		for(Laboratorio l:this.labos) {
			for(PC pc:l.computadoras) {
				for(Componente c:pc.componentes) {
					if(this.cantUsos(c.marca) > this.cantUsos(max)) {
						max = c.marca;
					}
				}
			}
		}
		return max;
	}

	public int cantUsos(Marca m) {
		int cont=0;
		for(Laboratorio l:this.labos) {
			for(PC pc:l.computadoras) {
				for(Componente c:pc.componentes) {
					if(c.marca.equals(m)) {
						cont++;
					}
				}
			}
		}
		return cont;
	}
	
	
	
	
	
	
	
	
	
}