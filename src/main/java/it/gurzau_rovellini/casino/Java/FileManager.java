package it.gurzau_rovellini.casino.Java;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author mirko
 */
// Gestisce tutti i file
public class FileManager {
    private String pathFile;

    public FileManager(String pathFile) {
        this.pathFile = pathFile;
    }
    
   /**
    * legge dal file tutte le righe presenti e le inserisce in una lista di tipo String
    * @return la lista di tipo String dove ogni nodo corrisponde a una riga del file
    */
    public Vector<String> getAllLines(){
        try {
            Vector<String> list = new Vector<>();
            Scanner sc = new Scanner(new FileReader(pathFile));
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                list.add(line);
            }
            sc.close();
            return list;
        } catch (IOException e ) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    /**
     * Viene prelevata una riga specifica dal file grazie al parametro index
     * @param index indica una riga all'interno del file
     * @return la linea specificata 
     */
    public String getLine(int index) {
        try {
            Scanner sc = new Scanner(new FileReader(pathFile));
            int i = 0;
            String line;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                if (i == index) return line;
                i++;
            }
            sc.close();
            return null;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    /**
     * Stampa una stringa nel file senza andata a capo
     * @param line rappresenta la stringa da inserire nel file
     * @param mod la modaità di scrittura del file
     * @return true, se e solo se, la scrittura è andata a buon fine.
     *          Altrimenti false;
     */
    public boolean print(String line, char mod){ 
        if (mod != 'a' && mod != 'w') return false;
        try {
            FileWriter fileWriter = new FileWriter(pathFile, mod == 'a'); // se mod è 'a' scrive in append, altrimenti scrive in write('w')
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            printWriter.print(line);
            
            printWriter.close();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    
    /**
     * Stampa una stringa nel file con andata a capo
     * @param line rappresenta la stringa da inserire nel file
     * @param mod la modaità di scrittura del file
     * @return true, se e solo se, la scrittura è andata a buon fine.
     *          Altrimenti false;
     */
    public boolean println(String line, char mod){
        return print(line + "\n", mod);
    }
    
    /**
     * Stampa tutte le carte di credito presenti nella lista nel file.
     * La modalità di scrittura è 'write' cioè i dati presenti nel file vengono sovrascritti da quelli nuovi.
     * @param lista contiene tutte le carte di credito
     * @return true, se la scrittura è andata a buon fine
     */
    public boolean println(Vector lista){
        try {
            FileWriter fileWriter = new FileWriter(pathFile, false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            for (int i = 0; i < lista.size(); i++)
                printWriter.write(lista.get(i).toString() + "\n");
            
            printWriter.close();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
