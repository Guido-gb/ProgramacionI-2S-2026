package juego;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;

public class Pruebas {

    public static void main(String[] args) {
    	Scanner scan= new Scanner(System.in);
        int numero = -1;
        boolean ok=false;
    	JFrame ventana = new JFrame("Graficador Jodete");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        GraficadorJodete panelGrafico = new GraficadorJodete();
        ventana.add(panelGrafico);
        ventana.setVisible(true);
        
        ManoJugador jugador = new ManoJugador();
        Mazo mazo= new Mazo();
        Carta mesa;
        mazo.mezclar();
        for(int pos =0; pos < 5;pos++) {
        	jugador.recibirCarta(mazo.darCarta());
        }
        mesa = mazo.darCarta();
        
        while(jugador.numCartas() != 0 && mazo.repartidas < 40) {
        	panelGrafico.limpiarPantalla();
	        panelGrafico.mostrarTexto("Mesa", 60, 40, Color.YELLOW);
	        panelGrafico.mostrarTexto("Juego Jodete", 400, 20, Color.YELLOW);
	        panelGrafico.mostrarTexto("Mano Jugador", 50, 220, Color.YELLOW);
	        panelGrafico.agregarCarta(mesa, 50, 50); 
	        panelGrafico.mostrarCartas(jugador.cartas);

        	ok=false;
	        while(!ok) {
		        System.out.println("Ingrese que numero de carta quiere jugar o 0 para recibir carta");
		        numero = scan.nextInt();
		        if( numero < 0 || numero > jugador.numCartas()) {
		        	System.out.println("Ingreso un numero invalido");
		        }else {
		        	ok = true;
		        }
	        }
	        if(numero == 0) {
	        	jugador.recibirCarta(mazo.darCarta());
	        }else {
	        	Carta jugada = jugador.jugarCarta(numero);
	        	if(jugada.palo == mesa.palo || jugada.numero == mesa.numero) {
	        		mesa = jugada;
	        	}else {
	        		System.out.println("Jugada invalida. Solo puede jugar " + mesa.numero + " o " + mesa.palo);
	        		jugador.recibirCarta(jugada);
	        	}
	        }
        }
        if(jugador.numCartas() == 0) {
        	System.out.println("Ganaste");
        }else {
        	System.out.println("Perdiste");
        }
    }
}

	
