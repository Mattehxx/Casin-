package it.gurzau_rovellini.casino.Java;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author teoro
 */
public class ConditionSlotMachine extends Thread {
    Spin spin1, spin2, spin3, spin4, spin5;
    JLabel lblBet, lblNumCredits, lblNumWinnings;
    JButton btnSpin;
    int win, initialCredits;

    public ConditionSlotMachine(Spin spin1, Spin spin2, Spin spin3, Spin spin4, Spin spin5, JLabel lblBet, JLabel lblNumCredits, JLabel lblNumWinnings, JButton btnspin, int initialCredits) {
        this.spin1=spin1;
        this.spin2=spin2;
        this.spin3=spin3;
        this.spin4=spin4;
        this.spin5=spin5;
        this.lblBet=lblBet;
        this.lblNumCredits=lblNumCredits;
        this.lblNumWinnings=lblNumWinnings;
        this.btnSpin=btnspin;
        this.initialCredits=initialCredits;
        win=0;
    }
    
    /**
     * Metodo per la verifica delle condizioni di vittoria della slotmachine
     */
    @Override
    public void run() {
        try {
            btnSpin.setEnabled(false);
            //attesa della fine degli altri thread
            Thread.sleep(610*5);
            
            //condizione 5 figure uguali
            if (spin1.index==spin2.index&&spin1.index==spin3.index&&spin1.index==spin4.index&&spin1.index==spin5.index) {
                win=(spin1.index+1+Integer.parseInt(lblBet.getText()))*5;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
            
            //condizioni 4 figure uguali con spin1
            } else if (spin1.index==spin2.index&&spin1.index==spin3.index&&spin1.index==spin4.index
                    || spin1.index==spin2.index&&spin1.index==spin3.index&&spin1.index==spin5.index
                    || spin1.index==spin2.index&&spin1.index==spin4.index&&spin1.index==spin5.index
                    || spin1.index==spin3.index&&spin1.index==spin4.index&&spin1.index==spin5.index) {
                win=(spin1.index+1+Integer.parseInt(lblBet.getText()))*4;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizioni 4 figure uguali con spin2
            } else if (spin2.index==spin3.index&&spin2.index==spin4.index&&spin2.index==spin5.index) {
                win=(spin2.index+1+Integer.parseInt(lblBet.getText()))*4;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizioni 3 figure uguali con spin1
            } else if (spin1.index==spin2.index&&spin1.index==spin3.index || spin1.index==spin2.index&&spin1.index==spin4.index 
                    || spin1.index==spin2.index&&spin1.index==spin5.index || spin1.index==spin3.index&&spin1.index==spin4.index 
                    || spin1.index==spin3.index&&spin1.index==spin5.index || spin1.index==spin4.index&&spin1.index==spin5.index) {
                win=(spin1.index+1+Integer.parseInt(lblBet.getText()))*3;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizioni 3 figure uguali con spin2
            } else if (spin2.index==spin3.index&&spin2.index==spin4.index || spin2.index==spin3.index&&spin2.index==spin5.index
                    || spin2.index==spin4.index&&spin2.index==spin5.index) {
                win=(spin2.index+1+Integer.parseInt(lblBet.getText()))*3;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizioni 3 figure uguali con spin3
            } else if (spin3.index==spin4.index&&spin3.index==spin5.index) {
                win=(spin3.index+1+Integer.parseInt(lblBet.getText()))*3;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizioni 2 figure uguali con spin1
            } else if (spin1.index==spin2.index || spin1.index==spin3.index || spin1.index==spin4.index || spin1.index==spin5.index) {
                win=(spin1.index+1+Integer.parseInt(lblBet.getText()))*2;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizioni 2 figure uguali con spin2
            } else if (spin2.index==spin3.index || spin2.index==spin4.index || spin2.index==spin5.index) {
                win=(spin2.index+1+Integer.parseInt(lblBet.getText()))*2;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizioni 2 figure uguali con spin3
            } else if (spin3.index==spin4.index || spin3.index==spin5.index) {
                win=(spin3.index+1+Integer.parseInt(lblBet.getText()))*2;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizione 2 figure uguali con spin4
            } else if (spin4.index==spin5.index) {
                win=(spin4.index+1+Integer.parseInt(lblBet.getText()))*2;
                lblNumCredits.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())+win));
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumCredits.getText())-initialCredits));
                
            //condizione nessuna figura uguale
            } else {
                lblNumWinnings.setText(String.valueOf(Integer.parseInt(lblNumWinnings.getText())-Integer.parseInt(lblBet.getText())));
            }
            lblBet.setText("0");
            btnSpin.setEnabled(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(ConditionSlotMachine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
