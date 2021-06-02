/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaDciudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciuda;
    private Ciudad objciudad;
    private String nombreArchivo;

    public LecturaDciudad(String n) {
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

    public void establecerObjetoCiudad(String n) {
        for (int i = 0; i < ciuda.size(); i++) {
            if (ciuda.get(i).obtenerNombreCuidad().equals(n)) {
                objciudad = ciuda.get(i);

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCiudadD() {
        // 
        ciuda = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciuda.add(registro);
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

    public Ciudad obtenerOnjetoCiudad() {
        return objciudad;
    }

    public ArrayList<Ciudad> obtenerListaCiudadD() {
        return ciuda;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Ciudades\n";
        for (int i = 0; i < obtenerListaCiudadD().size(); i++) {
            Ciudad ci = obtenerListaCiudadD().get(i);
            cadena = String.format("%s(%d)\n"
                    + "\t> Ciudad: %s\n"
                    + "\t> Provincia: %s\n\n", cadena,
                    i + 1,
                    ci.obtenerNombreCuidad(),
                    ci.obtenerNombreProvincia());
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
