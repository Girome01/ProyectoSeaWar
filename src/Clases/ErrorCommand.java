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
public class ErrorCommand extends BaseCommand{
    public static final String COMMAND_NAME = "error";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        refCliente.refPantalla.addMensaje("ERROR en ejecutar ese comando");
    }
    
}
