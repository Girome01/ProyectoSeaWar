/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
        
        if(refCliente.refPantalla.turno.equals(refCliente.refPantalla.getTitle())){
           if(args != null){
               
               String sanidad = "sanidad";
               String poder = "poder";
               String Resistenica = "resistencia";

               if(args[1].trim().equals(sanidad)){
                   for (int i = 0; i < refCliente.personajes.size(); i++) {
                       if(refCliente.personajes.get(i).getNombre().equals(args[0].trim())){
                           System.out.println("Encuentra el personaje");
                           for(int r=0; r<20; r++){
                                for(int c=0; c<30; c++){
                                
                                    if(refCliente.refPantalla.casillas[r][c].personaje.getNombre().equals(args[0].trim())){
                                        refCliente.refPantalla.casillas[r][c].RecuperarVida();
                                        refCliente.refPantalla.MensajeBitacora("La casilla :" + r + c + "se curo su porcentaje");
                                    }
                                        
                                }
                            }
                       }
                   }
               }
               else if(args[0].trim().equals(poder)){
                   for (int i = 0; i < refCliente.personajes.size(); i++) {
                       if(refCliente.personajes.get(i).getNombre().equals(args[0].trim())){
                           refCliente.personajes.get(i).ActivarPoder();
                           refCliente.refPantalla.MensajeBitacora("Activo el poder del personaje");
                       }
                   }
                   
               }
               else if(args[0].trim().equals(Resistenica)){
                   for (int i = 0; i < refCliente.personajes.size(); i++) {
                       if(refCliente.personajes.get(i).getNombre().equals(args[0].trim())){
                           refCliente.personajes.get(i).ActivarResistencia();
                           refCliente.refPantalla.MensajeBitacora("Activo la Resistencia del personaje");
                       }
                   }
                   
               }
               else{
                   if(args.length >= 3 ){
                       for(int i = 0; i < refCliente.personajes.size(); i++){
                        if(refCliente.personajes.get(i).Nombre.equals(args[0])){

                            ArrayList<Integer> Posiciones = new ArrayList<Integer> (); 
                            for (int j = 4; j < args.length; j++) {
                                Posiciones.add(Integer.parseInt(args[j].trim()));
                            }
                            refCliente.personajes.get(i).Ataque(args[1],args[2],args[3],Posiciones);
                            }
                        }
                   }
                    
               }
                
            } 
        }
        
        else{
            refCliente.refPantalla.addMensaje("NO ES SU TURNO");
        }
        
      

        
    }
    
}
