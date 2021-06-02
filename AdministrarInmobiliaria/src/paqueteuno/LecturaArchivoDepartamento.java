package paqueteuno;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paqueteseis.Departamento;

public class LecturaArchivoDepartamento {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> casa;
    private String nombreArchivo;

    public LecturaArchivoDepartamento(String n) {
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

    public void establecerListaDepartamento() {
        // 
        casa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
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

    public ArrayList<Departamento> obtenerListaDepartamento() {
        return casa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Departamentos\n";
        for (int i = 0; i < obtenerListaDepartamento().size(); i++) {
            Departamento dp = obtenerListaDepartamento().get(i);
            cadena = String.format("%s (%d)\n"
                    + " Propietario:\n"
                    + "\t> Nombres: %s\n"
                    + "\t> Apellidos: %s\n"
                    + "\t> Identificación: %s\n"
                    + "\t> Precio por metro cuadrado: %.2f$\n "
                     + "\t> Número de metros cuadrados: %d\n"
                    + " ubicacion:\n"
                    + "\t>Numero de casa%d\n:"
                    + "\t> Barrio: %s\n"
                    + "\t> Referencia: %s\n"
                    + "\t> Numero de Departamento: %s\n"
                    + " Ciudad:\n"
                    + "\t> Ciudad: %s\n"
                    + "\t> Provincia: %s\n"
                    + "\t> Valor cuota mensual: %.2f$\n"
                    + "\t> Constructora: %s\n"
                    + "\t> Id de la empresa: %s\n"
                    + "\t> Nombre de edificio: %s\n"
                    + "\t> Costo Final: %.2f$\n\n",
                    cadena,
                    i + 1,
                    dp.obtenerPropietario().obtenerNombre(),
                    dp.obtenerPropietario().obtenerApellido(),
                    dp.obtenerPropietario().obtenerIdentificacion(),
                    dp.obtenerPrecioMetroC(),
                    dp.obtenerNumeroMetroC(),
                    dp.obtenerUbicacion().obtenerNumeroCasa(),
                    dp.obtenerUbicacion().obtenerUbicacionBarrio(),
                    dp.obtenerUbicacion().obtenerReferncia(),
                    dp.obtenerCiudad().obtenerNombreCuidad(),
                    dp.obtenerCiudad().obtenerNombreProvincia(),
                    dp.obtenerValorAlicuotaM(),
                    dp.obtenerConstructora().obtenerNombreCostructora(),
                    dp.obtenerConstructora().obtenerIdEmpresa(),
                    dp.obtenerNombreEdificio(),
                    dp.obtenerUbicacionDepartamento(),
                    dp.obtenerCostoFinal());
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
