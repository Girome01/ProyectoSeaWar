/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;
import java.util.HashMap;

/**
 *
 * @author Gilberth
 */
public class CommandManager {
    Cliente refCliente;
    private static CommandManager commandManager;
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =          
            new HashMap<String, Class<? extends ICommand>>();  

    public void setRefCliente(Cliente refCliente) {
        this.refCliente = refCliente;
    }
    
    private CommandManager() {           
           
    } 
    
    public static synchronized CommandManager getIntance() {           
        if (commandManager == null) {               
            commandManager = new CommandManager();   
        }
        return commandManager;   
    }
    
    public ICommand getCommand(String commandName) {           
        if (COMMANDS.containsKey(commandName.toUpperCase())) {               
            try {                   
                return COMMANDS.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {   e.printStackTrace();                   
            //return new ErrorCommand();
            return null;
            }           
        } 
        else {
            //return new NotFoundCommand();   
            return null;
        }  
    }
    
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    } 
    
}
