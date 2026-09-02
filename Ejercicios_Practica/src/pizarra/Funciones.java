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
	/*public static Point centro(Rectangle r) {
		
	}*/
	
}