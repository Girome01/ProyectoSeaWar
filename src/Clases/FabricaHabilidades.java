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
public class FabricaHabilidades implements MetFabHabilidades{
    private Cliente refCliente;
    enum habilidades
    {RELEASETHEKRAKEN,POSEIDONTRIDENT,FISHTELEPATHY,UNDERSEAFIRE,
    THUNDERUNDERTHESEA,WAVESCONTROL};
    
    public FabricaHabilidades(Cliente refCliente) {
        this.refCliente = refCliente;
    }
    
    @Override
    public Habilidades createHablidad(String _habilidad) {
        switch(habilidades.valueOf(_habilidad.toUpperCase())){
            case RELEASETHEKRAKEN:
                return new ReleaseTheKraken(refCliente.refPantalla.casillas);
            case POSEIDONTRIDENT:
                return new PoseidonTrident(refCliente.refPantalla.casillas);
            case FISHTELEPATHY:
                return new FishTelepathy(refCliente.refPantalla.casillas);
            case UNDERSEAFIRE:
                return new UnderSeaFire(refCliente.refPantalla.casillas);
            case THUNDERUNDERTHESEA:
                return new ThunderUnderTheSea(refCliente.refPantalla.casillas);
            case WAVESCONTROL:
                return new WavesControl(refCliente.refPantalla.casillas);
            default:
                return null;
        }
    }
}
