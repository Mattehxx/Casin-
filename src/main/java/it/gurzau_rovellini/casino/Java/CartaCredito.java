package it.gurzau_rovellini.casino.Java;

/**
 * Classe che definisce una carta di credito
 * @author Mirko Gurzau
 */
public class CartaCredito {
    /**
     * Nome del proprietario della carta
     */
    private String proprioetario;
    
    /**
     * Numero identificativo della carta
     */
    private String numeroCarta;
    
    /**
     * CVV della carta
     */
    private String cvv;
    
    /**
     * Saldo della carta
     */
    private int saldo;
    
    
    /**
     * Saldo iniziale al momento della creazione di una nuova carta
     */
    public static final int DEFAULT_SOLDI = 100;
    
    
    /**
     * Costruttore di una carta di credito
     * @param proprioetario stringa contenente nome del proprietario della carta
     * @param numeroCarta string contenente il numero identificativo della carta
     * @param cvv valore intero del cvv della carta
     * @param saldo valore intero del saldo sulla carta
     */
    public CartaCredito(String proprioetario, String numeroCarta, String cvv, int saldo){
        this.proprioetario = proprioetario;
        this.numeroCarta = numeroCarta;
        this.cvv = cvv;
        this.saldo = saldo;
    }

    /**
     * Metodo getter del nome del proprietario
     * @return stringa che rappresenta il nome del proprietario
     */
    public String getProprietario() {
        return proprioetario;
    }

    /**
     * Metodo getter del numero della carta
     * @return stringa che rappresenta il numero univoco della carta
     */
    public String getNumeroCarta() {
        return numeroCarta;
    }

    /**
     * Metodo getter del cvv
     * @return stringa del cvv
     */
    public String getCvv() {
        return cvv;
    }

    /**
     * Metodo getter del saldo del proprietario della carta
     * @return valore intero del saldo corrente
     */
    public int getSaldo() {
        return saldo;
    }
    
    /** 
     * Metodo per verificare la lunghezza del numero della carta
     * @return {@code = true} lunghezza numero carta corretto
     *          {@code = false} lunghezza numero carta errato
     */
    public boolean nCardValido() {
        int count=0;
        for (int i = 0;i < numeroCarta.length();i++) {
            if (numeroCarta.charAt(i) >= '0' && numeroCarta.charAt(i) <= '9') {
                count++;
            }
        }
        
        if (count == 16) return true;
        return false;
    }
    
    /** 
     * Metodo per verificare la lunghezza del CVV della carta 
     * @return {@code = true} lunghezza CVV della carta corretto
     *          {@code = false} lunghezza CVV della carta  errato
     */
    public boolean cvvValido() {
        int count=0;
        for (int i = 0;i < cvv.length();i++) {
            if (cvv.charAt(i) >= '0' && cvv.charAt(i) <= '9') {
                count++;
            }
        }
        
        if (count == 3) return true;
        return false;
    }
    
    /**
     * Controlla se è possibile prelevare una certa quantità di denaro
     * @param soldi valore intero che corrispondono ai soldi da prelevare
     * @return {@code true} Se e solo se, il saldo è maggiore o uguale rispetto ai soldi da prelevare
     *         Altrimenti {@code false}. 
     */
    public boolean puoPrelevare(int soldi) {
        return saldo >= soldi;
    }
    
    
    /**
     * Deposita una quantità specifica di denaro sulla carta
     * @param soldi valore intero che rappresenta la quantità di denaro da depositare
     * @return valore intero del nuovo saldo modificato
     */
    public int deposita(int soldi){
       this.saldo += soldi;
       return this.saldo;
    }
    
    /**
     * Preleva una quantità specifica di denaro sulla carta
     * @param soldi valore intero che rappresenta la quantità di denaro da prelevare
     * @return valore intero del nuovo saldo modificato
     */
    public int preleva(int soldi){
        if (puoPrelevare(soldi)) this.saldo -= soldi;
        return this.saldo;
    }

    @Override
    public boolean equals(Object obj) {
        CartaCredito altro = (CartaCredito) obj;
        return numeroCarta.equals(altro.getNumeroCarta());
    }
    

    @Override
    public String toString() {
        return proprioetario + "," + numeroCarta + "," + cvv + "," + saldo;
    }

    
    
    
    
}
