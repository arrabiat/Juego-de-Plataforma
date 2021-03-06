package Plataformas;

import javax.swing.JLabel;

// import Clases.Colores;
import Objetos.Personaje;
import java.awt.*;
import java.math.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Nivel1 extends JLabel {
    float x = 0, y = 300;
    int vx, vy;

    Boolean ida = true, vuelta = false, pcuarto = true, scuarto = false; 
    // estas son las fases o estapas que se hacen en el recorrido de media luna del cuadadrado del nivel
    Personaje per = new Personaje();
    // Colores color = new Colores();

    public Nivel1() {
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                per.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                per.keyReleased(e);
            }
        });
        setFocusable(true);
        // addMouseListener(new MouseListener() {

            // @Override
            // public void mouseClicked(MouseEvent e) {
                // color.mouseClicked(e);                
            // }

            // @Override
            // public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            // }

            // @Override
            // public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            // }

            // @Override
            // public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub
                
            // }

            // @Override
            // public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            // }

        // });
    }


    public void paint(Graphics g) {
        vx = (int) x;
        vy = (int) y;
        // cada que cicla el programa asigno los valores a estas variables enteras
        // debido a que el metodo fillRect no acepta valores flotantes
        super.paint(g);
        g.fillRect(0,300,150,300);
        g.fillRect(700,300,150,300);
        g.fillRect(400,300,50,50);
        g.fillRect(vx, vy, 50, 50);
        per.paint(g);
        // color.color();}
        Circulo();
        // System.out.println("x= " + x);
        // System.out.println("y= " + y);
        if (per.rectangulo().intersects(Circulo())){
            System.out.println("colicion");
        }
    }

    public Rectangle Circulo() {
        // algo importante en la funcion original
        // x = -raiz(-(y+150)*(y+450))+400
        // declaro a y con un valor positivo y en la formula le doy un valor negativo
        // debido a que en java los valores
        // no pueden ser negativos al contrario de un plano carteciano
        // todos los valores deben de ser positivos para ser representados en el grafico
        if (ida) {
            // en la condicion ida le indico que debe ir de izquierda a derecha
            if (pcuarto) {
                x = (float) -Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                // utilizo esta formula si se evalua en una grafica da como resultado un circulo. 
                y += .05;
                if (y > 450) {
                    scuarto=true;
                    pcuarto=false;
                }
            }
            if (scuarto) {
                x = (float) Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                y -= .05;
                if (y < 300) {
                    // como solo deseo que se dibuje una media luna, cuando llegue a la mitad hago a la variable 
                    // ida falsa y vuelta verdadera
                    vuelta=true;
                    ida=false;
                }
            }
        }
        // decremento en lugar de aumento para hacer que retroceda la plataforma
        if (vuelta) {
            if (pcuarto) {
                x = (float) -Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                y -= .05;
                if (y < 300) {
                    vuelta=false;
                    ida=true;
                }
            }
            if (scuarto) {
                x = (float) Math.sqrt(-(-y + 150) * (-y + 450)) + 400;
                y += .05;
                if (y > 450) {
                    scuarto = false;
                    pcuarto = true;
                }
            }
        }   
        
    // public ArrayList<Rectangle> obtieneCajaLluvia() {
        // ArrayList<Rectangle> arreglo = new ArrayList<>();
        // for (int i = 0; i < arrayY.size(); i++) {
            // arreglo.add(new Rectangle(x, arrayY.get(i) + y, 100, 100));
        // }
        // return arreglo;
        return new Rectangle(vx, vy,50,50); 
        // creo un objeto de tipo rectangulo que en cada actualizacion me retorna la ubicacion de la plataforma
    }
}
