package objetos;

public class Fecha {
	int dia;
	int mes;
	int anio;
	
	public Fecha(int dia, int mes, int anio) {
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	
	public Fecha() {
		this.dia = 1;
		this.mes = 1;
		this.anio = 1970;
	}
	
	public Fecha(String f) {
		this.dia = 1;
		this.mes = 1;
		this.anio = 1970;
		
		if(f.equals("Navidad")) {
			this.dia = 25;
			this.mes = 12;
			this.anio = 1970;
		}
		
		if(f.equals("Independencia")) {
			this.dia = 9;
			this.mes = 7;
			this.anio = 1816;
		}
	}
	
	public static boolean esBisiesto(int anio) {
		if(anio % 4 == 0 && anio % 100 != 0) {
			return true;
		}
		if(anio % 400 == 0) {
			return true;
		}
		return false;
	}
	
	public static int diasDelMes(int mes, int anio) {
		if(mes == 2) {
			return esBisiesto(anio) ? 29 : 28;
		}
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			return 30;
		}
		return 31;
	}
	
	public boolean esValida() {
		if(this.anio <= 0) {
			return false;
		}
		
		if(this.mes < 1 || this.mes > 12) {
			return false;
		}
		
		if(this.dia < 1 || this.dia > diasDelMes(this.mes, this.anio)) {
			return false;
		}
		
		return true;
	}
	
	public void avanzarDia(int n) {
		for(int x=0;x<n;x++) {
			this.avanzarDia();
		}
	}
	
	public void avanzarDia() {
		if(this.dia == 31 && this.mes == 12) {
			this.dia = 1;
			this.mes = 1;
			this.anio++;
			return;
		}
		if(this.dia == diasDelMes(this.mes, this.anio)) {
			this.dia = 1;
			this.mes++;
			return;
		}
		this.dia++;
	}
	
	public int diaDelAnio() {
		int cont=this.dia;
		for(int ite=1; ite<this.mes;ite++) {
			cont+= diasDelMes(ite, this.anio);
		}
		return cont;
	}
	
	public int numSerie() {
		int cont=this.diaDelAnio();
		for(int ite=1900;ite<this.anio;ite++) {
			cont+= esBisiesto(ite) ? 366 : 365;
		}
		return cont;
	}
	
	public void mostrar() {
		System.out.println(this.dia+"/"+this.mes+"/"+this.anio);
	}
}