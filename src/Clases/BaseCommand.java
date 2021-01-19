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
public abstract class BaseCommand implements ICommand{

    @Override
    public abstract String getCommandName();

    @Override
    public abstract void execute(String[] args);

    public void write(){
        
    }
    
}
