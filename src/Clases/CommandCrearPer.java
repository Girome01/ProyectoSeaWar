/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Gilberth
 */
public class CommandCrearPer extends BaseCommand{
    public static final String COMMAND_NAME = "crearpersonaje";


    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        
        if (args != null){
            if(Finalizo() && args.length == 6 && Seleccion(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])) && VerificarNombre(args[0]) && PorcentajePoblacion(Integer.parseInt(args[1]))){
                       

                refCliente.Sanidad.add(Integer.parseInt(args[3]));
                refCliente.Poder.add((Integer.parseInt(args[2])));
                refCliente.Resistencia.add(Integer.parseInt(args[4]));
     
                JOptionPane.showMessageDialog(null, "Seleccione la url de la imagen del personaje");
                File url;
                JFileChooser ulrf = new JFileChooser();
                ulrf.showOpenDialog(null);
                url = ulrf.getSelectedFile();
                String casting = "" + url;
                refCliente.CrearPersonaje(args[0], casting, Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), args[5]);
            }
        else{
            refCliente.refPantalla.addMensaje("PARA ESTE COMANDO OCUPA ESCRIBIR El NOMBRE DEL PERSONAJE, EL PORCENTAJE"+
                    "\n, EL PODER, LA RESISTENCIA, LA SANIDAD Y EL ATAQUE; EN EL ORDEN PRESENTADO ANTERIORMENTE ");
            }
            
        }
        
  
        
    }
    
    private boolean Seleccion(int poder, int sanidad, int resistencia){
        boolean resultado = true;
        if((sanidad == 50 || sanidad == 75 || sanidad == 100) && ( poder == 50 || poder == 75 || poder == 100 ) && ( resistencia == 50 || resistencia == 75 || resistencia == 100)){
            for (int i = 0; i < refCliente.Poder.size(); i++) {
                if (refCliente.Poder.get(i) == poder){
                    resultado = false;
                    break;
                }
            }
            for (int i = 0; i < refCliente.Sanidad.size(); i++) {
                if (refCliente.Sanidad.get(i) == sanidad){
                    resultado = false;
                    break;
                }
            }
            for (int i = 0; i < refCliente.Resistencia.size(); i++) {
                if (refCliente.Resistencia.get(i) == resistencia){
                    resultado = false;
                    break;
                }
            }
        }
        else{
            resultado = false;
        }
        
        if (resultado == false){
             refCliente.refPantalla.addMensaje("Verifique los datos ingresados,porder, sanidad o resistencia");
        }
        return resultado;
    }
    
    private boolean VerificarNombre(String name){
        boolean resultado = true;
        for (int i = 0; i < refCliente.personajes.size(); i++) {
            if (refCliente.personajes.get(i).equals(name)){
                    resultado = false;
                    break;
            }
       }
        return resultado;
    }
    
    private boolean PorcentajePoblacion(int Porcentaje){
        boolean resultado = true;
        System.out.println(refCliente.PorPoblacion);
           if (Porcentaje > 98){
               resultado = false;

               refCliente.refPantalla.addMensaje("Verifique los datos ingresados, porcentaje de poblacion");
           }
           if(refCliente.PorPoblacion == 2 && Porcentaje > 1){
               resultado = false;
               refCliente.refPantalla.addMensaje("Verifique los datos ingresados, porcentaje de poblacion");
           }
           
           if(refCliente.PorPoblacion + Porcentaje > 100){

              resultado = false;
               refCliente.refPantalla.addMensaje("Verifique los datos ingresados, porcentaje de muy alto"); 
           }

        return resultado;
    }
    
    private boolean Finalizo(){
        boolean resultado = true;
        if(refCliente.cantidadPersonajes >=4){
            resultado = false;
            refCliente.refPantalla.addMensaje("Ya no puede crear mas personajes"); 
        }
        return resultado;
    }
}
