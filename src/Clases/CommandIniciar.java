/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberth
 */
public class CommandIniciar extends BaseCommand{
    public static final String COMMAND_NAME = "iniciar";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        try {
            refCliente.hiloCliente.writer.writeUTF("INICIARPARTIDA");
 
        } catch (IOException ex) {
            Logger.getLogger(CommandIniciar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
