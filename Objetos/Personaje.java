package Objetos;

import java.awt.*;

public class Personaje {
    float x = 40, y = 280, alto = y - 120, piso = 280;
    int vx, vy;
    boolean derecha = false, izquierda = false, grav = true, sal = false, suelo = false;

    public void paint(Graphics g) {
        vx = (int) x;
        vy = (int) y;
        g.setColor(Color.cyan);
        g.fillRect(vx, vy, 20, 20);
        izq();
        der();
        gravedad();
        saltar();
        suelo();
    }

    public void keyPressed(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == 37) {
            izquierda = true;
        }
        if (e.getKeyCode() == 39) {
            derecha = true;
        }
        if (e.getKeyCode() == 38) {
            sal = true;
        }
    }

    public void keyReleased(java.awt.event.KeyEvent e) {
        if (e.getKeyCode() == 37) {
            izquierda = false;
        }
        if (e.getKeyCode() == 39) {
            derecha = false;
        }
    }

    public void izq() {
        if (izquierda) {
            x -= .5;
        }
    }

    public void der() {
        if (derecha) {
            x += .5;
        }
    }

    public void gravedad() {
        if (y == piso) {
            suelo = true;
        }
        if (grav) {
            y += 1;
        }
    }

    public void saltar() {

        if (sal) {
            if (y >= alto) {
                y -= 2;
                grav = true;
                suelo = false;
            } else {
                sal = false;
            }
        }

    }

    public void suelo() {
        if (suelo) {
            grav = false;
        }
    }

}
