package paquetecinco;

import java.io.Serializable;

public class Constructora implements Serializable {

    private String nombreCons;
    private String idempresa;

    public Constructora(String nc, String ie) {
        nombreCons = nc;
        idempresa = ie;
    }

    public void establecerNombreCostructora(String a) {
        nombreCons = a;
    }

    public void establecerIdEmpresa(String a) {
        idempresa = a;
    }

    public String obtenerNombreCostructora() {
        return nombreCons;
    }

    public String obtenerIdEmpresa() {
        return idempresa;
    }

}
