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
    private Luchador refPersonaje;
    enum habilidades
    {RELEASETHEKRAKEN,POSEIDONTRIDENT,FISHTELEPATHY,UNDERSEAFIRE,
    THUNDERUNDERTHESEA,WAVESCONTROL};
    
    public FabricaHabilidades(Cliente refCliente,Luchador refPersonaje) {
        this.refCliente = refCliente;
        this.refPersonaje = refPersonaje;
    }
    
    @Override
    public Habilidades createHablidad(String _habilidad) {
        switch(habilidades.valueOf(_habilidad.toUpperCase())){
            case RELEASETHEKRAKEN:
                return new ReleaseTheKraken(refCliente,refPersonaje);
            case POSEIDONTRIDENT:
                return new PoseidonTrident(refCliente,refPersonaje);
            case FISHTELEPATHY:
                return new FishTelepathy(refCliente,refPersonaje);
            case UNDERSEAFIRE:
                return new UnderSeaFire(refCliente,refPersonaje);
            case THUNDERUNDERTHESEA:
                return new ThunderUnderTheSea(refCliente,refPersonaje);
            case WAVESCONTROL:
                return new WavesControl(refCliente,refPersonaje);
            default:
                return null;
        }
    }
}
