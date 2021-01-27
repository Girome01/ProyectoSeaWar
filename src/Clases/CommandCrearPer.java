/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilberth
 */
public class CommandCrearPer extends BaseCommand{
    public static final String COMMAND_NAME = "crearpersonaje";


    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        
        if (args != null){
            if(args.length == 5 && Seleccion(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])) && VerificarNombre(args[0])){
                
                JOptionPane.showMessageDialog(null, "Seleccione la url de la imagen del personaje");
                File url;
                JFileChooser ulrf = new JFileChooser();
                ulrf.showOpenDialog(null);
                url = ulrf.getSelectedFile();
                String casting = "" + url;
                try {
                    refCliente.hiloCliente.writer.writeUTF("CREARPERSONAJE");
                    refCliente.hiloCliente.writer.writeUTF(args[0]);
                    refCliente.hiloCliente.writer.writeUTF(casting);
                    refCliente.hiloCliente.writer.writeInt(Integer.parseInt(args[1]));
                    refCliente.hiloCliente.writer.writeInt(Integer.parseInt(args[2]));
                    refCliente.hiloCliente.writer.writeInt(Integer.parseInt(args[3]));
                    refCliente.hiloCliente.writer.writeInt(Integer.parseInt(args[4]));
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(CommandChat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
  
        
    }
    
    private boolean Seleccion(int poder, int sanidad, int resistencia){
        boolean resultado = true;
        if((sanidad == 50 || sanidad == 75 || sanidad == 100) && ( poder == 50 || poder == 75 || poder == 100 ) && ( resistencia == 50 || resistencia == 75 || resistencia == 100)){
            System.out.println(refCliente.Poder.size());
            for (int i = 0; i < refCliente.Poder.size(); i++) {
                if (refCliente.Poder.get(i) == poder){
                    resultado = false;
                    break;
                }
            }
            for (int i = 0; i < refCliente.Sanidad.size(); i++) {
                if (refCliente.Sanidad.get(i) == sanidad){
                    resultado = false;
                    break;
                }
            }
            for (int i = 0; i < refCliente.Resistencia.size(); i++) {
                if (refCliente.Resistencia.get(i) == resistencia){
                    resultado = false;
                    break;
                }
            }
        }
        else{
            resultado = false;
        }
        
        if (resultado == true){

            refCliente.Sanidad.add(sanidad);
            refCliente.Poder.add(poder);
            refCliente.Resistencia.add(resistencia);
        }
        else{
             refCliente.refPantalla.addMensaje("Verifique los datos ingresados");
        }
        return resultado;
    }
    
    private boolean VerificarNombre(String name){
        boolean resultado = true;
        for (int i = 0; i < refCliente.personajes.size(); i++) {
            if (refCliente.personajes.get(i).equals(name)){
                    resultado = false;
                    break;
            }
       }
        return resultado;
    }
}
