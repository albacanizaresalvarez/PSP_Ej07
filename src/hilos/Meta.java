
package hilos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

class Meta {
    private int x;
    private int y;
    private static final int WIDTH = 1100;
    private static final int HEIGHT = 20;
    private static final Color color = new Color(164, 196, 71); 

    public Meta(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        g.setColor(color); // Color de la meta
        g.fillRect(x, y, WIDTH, HEIGHT); // Dibuja un rectángulo para representar la meta (suelo)
    }
}