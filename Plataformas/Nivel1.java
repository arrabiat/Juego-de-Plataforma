package Plataformas;

import javax.swing.JLabel;
import java.awt.*;
import java.math.*;

public class Nivel1 extends JLabel {
    float x = 0, y = 300;
    int vx, vy;
    Boolean ida = true, vuelta = false, pcuarto = true, scuarto = false;

    public Nivel1() {
    }

    public void paint(Graphics g) {
        vx = (int) x;
        vy = (int) y;
        super.paint(g);
        g.fillRect(0,300,150,300);
        g.fillRect(700,300,150,300);
        g.fillRect(400,300,50,50);
        g.fillRect(vx, vy, 50, 50);
        Circulo();
        // System.out.println("x= " + x);
        // System.out.println("y= " + y);
    }

    public void Circulo() {
        if (ida) {
            if (pcuarto) {
                x = (float) -Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                y += .1;
                if (y > 450) {
                    scuarto=true;
                    pcuarto=false;
                }
            }
            if (scuarto) {
                x = (float) Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                y -= .1;
                if (y < 300) {
                    vuelta=true;
                    ida=false;
                }
            }
        }
        if (vuelta) {
            if (pcuarto) {
                x = (float) -Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                y -= .1;
                if (y < 300) {
                    vuelta=false;
                    ida=true;
                }
            }
            if (scuarto) {
                x = (float) Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                y += .1;
                if (y > 450) {
                    scuarto = false;
                    pcuarto = true;
                }
            }
        }
    }
}
