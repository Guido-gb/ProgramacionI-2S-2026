package pizarra;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner; // Importación para leer el teclado de la consola

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // 1. Iniciar la pizarra
        PizarraGeometrica pizarra = PizarraGeometrica.crearPizarra();

        // 2. Crear y enviar figuras iniciales
        Point p1 = new Point(100, 100);
        Point p2 = new Point(300, 300);
        Point p3 = new Point(100,300);
        
        Rectangle r1 = new Rectangle(100,100,100,200);
        Point punto1DeR1 = new Point(r1.x, r1.y);
        Point punto2DeR1 = new Point(r1.x + r1.width, r1.y + r1.height);
        
        Linea l1 = new Linea(p1,p2);
        Linea l2 = new Linea(p1,p3);
        Linea l3 = new Linea(p2,p3);
        
        pizarra.dibujar(r1);
        pizarra.dibujar(punto1DeR1);
        pizarra.dibujar(punto2DeR1);
        
        pizarra.actualizar();
        
        System.out.println("La Diagonal de r1 es " + Funciones.diagonal(r1));
        teclado.close();
    }
}
