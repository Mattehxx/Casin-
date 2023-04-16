package it.gurzau_rovellini.casino.Java;

/**
 *
 * @author mirko
 */
public class Account {
    private String username;
    private String password;
    private int crediti;
    
    public static final int DEFAULT_CREDITI = 0;
    public static final int MIN_LENGTH = 6;
    public static final int MAX_LENGTH = 16;

    
    public Account(String username, String password, int crediti){
        this.username = username;
        this.password = password;
        this.crediti = crediti;
    }
    
    public Account(String username, String password){
        this.username = username;
        this.password = password;
        this.crediti = DEFAULT_CREDITI;
    }
    
    /**
    * Metodo getter del username dell'account
    * @return stringa che rappresenta lo username univoco dell'account
    */
     public String getUsername() {
        return username;
    }
     
    /**
    * Metodo getter della password dell'account
    * @return stringa che rappresenta la password dell'account
    */
    public String getPassword() {
        return password;
    }
    
    /**
    * Metodo getter dei crediti presenti nell'account
    * @return int che rappresenta i crediti correnti dell'account
    */
    public int getCrediti() {
        return crediti;
    }
     /**
    * Metodo setter dei crediti presenti nell'account
    * @param crediti la nuova di crediti da attribuire all'account
    * @return nuovi crediti presenti nell'account
    */
    public int setCrediti(int crediti){
        return this.crediti = crediti;
    }
    
    /**
     * Metodo per verificare la presenza di sufficienti crediti
     * @param crediti l'importo da verificare
     * @return {@code = true} crediti sufficienti
     *          {@code = false} crediti non sufficienti
     */
    public boolean creditiSufficienti (int crediti) {
        if (this.crediti>=crediti) return true;
        return false;
    }
    
    /**
     * Metodo per controllare se la lunghezza della password rispetta i parametri imposti
     * @param password stringa da controllare
     * @return {@code = true} password valida
     *          {@code = false} password non valida
     */
    
    public static boolean passwordValid(String password) {
        if (password.length() < MIN_LENGTH || password.length() > MAX_LENGTH)
            return false;
        return true;
        
    }
    
    
    @Override
    public String toString() {
        return username + "," + password + "," + crediti;
    }
     
     
    
}
