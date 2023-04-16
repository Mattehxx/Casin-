package it.gurzau_rovellini.casino.Java;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author teoro
 */
public class Spin extends Thread {
    ImageIcon[] images;
    JLabel lbl;
    int pause;
    int index;

    public Spin(ImageIcon[] images, JLabel lbl, int pause) {
        this.images=images;
        this.lbl=lbl;
        this.pause=pause;
    }
    
    /**
     * Metodo per animare la scelta casuale delle immagini della slotmachine
     */
    @Override
    public void run() {
        try {
            for (int i=0;i<5;i++) {
                //generazione casuale di un indice dell'array delle immagini
                Random rnd=new Random();
                lbl.setIcon(images[index=rnd.nextInt(16)]);
                //pausa del thread
                Thread.sleep(pause);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Spin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
}