/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.gurzau_rovellini.casino.Java;

import java.util.Random;
import java.util.Vector;


/**
 *
 * @author mirko
 */
public class Mazzo {
  private Vector<Carta> mazzo = new Vector<>();
  
  private Random rand = new Random();
  public static final int DEFAULT_CARTE = 52;

    public Mazzo(int numCarte){
        int k = 0;
        while (k < numCarte) {
            for (int i = 1; i < Carta.SEMI.length() + 1; i++) {
                for (int j = 1; j < Carta.VALORI.length() + 1; j++) {
                    mazzo.add(new Carta(i, j));
                    //System.out.println(mazzo.lastElement());
                    k++;
                }
            }
        }
        shuffle(20);
    } 
    
    /**
     * Medoto per mischiare il mazzo
     * @param times quante volte effettuare la mescolata
     */
    private void shuffle(int times){
        int x, y;
        Carta tmp;
        for (int t = 0; t < times; t++) {
            for (int i = 0; i < mazzo.size(); i++) {
                x = rand.nextInt(mazzo.size());
                y = rand.nextInt(mazzo.size());
                tmp = mazzo.get(x);
                mazzo.set(x, mazzo.get(y));
                mazzo.set(y, tmp);
            }
        }
    }
    /**
     * Metodo getter per prendere una carta dal mazzo ad un particolare indice
     * @param index indice da cui prendere la carta
     * @return la carta all'indice specificato
     */
    public Carta getCarta(int index){
        return mazzo.get(index);
    }
    
    /**
     * Metodo per pescare una carta dal mazzo
     * @return la carta pescata
     */
    public Carta pescaCarta(){
        if (!mazzo.isEmpty()) {
            return mazzo.remove(0);
        }
        return null;
    }
    
    public String toString(){
        for(int i = 0; i < mazzo.size(); i++){
            System.out.println(getCarta(i).toString());
        } 
        return "";
    }
}
