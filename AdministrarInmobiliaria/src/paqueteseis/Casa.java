
package paqueteseis;

import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;


public class Casa {
    private int numMetro;
    private double precioMetro;
    private int numCuartos;
    private double costoFinal;
    private Propietario propietario;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private Constructora constructora;
    
    public Casa(Propietario pro,double pm,int nm ,Ubicacion
            ub,Ciudad ciu,int nc,Constructora cons){
        propietario = pro;
        precioMetro = pm;
        numMetro = nm;
        ubicacion = ub;
        ciudad = ciu;
        numCuartos = nc;
        constructora = cons;
    }
    public void establecerPropietario(Propietario t){
       propietario = t; 
    }
    public void establecerPrecioMetroC( double t){
        precioMetro = t;
    }
    public void establecerNumeroMetrosC(int t){
        numMetro = t;
    }
    public void establecerUbicacion(Ubicacion t){
        ubicacion = t;
    }
    public void establecerCiudad(Ciudad t){
        ciudad = t;
    }
    public void establecerNumeroCuartos(int t){
        numCuartos = t;
    }
    public void establecerConstructora(Constructora t){
        constructora = t;
    }
    public void establecerCostoFinal(){
        costoFinal = numMetro * precioMetro;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    public double  obtenerPrecioMetroC(){
        return precioMetro;
    }
    public int obtenerNumeroMetroC(){
        return numMetro;
    }
    public Ubicacion obtenerUbicacion (){
        return ubicacion;
    }
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    public int obtenerNumeroCuartos(){
        return numCuartos;
    }
    public Constructora obtenerCostructora(){
        return constructora;
    }
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    
    
}
