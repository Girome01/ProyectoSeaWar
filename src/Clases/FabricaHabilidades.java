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
public class FabricaHabilidades implements MetFabHabilidades{
    enum habilidades
    {RELEASETHEKRAKEN,POSEIDONTRIDENT,FISHTELEPATHY,UNDERSEAFIRE,
    THUNDERUNDERTHESEA};

    @Override
    public Habilidades createHablidad(String _habilidad) {
        switch(habilidades.valueOf(_habilidad.toUpperCase())){
            case RELEASETHEKRAKEN:
                return new ReleaseTheKraken();
            case POSEIDONTRIDENT:
                return new PoseidonTrident();
            case FISHTELEPATHY:
                return new FishTelepathy();
            case UNDERSEAFIRE:
                return null;
            case THUNDERUNDERTHESEA:
                return new ThunderUnderTheSea();
            default:
                return null;
        }
    }
}
