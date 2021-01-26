/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.HashMap;

/**
 *
 * @author Gilberth
 */
public class CommandManager {
    private static CommandManager commandManager;
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =          
            new HashMap<String, Class<? extends ICommand>>();  
    
    private CommandManager() {           
        registCommand(CommandChat.COMMAND_NAME, CommandChat.class);
        registCommand(CommandChatPriv.COMMAND_NAME, CommandChatPriv.class);
        registCommand(CommandPintarCeldas.COMMAND_NAME, CommandPintarCeldas.class);
        registCommand(CommandConsulCelda.COMMAND_NAME, CommandConsulCelda.class);
        registCommand(CommandConCeldOcupada.COMMAND_NAME, CommandConCeldOcupada.class);
        registCommand(CommandConEnem.COMMAND_NAME, CommandConEnem.class);
        registCommand(CommandIniciar.COMMAND_NAME, CommandIniciar.class);
        registCommand(CommandCrearPer.COMMAND_NAME, CommandCrearPer.class);
        registCommand(CommandSaltarTurno.COMMAND_NAME, CommandSaltarTurno.class);
        registCommand(CommandRendirse.COMMAND_NAME, CommandRendirse.class);
        registCommand(CommandLog.COMMAND_NAME, CommandLog.class);
        registCommand(CommandLogresumen.COMMAND_NAME, CommandLogresumen.class);
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
                return new ErrorCommand();
            }           
        } 
        else {
            return new NotFoundCommand();   
        }  
    }
    
    public void registCommand(String commandName, Class<? extends ICommand> command) {   
        COMMANDS.put(commandName.toUpperCase(), command);   
    } 
    
}