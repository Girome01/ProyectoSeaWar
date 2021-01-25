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
public class CommandSaltarTurno extends BaseCommand{
    public static final String COMMAND_NAME = "saltarturno";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {

        try {
            refCliente.hiloCliente.writer.writeUTF("SALTARTURNO");
        } catch (IOException ex) {
            Logger.getLogger(CommandSaltarTurno.class.getName()).log(Level.SEVERE, null, ex);
        }

                    
  
        
    }
    
}
