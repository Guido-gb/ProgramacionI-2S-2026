package juego; 

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraficadorJodete extends JPanel {

    // Constantes de clase para el tamaño de las cartas (las podés modificar acá)
    public static final int ANCHO_CARTA = 80;
    public static final int ALTO_CARTA = 120;

    // Estructura interna para asociar una carta con su posición y su identificador
    private class CartaPosicionada {
        Carta carta;
        int x;
        int y;
        int numeroIdentificador;

        CartaPosicionada(Carta carta, int x, int y, int numeroIdentificador) {
            this.carta = carta;
            this.x = x;
            this.y = y;
            this.numeroIdentificador = numeroIdentificador;
        }
    }

    // Estructura interna para recordar los textos agregados a la mesa
    private class TextoPantalla {
        String contenido;
        int x;
        int y;
        Color color;

        TextoPantalla(String contenido, int x, int y, Color color) {
            this.contenido = contenido;
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    private ArrayList<CartaPosicionada> cartasEnPantalla;
    private ArrayList<TextoPantalla> textosEnPantalla;

    // Constructor: Arranca completamente vacío
    public GraficadorJodete() {
        this.cartasEnPantalla = new ArrayList<>();
        this.textosEnPantalla = new ArrayList<>();
        this.setBackground(new Color(34, 139, 34)); // Fondo verde mesa de juego
    }

    /**
     * Coloca una carta suelta en una coordenada manual específica.
     */
    public void agregarCarta(Carta nuevaCarta, int x, int y) {
        if (nuevaCarta != null) {
            synchronized (this) {
                this.cartasEnPantalla.add(new CartaPosicionada(nuevaCarta, x, y, -1));
            }
            this.repaint();
        }
    }

    /**
     * Muestra un arreglo de cartas en filas de 8 columnas partiendo de (50, 200).
     * Cada fila tapa el 25% inferior de la anterior y las numera del 1 al N saltando los nulos.
     */
    public void mostrarCartas(Carta[] arregloCartas) {
        if (arregloCartas == null) return;

        int xInicial = 50;
        int yInicial = 250;

        int separacionX = ANCHO_CARTA + 10; 
        int separacionY = (int) (ALTO_CARTA * 0.75); 

        int columna = 0;
        int fila = 0;
        int contadorCartasValidas = 1;

        synchronized (this) {
            for (int i = 0; i < arregloCartas.length; i++) {
                Carta carta = arregloCartas[i];
                
                // Si el elemento es nulo, no se dibuja ni avanza el contador
                if (carta == null) continue;

                int posX = xInicial + (columna * separacionX);
                int posY = yInicial + (fila * separacionY);

                this.cartasEnPantalla.add(new CartaPosicionada(carta, posX, posY, contadorCartasValidas));

                contadorCartasValidas++;
                columna++;
                
                if (columna == 8) {
                    columna = 0;
                    fila++;
                }
            }
        }

        this.repaint();
    }

    /**
     * Dibuja un texto personalizado en pantalla con coordenadas y color a elección.
     */
    public void mostrarTexto(String texto, int x, int y, Color color) {
        if (texto != null && color != null) {
            synchronized (this) {
                this.textosEnPantalla.add(new TextoPantalla(texto, x, y, color));
            }
            this.repaint();
        }
    }

    /**
     * Borra únicamente las cartas de la pantalla para poder redibujar de cero manualmente.
     */
    public void limpiarCartas() {
        synchronized (this) {
            this.cartasEnPantalla.clear();
        }
        this.repaint();
    }

    /**
     * Limpia por completo todas las cartas y textos del tablero gráfico.
     */
    public void limpiarPantalla() {
        synchronized (this) {
            this.cartasEnPantalla.clear();
            this.textosEnPantalla.clear();
        }
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Activar suavizado para que los círculos y palos no se vean pixelados
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Clona las listas de manera segura bajo sincronización para evitar la excepción
        ArrayList<CartaPosicionada> copiaCartas;
        ArrayList<TextoPantalla> copiaTextos;
        
        synchronized (this) {
            copiaCartas = new ArrayList<>(cartasEnPantalla);
            copiaTextos = new ArrayList<>(textosEnPantalla);
        }

        // 1. Dibujar todas las cartas posicionadas desde la copia segura
        for (CartaPosicionada cp : copiaCartas) {
            Carta carta = cp.carta;
            int x = cp.x;
            int y = cp.y;

            // Fondo blanco con bordes redondeados
            g2d.setColor(Color.WHITE);
            g2d.fillRoundRect(x, y, ANCHO_CARTA, ALTO_CARTA, 15, 15);
            
            // Borde exterior negro
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(1.5f));
            g2d.drawRoundRect(x, y, ANCHO_CARTA, ALTO_CARTA, 15, 15);

            // Obtener el color correspondiente al palo español
            Color colorPalo = obtenerColorPalo(carta.palo);
            g2d.setColor(colorPalo);

            // Dibujar el número de la carta en los extremos internos
            g2d.setFont(new Font("Arial", Font.BOLD, 16));
            String numStr = String.valueOf(carta.numero);
            g2d.drawString(numStr, x + 8, y + 20); 
            g2d.drawString(numStr, x + ANCHO_CARTA - 18, y + ALTO_CARTA - 10); 

            // Dibujar diseño del palo geométrico centrado
            dibujarSimboloPalo(g2d, carta.palo, x + ANCHO_CARTA / 2, y + ALTO_CARTA / 2);

            // Dibujar el indicador numérico del array con su círculo amarillo suave
            if (cp.numeroIdentificador != -1) {
                String textoNum = String.valueOf(cp.numeroIdentificador);
                g2d.setFont(new Font("Arial", Font.BOLD, 12));
                FontMetrics fm = g2d.getFontMetrics();
                
                int diametroCirculo = 20; 
                int xCirculo = x + ANCHO_CARTA - diametroCirculo - 2; // Extremo derecho
                int yCirculo = y - (diametroCirculo / 2);              // Mitad sobre el borde superior

                // Relleno amarillo pastel suave
                g2d.setColor(new Color(255, 239, 150)); 
                g2d.fillOval(xCirculo, yCirculo, diametroCirculo, diametroCirculo);
                
                // Contorno del circulito indicador
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(1.0f));
                g2d.drawOval(xCirculo, yCirculo, diametroCirculo, diametroCirculo);

                // Texto numérico centrado dentro del círculo amarillo
                int xTexto = xCirculo + (diametroCirculo - fm.stringWidth(textoNum)) / 2;
                int yTexto = yCirculo + ((diametroCirculo - fm.getHeight()) / 2) + fm.getAscent();
                
                g2d.drawString(textoNum, xTexto, yTexto);
            }
        }

        // 2. Dibujar los textos personalizados sobre la mesa desde la copia segura
        g2d.setFont(new Font("Arial", Font.BOLD, 18));
        for (TextoPantalla tp : copiaTextos) {
            g2d.setColor(tp.color);
            g2d.drawString(tp.contenido, tp.x, tp.y);
        }
    }

    private Color obtenerColorPalo(int palo) {
        switch (palo) {
            case 2: return new Color(218, 165, 32); // Oros (Dorado)
            case 3: return new Color(178, 34, 34);  // Copas (Rojo vino)
            case 1: return new Color(30, 144, 255); // Espadas (Azul acero)
            case 4: return new Color(34, 139, 34);  // Bastos (Verde)
            default: return Color.BLACK;
        }
    }

    private void dibujarSimboloPalo(Graphics2D g2d, int palo, int centerX, int centerY) {
        int r = 16;
        switch (palo) {
            case 2: // OROS
                g2d.fillOval(centerX - r, centerY - r, r * 2, r * 2);
                g2d.setColor(Color.WHITE);
                g2d.drawOval(centerX - (r - 4), centerY - (r - 4), (r - 4) * 2, (r - 4) * 2);
                break;
            case 3: // COPAS
                int[] xCopa = {centerX - 12, centerX + 12, centerX + 8, centerX - 8};
                int[] yCopa = {centerY - 10, centerY - 10, centerY + 6, centerY + 6};
                g2d.fillPolygon(xCopa, yCopa, 4);
                g2d.fillRect(centerX - 3, centerY + 6, 6, 8);
                g2d.fillRect(centerX - 10, centerY + 12, 20, 4);
                break;
            case 1: // ESPADAS
                int[] xEspada = {centerX, centerX + 8, centerX, centerX - 8};
                int[] yEspada = {centerY - 16, centerY, centerY + 8, centerY};
                g2d.fillPolygon(xEspada, yEspada, 4);
                g2d.fillRect(centerX - 10, centerY + 8, 20, 3);
                g2d.fillRect(centerX - 2, centerY + 11, 4, 7);
                break;
            case 4: // BASTOS
                g2d.rotate(Math.toRadians(15), centerX, centerY);
                g2d.fillRoundRect(centerX - 6, centerY - 15, 12, 30, 8, 8);
                g2d.fillOval(centerX - 9, centerY - 5, 5, 5);
                g2d.fillOval(centerX + 4, centerY + 5, 5, 5);
                g2d.rotate(Math.toRadians(-15), centerX, centerY);
                break;
        }
    }
}

