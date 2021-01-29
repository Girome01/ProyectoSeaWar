/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import Clases.Casillas;
import Clases.CommandManager;
import Clases.CommandUtil;
import Clases.ICommand;
import Clases.Luchador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Gilberth
 */
public class PantallaCliente extends javax.swing.JFrame {
    private String UrlImagen;
    public Cliente refCliente;
    private String nombreTurno = "";
    private String [][]matrix;
    private JButton [][]label = new JButton[20][30]; // lbel[1][4]
    public Casillas[][]casillas;
    private int MaximoP1;
    private int MaximoP2;
    private int MaximoP3;
    CommandManager manager = CommandManager.getIntance();  
    /**
     * Creates new form PantallaCliente
     */
    public PantallaCliente() {
        initComponents();
        generarMatriz();
    }

    public void setRefCliente(Cliente refCliente) {
        this.refCliente = refCliente;
    }
    
    public void setNombreTurno(String nombreTurno) {
        this.nombreTurno = nombreTurno;
        lblTurno.setText("Turno: "+nombreTurno);
    }
    
    public void addMensaje(String msj){
        txaMensajes.append(msj + "\n");
    }
    
    public void addBitacora(String msj){
        txaBitacora.append(msj + "\n");
    }
    
    public void generarMatriz(){
        matrix = new String[20][30];
        casillas = new Casillas[20][30];
        panelJuego.setLayout(new GridLayout(20, 30));
        for(int r=0; r<20; r++){
            for(int c=0; c<30;){
                label[r][c] = new JButton(matrix[r][c]);
                casillas[r][c] = new Casillas(label[r][c]);
                label[r][c].setPreferredSize(new Dimension(5, 5));
                label[r][c].setBackground(Color.BLUE);
                //label[r][c].setEnabled(false);
                label[r][c].setVisible(true);
                panelJuego.add(label[r][c]);
                c++;
            }                   
        }
    }
    
    public void VolverCasillas(){
         for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 30; y++) {
                if(casillas[x][y].personaje.getNombre().equals(refCliente.personajes.get(0).getNombre())){
                    label[x][y].setBackground(Color.LIGHT_GRAY);
                }
                else if(casillas[x][y].personaje.getNombre().equals(refCliente.personajes.get(1).getNombre())){
                    label[x][y].setBackground(Color.MAGENTA);
                }
                else if(casillas[x][y].personaje.getNombre().equals(refCliente.personajes.get(2).getNombre())){
                    label[x][y].setBackground(Color.CYAN);
                }
            }
         }
    }
    
    
    public void RepartirTropas(Luchador luchador1, Luchador luchador2, Luchador luchador3){
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 30; y++) {
                Random r = new Random();
                int valorDado = r.nextInt(3)+1;
                while(valorDado ==0){
                    valorDado = r.nextInt(3)+1;
                }
                
                if(valorDado == 1 && MaximoP1 != 0){
                    casillas[x][y].personaje = luchador1;
                    label[x][y].setBackground(Color.LIGHT_GRAY);
                    MaximoP1= MaximoP1 - 1;
                }

                else if(valorDado == 2 && MaximoP2 != 0){

                    casillas[x][y].personaje = luchador2;
                    label[x][y].setBackground(Color.MAGENTA);
                     MaximoP2= MaximoP2 - 1;
                }

                else if(valorDado == 3 && MaximoP3 != 0){
                    casillas[x][y].personaje= luchador3;
                    label[x][y].setBackground(Color.CYAN);
                     MaximoP3 = MaximoP3 - 1;
                }
                else{
                    y = y - 1;
                }
            }  
        }  
    }
    
    public void Sanidad(String nombre){
        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 30; y++) {
                if(casillas[x][y].personaje.getNombre().equals(nombre)){
                    casillas[x][y].RecuperarVida();
                
                }
            }
        }
    }
     
    public void ActualizarDatos(){
        int casillasvivas1 = 0,casillastotales1=0,casillasvivas2=0,casillastotales2=0,casillasvivas3=0,casillastotales3=0;
        for (int i = 0; i <  20; i++) {
            for (int j = 0; j < 30; j++) {
                if(casillas[i][j].personaje.getNombre().equals(refCliente.personajes.get(0).getNombre()) ){
                    if(casillas[i][j].estaViva()){
                        casillasvivas1 = casillasvivas1 + 1;
                    }
                    casillastotales1 = casillastotales1 +1;
                }
                else if(casillas[i][j].personaje.getNombre().equals(refCliente.personajes.get(1).getNombre())){
                    if(casillas[i][j].estaViva()){
                        casillasvivas2 = casillasvivas1 + 1;
                    }
                    casillastotales2 = casillastotales1 +1;
                }
                else if(casillas[i][j].personaje.getNombre().equals(refCliente.personajes.get(2).getNombre())){
                    if(casillas[i][j].estaViva()){
                        casillasvivas3 = casillasvivas1 + 1;
                    }
                    casillastotales3 = casillastotales1 +1;
                }
            }
            
        }
        
        int vida = (casillastotales3 - casillasvivas3) +  (casillastotales2 - casillasvivas2) + (casillastotales1 - casillasvivas1) ;

        SetVida(100-vida);
        int muertas = (casillastotales1 - casillasvivas1 + casillastotales2 - casillasvivas2 + casillastotales3 -casillasvivas3);
        SetCasillasDestruidas(muertas);
        int porcentaje1 = casillasvivas1 * 100 / casillastotales1;
        int porcentaje2 = casillasvivas2 * 100 / casillastotales2;
        int porcentaje3 = casillasvivas3 * 100 / casillastotales3;
        Personaje1(refCliente.personajes.get(0).getNombre(), porcentaje1,casillasvivas1,casillastotales1);
        Personaje2(refCliente.personajes.get(1).getNombre(), porcentaje2,casillasvivas2,casillastotales2);
        Personaje3(refCliente.personajes.get(2).getNombre(), porcentaje2,casillasvivas3,casillastotales3);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaMensajes = new javax.swing.JTextArea();
        txfMensaje = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        lblTurno = new javax.swing.JLabel();
        lblBitacora = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaBitacora = new javax.swing.JTextArea();
        lblResultadoDelAtaque = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxtResulAtaque = new javax.swing.JTextArea();
        panelPersonajes = new javax.swing.JPanel();
        jLPersonaje1 = new javax.swing.JLabel();
        jLPersonaje3 = new javax.swing.JLabel();
        jLPersonaje2 = new javax.swing.JLabel();
        jLSanidad1 = new javax.swing.JLabel();
        jLSanidad2 = new javax.swing.JLabel();
        jLSanidad3 = new javax.swing.JLabel();
        jSetSanidad3 = new javax.swing.JLabel();
        jSetSanidad1 = new javax.swing.JLabel();
        jSetSanidad2 = new javax.swing.JLabel();
        jLPoder1 = new javax.swing.JLabel();
        jLPoder2 = new javax.swing.JLabel();
        jLPoder3 = new javax.swing.JLabel();
        jSetPoder2 = new javax.swing.JLabel();
        jSetResistencia1 = new javax.swing.JLabel();
        jSetPoder3 = new javax.swing.JLabel();
        jLResistencia = new javax.swing.JLabel();
        jSetPoder1 = new javax.swing.JLabel();
        jLResistencia1 = new javax.swing.JLabel();
        jSetResistencia2 = new javax.swing.JLabel();
        jLResistencia2 = new javax.swing.JLabel();
        jSetResistencia3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblVida = new javax.swing.JLabel();
        lblCasillasDestruidas = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        panelJuego = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txaMensajes.setColumns(20);
        txaMensajes.setRows(5);
        jScrollPane1.setViewportView(txaMensajes);

        txfMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfMensajeActionPerformed(evt);
            }
        });

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTurno.setText("Turno:");
        lblTurno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblBitacora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBitacora.setText("Bitacora");
        lblBitacora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txaBitacora.setColumns(20);
        txaBitacora.setRows(5);
        jScrollPane2.setViewportView(txaBitacora);

        lblResultadoDelAtaque.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultadoDelAtaque.setText("Resultado del ataque");
        lblResultadoDelAtaque.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtxtResulAtaque.setColumns(20);
        jtxtResulAtaque.setRows(5);
        jScrollPane3.setViewportView(jtxtResulAtaque);

        panelPersonajes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLSanidad1.setText("Sanidad:");

        jLSanidad2.setText("Sanidad:");

        jLSanidad3.setText("Sanidad:");

        jSetSanidad3.setText("       0");

        jSetSanidad1.setText("       0");

        jSetSanidad2.setText("       0");

        jLPoder1.setText("Poder:");
        jLPoder1.setToolTipText("");

        jLPoder2.setText("Poder:");
        jLPoder2.setToolTipText("");

        jLPoder3.setText("Poder:");
        jLPoder3.setToolTipText("");

        jSetPoder2.setText("       0");

        jSetResistencia1.setText("       0");

        jSetPoder3.setText("       0");

        jLResistencia.setText("Resistencia:");

        jSetPoder1.setText("       0");

        jLResistencia1.setText("Resistencia:");

        jSetResistencia2.setText("       0");

        jLResistencia2.setText("Resistencia:");

        jSetResistencia3.setText("       0");

        javax.swing.GroupLayout panelPersonajesLayout = new javax.swing.GroupLayout(panelPersonajes);
        panelPersonajes.setLayout(panelPersonajesLayout);
        panelPersonajesLayout.setHorizontalGroup(
            panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonajesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPersonajesLayout.createSequentialGroup()
                        .addComponent(jLPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLResistencia, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jLSanidad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelPersonajesLayout.createSequentialGroup()
                                .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSetSanidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLPoder2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSetResistencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSetPoder1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelPersonajesLayout.createSequentialGroup()
                        .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLPersonaje3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLPersonaje2, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPersonajesLayout.createSequentialGroup()
                                .addComponent(jLSanidad3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9))
                            .addComponent(jLResistencia1, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jLSanidad2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLResistencia2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addGroup(panelPersonajesLayout.createSequentialGroup()
                                .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSetResistencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSetSanidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSetPoder3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLPoder1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSetResistencia3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLPoder3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSetPoder2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSetSanidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        panelPersonajesLayout.setVerticalGroup(
            panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonajesLayout.createSequentialGroup()
                .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLPersonaje1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPersonajesLayout.createSequentialGroup()
                        .addComponent(jLSanidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jSetSanidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPoder2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jSetPoder1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLResistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSetResistencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPersonajesLayout.createSequentialGroup()
                        .addComponent(jLSanidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(jSetSanidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPoder3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSetPoder2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLResistencia1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSetResistencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLPersonaje2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(panelPersonajesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelPersonajesLayout.createSequentialGroup()
                        .addComponent(jLPersonaje3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(panelPersonajesLayout.createSequentialGroup()
                        .addComponent(jLSanidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSetSanidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLPoder1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSetPoder3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLResistencia2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSetResistencia3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblVida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblVida.setText("Vida: ");
        lblVida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblCasillasDestruidas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCasillasDestruidas.setText("Casillas destruidas:");
        lblCasillasDestruidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane5.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane6.setViewportView(jTextArea3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblVida, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(177, 177, 177)
                        .addComponent(lblCasillasDestruidas, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblVida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCasillasDestruidas, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelJuego.setBackground(new java.awt.Color(153, 153, 153));
        panelJuego.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelJuegoLayout = new javax.swing.GroupLayout(panelJuego);
        panelJuego.setLayout(panelJuegoLayout);
        panelJuegoLayout.setHorizontalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        panelJuegoLayout.setVerticalGroup(
            panelJuegoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txfMensaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEnviar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResultadoDelAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblBitacora, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addComponent(panelPersonajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultadoDelAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelPersonajes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(panelJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
        String line = txfMensaje.getText();               
        if (line.trim().length() != 0) {                     
            String[] commands = CommandUtil.tokenizerArgs(line);
            String commandName = commands[0];               
            String[] commandArgs = null;               

            if (commands.length > 1) {                   
                commandArgs = Arrays.copyOfRange(commands, 1, commands.length);   
            }   

            ICommand command = manager.getCommand(commandName.trim());
            command.setRefCliente(refCliente);
            command.execute(commandArgs); 
        }
        txfMensaje.setText("");
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void txfMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfMensajeActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaCliente().setVisible(true);
            }
        });
    }
    
    public void pintarTurno(String turno){
        this.nombreTurno = turno;
        lblTurno.setText("Turno de " + turno);
    }
    
    public void SetInfoPersonaje(String url, int sanidad, int poder, int resistencia, int personaje){
        if(personaje == 1){
            
            System.out.println(url);
           
            ImageIcon imagen = new ImageIcon(url);
            Icon image = new ImageIcon(imagen.getImage().getScaledInstance(jLPersonaje1.getWidth(), jLPersonaje1.getHeight(), Image.SCALE_DEFAULT));
            jLPersonaje1.setIcon(image);
            jSetPoder1.setVisible(true);
            jSetPoder1.setText(""+poder);
            jSetSanidad1.setVisible(true);
            jSetSanidad1.setText(""+sanidad);
            jSetResistencia1.setVisible(true);
            jSetResistencia1.setText(""+resistencia);
        }
        else if(personaje == 2){
            ImageIcon imagen = new ImageIcon(url);
            Icon image = new ImageIcon(imagen.getImage().getScaledInstance(jLPersonaje2.getWidth(), jLPersonaje2.getHeight(), Image.SCALE_DEFAULT));
            jLPersonaje2.setIcon(image);
            jSetPoder2.setVisible(true);
            jSetPoder2.setText(""+poder);
            jSetSanidad2.setVisible(true);
            jSetSanidad2.setText(""+sanidad);
            jSetResistencia2.setVisible(true);
            jSetResistencia2.setText(""+resistencia);
        }
        else if(personaje == 3){
            ImageIcon imagen = new ImageIcon(url);
            Icon image = new ImageIcon(imagen.getImage().getScaledInstance(jLPersonaje3.getWidth(), jLPersonaje3.getHeight(), Image.SCALE_DEFAULT));
            jLPersonaje3.setIcon(image);
            jSetPoder3.setVisible(true);
            jSetPoder3.setText(""+poder);
            jSetSanidad3.setVisible(true);
            jSetSanidad3.setText(""+sanidad);
            jSetResistencia3.setVisible(true);
            jSetResistencia3.setText(""+resistencia);
        }
    }

    public void setMaximoP1(int MaximoP1) {
        this.MaximoP1 = MaximoP1;
    }

    public void setMaximoP2(int MaximoP2) {
        this.MaximoP2 = MaximoP2;
    }

    public void setMaximoP3(int MaximoP3) {
        this.MaximoP3 = MaximoP3;
    }
    
    public void MensajeAtaque(String ataque){
        jtxtResulAtaque.append(ataque+"\n");
    }
    
    public void MensajeBitacora(String mensaje){
        txaBitacora.append(mensaje+"\n");
    }
    
    public void SetVida(int porcentajevida){
        lblVida.setText("Vida: " + porcentajevida + "%");
    }
    
    public void SetCasillasDestruidas(int casillas){
        lblCasillasDestruidas.setText("CASILLAS DESTRUIDAS : " + casillas  + "%");
    }
    
    public void Personaje1(String nombre,int porcentaje, int  casillas1, int casillas2){
        jTextArea1.setText("");
        jTextArea1.append("     "+nombre+"\n");
        jTextArea1.append(porcentaje+ "  %  "+"\n");
        jTextArea1.append(casillas1 + "  de  " + casillas2 + " casillas\n");
        
    }
    
    public void Personaje2(String nombre,int porcentaje, int  casillas1, int casillas2){
        jTextArea2.setText("");
        jTextArea2.append("     "+nombre+"\n");
        jTextArea2.append(porcentaje+ "  %  "+"\n");
        jTextArea2.append(casillas1 + "  de  " + casillas2 + " casillas\n");
        
    }
    
    public void Personaje3(String nombre,int porcentaje, int  casillas1, int casillas2){
        jTextArea3.setText("");
        jTextArea3.append("     "+nombre+"\n");
        jTextArea3.append(porcentaje+ "  %  "+"\n");
        jTextArea3.append(casillas1 + "  de  " + casillas2 + " casillas\n");
        
    }

    public void setLblTurno(String lblTurno) {
        this.lblTurno.setText(lblTurno);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLPersonaje1;
    private javax.swing.JLabel jLPersonaje2;
    private javax.swing.JLabel jLPersonaje3;
    private javax.swing.JLabel jLPoder1;
    private javax.swing.JLabel jLPoder2;
    private javax.swing.JLabel jLPoder3;
    private javax.swing.JLabel jLResistencia;
    private javax.swing.JLabel jLResistencia1;
    private javax.swing.JLabel jLResistencia2;
    private javax.swing.JLabel jLSanidad1;
    private javax.swing.JLabel jLSanidad2;
    private javax.swing.JLabel jLSanidad3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel jSetPoder1;
    private javax.swing.JLabel jSetPoder2;
    private javax.swing.JLabel jSetPoder3;
    private javax.swing.JLabel jSetResistencia1;
    private javax.swing.JLabel jSetResistencia2;
    private javax.swing.JLabel jSetResistencia3;
    private javax.swing.JLabel jSetSanidad1;
    private javax.swing.JLabel jSetSanidad2;
    private javax.swing.JLabel jSetSanidad3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jtxtResulAtaque;
    private javax.swing.JLabel lblBitacora;
    private javax.swing.JLabel lblCasillasDestruidas;
    private javax.swing.JLabel lblResultadoDelAtaque;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JLabel lblVida;
    private javax.swing.JPanel panelJuego;
    private javax.swing.JPanel panelPersonajes;
    private javax.swing.JTextArea txaBitacora;
    private javax.swing.JTextArea txaMensajes;
    private javax.swing.JTextField txfMensaje;
    // End of variables declaration//GEN-END:variables
}
