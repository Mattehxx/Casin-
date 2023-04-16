/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package it.gurzau_rovellini.casino.Java;

import java.awt.Color;
import java.awt.Cursor;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author mirko
 */
public class BlackJack extends javax.swing.JFrame {
    private GestioneAccount ga;
    
    private String yellowHex = "#ffff66";
    private String pathImagesFolder = "src\\test\\Images\\blackjack\\carte\\";
    private String extension = ".png";
    
    public static final int DEFAULT_CARTE_BLACKJACK = 104;
    public final int LIMITE_PUNTI_GIOCO = 21;
    public final int LIMITE_PUNTI_BANCO = 17;
    
    private HashMap<String, ImageIcon> mapImages = new HashMap<>();

    
    private JLabel[] vetLabelsGiocatore; 
    private JLabel[] vetLabelsBanco; 

    int countCardsGiocatore = 0;
    int countCardsBanco = 0;
    int initCredits = 0;

    
    private Mazzo mazzo;
    
    
    private Vector<Carta> manoGiocatore = new Vector<>();
    private Vector<Carta> manoBanco = new Vector<>();

    
    
    private boolean gameActive = false;
    private boolean turnoGiocatore = false;
    boolean isClickedDouble = false;
    Boolean isOpen=true;
    private int winGiocatore = -1;   //0 Vinto  1 Pareggio  2 Perso -1 default
    

    
    
    public BlackJack() {
        
        initComponents();
        mazzo = new Mazzo(DEFAULT_CARTE_BLACKJACK);
        ga = new GestioneAccount();
        
        
        initCardsIcon();
        
        initLabelsGiocatore();
        initLabelsBanco();
        
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    
    public void setLblName(JLabel lblName) {
        this.lblName.setText(lblName.getText());
    }

    public void setLblNumCredits(JLabel lblNumCredits) {
        this.lblSaldo.setText(lblNumCredits.getText());
        initCredits = Integer.parseInt(lblNumCredits.getText());
    }
    
    
    public void initCardsIcon(){
        for (int i = 0; i < Carta.SEMI.length(); i++) {
            for (int j = 0; j < Carta.VALORI.length(); j++) {
                String codice = "" + Carta.SEMI.charAt(i) + (j + 1);
                mapImages.put(codice, new ImageIcon(pathImagesFolder + Carta.SEMI.charAt(i) + (j + 1) + extension));
                //System.out.println(codice + "  " + mapImages.get(codice));
            }
        }
    }
    
    public void initLabelsGiocatore() {
        vetLabelsGiocatore = new JLabel[]{ 
            lblCartaG1, lblCartaG2, lblCartaG3,
            lblCartaG4, lblCartaG5, lblCartaG6,
            lblCartaG7
        };
    }
    
    public void initLabelsBanco() {
        vetLabelsBanco = new JLabel[]{ 
            lblCartaB1, lblCartaB2, lblCartaB3,
            lblCartaB4, lblCartaB5, lblCartaB6,
            lblCartaB7
        };
    }
    
    /**
     * il banco gioca fino ad avere una somma del valore delle carte maggiore uguale a 17
     */
    private void turnoBanco(){
        int valoreManoBanco = Integer.parseInt(lblStatoBanco.getText());
        int valoreManoGiocatore = Integer.parseInt(lblStatoGiocatore.getText());


        while(valoreManoBanco < LIMITE_PUNTI_BANCO && valoreManoBanco < LIMITE_PUNTI_GIOCO ){
            Carta c = mazzo.pescaCarta();
            manoBanco.add(c);
            
            valoreManoBanco = calcValueCards(manoBanco);
            
            vetLabelsBanco[countCardsBanco++].setIcon(mapImages.get(c.getCode()));
            lblStatoBanco.setText(valoreManoBanco + "");
        }
        
        if(valoreManoBanco > LIMITE_PUNTI_GIOCO || valoreManoGiocatore > valoreManoBanco){
            lblStatoGiocatore.setForeground(Color.BLUE);
            lblStatoBanco.setForeground(Color.RED);
            winGiocatore = 0;
        } else if(valoreManoGiocatore < valoreManoBanco){
            lblStatoGiocatore.setForeground(Color.RED);
            lblStatoBanco.setForeground(Color.BLUE);
            winGiocatore = 2;
        } else {
            lblStatoGiocatore.setForeground(Color.LIGHT_GRAY);
            lblStatoBanco.setForeground(Color.LIGHT_GRAY);
            winGiocatore = 1;
        }
    }
    
    /**
     * Metodo per il calcolo del valore totale delle carte in mano
     * @param carte lista contenente le carte in mano
     * @return il valore totale delle carte in mano
     */
    private int calcValueCards(Vector<Carta> carte){
        Vector<Carta> lista = ordina(carte);
        int v = 0;
        for (Carta c: lista){
            if (!c.isAsso()){
                if (c.isFigura()) v += 10;
                else v += c.getValoreGioco()+ 1;
            }
            else {
                if (v + 11 > LIMITE_PUNTI_GIOCO) v += 1;
                else v += 11;
            }
        }
        return v;
    }
    
    /**
     * Metodo pre riordinare in modo crescente le carte tramite l'utilizzo del compareTo
     * @param lista lista contenete le carte da ordinare
     * @return la nuova lista ordinata
     */
    private Vector<Carta> ordina(Vector<Carta> lista) {
        Vector<Carta> ordLista = new Vector<>(lista);
        ordLista.sort(Comparable:: compareTo);
        return ordLista;
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlFiches = new javax.swing.JPanel();
        btnFiches_1 = new javax.swing.JButton();
        btnFiches_5 = new javax.swing.JButton();
        btnFiches_10 = new javax.swing.JButton();
        btnFiches_25 = new javax.swing.JButton();
        btnFiches_100 = new javax.swing.JButton();
        btnFiches_500 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlCarteGiocatore = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblCartaG6 = new javax.swing.JLabel();
        lblCartaG5 = new javax.swing.JLabel();
        lblCartaG4 = new javax.swing.JLabel();
        lblCartaG3 = new javax.swing.JLabel();
        lblCartaG2 = new javax.swing.JLabel();
        lblCartaG7 = new javax.swing.JLabel();
        lblCartaG1 = new javax.swing.JLabel();
        lblStatoGiocatore = new javax.swing.JLabel();
        pnlCarteBanco = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblCartaB1 = new javax.swing.JLabel();
        lblCartaB2 = new javax.swing.JLabel();
        lblCartaB3 = new javax.swing.JLabel();
        lblCartaB4 = new javax.swing.JLabel();
        lblCartaB5 = new javax.swing.JLabel();
        lblCartaB6 = new javax.swing.JLabel();
        lblCartaB7 = new javax.swing.JLabel();
        lblStatoBanco = new javax.swing.JLabel();
        btnStay = new javax.swing.JButton();
        btnDouble = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblIndicaPuntata = new javax.swing.JLabel();
        lblPuntata = new javax.swing.JLabel();
        lblIndicaSaldo = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        btnHit = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 102));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlMain.setBackground(new java.awt.Color(37, 37, 37));

        pnlFiches.setBackground(new java.awt.Color(229, 39, 102));
        pnlFiches.setForeground(new java.awt.Color(255, 255, 255));

        btnFiches_1.setBackground(new java.awt.Color(229, 39, 102));
        btnFiches_1.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\fiches\\Fiches_1.png"));
        btnFiches_1.setBorderPainted(false);
        btnFiches_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiches_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiches_1ActionPerformed(evt);
            }
        });

        btnFiches_5.setBackground(new java.awt.Color(229, 39, 102));
        btnFiches_5.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\fiches\\Fiches_5.png"));
        btnFiches_5.setBorderPainted(false);
        btnFiches_5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiches_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiches_5ActionPerformed(evt);
            }
        });

        btnFiches_10.setBackground(new java.awt.Color(229, 39, 102));
        btnFiches_10.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\fiches\\Fiches_10.png"));
        btnFiches_10.setBorderPainted(false);
        btnFiches_10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiches_10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiches_10ActionPerformed(evt);
            }
        });

        btnFiches_25.setBackground(new java.awt.Color(229, 39, 102));
        btnFiches_25.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\fiches\\Fiches_25.png"));
        btnFiches_25.setBorderPainted(false);
        btnFiches_25.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiches_25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiches_25ActionPerformed(evt);
            }
        });

        btnFiches_100.setBackground(new java.awt.Color(229, 39, 102));
        btnFiches_100.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\fiches\\Fiches_100.png"));
        btnFiches_100.setBorderPainted(false);
        btnFiches_100.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiches_100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiches_100ActionPerformed(evt);
            }
        });

        btnFiches_500.setBackground(new java.awt.Color(229, 39, 102));
        btnFiches_500.setForeground(new java.awt.Color(0, 204, 102));
        btnFiches_500.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\fiches\\Fiches_500.png"));
        btnFiches_500.setBorderPainted(false);
        btnFiches_500.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiches_500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiches_500ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Clicca sulle FICHES per puntare");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout pnlFichesLayout = new javax.swing.GroupLayout(pnlFiches);
        pnlFiches.setLayout(pnlFichesLayout);
        pnlFichesLayout.setHorizontalGroup(
            pnlFichesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFichesLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(btnFiches_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 33, Short.MAX_VALUE)
                .addComponent(btnFiches_5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnFiches_10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnFiches_25, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnFiches_100, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnFiches_500, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlFichesLayout.setVerticalGroup(
            pnlFichesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFichesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlFichesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFiches_500, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiches_5, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiches_10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiches_25, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiches_100, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiches_1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pnlCarteGiocatore.setBackground(new java.awt.Color(0, 204, 102));

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblName.setForeground(new java.awt.Color(37, 37, 37));
        lblName.setText("GUEST");

        lblCartaG6.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaG5.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaG4.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaG3.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaG2.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaG7.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaG1.setBackground(new java.awt.Color(204, 0, 102));

        lblStatoGiocatore.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblStatoGiocatore.setForeground(new java.awt.Color(255, 255, 102));
        lblStatoGiocatore.setText("0");

        javax.swing.GroupLayout pnlCarteGiocatoreLayout = new javax.swing.GroupLayout(pnlCarteGiocatore);
        pnlCarteGiocatore.setLayout(pnlCarteGiocatoreLayout);
        pnlCarteGiocatoreLayout.setHorizontalGroup(
            pnlCarteGiocatoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarteGiocatoreLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblStatoGiocatore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblCartaG7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaG6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaG5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaG4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaG3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaG2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblCartaG1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(pnlCarteGiocatoreLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCarteGiocatoreLayout.setVerticalGroup(
            pnlCarteGiocatoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarteGiocatoreLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(pnlCarteGiocatoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCarteGiocatoreLayout.createSequentialGroup()
                        .addGroup(pnlCarteGiocatoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCartaG7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaG6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaG5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaG4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaG3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaG2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaG1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCarteGiocatoreLayout.createSequentialGroup()
                        .addComponent(lblStatoGiocatore)
                        .addGap(43, 43, 43)))
                .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pnlCarteBanco.setBackground(new java.awt.Color(0, 204, 102));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(37, 37, 37));
        jLabel3.setText("BANCO");

        lblCartaB1.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaB2.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaB3.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaB4.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaB5.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaB6.setBackground(new java.awt.Color(204, 0, 102));

        lblCartaB7.setBackground(new java.awt.Color(204, 0, 102));

        lblStatoBanco.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lblStatoBanco.setForeground(new java.awt.Color(255, 255, 102));
        lblStatoBanco.setText("0");

        javax.swing.GroupLayout pnlCarteBancoLayout = new javax.swing.GroupLayout(pnlCarteBanco);
        pnlCarteBanco.setLayout(pnlCarteBancoLayout);
        pnlCarteBancoLayout.setHorizontalGroup(
            pnlCarteBancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCarteBancoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblStatoBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(lblCartaB7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaB6, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaB5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaB4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaB3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblCartaB2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(lblCartaB1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(pnlCarteBancoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlCarteBancoLayout.setVerticalGroup(
            pnlCarteBancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCarteBancoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pnlCarteBancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCarteBancoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCarteBancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCartaB7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaB6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaB5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaB4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaB3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaB2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCartaB1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCarteBancoLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblStatoBanco)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnStay.setBackground(new java.awt.Color(37, 37, 37));
        btnStay.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnStay.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\minus.png"));
        btnStay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnStay.setBorderPainted(false);
        btnStay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStayActionPerformed(evt);
            }
        });

        btnDouble.setBackground(new java.awt.Color(204, 0, 204));
        btnDouble.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnDouble.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\x2.png"));
        btnDouble.setText(" RADDOPPIA");
        btnDouble.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnDouble.setBorderPainted(false);
        btnDouble.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDouble.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoubleActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(37, 37, 37));
        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 102));
        btnReset.setText("Reset");
        btnReset.setToolTipText("");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 2));
        btnReset.setBorderPainted(false);
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.setFocusable(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        lblIndicaPuntata.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblIndicaPuntata.setForeground(new java.awt.Color(255, 255, 255));
        lblIndicaPuntata.setText("PUNTATA : ");
        lblIndicaPuntata.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        lblPuntata.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPuntata.setForeground(new java.awt.Color(255, 255, 0));
        lblPuntata.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntata.setText("0");

        lblIndicaSaldo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblIndicaSaldo.setForeground(new java.awt.Color(242, 242, 242));
        lblIndicaSaldo.setText("SALDO : ");

        lblSaldo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(255, 255, 0));
        lblSaldo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSaldo.setText("0");

        btnHit.setBackground(new java.awt.Color(37, 37, 37));
        btnHit.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHit.setIcon(new javax.swing.ImageIcon("src\\test\\Images\\blackjack\\plus.png"));
        btnHit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnHit.setBorderPainted(false);
        btnHit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHitActionPerformed(evt);
            }
        });

        btnStart.setBackground(new java.awt.Color(255, 255, 102));
        btnStart.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnStart.setText("Inizia");
        btnStart.setToolTipText("");
        btnStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        btnStart.setBorderPainted(false);
        btnStart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(lblIndicaSaldo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblIndicaPuntata)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPuntata, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlFiches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addComponent(btnHit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnStay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDouble, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)))
                    .addComponent(pnlCarteBanco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlCarteGiocatore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(pnlCarteBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlCarteGiocatore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblIndicaSaldo)
                            .addComponent(lblSaldo)
                            .addComponent(lblPuntata, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIndicaPuntata, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnlMainLayout.createSequentialGroup()
                                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnStay, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDouble, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(pnlFiches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiches_500ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiches_500ActionPerformed
        // TODO add your handling code here:
        if(!gameActive){
            if(Integer.parseInt(lblSaldo.getText()) >= 500){
                int tmp = Integer.parseInt(lblPuntata.getText()) + 500;
                lblPuntata.setText("" + tmp);

                 tmp=Integer.parseInt(lblSaldo.getText())-500;
                lblSaldo.setText(String.valueOf(tmp));
            }
        }
    }//GEN-LAST:event_btnFiches_500ActionPerformed

    private void btnFiches_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiches_1ActionPerformed
        // TODO add your handling code here:
        if(!gameActive){
            if(Integer.parseInt(lblSaldo.getText()) >= 1){
                int tmp = Integer.parseInt(lblPuntata.getText()) + 1;
                lblPuntata.setText("" + tmp);

                 tmp=Integer.parseInt(lblSaldo.getText())-1;
                lblSaldo.setText(String.valueOf(tmp));
            }
        } 
    }//GEN-LAST:event_btnFiches_1ActionPerformed
    
    /**
     * Metodo per la richiesta di una nuova carta
     * @param evt bottone cliccato
     */
    private void btnHitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHitActionPerformed
        // TODO add your handling code here:
        isClickedDouble = true;
        int valoreManoGiocatore = 0;
        
        if (gameActive) {
            if(turnoGiocatore){
                if (countCardsGiocatore < vetLabelsGiocatore.length) {
                    Carta c = mazzo.pescaCarta();
                    manoGiocatore.add(c);
                    
                    valoreManoGiocatore = calcValueCards(manoGiocatore);
                    
                    vetLabelsGiocatore[countCardsGiocatore++].setIcon(mapImages.get(c.getCode()));
                    lblStatoGiocatore.setText(valoreManoGiocatore + "");

                    if (valoreManoGiocatore > LIMITE_PUNTI_GIOCO) {
                        lblStatoGiocatore.setForeground(Color.RED);
                        lblStatoBanco.setForeground(Color.blue);
                        turnoGiocatore = false;
                        gameActive = false;
                    }
                    else if (valoreManoGiocatore == LIMITE_PUNTI_GIOCO){
                        turnoBanco();
                    }
                }
            }
        }
    }//GEN-LAST:event_btnHitActionPerformed
    
    /**
     * Metodo per resettare la mano una volta terminata
     * @param evt bottone cliccato
     */
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        int newsaldo = Integer.parseInt(lblSaldo.getText());

        for (int i = 0; i < vetLabelsGiocatore.length; i++) {
            vetLabelsGiocatore[i].setIcon(null);
            vetLabelsBanco[i].setIcon(null);
        }
        mazzo = new Mazzo(DEFAULT_CARTE_BLACKJACK);
        btnStart.setEnabled(true);

        switch (winGiocatore) {
            case 0: // vittoria
                if(countCardsGiocatore == 2 && calcValueCards(manoGiocatore) == LIMITE_PUNTI_GIOCO)
                    newsaldo += Integer.parseInt(lblPuntata.getText()) * 4; 
                else newsaldo += Integer.parseInt(lblPuntata.getText()) * 2;

                lblPuntata.setText("0");
                lblSaldo.setText("" + newsaldo);
            break;

            case 1: // pareggio
                newsaldo += Integer.parseInt(lblPuntata.getText());
                lblPuntata.setText("0");
                lblSaldo.setText("" + newsaldo);
            break;

            case 2: //sconfitta
                lblPuntata.setText("0");
                lblSaldo.setText("" + newsaldo);
            break;
            default:
                int tmp = Integer.parseInt(lblPuntata.getText());
                lblPuntata.setText("0");
                newsaldo += tmp;
                lblSaldo.setText("" + newsaldo);
        }
        manoBanco.clear();
        manoGiocatore.clear();

        countCardsGiocatore = 0;
        countCardsBanco = 0;

        winGiocatore = -1;

        lblStatoGiocatore.setText("0");
        lblStatoGiocatore.setForeground(Color.decode(yellowHex));
        lblStatoBanco.setText("0");
        lblStatoBanco.setForeground(Color.decode(yellowHex));

        gameActive = false;
        isClickedDouble = false; 
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * Metodo per la richiesta di una sola carta e il raddoppio della puntata effettuata
     * @param evt bottone cliccato
     */
    private void btnDoubleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoubleActionPerformed
        // TODO add your handling code here:
        int valoreManoGiocatore = 0;
        if(!isClickedDouble){ 
            if (gameActive) {
                if(turnoGiocatore){
                    Carta c = mazzo.pescaCarta();
                    manoGiocatore.add(c);

                    valoreManoGiocatore = calcValueCards(manoGiocatore);

                    vetLabelsGiocatore[countCardsGiocatore++].setIcon(mapImages.get(c.getCode()));
                    lblStatoGiocatore.setText(valoreManoGiocatore + "");

                    int tmp = Integer.parseInt(lblPuntata.getText());
                    int newpuntata = tmp * 2;
                    lblPuntata.setText("" + newpuntata);


                    int newsaldo = Integer.parseInt(lblSaldo.getText());
                    newsaldo -= tmp;
                    lblSaldo.setText("" + newsaldo);


                    if (valoreManoGiocatore > LIMITE_PUNTI_GIOCO) {
                        lblStatoGiocatore.setForeground(Color.RED);
                        lblStatoBanco.setForeground(Color.blue);
                        gameActive = false;
                    }
                    else if (valoreManoGiocatore == LIMITE_PUNTI_GIOCO){
                        turnoBanco();
                    }
                    turnoGiocatore = false;
                }
                if (gameActive && !turnoGiocatore) {
                    if (countCardsBanco < vetLabelsBanco.length) {
                        turnoBanco();
                    }  
                }
            }
        }
    }//GEN-LAST:event_btnDoubleActionPerformed

    private void btnFiches_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiches_5ActionPerformed
        // TODO add your handling code here:
        if(!gameActive && winGiocatore < 0){
            if(Integer.parseInt(lblSaldo.getText()) >= 5){
                int tmp = Integer.parseInt(lblPuntata.getText()) + 5;
                lblPuntata.setText("" + tmp);

                tmp=Integer.parseInt(lblSaldo.getText())-5;
                lblSaldo.setText(String.valueOf(tmp));
            }
        }
    }//GEN-LAST:event_btnFiches_5ActionPerformed

    private void btnFiches_10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiches_10ActionPerformed
        // TODO add your handling code here:
        if(!gameActive){
            if(Integer.parseInt(lblSaldo.getText()) >= 10){
                int tmp = Integer.parseInt(lblPuntata.getText()) + 10;
                lblPuntata.setText("" + tmp);

                tmp=Integer.parseInt(lblSaldo.getText())-10;
                lblSaldo.setText(String.valueOf(tmp));
            }    
        } 
    }//GEN-LAST:event_btnFiches_10ActionPerformed

    private void btnFiches_25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiches_25ActionPerformed
        // TODO add your handling code here:
        if(!gameActive){
            if(Integer.parseInt(lblSaldo.getText()) >= 25){
              int tmp = Integer.parseInt(lblPuntata.getText()) + 25;
              lblPuntata.setText("" + tmp);

               tmp=Integer.parseInt(lblSaldo.getText())-25;
              lblSaldo.setText(String.valueOf(tmp));
            }    
        }
        
    }//GEN-LAST:event_btnFiches_25ActionPerformed

    private void btnFiches_100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiches_100ActionPerformed
        // TODO add your handling code here:
        if(!gameActive){
            if(Integer.parseInt(lblSaldo.getText()) >= 100){
                int tmp = Integer.parseInt(lblPuntata.getText()) + 100;
                lblPuntata.setText("" + tmp);

                tmp = Integer.parseInt(lblSaldo.getText())-100;
                lblSaldo.setText(String.valueOf(tmp));
            }     
        }
    }//GEN-LAST:event_btnFiches_100ActionPerformed
    /**
     * Metodo per terminare il turno del giocatore e passare il turno al banco
     * @param evt bottone cliccato
     */
    private void btnStayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStayActionPerformed
        // TODO add your handling code here:
        turnoGiocatore = false;
        
        if (gameActive && !turnoGiocatore) {
            if (countCardsBanco < vetLabelsBanco.length) {
                turnoBanco();
            }  
        }        
    }//GEN-LAST:event_btnStayActionPerformed
    
    /**
     * Metodo per iniziare a giocare
     * @param evt bottone cliccato
     */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
        int saldo = Integer.parseInt(lblSaldo.getText());
        int puntata = Integer.parseInt(lblPuntata.getText());
        Carta c;
        int valoreManoGiocatore = 0, valoreManoBanco = 0;
        int totBanco = Integer.parseInt(lblStatoBanco.getText());
        
        if (!gameActive && puntata >= 1) {
            gameActive = true;
            turnoGiocatore = true;
        
            for (int i = 0; i < 2; i++) {
                c = mazzo.pescaCarta();
                manoGiocatore.add(c);
                
                valoreManoGiocatore = calcValueCards(manoGiocatore);
                
                vetLabelsGiocatore[countCardsGiocatore++].setIcon(mapImages.get(c.getCode()));
                lblStatoGiocatore.setText(valoreManoGiocatore + "");
            }
            
            
            c = mazzo.pescaCarta();
            manoBanco.add(c);
            
            valoreManoBanco = calcValueCards(manoBanco);

            vetLabelsBanco[countCardsBanco++].setIcon(mapImages.get(c.getCode()));
            lblStatoBanco.setText(valoreManoBanco + "");
            
            if (valoreManoGiocatore == LIMITE_PUNTI_GIOCO) {
                turnoBanco();
            } 
        }
    }//GEN-LAST:event_btnStartActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        ga.setCrediti(lblName.getText(), Integer.parseInt(lblSaldo.getText()));
        isOpen=false;
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlackJack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BlackJack().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDouble;
    private javax.swing.JButton btnFiches_1;
    private javax.swing.JButton btnFiches_10;
    private javax.swing.JButton btnFiches_100;
    private javax.swing.JButton btnFiches_25;
    private javax.swing.JButton btnFiches_5;
    private javax.swing.JButton btnFiches_500;
    private javax.swing.JButton btnHit;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCartaB1;
    private javax.swing.JLabel lblCartaB2;
    private javax.swing.JLabel lblCartaB3;
    private javax.swing.JLabel lblCartaB4;
    private javax.swing.JLabel lblCartaB5;
    private javax.swing.JLabel lblCartaB6;
    private javax.swing.JLabel lblCartaB7;
    private javax.swing.JLabel lblCartaG1;
    private javax.swing.JLabel lblCartaG2;
    private javax.swing.JLabel lblCartaG3;
    private javax.swing.JLabel lblCartaG4;
    private javax.swing.JLabel lblCartaG5;
    private javax.swing.JLabel lblCartaG6;
    private javax.swing.JLabel lblCartaG7;
    private javax.swing.JLabel lblIndicaPuntata;
    private javax.swing.JLabel lblIndicaSaldo;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPuntata;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblStatoBanco;
    private javax.swing.JLabel lblStatoGiocatore;
    private javax.swing.JPanel pnlCarteBanco;
    private javax.swing.JPanel pnlCarteGiocatore;
    private javax.swing.JPanel pnlFiches;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
