package Clases;

import javax.swing.JFrame;

import Objetos.Personaje;
import Plataformas.Nivel1;
import Plataformas.Nivel2;

public class Main {
    static int nivel =1;
    public static void main(String[] args) throws Exception {
        Personaje p = new Personaje ();
        JFrame vent = new JFrame();
        Nivel1 obj = new Nivel1();
        Nivel2 obj2 = new Nivel2();
        vent.add(obj);
        
        vent.setSize(850, 600);
        vent.setVisible(true);
        vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (;;) {
            try {
                Thread.sleep(1);
                if (p.vx==850){
                    nivel++;
                    obj.setVisible(false);
                    p.vx = 50;
                    p.vy = 100;
                    // p.suelo= false;
                    // p.vy = p.piso;
                    vent.add(obj2);
                    
                    // p.gravedad=true;
                }
                if (nivel==1){
                    obj.repaint();
                }
                if (nivel==2){
                    obj2.repaint();
                }
            } catch (Exception e) {
                System.out.println("Exception");
            }
        }
    }
}