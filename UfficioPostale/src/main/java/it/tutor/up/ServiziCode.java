/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tutor.up;

/**
 *
 * @author Federico
 */
public enum ServiziCode {
    S('S'),
    P('P'),
    F('F');
    
    private char code;

    private ServiziCode(char code) {
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public static ServiziCode codeByChar(char x){
        switch (x){
            
            case 'S': return ServiziCode.S;
            case 'P': return ServiziCode.P;
            case 'F': return ServiziCode.F;
            
            default : return null;
        }
    }
    
    
    
    
}
