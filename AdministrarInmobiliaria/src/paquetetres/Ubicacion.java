package paquetetres;

import java.io.Serializable;

public class Ubicacion implements Serializable {

    private int numCasa;
    private String ubibarrio;
    private String referencia;

    public Ubicacion(int nc, String ub, String ref) {
        numCasa = nc;
        ubibarrio = ub;
        referencia = ref;
    }

    public void establecerNumeroCasa(int l) {
        numCasa = l;
    }

    public void establecerUbicacionBarrio(String l) {
        ubibarrio = l;
    }

    public void establecerReferncia(String l) {
        referencia = l;
    }

    public int obtenerNumeroCasa() {
        return numCasa;
    }

    public String obtenerUbicacionBarrio() {
        return ubibarrio;
    }

    public String obtenerReferncia() {
        return referencia;
    }

}
