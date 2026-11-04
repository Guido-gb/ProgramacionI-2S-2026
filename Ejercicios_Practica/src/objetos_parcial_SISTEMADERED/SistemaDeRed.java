package objetos_parcial_SISTEMADERED;

import java.util.LinkedList;

public class SistemaDeRed {
	String nombre;
	PC[] pcs;
	
	public int cantPCsSeguras() {
		int cont=0;
		for(PC pc:this.pcs) {
			if(pc.esSegura()) {
				cont++;
			}
		}
		return cont;
	}
	
	public LinkedList<Directorio> 
	directoriosSinHijosPesados(double peso, String extension){
		
		LinkedList<Directorio> resultado = new LinkedList<Directorio>();
		for(PC pc: this.pcs) {
			for(Usuario us: pc.so.usuarios) {
				for(Directorio di:us.directorios) {
					if(resultado.contains(di) && di.peso() < peso && di.tener(extension)) {
						resultado.add(di);
					}
				}
			}
		}
		return resultado;
	}
}
