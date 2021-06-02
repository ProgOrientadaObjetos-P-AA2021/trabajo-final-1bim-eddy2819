
package paquetetres;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoUbicacion {
    private ObjectInputStream entrada;
    private ArrayList<Ubicacion> ubica;
    private Ubicacion objetoUbi;
    private String nombreArchivo;

    public LecturaArchivoUbicacion(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaUbicacionD() {
        // 
        ubica = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ubicacion registro = (Ubicacion) entrada.readObject();
                    ubica.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }
    public void establecerUbicacionObjeto(int n){
        
        for(int i=0; i < ubica.size(); i++ ){
            if(ubica.get(i).obtenerNumeroCasa() == n){
               objetoUbi = ubica.get(i);
                
            }
        }
    }

    public ArrayList<Ubicacion> obtenerListaUbicacionD() {
        return ubica;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    public Ubicacion obtenerObjetoUbicacion(){
        return objetoUbi;
    }

    @Override
    public String toString() {
        String cadena = "Ubicaciones de Departamentos\n";
        for (int i = 0; i < obtenerListaUbicacionD().size(); i++) {
            Ubicacion ubi = obtenerListaUbicacionD().get(i);
            cadena = String.format("%s(%d)\n"
                    + "\t> Barrio: %s\n"
                    + "\t> Referencia: %s\n\n", cadena,
                    i + 1,
                   ubi.obtenerNumeroCasa(),
                   ubi.obtenerUbicacionBarrio(),
                   ubi.obtenerReferncia());
        }
        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo
}

