package paqueteseis;

import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

public class Departamento {

    private Propietario propietarios;
    private double precioMetro;
    private int numerMetro;
    private double valorAli;
    private Ubicacion ubicaciones;
    private Ciudad ciudades;
    private String nombreEdi;
    private String ubideparta;
    private Constructora constructoras;
    private double costoFinal;

    public Departamento(Propietario prop, double prem, int num, double val, Ubicacion ubi, Ciudad ciu, String ne, String ube, Constructora con) {
        propietarios = prop;
        precioMetro = prem;
        numerMetro = num;
        valorAli = val;
        ubicaciones = ubi;
        ciudades = ciu;
        nombreEdi = ne;
        ubideparta = ube;
        constructoras = con;

    }

    public void establecerPropietario(Propietario k) {
        propietarios = k;
    }

    public void establecerPrecioMetroC(double k) {
        precioMetro = k;
    }

    public void establecerNumeroMetroC(int k) {
        numerMetro = k;
    }

    public void establecerValorAlicuotaM(double k) {
        valorAli = k;
    }

    public void establecerUbicacion(Ubicacion k) {
        ubicaciones = k;
    }

    public void establecerCiudad(Ciudad k) {
        ciudades = k;
    }

    public void establecerNombreEdificio(String k) {
        nombreEdi = k;
    }

    public void establecerUbicacionDepartamento(String k) {
        ubideparta = k;
    }

    public void establecerConstructora(Constructora k) {
        constructoras = k;
    }

    public void establecerCostoFinal() {
        costoFinal = (numerMetro * precioMetro) + (valorAli * 12);
    }

    public Propietario obtenerPropietario() {
        return propietarios;
    }

    public double obtenerPrecioMetroC() {
        return precioMetro;

    }

    public int obtenerNumeroMetroC() {
        return numerMetro;
    }

    public double obtenerValorAlicuotaM() {
        return valorAli;
    }

    public Ubicacion obtenerUbicacion() {
        return ubicaciones;
    }

    public Ciudad obtenerCiudad() {
        return ciudades;
    }

    public String obtenerNombreEdificio() {
        return nombreEdi;
    }

    public String obtenerUbicacionDepartamento() {
        return ubideparta;
    }

    public Constructora obtenerConstructora() {
        return constructoras;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

}
