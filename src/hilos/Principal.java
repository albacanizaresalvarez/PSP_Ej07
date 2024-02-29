
package hilos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class Principal extends JFrame {
   private List<Corredor> corredores;
    Meta meta;
    private JPanel panelJuego;
    String ganador;
    private Image imagenFondo;


    public Principal() {
        setTitle("Carrera de Paracaidistas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1550, 700);
        
        ImageIcon imageIcon = new ImageIcon("src/Fotos/fondo.png");
        imagenFondo = imageIcon.getImage();

        panelJuego = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
                for (Corredor corredor : corredores) {
                    corredor.paint(g);
                }
                meta.paint(g);
            }
        };
        add(panelJuego);

        corredores = new ArrayList<>();
        corredores.add(new Corredor(1, 10, "Paracaidista 1"));
        corredores.add(new Corredor(1, 150, "Paracaidista 2"));
        corredores.add(new Corredor(1, 300, "Paracaidista 3"));
        corredores.add(new Corredor(1, 450, "Paracaidista 4"));
        corredores.add(new Corredor(1, 600, "Paracaidista 5"));

        meta = new Meta(200, 600);

        for (Corredor corredor : corredores) {
            corredor.start();
        }

        Timer timer = new Timer(10, e -> {
            panelJuego.repaint();
            checkWinners();
           
        });
        timer.start();
    }

   public void checkWinners() {
        String campeon = Corredor.getGanador();
        if (campeon != null) {
            JOptionPane.showMessageDialog(this, "Ha ganado: " + campeon, "Final de la Carrera", JOptionPane.INFORMATION_MESSAGE);
            System.exit(ABORT);
        }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       SwingUtilities.invokeLater(() -> {
            Principal ventana = new Principal();
            ventana.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
