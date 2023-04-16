package it.gurzau_rovellini.casino.Java;

import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Classe che gestisce il file delle carte di credito
 * @author Mirko Gurzau
 */
public class GestioneCrediti {
    private String fileCreditsCards = "./src/main/java/it/gurzau_rovellini/casino/CSV_Files/CreditCards.txt";
    private FileManager fm;
    private Vector<CartaCredito> listaCC;
            
    public GestioneCrediti(){ 
        fm = new FileManager(fileCreditsCards);
        listaCC = caricaDati(fm.getAllLines());
    }
    
    /**
     * Riempie la lista delle carte di crediti con i dati presenti nel file
     * @param listLines lista di stringhe che contiene le righe del file
     * @return la lista di carte di credito 
     */
    private Vector<CartaCredito> caricaDati(Vector<String> listLines){
        Vector<CartaCredito> tmpList = new Vector<>();
        
        for (String line: listLines){
            StringTokenizer st = new StringTokenizer(line, ",");
            String proprieario = st.nextToken();
            String numeroCarta = st.nextToken();
            String cvv = st.nextToken();
            int saldo = Integer.parseInt(st.nextToken());
            
            CartaCredito cc = new CartaCredito(proprieario, numeroCarta, cvv, saldo);
            tmpList.add(cc);
        }
        return tmpList;
    }
    
    
    /**
     * Verifica se nella lista di carte di credito esiste già una numero di carta specifico
     * @param numeroCarta numero di carta da verifica se è presente nella lista
     * @return {@code = true} se e solo se, la lista contiene quel numero di carta di credito.
     *          Altrimenti {@code = false}
     */
    public boolean contains(String numeroCarta) {
        for (CartaCredito cc: listaCC) {
            if (cc.getNumeroCarta().equals(numeroCarta)) return true;
        }
        return false;
    }
    
    public boolean contains(String proprietario, String numeroCarta, String CVV) {
        for (CartaCredito cc: listaCC) {
            if (cc.getNumeroCarta().equals(numeroCarta)){
                if (cc.getProprietario().equals(proprietario)) {
                    if (cc.getCvv().equals(CVV)) return true;
                }
            }
        }
        return false;
    }
    
    
    /**
     * Trova la posizione di una carta di credito nella lista.
     * @param numeroCarta numero di carta da cercare
     * @return ritorna un valore intero da 0 fino a lista.size() se è presente.
     *          Altrimenti -1;
     */
    public int indexOf(String numeroCarta) {
        int i = 0;
        for (CartaCredito cc: listaCC) {
            if (cc.getNumeroCarta().equals(numeroCarta)) return i;
            i++;
        }
        return -1;
    }
    
    
    
    /**
     * Aggiunge una nuova carta di credito alla lista e aggiorna il file
     * @param cc carta di credito da aggiungere
     * @return {@code = true} se e solo se, la scrittura dei dati della carta è andata a buon fine.
     *          Altrimenti {@code = false}
     */
    public boolean aggiungi(CartaCredito cc) {
        if (cc.nCardValido()) {
            if (cc.cvvValido()) {
                listaCC.add(cc);
                return fm.println(cc.toString(), 'a');
            }
        } 
        return false;
    }
    
    /**
     * Preleva una certa quantità di denaro dalla carta, se è solo se è già presente.
     * Dopo aver aggiornato la carta con il nuovo saldo, aggiorna anche il file
     * @param numeroCarta numero di carta da cercare nella lista
     * @param soldiDaTogliere quantità di denaro da prelevare
     * @return {@code = true} se e solo se, la l'aggiornamento dei dati della carta è andata a buon fine.
     *          Altrimenti {@code = false}
     */
    public boolean preleva(String numeroCarta, int soldiDaTogliere){
        int pos = indexOf(numeroCarta);
        if (pos < 0) return false;
        
        CartaCredito ccDaModificare = listaCC.get(pos);
        ccDaModificare.preleva(soldiDaTogliere);
        
        listaCC.set(pos, ccDaModificare);
        return aggiornaFile(listaCC, 0, listaCC.size());
    }
    
    public boolean puoPrelevare(String numeroCarta, int soldiDaTogliere){
        int pos = indexOf(numeroCarta);
        if (pos < 0) return false;
        
        CartaCredito cc = listaCC.get(pos);
        if(cc.puoPrelevare(soldiDaTogliere))
            return true;
        return false;
        
        
        
    }
    
    /**
     * Deposita una certa quantità di denaro dalla carta, se è solo se è già presente. 
     * Dopo aver aggiornato la carta con il nuovo saldo, aggiorna anche il file
     * @param numeroCarta numero di carta da cercare nella lista
     * @param soldiDaTogliere quantità di denaro da depositare
     * @return {@code = true} se e solo se, la l'aggiornamento dei dati della carta è andata a buon fine.
     *          Altrimenti {@code = false}
     */
    public boolean deposita(String numeroCarta, int soldiDaTogliere){
        int pos = indexOf(numeroCarta);
        if (pos < 0) return false;
        
        CartaCredito ccDaModificare = listaCC.get(pos);
        ccDaModificare.deposita(soldiDaTogliere);
        
        listaCC.set(pos, ccDaModificare);
        return aggiornaFile(listaCC, 0, listaCC.size());
    }
    
    public int getSoldi(String numeroCarta){
        int pos = indexOf(numeroCarta);
        if (pos < 0) return -1;
        
        CartaCredito cc = listaCC.get(pos);
        return cc.getSaldo();
    }
    
    
    /**
     * Aggiorna il file con una lista di carte di credito, a partite da una determinata posizione
     * @param lista lista da scrivere nel file
     * @param indexFrom indice della lista da cui partire
     * @param indexTo indece della lista da cui finire
     * @return {@code = true} se e solo se, la l'aggiornamento dei dati della carta è andata a buon fine.
     *          Altrimenti {@code = false}
     */
    public boolean aggiornaFile(Vector<CartaCredito> lista, int indexFrom, int indexTo){
        return fm.println(lista);
    }
    
}