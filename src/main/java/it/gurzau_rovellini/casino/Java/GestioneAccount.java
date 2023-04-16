package it.gurzau_rovellini.casino.Java;

import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JFrame;

/**
 *
 * @author teoro
 */
public class GestioneAccount {
    private String fileAccount = "./src/main/java/it/gurzau_rovellini/casino/CSV_Files/Account.txt";
    private FileManager fm;
    private Vector<Account> listaAccount;

    public GestioneAccount() {
        fm = new FileManager(fileAccount);
        listaAccount = caricaDati(fm.getAllLines());
    }
    
    /**
     * Trova la posizione di un account nella lista.
     * @param username account da cercare
     * @return ritorna un valore intero da 0 fino a lista.size() se è presente.
     *          Altrimenti -1;
     */
    public int indexOf(String username) {
        int i = 0;
        for (Account account: listaAccount) {
            if (account.getUsername().equals(username)) return i;
            i++;
        }
        return -1;
    }
    
    /**
     * Verifica la presenza di crediti sufficienti all'interno di un account specificato
     * @param username account da cercare
     * @param crediti credti di cui verificare la presenza
     * @return {@code = true} crediti sufficienti
     *          {@code = false} crediti insufficienti
     */
    public boolean creditiSufficienti(String username, int crediti) {
        int pos = indexOf(username);
        if (pos < 0) return false;
        
        Account accDaVerificare = listaAccount.get(pos);
        if (accDaVerificare.creditiSufficienti(crediti)) return true;
        return false;
    }
    
    /**
     * Riempie la lista degli account con i dati presenti nel file
     * @param listLines lista di stringhe che contiene le righe del file
     * @return la lista di account
     */
    private Vector<Account> caricaDati(Vector<String> listLines){
        Vector<Account> tmpList = new Vector<>();
        
        for (String line: listLines){
            StringTokenizer st = new StringTokenizer(line, ",");
            String username = st.nextToken();
            String password = st.nextToken();
            int crediti = Integer.parseInt(st.nextToken());
            
            Account account = new Account(username, password, crediti);
            tmpList.add(account);
        }
        return tmpList;
    }
    
    /**
     * Verifica se nella lista di account esiste già uno username e una password specifici
     * @param username nome da cercare all'interno della lista
     * @param password password da cercare all'interno della lista
     * @return {@code = true} se e solo se, la lista contiene sia lo username che la relativa password.
     *          Altrimenti {@code = false}
     */
    public boolean contains(String username, String password) {
        if (listaAccount.isEmpty()) return false;
        
        for (Account account: listaAccount) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) 
                return true;
        }
        return false;
    }
    
    /**
     * Verifica se nella lista di account esiste già uno username specifico
     * @param username nome da cercare all'interno della lista
     * @return {@code = true} se e solo se, la lista contiene lo username.
     *          Altrimenti {@code = false}
     */
    public boolean contains(String username) {
        if (listaAccount.isEmpty()) return false;
        for (Account account: listaAccount) {
            if (account.getUsername().equals(username) || account.getUsername().equals("Guest") || account.getUsername().equals("guest")) return true;
        }
        return false;
    }
    
    /**
     * Avviene la registrazione di un account all'interno del file
     * @param account account da registrare
     * @return 1 se lo username è già esistente all'interno del file,
     *          2  password non valida
     *          0 registrazione andata a buon fine
     */
    public int register(Account account) {
        if (contains(account.getUsername())) {
            return 1; //errore username già esistente
        }
        if (!Account.passwordValid(account.getPassword())){
            return 2; //errore lunghezza password
        } 
        listaAccount.add(account);
        fm.println(account.toString(), 'a');
        return 0;
    }
    
    /**
     * Avviene l'accesso ad un account già esistente
     * @param account account a cui accedere
     * @return {@code = true} se l'account è presente nel file.
     *          Altrimenti {@code = false}
     */
    public boolean login(Account account) {
        if (contains(account.getUsername(), account.getPassword())) return true;
        return false;
    }
    
    /**
     * Metodo per accedere ai crediti di un account
     * @param username account da cercare
     * @return il valore dei crediti all'interno dell'account
     */
    public int getCrediti(String username){
        for (Account account: listaAccount) {
            if (account.getUsername().equals(username))
                return account.getCrediti();
        }
        return 0;
    }
    
    /**
     * Metodo per la modifica dei crediti all'interno di un account
     * @param username account da cercare
     * @param crediti quantità di crediti 
     * @param mod indica se sottrarre o aggiungere i crediti dall'account
     * @return {@code = true} aggiornamento del file
     *          altrimenti {@code = false}      
     */
    public boolean setCrediti(String username, int crediti , char mod){
        int newcrediti;
        int pos = indexOf(username);
        if (pos < 0) return false;
        
        listaAccount = caricaDati(fm.getAllLines());
        Account accDaModificare = listaAccount.get(pos);
        if (mod == '-') {
            newcrediti= accDaModificare.getCrediti() - crediti;
        } else {
            newcrediti= accDaModificare.getCrediti() + crediti;
        }
        accDaModificare.setCrediti(newcrediti);
        
        listaAccount.set(pos, accDaModificare);
        return aggiornaFile(listaAccount, 0, listaAccount.size());
    }
    
     /**
     * Metodo per la modifica dei crediti all'interno di un account
     * @param username account da cercare
     * @param crediti quantità di crediti 
     * @return {@code = true} aggiornamento del file
     *          altrimenti {@code = false}      
     */
    public boolean setCrediti(String username, int crediti){
        int pos = indexOf(username);
        if (pos < 0) return false;
        
        listaAccount = caricaDati(fm.getAllLines());
        Account accDaModificare = listaAccount.get(pos);
        accDaModificare.setCrediti(crediti);
        
        listaAccount.set(pos, accDaModificare);
        return aggiornaFile(listaAccount, 0, listaAccount.size());
    }
    
    /**
     * Aggiornamento del file copiando i dati dalla lista
     * @param lista lista da cui prendere i dati
     * @param indexFrom indica da che punto copiare i dati
     * @param indexTo indica fino a che punto copiare i dati
     * @return {@code = true} aggiornamento del file
     *          altrimenti {@code = false} 
     */
    public boolean aggiornaFile(Vector<Account> lista, int indexFrom, int indexTo){
        return fm.println(lista);
    }
}
