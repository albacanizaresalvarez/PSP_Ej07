/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hilos;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


class Corredor extends Thread {
    private static boolean finalCarrera = false;
    private static String ganador;
    private int x;
    private int y;
    private String nombre;
    private int vx = 2;
    private int vy = 2;
    private static final int DIAMETER = 100;
    private Image imagenCorredor;

    public Corredor(int y, int x, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        ImageIcon imageIcon = new ImageIcon("src/Fotos/corredor.png");
        imagenCorredor = imageIcon.getImage();
    }

    public static void iniciarCarrera() {
        finalCarrera = false;
    }

    public static boolean haTerminado() {
        return finalCarrera;
    }

    public static String getGanador() {
        return ganador;
    }

    public void move() {
        if (x + vx < 0 || x + vx > 1200 - DIAMETER) {
            vx = -vx; 

        }
        if (y + vy < 0 || y + vy > 600 - DIAMETER) {
            vy = -vy; 
            finalCarrera = true;
            ganador = nombre;
            
        }

        x = x + vx;
        y = y + vy;
    }

    @Override
    public void run() {
        
        while (!finalCarrera) {
            move(); 
            try {
                Thread.sleep((int)(Math.random() * 50));
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
       
    }

    public void paint(Graphics g) {
       g.drawImage(imagenCorredor, x, y, 100, 100, null);
    }

    public String getNombre() {
        return nombre;
    }

   
}
