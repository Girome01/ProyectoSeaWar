/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Gilberth
 */
public class CommandCeldasNormal extends BaseCommand{
    public static final String COMMAND_NAME = "celdasanormal";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        
        refCliente.refPantalla.VolverCasillas();
        
        
    }
    
}
