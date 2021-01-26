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
public class CommandMostarPorCelda extends BaseCommand{
    public static final String COMMAND_NAME = "porcentajecelda";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        for(int r=0; r<20; r++){
            for(int c=0; c<30;){
                refCliente.refPantalla.casillas[r][c].porcentajeCasilla();
            }
        }
    }
    
}
