/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.gurzau_rovellini.casino.Java;

/**
 *
 * @author mirko
 */
public class Carta implements Comparable {

    private int seme;
    private int valore;
    
    public static final String SEMI = "cqfp";    
    public static final String VALORI = "123456789JQKA";


    public Carta(int seme, int valore) {
        this.seme = seme;
        this.valore = valore;
    }
    /**
     * Metodo per aqcuisire il seme di una carta
     * @return il seme della carta
     */

    public String getSeme() {
        switch(seme){
            case 1:
                return "c";
            case 2:
                return "q";
            case 3:
                return "f";
            case 4:
                return "p";
            default:
                return null;
        }
    }
    
    /**
     * Metodo per aqcuisire il valore di una carta
     * @return il valore della carta
     */
    public int getValore() {
        return valore;
    }
    
    /**
     * Metodo per verificare se la carta è un asso
     * @return {@code = true} la carta è un asso
     *          {@code = false} la carta non è un asso
     */
    public boolean isAsso(){
        return valore == 1;
    }
    
    /**
     * Metodo per verificare se la carta è una figura
     * @return {@code = true} la carta è una figura
     *          {@code = false} la carta non è una figura
     */
    public boolean isFigura(){
        return valore > 10; 
    }
    
    /**
     * Metodo per attribuire il valore in gioco ad una carta
     * @return valore della carta
     */
    public int getValoreGioco(){
        // asso
        if (valore == 1) return 11;
        
        // jack, donna, re
        if(valore > 10) return 10;
        
        return valore - 1;
    }
    
    /**
     * Confronta due carte e stabilisce un ordine di grandezza tra le 2 
     * @param o altra carta di confronto
     * @return 0 se hanno lo stesso valore di gioco,
     *          1  se questa carta ha un valore di gioco più alto,
     *          -1 se questa carta ha un valore di gioco inferiore all'altra
     */
    public int compareTo(Object o){
        Carta altra = (Carta) o;
        
        if (altra.getValoreGioco() > getValoreGioco()) return -1;
        if (altra.getValoreGioco() < getValoreGioco()) return 1;
        return 0;
    }
    
   
    /**
     * Medoto per aqcuisire il seme ed il valore di una carta
     * @return il seme e il valore+
     */
    public String getCode(){
        return getSeme() + getValore();
    }
    

    @Override
    public String toString() {
        return getValore() + " " + "di" + " " + getSeme();
    }
  
    
    
}
    
    
    

