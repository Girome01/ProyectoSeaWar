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
public class CommandLog extends BaseCommand{
    public static final String COMMAND_NAME = "log";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;    
    }

    @Override
    public void execute(String[] args) {
       
            refCliente.refPantalla.addMensaje("Ataques Ejecutados:");
            for (int i = 0; i < refCliente.AtaquesExitosos.size(); i++) {
                String exitosos = refCliente.AtaquesExitosos.get(i);
                refCliente.refPantalla.addMensaje(exitosos);
            }
            for (int i = 0; i < refCliente.AtaquesNoExitosos.size(); i++) {
                String noexitosos = refCliente.AtaquesNoExitosos.get(i);
                refCliente.refPantalla.addMensaje(noexitosos);
            }
            refCliente.refPantalla.addMensaje("");
            refCliente.refPantalla.addMensaje("Ataques Recibidos:");
            for (int i = 0; i < refCliente.AtaquesRecibido.size(); i++) {
                String recibidos = refCliente.AtaquesRecibido.get(i);
                refCliente.refPantalla.addMensaje(recibidos);
            }
            
    }
    
}
