/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Cliente.Cliente;

/**
 *
 * @author Gilberth
 */
public abstract class BaseCommand implements ICommand{
    Cliente refCliente;

    public BaseCommand(Cliente refCliente) {
        this.refCliente = refCliente;
    }
    
    @Override
    public abstract String getCommandName();

    @Override
    public abstract void execute(String[] args);

    public void write(){
        
    }
    
}
