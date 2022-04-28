package Objetos;

import javax.swing.JFrame;
import Plataformas.Nivel1;

public class Main {
   public static void main(String[] args) {
       JFrame vent = new JFrame();
       Nivel1 obj = new Nivel1();
       vent.add(obj);
       vent.setSize(850, 600);
       vent.setVisible(true);
       vent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       for(;;){
           try {
               Thread.sleep(1);
               obj.repaint();
           }
           catch(Exception e){
                System.out.println("Exception");
           }
       }
   } 
}
