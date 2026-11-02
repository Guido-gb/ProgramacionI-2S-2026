package listas;

public class ListaInt {
	NodoInt primero;
	
	public void imprimir(){
	      System.out.print("[");
	      NodoInt actual = this.primero;
	      while(actual != null){
	         System.out.print(actual.elemento + " ");
	         actual = actual.siguiente;
	      }
	      System.out.println("]");
	   }
	
	public void agregarAdelante(int n){
	       NodoInt nuevo = new NodoInt(n);
	       nuevo.siguiente = this.primero;
	       this.primero = nuevo;
	   }
	
	public int largo(){
	      int cantidad = 0;
	      NodoInt actual = this.primero;
	      while (actual != null){
	          cantidad++;
	          actual = actual.siguiente;
	      }
	      return cantidad;
	  }
	
	public void agregarAtras(int n){
		NodoInt nuevo = new NodoInt(n);
		
		if (this.primero == null) {
			this.primero = nuevo;
			return;
		}
		
		NodoInt actual = this.primero;
		
		while (actual.siguiente != null) {
			actual = actual.siguiente;
		}
		
		actual.siguiente = nuevo;
	}
	
	public void quitar(int n){
		
		if (this.primero != null && this.primero.elemento == n) {
			this.primero = this.primero.siguiente;
			return;
		}
		
		NodoInt actual = this.primero;

		while(actual.siguiente != null && actual.siguiente.elemento != n) {
           actual = actual.siguiente;
		}
		
		if (actual.siguiente != null) {
			actual.siguiente = actual.siguiente.siguiente;
		}
	}
	
	
	public void quitar2(int n) {
		
		if(this.primero.elemento == n) {
			this.primero = this.primero.siguiente;
			return;
		}
		NodoInt actual = this.primero;
		for(;actual.siguiente != null && actual.siguiente.elemento != n;) {
			actual=actual.siguiente;
		}
		if (actual.siguiente != null) {
			actual.siguiente = actual.siguiente.siguiente;
		}
	}
	
	public int mayorPar() {
		int mayor = 0;
		NodoInt a = this.primero;
		while(a != null) {
			if(a.elemento % 2 == 0 && a.elemento > mayor){
				mayor = a.elemento;
			}
			a = a.siguiente;
		}
		return mayor;
	}
	
	public ListaInt generarMenoresAlMayorPar1() {
		int mayor = this.mayorPar();
		ListaInt salida = new ListaInt();
		NodoInt a = this.primero;
		while(a != null) {
			if(a.elemento < mayor) {
				salida.agregarAdelante(a.elemento);
			}
			a = a.siguiente;
		}
		return salida;
	}
	
	public ListaInt generarMenoresAlMayorPar2() {
		int mayor = this.mayorPar();
		ListaInt salida = new ListaInt();
		NodoInt a = this.primero;
		NodoInt b = null;
		while(a != null) {
			if(a.elemento < mayor) {
				NodoInt nuevo = new NodoInt(a.elemento);
				if(b == null) {
					salida.primero = nuevo;
					b = nuevo;
				}else {
					b.siguiente = nuevo;
					b = nuevo;
				}
			}
			a = a.siguiente;
		}
		return salida;
	}
	
	public boolean estaEnPos(int pos, int ele) {
		if(this.primero == null) {
			return false;
		} 
		int cont =0;
		NodoInt a = this.primero;
		while(a != null) {
			if(cont == pos && ele == a.elemento) {
				return true;
			}
			cont++;
			a = a.siguiente;
		}
		return false;	
	}
}