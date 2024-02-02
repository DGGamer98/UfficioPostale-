/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tutor.up;

/**
 *
 * @author mario
 */
public enum ServiziType {
    SPEDIZIONI(7.5f, ServiziCode.S),
    PAGAMENTI(10.0f, ServiziCode.P),
    FINANZIARI(30.0f,ServiziCode.F);
    
   
    private float mediaTemp;
    private ServiziCode code;
   
    private ServiziType(float mediaTemp, ServiziCode code) {
        this.mediaTemp = mediaTemp;
        this.code = code;
    }
    
    public float getTempMedia() {
        return mediaTemp;
    }

    public ServiziCode getCode() {
        return code;
    }
    public static ServiziType getTypeByComboIndex(int c){
        switch(c){
            case 0:{
                return ServiziType.SPEDIZIONI;
            }
            case 1:{
                return ServiziType.PAGAMENTI;
            }
            case 2:{
                return ServiziType.FINANZIARI;
            }
            default:{
                return ServiziType.SPEDIZIONI;
            }
        }
        
    }
    
    
}
