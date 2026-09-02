package pizarra;

import java.awt.Point;
import java.awt.Rectangle;

public class Funciones {
	//La función debe devolver la distancia entre los puntos p1 y p2.
	
	public static double distancia(Point p1, Point p2) {
		return Math.sqrt( (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y) );
	}
	
	// La función debe devolver la medida de la diagonal del rectángulo pasado como parámetro. 
	// Usar la función distancia() del punto anterior sobre determinados puntos del rectángulo.
	
	public static double diagonal(Rectangle r) {
		Point p1 = new Point(r.x,r.y);
		Point p2 = new Point(r.x + r.width, r.y + r.height);
		return distancia(p1, p2);
	}
	
	// La función debe devolver el punto central del rectangulo r.
	
	public static Point centro(Rectangle r) {
		return new Point(r.x + r.width/2, r.y + r.height/2);
	}
	
	// La función debe indicar si el punto p está dentro del rectángulo r.
	
	public static boolean estáDentro(Point p, Rectangle r) {
		return p.x > r.x && r.x < r.x + r.width && p.y > r.y && p.y < r.y +r.height;
	}
	
	// La función devuelve un nuevo punto que se encuentra en el medio del segmento que une a p1 con p2.
	// Matemáticamente, este punto tiene como coordenada x el promedio de las coordenadas x de los dos puntos, 
	// y lo mismo para la coordenada y.
	
	public static Point puntoMedio(Point p1, Point p2) {
		return new Point((p1.x + p2.x)/2,(p1.y + p2.y)/2 );	
	}
	
	// La función debe devolver el rectángulo más pequeño que contenga 
	// a los dos rectángulos pasados como parámetros.
	
	public static Rectangle encuadrar(Rectangle r1, Rectangle r2) {
		return null;
	}
	
	// La función debe indicar si el rectangulo r1 está contenido completamente dentro del rectángulo r2.
	
	public static boolean estáContenido(Rectangle r1, Rectangle r2) {
		return false;
	}
	
	// (Ejercicio desafío) La función debe devolver el rectángulo contenido en ambos rectángulos r1 y r2.
	// En caso de que no se intersequen debe devolver null.
	
	public static Rectangle intersección(Rectangle r1, Rectangle r2) {
		return null;
	}
	
	
}