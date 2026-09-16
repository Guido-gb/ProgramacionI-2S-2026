package resolucion;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Persona {
    String nombre;
    int edad;
    int DNI;
    String email;
    
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	boolean masJovenQue(Persona otro) {
		return this.edad < otro.edad;
	}
	
	boolean tocayo(Persona otro) {
		return this.nombre.equals(otro.nombre);
	}
	
	boolean mismaPersona(Persona otro) {
		return this.DNI == otro.DNI;
	}
	
	static Persona masJoven(Persona[] grupo) {
		Persona masJoven = grupo[0];
		for(Persona p:grupo) {
			if(p.edad < masJoven.edad) {
				masJoven = p;
			}
		}
		return masJoven;
	}
	
	static Persona buscar(Persona[] grupo, String nombre) {
		for(Persona p:grupo) {
			if(p.nombre.equals(nombre)) {
				return p;
			}
		}
		return null;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		String refs= "qwertyuiopñlkjhgfdsazxcvbnm .'áéíóúü";
		refs += refs.toUpperCase();
		for(int pos=0;pos<nombre.length();pos++) {
			if(refs.indexOf(nombre.charAt(pos)) == -1) {
				throw new RuntimeException("Caracter invalido " + nombre.charAt(pos));
			}
		}
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if(edad < 0 || edad > 120) {
			throw new RuntimeException("Edad invalida, tiene que ser mayor a 0 o menor a 120");
		}
		this.edad = edad;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int DNI) {
		if(DNI < 1000000 || DNI > 100000000) {
			throw new RuntimeException("DNI invalido");
		}
		this.DNI = DNI;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		String refs= "qwertyuioplkjhgfdsazxcvbnm.-_1234567890";
		refs += refs.toUpperCase();
		int posA = email.indexOf('@');
		if(posA < 1) {
			throw new RuntimeException("Email invalido, no tiene @");
		}
		String usuario = email.substring(0, posA);
		String dominio = email.substring(posA+1);
		for(int pos=0;pos<usuario.length();pos++) {
			if(refs.indexOf(usuario.charAt(pos)) == -1) {
				throw new RuntimeException("Usuario invalido");
			}
		}
		try {
			InetAddress.getByName(dominio);
		} catch (UnknownHostException e) {
			throw new RuntimeException("Dominio invalido");
		}
		this.email = email;
	}
}
