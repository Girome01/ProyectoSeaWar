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
public class CommandRendirse extends BaseCommand{
    public static final String COMMAND_NAME = "rendirse";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {

        try {
            refCliente.hiloCliente.writer.writeUTF("RENDIDO");
            refCliente.hiloCliente.writer.writeUTF(refCliente.refPantalla.getTitle());
            
        } catch (IOException ex) {
            Logger.getLogger(CommandRendirse.class.getName()).log(Level.SEVERE, null, ex);
        }

                    
  
        
    }
    
}
