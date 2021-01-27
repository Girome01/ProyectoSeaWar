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
                return new ReleaseTheKraken(refCliente);
            case POSEIDONTRIDENT:
                return new PoseidonTrident(refCliente);
            case FISHTELEPATHY:
                return new FishTelepathy(refCliente);
            case UNDERSEAFIRE:
                return new UnderSeaFire(refCliente);
            case THUNDERUNDERTHESEA:
                return new ThunderUnderTheSea(refCliente);
            case WAVESCONTROL:
                return new WavesControl(refCliente);
            default:
                return null;
        }
    }
}
