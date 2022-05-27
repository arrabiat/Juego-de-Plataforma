package Plataformas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Objetos.Personaje;
import javafx.scene.control.TableColumn.SortType;

import java.awt.*;

public class Nivel2 extends JPanel{
    Personaje personaje = new Personaje ();
    public Nivel2 (){
        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
        
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                personaje.keyReleased(e);
            }
        });
        setFocusable(true);
    }
    public void paint(Graphics g) {
      
        // cada que cicla el programa asigno los valores a estas variables enteras
        // debido a que el metodo fillRect no acepta valores flotantes
        super.paint(g);
        g.fillRect(20, 300, 50, 50);
        g.fillRect(170, 300, 50, 50);
        g.fillRect(360, 300, 50, 50);
        g.fillRect(500, 300, 50, 50);
        g.fillRect(650, 300, 50, 50);
        g.fillRect(800, 300, 50, 50);
        personaje.paint(g);
        // System.out.println(personaje.rectangulo());
        System.out.println(personaje.suelo);
        // System.out.println(personaje.gravedad);
        
        // color.color();    
        // System.out.println("x= " + x);
        // System.out.println("y= " + y);
    
    }
}
