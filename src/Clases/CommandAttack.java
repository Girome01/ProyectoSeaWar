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
public class CommandAttack extends BaseCommand{
    public static final String COMMAND_NAME = "ataque";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        
        if(args != null){
           for(int i = 0; i < refCliente.personajes.size(); i++){
                if(refCliente.personajes.get(i).Nombre.equals(args[0])){
                    
                    //3
                    ArrayList<Integer> Posiciones = new ArrayList<Integer> (); 
                    for (int j = 4; j < args.length; j++) {
                        Posiciones.add(Integer.parseInt(args[j].trim()));
                    }
                   boolean ataco = refCliente.personajes.get(i).Ataque(args[1],args[2],args[3],Posiciones);
                   if (ataco == true){
                       refCliente.refPantalla.MensajeAtaque("EL ataque se realizo con exito");
                   }
                   else{
                     refCliente.refPantalla.MensajeAtaque("EL ataque no se realizo con exito");  
                   }
                }
            } 
        }
        
        
    }
    
}
