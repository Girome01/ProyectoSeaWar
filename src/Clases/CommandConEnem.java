/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberth
 */
public class CommandConEnem extends BaseCommand{
    public static final String COMMAND_NAME = "consultarenemigo";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        
        if(args != null){
            try {
                refCliente.hiloCliente.writer.writeUTF("CONSULTARENEMIGO");
                refCliente.hiloCliente.writer.writeUTF(args[0]);
            } catch (IOException ex) {
                Logger.getLogger(CommandConEnem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
    
}
