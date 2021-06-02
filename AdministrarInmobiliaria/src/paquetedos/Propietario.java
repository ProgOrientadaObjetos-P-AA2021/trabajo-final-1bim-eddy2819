
package paquetedos;

import java.io.Serializable;

public class Propietario implements Serializable{
    private String nombre;
    private String apellido;
    private String ident;
    
    public Propietario(String n, String ap, String id){
        nombre = n;
        apellido = ap;
        ident = id;
        
    }
    public void establecerNombre(String p){
        nombre = p;
    }
    public void establecerApellido(String p){
        apellido = p;
    }
    public void establecerIdentificacion(String p){
        ident = p;
    }
    
    public String obtenerNombre(){
        return nombre;
    }  
    public String obtenerApellido(){
        return apellido;
    }
    public String obtenerIdentificacion(){
        return ident;
    }  
}
