
package paquetecuatro;

import java.io.Serializable;


public class Ciudad implements Serializable{
    private String nombreci;
    private String nombrepro;
    
    public Ciudad(String nc, String np){
        nombreci = nc;
        nombrepro = np;
    }
    public void establecerNombreCiudad(String n){
        nombreci = n;
    }
    public void establecerNombreProvincia( String n){
        nombrepro = n;
    }
    
    public String obtenerNombreCuidad(){
        return nombreci;
    }
    public String obtenerNombreProvincia(){
        return nombrepro;
    }
    
}
