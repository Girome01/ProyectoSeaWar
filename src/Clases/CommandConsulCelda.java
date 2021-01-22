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
public class CommandConsulCelda extends BaseCommand{
    public static final String COMMAND_NAME = "consultarcasillas";

    @Override
    public String getCommandName() {
        return COMMAND_NAME;
    }

    @Override
    public void execute(String[] args) {
        int x =  Integer.parseInt(args[0].trim());
        int y = Integer.parseInt(args[1].trim());
        String datAtaque = "Datos de la casilla "+" ( "+x+", "+y+" )"+"\n";
        datAtaque += refCliente.refPantalla.casillas[x][y].datosCasilla();
        refCliente.refPantalla.addBitacora("*******************\n"+datAtaque);
    }
    
}
