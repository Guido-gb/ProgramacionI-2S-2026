package pizarra;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Scanner; // Importación para leer el teclado de la consola

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // 1. Iniciar la pizarra
        PizarraGeometrica pizarra = PizarraGeometrica.crearPizarra();

        /*
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
        
        Rectangle r = new Rectangle(100,100,100,300);
        
        pizarra.dibujar(r);
        
        Point centro = Funciones.centro(r);
        Point afuera = new Point (400,500);
        
        pizarra.dibujar(centro);
        pizarra.dibujar(afuera);
        
        System.out.println("El punto centro esta adentro? " + Funciones.estáDentro(centro, r));
        System.out.println("El punto afuera esta adentro? " + Funciones.estáDentro(afuera, r));
        
        Point medio = Funciones.puntoMedio(afuera, centro);
        
        pizarra.dibujar(medio);
        
        System.out.println("El punto del medio de afuera y centro es " + medio);
        
        */
        Rectangle r1 = new Rectangle(10,10,200,350);
        Rectangle r2 = new Rectangle(100,50,400,250);
        Point p1 = new Point(Math.max(r1.x,r2.x),Math.max(r1.y,r2.y));
        Point p2 = new Point(Math.min(r1.x + r1.width,r2.x + r2.width),Math.min(r1.y + r1.height,r2.y+r2.height));
        
        pizarra.dibujar(r1);
        pizarra.dibujar(r2);
        pizarra.dibujar(p1);
        pizarra.dibujar(p2);
        //System.out.println("r1 esta adentro de r2? " + Funciones.estaContenido(r1, r2));
        
        teclado.close();
        
      
    }
}
