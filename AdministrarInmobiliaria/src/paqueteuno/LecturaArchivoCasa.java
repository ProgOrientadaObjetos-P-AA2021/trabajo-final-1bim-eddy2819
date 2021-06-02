package paqueteuno;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paqueteseis.Casa;

public class LecturaArchivoCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casa;
    private String nombreArchivo;

    public LecturaArchivoCasa(String n) {
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

    public void establecerListaCasa() {
        // 
        casa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casa.add(registro);
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

    public ArrayList<Casa> obtenerListaCasa() {
        return casa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Casas\n";
        for (int i = 0; i < obtenerListaCasa().size(); i++) {
            Casa cs = obtenerListaCasa().get(i);
            cadena = String.format("%s (%d)\n"
                    + "Propietario:\n"
                    + "\t> Nombre: %s\n"
                    + "\t> Apellido: %s\n"
                    + "\t> Identificación: %s\n"
                     + "\t> Precio por metros cuadrados: %.2f$\n"
                    + "\t> Número de metros cuadrados: %dm\n"
                    + " ubicacion:\n"
                    + "\t> Barrio: %s\n"
                    + "\t> Referencia: %s\n"              
                    + "\t> Numero de casa: %s\n"
                    + " Ciudad:\n"
                    + "\t> Ciudad: %s\n"
                    + "\t> Provincia: %s\n"
                    + "\t> Número de cuartos: %d\n"
                    + " constructora:\n"
                    + "\t> Constructora: %s\n"
                    + "\t> Id de la empresa: %s\n"                    
                    + "\t> Costo final: %.2f$\n\n", cadena, i + 1,
                    cs.obtenerPropietario().obtenerNombre(),
                    cs.obtenerPropietario().obtenerApellido(),
                    cs.obtenerPropietario().obtenerIdentificacion(),
                    cs.obtenerPrecioMetroC(),
                    cs.obtenerNumeroMetroC(),
                    cs.obtenerUbicacion().obtenerUbicacionBarrio(),
                    cs.obtenerUbicacion().obtenerReferncia(),
                    cs.obtenerUbicacion().obtenerNumeroCasa(),
                    cs.obtenerCiudad().obtenerNombreCuidad(),
                    cs.obtenerCiudad().obtenerNombreProvincia(),
                    cs.obtenerNumeroCuartos(),
                    cs.obtenerCostructora().obtenerNombreCostructora(),
                    cs.obtenerCostructora().obtenerIdEmpresa(),
                    cs.obtenerCostoFinal());
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
