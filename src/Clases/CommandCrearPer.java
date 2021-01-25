/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.IOException;
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
            if(args.length == 5){
                
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
                    refCliente.hiloCliente.writer.writeUTF(refCliente.refPantalla.getTitle());
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
    
}
