package listas;

public class ListaInt {
	NodoInt primero;
	
	
	
	public ListaInt obtenerMenoresAlPromedioPares() {
		double promedio = this.promedioPares();
		NodoInt a = this.primero;
		ListaInt salida = new ListaInt();
		NodoInt b = null; // puntero ultimo a lista salida
		while(a != null) {
			if(a.elemento < promedio) {
				NodoInt nuevo = new NodoInt(a.elemento);
				if(b == null) {
					salida.primero = nuevo;
				}else {
					b.siguiente = nuevo;
				}
				b = nuevo;
			}
			a = a.siguiente;
		}
		return salida;
	}
	
	public double promedioPares() {
		double promedio =0;
		int cont=0;
		NodoInt actual = this.primero;
		while(actual != null) {
			if(actual.elemento % 2 == 0) {
				promedio+=actual.elemento;
				cont++;
			}
			actual = actual.siguiente;
		}
		return cont == 0 ? 0 : promedio / cont;
	}
	
	public void eliminarEntrePos1(int d, int h) {
		int pos=1;
		NodoInt a = this.primero;
		while(a != null && a.siguiente != null) {
			if(pos >= d && pos <= h) {
				if(a.siguiente.elemento % 2 == 0) {
					a.siguiente = a.siguiente.siguiente;
				}else {
					a = a.siguiente;
				}
				pos++;
			}else {
				a = a.siguiente;
				pos++;
			}
		}
	}
	
	public void eliminarEntrePos2(int d, int h) {
		int pos=1;
		NodoInt a = this.primero;
		while(a != null && a.siguiente != null) {
			if(pos >= d && pos <= h && a.siguiente.elemento % 2 == 0) {
				a.siguiente = a.siguiente.siguiente;
			}else {
				a = a.siguiente;
			}
			pos++;
		}
		if(d == 0 && this.primero.elemento % 2 == 0) {
			this.primero = this.primero.siguiente;
		}
	}
	
	//recorta todos los nodos antes de "d" y despues de "h"
	public void recortarFuerade(int d, int h) {
		int pos = 1;
		NodoInt a = this.primero;
		while(a.siguiente != null) {
			if(pos < d || pos > h) {
				a.siguiente = a.siguiente.siguiente;
			}else {
				a = a.siguiente;
			}
			pos++;
		}
		if(d != 0) {
			this.primero = this.primero.siguiente;
		}
	}
	
	public void recortarFuerade2(int d, int h) {
		int pos = 0;
		NodoInt a = this.primero;
		while(a != null) {
			if(pos == d) {
				this.primero = a;
			}
			if(pos == h) {
				a.siguiente= null;
			}
			a = a.siguiente;
			pos++;
		}
	} 
	
	
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
	
	public void eliminarMenoresMayores(int men, int may) {
		NodoInt a = this.primero;
		while(a != null && a.siguiente != null) {
			if(a.siguiente.elemento < men || a.siguiente.elemento > may) {
				a.siguiente = a.siguiente.siguiente;
				// si borro no avanzo
			}else {
				a = a.siguiente;
			}
		}
		if(this.primero.elemento < men || this.primero.elemento > may) {
			this.primero = this.primero.siguiente;
		}
	}
	
	public int nodosMayoresA(int m) {
		NodoInt a = this.primero;
		int cont = 0;
		while(a != null) {
			if(a.elemento > m) {
				cont++;
			}
			a = a.siguiente;
		}
		return cont;
	}
	
	
	
	
}