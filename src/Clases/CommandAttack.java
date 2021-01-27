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
public class CommandAttack extends BaseCommand{
    public static final String COMMAND_NAME = "ataque";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        for(int i = 0; i < refCliente.personajes.size(); i++){
            if(refCliente.personajes.get(i).Nombre.equals(args[0])){
                
            }
        }
    }
    
}
