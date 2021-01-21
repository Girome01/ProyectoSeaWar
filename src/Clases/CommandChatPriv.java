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
public class CommandChatPriv extends BaseCommand{
    public static final String COMMAND_NAME = "chatprivado";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;    
    }

    @Override
    public void execute(String[] args) {
        if(args.length > 1){
            try {
                refCliente.hiloCliente.writer.writeUTF("MENSAJEPRIVADO");
                refCliente.hiloCliente.writer.writeUTF(args[0]);
                refCliente.hiloCliente.writer.writeUTF(args[1]);
            } catch (IOException ex) {
                Logger.getLogger(CommandChat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
            refCliente.refPantalla.addMensaje("PARA ESTE COMANDO OCUPA ESCRIBIR AL DESTINATARIO Y EL MENSAJE"+
                    "\nCOMO SE MUESTRA A CONTINUACION chatprivado -destinatario -mensaje");
    }
    
}
