package paquetedos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoPropietario {

    private ObjectInputStream entrada;
    private ArrayList<Propietario> propi;
    private Propietario objpropietario;
    private String nombreArchivo;

    public LecturaArchivoPropietario(String n) {
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

    public void establecerObjetoPropietario(String n) {

        for (int i = 0; i < propi.size(); i++) {
            if ((propi.get(i).obtenerIdentificacion()).equals(n)) {
                objpropietario = propi.get(i);

            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaPropietario() {
        // 
        propi = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propi.add(registro);
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

    public Propietario obtenerObjetoPropietario() {
        return objpropietario;
    }

    public ArrayList<Propietario> obtenerListaPropietario() {
        return propi;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Propietarios\n";
        for (int i = 0; i < obtenerListaPropietario().size(); i++) {
            Propietario pr = obtenerListaPropietario().get(i);
            cadena = String.format("%s(%d)\n"
                    + "\t> Nombre: %s\n"
                    + "\t> Apellido: %s\n"
                    + "\t> Identificacion: %s\n\n", cadena,
                    i + 1,
                    pr.obtenerNombre(),
                    pr.obtenerApellido(),
                    pr.obtenerIdentificacion());
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
