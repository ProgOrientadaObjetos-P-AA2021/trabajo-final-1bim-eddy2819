/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.ArrayList;
import java.util.Scanner;
import paquetecinco.Constructora;
import paquetecinco.EscritutaArchivoConstructora;
import paquetecinco.LecturaArchivoConstructora;
import paquetecuatro.Ciudad;
import paquetecuatro.EscrituraDciudad;
import paquetecuatro.LecturaDciudad;
import paquetedos.EscrituraArchivoPropietario;
import paquetedos.LecturaArchivoPropietario;
import paquetedos.Propietario;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetetres.EscrituraArchivoUbicacion;
import paquetetres.LecturaArchivoUbicacion;
import paquetetres.Ubicacion;

/**
 *
 * @author USUARIO
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int datos;
        int ingreso;
        boolean salida = true;

        do {
            System.out.println("Inmobiliaria House cyti");
            System.out.println("++++++++++++++++++++++++++++");
            System.out.println("Eliga una opcion: ");
            System.out.println("1. Ingresar Datos \n2.Mostrar Datos\n3.finalizar");
            datos = sc.nextInt();
            if (datos == 1) {
                System.out.println("Eliga una opcion: ");
                System.out.println("1.Ingrese propietario: \n"
                        + "2.Ingrese ubicacion:\n"
                        + "3.Ingrese ciudad:\n"
                        + "4.Ingrese constructora:\n"
                        + "5.Ingrese Casa:\n "
                        + "6.Ingrese Departamento:\n");
                sc.nextLine();
                ingreso = sc.nextInt();
                switch (ingreso) {
                    case 1:
                        propietario();
                        break;
                    case 2:
                        ubicacion();
                        break;
                    case 3:
                        ciudad();
                        break;
                    case 4:
                        constructora();
                        break;
                    case 5:
                        System.out.println();
                        sc.nextLine();
                        System.out.println("Ingrese la identificacion del "
                                + "Propietario:");
                        String ci = sc.nextLine();
                        System.out.println("Ingrese el numero de casa:");
                        int nc = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de la ciudad:");
                        String nom = sc.nextLine();
                        System.out.println("Ingres ID de la empresa de la "
                                + "constructora:");
                        String empresa
                                = sc.nextLine();

                        casa(ci, nc, nom,
                                empresa);
                        break;
                    case 6:
                        System.out.println();
                        sc.nextLine();
                        System.out.println("Ingrese la identificacion del "
                                + "Propietario:");
                        String pro = sc.nextLine();
                        System.out.println("Ingrese el numero del "
                                + "Departamento:");
                        int npd = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Ingrese el nombre de la ciudad:");
                        String ncd = sc.nextLine();
                        System.out.println("Ingres el ID de la empresa "
                                + "constructora:");
                        String cd = sc.nextLine();
                        depa(pro, npd,
                                ncd, cd);
                        break;

                }
            } else {
                if (datos == 2) {
                    System.out.println("Escoja una opcion ");
                    System.out.println("1.Mostrar Lista Propietarios\n"
                            + "2.Mostrar Lista Ubicaciones\n"
                            + "3.Mostrar Lista Ciudades\n"
                            + "4.Mostrar Lista Constructoras\n"
                            + "5.Mostrar Lista Casas\n"
                            + "6.Mostrar Lista Departamentos");
                    ingreso = sc.nextInt();
                    switch (ingreso) {
                        case 1:
                            mostrarpropietario();
                            break;
                        case 2:
                            mostrarubicacion();
                            break;
                        case 3:
                            mostrarciudad();
                            break;
                        case 4:
                            mostrarconstructora();
                            break;
                        case 5:
                            mostrarcasa();
                            break;
                        case 6:
                            mostrardepa();
                            break;

                    }
                }
                if (datos == 3) {
                    salida = false;
                    System.out.println("Gracias por elegir nuestros Servicios\nVuelva Pronto");
                }

            }
        } while (salida);
    }

    public static void propietario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su Nombre: ");
        String nom = sc.nextLine();
        System.out.println("Ingrese su Apellido: ");
        String ape = sc.nextLine();
        System.out.println("Ingrese su Cedula");
        String ci = sc.nextLine();
        Propietario pro = new Propietario(nom, ape, ci);
        EscrituraArchivoPropietario archivoPropi
                = new EscrituraArchivoPropietario("PropietarioS.txt");

        archivoPropi.establecerRegistro(pro);
        archivoPropi.establecerSalida();

        archivoPropi.cerrarArchivo();
    }

    public static void ubicacion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el numero de Casa");
        int ncasa = sc.nextInt();
        System.out.println("Ingrese Ubicacion o Barrio");
        String barri = sc.nextLine();
        System.out.println("Ingrese una referencia");
        String ref = sc.nextLine();
        Ubicacion ubi = new Ubicacion(ncasa, barri, ref);
        EscrituraArchivoUbicacion archivoUbi
                = new EscrituraArchivoUbicacion("Ubicaciones.txt");
        archivoUbi.establecerRegistro(ubi);
        archivoUbi.establecerSalida();
        archivoUbi.cerrarArchivo();
    }

    public static void ciudad() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la ciudad");
        String ciu = sc.nextLine();
        System.out.println("Ingrese la Provincia");
        String prv = sc.nextLine();
        Ciudad ci = new Ciudad(ciu, prv);

        EscrituraDciudad archivoCiu
                = new EscrituraDciudad("Ciudades.txt");
        archivoCiu.establecerRegistro(ci);
        archivoCiu.establecerSalida();

        archivoCiu.cerrarArchivo();
    }

    public static void constructora() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese nombre constructora");
        String ncons = sc.nextLine();
        System.out.println("Ingrese Id de la Empresa");
        String id = sc.nextLine();
        Constructora cons = new Constructora(ncons, id);

        EscritutaArchivoConstructora archivoCo
                = new EscritutaArchivoConstructora("Constructoras.txt");
        archivoCo.establecerRegistro(cons);
        archivoCo.establecerSalida();

        archivoCo.cerrarArchivo();
    }

    public static void casa(String ci, int nume,
            String nombre, String empresa) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> citys;
        ArrayList<Constructora> constructoras;

        System.out.println("Ingrese el precio por metro Cuadrado");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados de la casa:");
        int numMetroCuadrado = sc.nextInt();
        System.out.println("Ingrese el numero de cuartos de la casa:");
        int numeroCuartos = sc.nextInt();

        LecturaArchivoPropietario lecturPropi
                = new LecturaArchivoPropietario("Propietarios.txt");
        lecturPropi.establecerListaPropietario();
        propietarios = lecturPropi.obtenerListaPropietario();
        String nombr = "";
        String apellido = "";
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerNombre().equals(ci)) {
                nombr = propietarios.get(i).obtenerNombre();
                apellido = propietarios.get(i).obtenerApellido();
            }
        }
        Propietario objPropi = new Propietario(nombr, apellido,
                ci);

        LecturaArchivoUbicacion lecturaUbicacion
                = new LecturaArchivoUbicacion("Ubicaciones.txt");
        lecturaUbicacion.establecerListaUbicacionD();

        ubicaciones = lecturaUbicacion.obtenerListaUbicacionD();
        String Barri = "";
        String referens = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNumeroCasa();
            if (numC == nume) {
                Barri = ubicaciones.get(i).obtenerUbicacionBarrio();
                referens = ubicaciones.get(i).obtenerReferncia();
            }
        }
        Ubicacion objUbicacion = new Ubicacion(nume, Barri, referens);

        LecturaDciudad lecturaCi
                = new LecturaDciudad("Ciudades.txt");
        lecturaCi.establecerListaCiudadD();

        citys = lecturaCi.obtenerListaCiudadD();
        String nombreProvincia = "";
        for (int i = 0; i < lecturaCi.obtenerListaCiudadD().size(); i++) {
            if ((citys.get(i).obtenerNombreCuidad().toLowerCase()).equals(nombre.toLowerCase())) {
                nombreProvincia = citys.get(i).obtenerNombreCuidad();
            }
        }
        Ciudad objCity = new Ciudad(nombre, nombreProvincia);

        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("Constructoras.txt");
        lectruaConstructora.establecerListaConstructora();

        constructoras = lectruaConstructora.obtenerListaConstructora();
        String nombreConstructora = "";
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructora().
                size(); i++) {
            if (constructoras.get(i).obtenerIdEmpresa().equals(empresa)) {
                nombreConstructora = constructoras.get(i).obtenerNombreCostructora();
            }
        }
        Constructora objContructora
                = new Constructora(nombreConstructora, empresa);

        Casa casa = new Casa(objPropi, precioMetroCuadrado, numMetroCuadrado,
                objUbicacion, objCity, numeroCuartos, objContructora);
        casa.establecerCostoFinal();

        EscrituraArchivoCasa archivoCasa = new EscrituraArchivoCasa("Casas.txt");
        archivoCasa.establecerRegistro(casa);
        archivoCasa.establecerSalida();
        archivoCasa.cerrarArchivo();
    }

    public static void depa(String prp, int ncs,
            String nameCiudad, String constructoraID) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Propietario> propietarios;
        ArrayList<Ubicacion> ubicaciones;
        ArrayList<Ciudad> citys;
        ArrayList<Constructora> constructoras;

        System.out.println("Ingrese el precio por metro Cuadrado:");
        double precioMetroCuadrado = sc.nextDouble();
        System.out.println("Ingrese el numero de metros cuadrados del "
                + "departamento:");
        int numMetroCuadrado = sc.nextInt();
        System.out.println("Ingrese el valor de la cuota mensual:");
        double cuotaMensual = sc.nextDouble();
        sc.nextLine();
        System.out.println("Ingrese el nombre del edificio:");
        String nameEdificio = sc.nextLine();
        System.out.println("Ingrese la dirección del edificio:");
        String ubicacionEdi = sc.nextLine();

        LecturaArchivoPropietario lecturPropietarios
                = new LecturaArchivoPropietario("Propietarios.txt");
        lecturPropietarios.establecerListaPropietario();
        propietarios = lecturPropietarios.obtenerListaPropietario();
        String nombrePropi = "";
        String apellidoPropi = "";
        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdentificacion().equals(prp)) {
                nombrePropi = propietarios.get(i).obtenerNombre();
                apellidoPropi = propietarios.get(i).obtenerApellido();
            }
        }
        Propietario Prop = new Propietario(nombrePropi, apellidoPropi,
                prp);

        LecturaArchivoUbicacion lecturaUbi
                = new LecturaArchivoUbicacion("Ubicaciones.txt");
        lecturaUbi.establecerListaUbicacionD();
        ubicaciones = lecturaUbi.obtenerListaUbicacionD();
        String nombreBarri = "";
        String referens = "";
        for (int i = 0; i < ubicaciones.size(); i++) {
            int numC = ubicaciones.get(i).obtenerNumeroCasa();
            if (numC == ncs) {
                nombreBarri = ubicaciones.get(i).obtenerUbicacionBarrio();
                referens = ubicaciones.get(i).obtenerReferncia();
            }
        }
        Ubicacion objUbicacion = new Ubicacion(ncs, nombreBarri, referens);

        LecturaDciudad lecturaCi
                = new LecturaDciudad("Ciudades.txt");
        lecturaCi.establecerListaCiudadD();
        citys = lecturaCi.obtenerListaCiudadD();
        String nombreProvincia = "";
        for (int i = 0; i < lecturaCi.obtenerListaCiudadD().size(); i++) {
            if (citys.get(i).obtenerNombreCuidad().equals(nameCiudad)) {
                nombreProvincia = citys.get(i).obtenerNombreCuidad();
            }
        }
        Ciudad objCity = new Ciudad(nameCiudad, nombreProvincia);

        LecturaArchivoConstructora lectruaConstructora
                = new LecturaArchivoConstructora("Constructoras.txt");
        lectruaConstructora.establecerListaConstructora();
        constructoras = lectruaConstructora.obtenerListaConstructora();
        String nombreConstructora = "";
        for (int i = 0; i < lectruaConstructora.obtenerListaConstructora().
                size(); i++) {
            if (constructoras.get(i).obtenerIdEmpresa().equals(constructoraID)) {
                nombreConstructora = constructoras.get(i).obtenerNombreCostructora();
            }
        }
        Constructora objContructora = new Constructora(nombreConstructora,
                constructoraID);

        Departamento dep = new Departamento(Prop, precioMetroCuadrado,
                numMetroCuadrado, cuotaMensual, objUbicacion, objCity,
                nameEdificio, ubicacionEdi, objContructora);

        dep.establecerCostoFinal();
        EscrituraArchivoDepartamento archivoDepa
                = new EscrituraArchivoDepartamento("Departamentos.txt");
        archivoDepa.establecerRegistro(dep);
        archivoDepa.establecerSalida();
        archivoDepa.cerrarArchivo();
    }

    public static void mostrarpropietario() {
        LecturaArchivoPropietario lecturapro
                = new LecturaArchivoPropietario("Propietarios.txt");
        lecturapro.establecerListaPropietario();
        System.out.println(lecturapro);
    }

    public static void mostrarubicacion() {
        LecturaArchivoUbicacion lecturaubi
                = new LecturaArchivoUbicacion("Ubicaciones.txt");
        lecturaubi.establecerListaUbicacionD();
        System.out.println(lecturaubi);
    }

    public static void mostrarciudad() {
        LecturaDciudad lecturaciu
                = new LecturaDciudad("Ciudades.txt");
        lecturaciu.establecerListaCiudadD();
        System.out.println(lecturaciu);
    }

    public static void mostrarconstructora() {
        LecturaArchivoConstructora lecturaCons
                = new LecturaArchivoConstructora("Constructoras.txt");
        lecturaCons.establecerListaConstructora();
        System.out.println(lecturaCons);
    }

    public static void mostrarcasa() {
        LecturaArchivoCasa lecturacasa
                = new LecturaArchivoCasa("Casas.txt");
        lecturacasa.establecerListaCasa();
        System.out.println(lecturacasa);
    }

    public static void mostrardepa() {
        LecturaArchivoDepartamento lecturadepa
                = new LecturaArchivoDepartamento("Departamentos.txt");
        lecturadepa.establecerListaDepartamento();
        System.out.println(lecturadepa);
    }

}
