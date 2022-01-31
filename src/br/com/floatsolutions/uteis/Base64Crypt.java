/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.floatsolutions.uteis;

import java.util.Base64;

/**
 *
 * @author Mikeias
 */
public class Base64Crypt {
    
    public static String encoder(String texto){
        String tEncode = Base64.getEncoder().encodeToString(texto.getBytes());
        return tEncode;
    }

    public static String decoder(String texto){
        String tDecoder = new String(Base64.getDecoder().decode(texto));
        return tDecoder;
    }

}
