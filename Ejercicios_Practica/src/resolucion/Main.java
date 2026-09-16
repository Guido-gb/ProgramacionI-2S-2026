package resolucion;

public class Main {

	public static void main(String[] args) {
		Dibujador d = new Dibujador();
		Imagen imagen = new Imagen("perro.jpg");
		d.dibujar(imagen);
		imagen.borrar();;
		d.dibujar(imagen);
	}
}