/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Gilberth
 */
public class NotFoundCommand extends BaseCommand{
    public static final String COMMAND_NAME = "noencontrado";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        refCliente.refPantalla.addMensaje("ESE COMANDO NO SE ENCUENTREA REGISTRADO");
    }
    
}
