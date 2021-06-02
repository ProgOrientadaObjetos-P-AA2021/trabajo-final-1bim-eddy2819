package paquetecinco;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class LecturaArchivoConstructora {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> constru;
    private String nombreArchivo;
    private Constructora ObjetoConstructora;

    public LecturaArchivoConstructora(String n) {
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

    public void establecerObjetoConstructora(String n) {
        for (int i = 0; i < constru.size(); i++) {
            if ((constru.get(i).obtenerIdEmpresa()).equals(n)) {
                ObjetoConstructora = constru.get(i);
            }
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaConstructora() {
        // 
        constru = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constru.add(registro);
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

    public Constructora obtenerObjetoConstructora() {
        return ObjetoConstructora;
    }

    public ArrayList<Constructora> obtenerListaConstructora() {
        return constru;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Constructoras\n";
        for (int i = 0; i < obtenerListaConstructora().size(); i++) {
            Constructora co = obtenerListaConstructora().get(i);
            cadena = String.format("%sConstructora numero (%d):\n"
                    + "\t> Constructora: %s\n"
                    + "\t> Id Empresa: %s\n\n", cadena,
                    i + 1,
                    co.obtenerNombreCostructora(),
                    co.obtenerIdEmpresa());
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
