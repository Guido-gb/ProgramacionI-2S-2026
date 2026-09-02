package pizarra;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PizarraGeometrica extends JPanel {
    private static final long serialVersionUID = 1L;

    private List<Point> puntos = new ArrayList<>();
    private List<Linea> lineas = new ArrayList<>();
    private List<Rectangle> rectangulos = new ArrayList<>();

    // Constructor público para que tu clase Principal no tenga problemas de acceso
    public PizarraGeometrica() {
        setBackground(Color.WHITE);
        
        JFrame ventana = new JFrame("Pizarra Geométrica Controlada");
        ventana.add(this);
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }

    // Método estático opcional por si prefieres usar PizarraGeometrica.crearPizarra()
    public static PizarraGeometrica crearPizarra() {
        return new PizarraGeometrica();
    }

    // Métodos para registrar las figuras geométricas
    public void dibujar(Point p) { puntos.add(p); repaint(); }
    public void dibujar(Linea l) { lineas.add(l); repaint(); }
    public void dibujar(Rectangle r) { rectangulos.add(r); repaint(); }

    // MÉTODO CORRECTO: Fuerza el redibujado desde la clase Principal
    public void actualizar() {
        repaint();
    }

    // Motor de renderizado de la pizarra gráfica
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // 1. Dibujar rectángulos (Verde)
        g.setColor(Color.GREEN);
        for (Rectangle r : rectangulos) {
            g.drawRect(r.x, r.y, r.width, r.height);
        }

        // 2. Dibujar líneas (Azul)
        g.setColor(Color.BLUE);
        for (Linea l : lineas) {
            g.drawLine(l.inicio.x, l.inicio.y, l.fin.x, l.fin.y);
        }

        // 3. Dibujar puntos (Rojo)
        g.setColor(Color.RED);
        for (Point p : puntos) {
            g.fillOval(p.x - 3, p.y - 3, 6, 6);
        }
    }
}
