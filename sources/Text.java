/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VigenereCipher;

import java.io.BufferedReader;

/**
 *
 * @author Sergio
 */
public class Text {
    private String textoCifrado;
    private String textoDescifrado;
    private String clave;
    
    public Text(String td, String c){
        textoDescifrado = td.toUpperCase();
        textoCifrado = "";
        clave = c.toUpperCase();
    }
    
    public String getTextoCifrado(){
        return textoCifrado;
    }
    
    public String getTextoDescifrado(){
        return textoDescifrado;
    }
    
    public void cifrarTexto(){
        int k=0;
        System.out.println("Clave: "+clave+" ("+clave.length()+")");
        
        for(int i=0; i<textoDescifrado.length();i++){
            if(textoDescifrado.charAt(i)>='A' && textoDescifrado.charAt(i)<='Z'){
                //ES UNA LETRA Y HAY QUE CIFRARLO
               System.out.print(textoDescifrado.charAt(i)+"("+i+") [Cifrando con "+clave.charAt(k)+"] --> ");
               char in = textoDescifrado.charAt(i);
               int aux = ((textoDescifrado.charAt(i)-'A' + clave.charAt(k)-'A') % 26);
               System.out.println((char)(aux+'A'));
                
               
               textoCifrado+= ((char)(aux+'A'));
                ++k;
                if(k>=clave.length())k=0;
                
            }else if (textoDescifrado.charAt(i)>='0' && textoDescifrado.charAt(i)<='9'){
                //ES UN NUMERO Y HAY QUE CIFRARLO DE FORMA DIFERENTE QUE LAS LETRAS
                textoCifrado+=textoDescifrado.charAt(i)+clave.length();
            }
        }
        
        System.out.println("CIFRADO: \n "+textoCifrado);
    }
    
    
    public void descifrarTexto(){
        
        int k = 0;
        String aux = "";
        char c;
        for(int i=0; i<textoCifrado.length(); i++){
            System.out.print(textoCifrado.charAt(i)+"("+i+") [Descifrando con "+clave.charAt(k)+"] --> ");
            c = textoCifrado.charAt(i);
            if(c>='A' && c<='Z'){
                
                c=(char)((c - clave.charAt(k) + 26) % 26 + 'A');
                System.out.println(c);
                aux+=c;
            }
              
            ++k;
            if(k>=clave.length())k=0;
            
        }
        System.out.println("DESCIFRADO: \n"+aux);
        textoDescifrado=aux;   
    }
}
