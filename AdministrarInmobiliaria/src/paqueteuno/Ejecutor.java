package paqueteuno;

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

public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int datos;
        int ingreso;
        boolean salida = true;

        do {
            System.out.println("Inmobiliaria");
            System.out.println("++++++++++++++++");
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
                        casa();
                        break;
                    case 6:
                        depa();
                        break;
                }
            } else{
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
                            mostarpropietario();
                            break;
                        case 2:
                            mostarubicacion();
                            break;
                        case 3:
                            mostarciudad();
                            break;
                        case 4:
                            mostarconstructora();
                            break;
                        case 5:
                            mostarcasa();
                            break;
                        case 6:
                            mostardepa();
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
        String nombreArchivop = "Propietarios.txt";
        System.out.println("Ingrese su Nombre: ");
        String nom = sc.nextLine();
        System.out.println("Ingrese su Apellido: ");
        String ape = sc.nextLine();
        System.out.println("Ingrese su Cedula");
        String ci = sc.nextLine();
        Propietario pro = new Propietario(nom, ape, ci);
        EscrituraArchivoPropietario archivopro = new EscrituraArchivoPropietario(nombreArchivop);
        archivopro.establecerRegistro(pro);
        archivopro.establecerSalida();
        archivopro.cerrarArchivo();
    }

    public static void ubicacion() {
        Scanner sc = new Scanner(System.in);
        String nombreArchivou = "Ubicaciones.txt";
        System.out.println("Ingrese el numero de Casa");
        int ncasa = sc.nextInt();
        System.out.println("Ingrese Ubicacion o Barrio");
        String barri = sc.nextLine();
        System.out.println("Ingrese una referencia");
        String ref = sc.nextLine();
        Ubicacion ubi = new Ubicacion(ncasa, barri, ref);
        EscrituraArchivoUbicacion archivoub = new EscrituraArchivoUbicacion(nombreArchivou);
        archivoub.establecerRegistro(ubi);
        archivoub.establecerSalida();
        archivoub.cerrarArchivo();
    }

    public static void ciudad() {
        Scanner sc = new Scanner(System.in);
        String nombreArchivoc = "Ciudades.txt";
        System.out.println("Ingrese la ciudad");
        String ciu = sc.nextLine();
        System.out.println("Ingrese la Provincia");
        String prv = sc.nextLine();
        Ciudad ci = new Ciudad(ciu, prv);
        EscrituraDciudad archivoCi = new EscrituraDciudad(nombreArchivoc);
        archivoCi.establecerRegistro(ci);
        archivoCi.establecerSalida();
        archivoCi.cerrarArchivo();
    }

    public static void constructora() {
        Scanner sc = new Scanner(System.in);
        String nombreArchivoco = "Constructora.txt";
        System.out.println("Ingrese nombre constructora");
        String ncons = sc.nextLine();
        System.out.println("Ingrese Id de la Empresa");
        String id = sc.nextLine();
        Constructora cons = new Constructora(ncons, id);
        EscritutaArchivoConstructora archivocon = new EscritutaArchivoConstructora(nombreArchivoco);
        archivocon.establecerRegistro(cons);
        archivocon.establecerSalida();
        archivocon.cerrarArchivo();
    }

    public static void casa() {
        Scanner sc = new Scanner(System.in);
        String nombreArchivoC = "Casas.txt";
        
        System.out.println("Ingrese Identificacion del Propietario");
        String ipro = sc.nextLine();
        LecturaArchivoPropietario lecturapro = new LecturaArchivoPropietario("Propietarios.txt");
        lecturapro.establecerListaPropietario();
        lecturapro.establecerObjetoPropietario(ipro);
        Propietario propie = lecturapro.obtenerObjetoPropietario();
        if (propie != null) {
            System.out.println(propie);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese numero Casa");
        int ncasa = sc.nextInt();
        LecturaArchivoUbicacion lecturaUbi = new LecturaArchivoUbicacion("Ubicaciones.txt");
        lecturaUbi.establecerListaUbicacionD();
        lecturaUbi.establecerUbicacionObjeto(ncasa);
        Ubicacion ubic = lecturaUbi.obtenerObjetoUbicacion();
        if (ubic != null) {
            System.out.println(ubic);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese Nombre de la Ciudad");
        String nomc = sc.nextLine();
        LecturaDciudad lecturaCiu = new LecturaDciudad("Ciudades.txt");
        lecturaCiu.establecerListaCiudadD();
        lecturaCiu.establecerObjetoCiudad(nomc);
        Ciudad ciud = lecturaCiu.obtenerOnjetoCiudad();
        if (ciud != null) {
            System.out.println(ciud);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese el ID de la Empresa");
        String idem = sc.nextLine();
        LecturaArchivoConstructora lecturacon = new LecturaArchivoConstructora("Constructoras.txt");
        lecturacon.establecerListaConstructora();
        lecturacon.establecerObjetoConstructora(idem);
        Constructora co = lecturacon.obtenerObjetoConstructora();
        if (co != null) {
            System.out.println(co);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese Precio  por metro cuadrado: ");
        double prec = sc.nextDouble();
        System.out.println("Ingrese número de metros cuadrados: ");
        int nmetros = sc.nextInt();
        System.out.println("Ingrese numero de cuartos: ");
        int cuartos = sc.nextInt();
        Casa cs = new Casa(propie, prec, nmetros, ubic, ciud, cuartos, co);
        cs.establecerCostoFinal();
        EscrituraArchivoCasa archivoca = new EscrituraArchivoCasa(nombreArchivoC);
        archivoca.establecerRegistro(cs);
        archivoca.establecerSalida();
        archivoca.cerrarArchivo();
    }

    public static void depa() {
        Scanner sc = new Scanner(System.in);
        String nombreArchivoD = "Departamentos.txt";
        System.out.println("Ingrese Identificacion del Propietario: ");
        String ic = sc.nextLine();
        LecturaArchivoPropietario lecturapropi = new LecturaArchivoPropietario("Propietarios.txt");
        lecturapropi.establecerListaPropietario();
        lecturapropi.establecerObjetoPropietario(ic);
        Propietario prop = lecturapropi.obtenerObjetoPropietario();
        if (prop != null) {
            System.out.println(prop);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese numero Casa: ");
        int casa = sc.nextInt();
        LecturaArchivoUbicacion lecturaUbica = new LecturaArchivoUbicacion("Ubicaciones.txt");
        lecturaUbica.establecerListaUbicacionD();
        lecturaUbica.establecerUbicacionObjeto(casa);
        Ubicacion ubi = lecturaUbica.obtenerObjetoUbicacion();
        if (ubi != null) {
            System.out.println(ubi);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese Nombre de la Ciudad: ");
        String nom = sc.nextLine();
        LecturaDciudad lecturaCiuy = new LecturaDciudad("Ciudades.txt");
        lecturaCiuy.establecerListaCiudadD();
        lecturaCiuy.establecerObjetoCiudad(nom);
        Ciudad cy = lecturaCiuy.obtenerOnjetoCiudad();
        if (cy != null) {
            System.out.println(cy);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese el ID de la Empresa");
        String empre = sc.nextLine();
        LecturaArchivoConstructora lecturacont = new LecturaArchivoConstructora("Constructoras.txt");
        lecturacont.establecerListaConstructora();
        lecturacont.establecerObjetoConstructora(empre);
        Constructora cos = lecturacont.obtenerObjetoConstructora();
        if (cos != null) {
            System.out.println(cos);
        } else {
            System.out.println("Datos no encontrados");

        }
        System.out.println("Ingrese precio por metro cuadrado: ");
        double pmetro = sc.nextDouble();
        System.out.println("Ingrese número de metros cuadrados: ");
        int metrosc = sc.nextInt();
        System.out.println("Ingrese valor alícuota mensual: ");
        double val = sc.nextDouble();
        System.out.println("Ingrese Nombre de Edificio: ");
        String nome = sc.nextLine();
        System.out.println("Ingrese ubicación del departamento en edificio:");
        String ubied = sc.nextLine();
        Departamento dep = new Departamento(prop, pmetro, metrosc, val, ubi, cy, nome, ubied, cos);
        dep.establecerCostoFinal();
        EscrituraArchivoDepartamento archivodepa = new EscrituraArchivoDepartamento(nombreArchivoD);
        archivodepa.establecerRegistro(dep);
        archivodepa.establecerSalida();
        archivodepa.cerrarArchivo();
    }

    public static void mostarpropietario() {
        String nombreArchivoP = "datos/Propietarios.txt";
        LecturaArchivoPropietario lecturapro = new LecturaArchivoPropietario(nombreArchivoP);
        lecturapro.establecerListaPropietario();
        System.out.println(lecturapro);
    }

    public static void mostarubicacion() {
        String nombreArchivou = "datos/Ubicaciones.txt";
        LecturaArchivoUbicacion lecturaubica = new LecturaArchivoUbicacion(nombreArchivou);
        lecturaubica.establecerListaUbicacionD();
        System.out.println(lecturaubica);

    }

    public static void mostarciudad() {
        String nombreArchivoc = "datos/Ciudades.txt";
        LecturaDciudad lecturacu = new LecturaDciudad(nombreArchivoc);
        lecturacu.establecerListaCiudadD();
        System.out.println(lecturacu);

    }

    public static void mostarconstructora() {
        String nombreArchivoco = "datos/Constructoras.txt";
        LecturaArchivoConstructora lecturaconst = new LecturaArchivoConstructora(nombreArchivoco);
        lecturaconst.establecerListaConstructora();
        System.out.println(lecturaconst);
    }

    public static void mostarcasa() {
        String nombreArchivoC = "datos/Casas.txt";
        LecturaArchivoCasa lecturacasa = new LecturaArchivoCasa(nombreArchivoC);
        lecturacasa.establecerListaCasa();
        System.out.println(lecturacasa);
    }

    public static void mostardepa() {
        String nombreArchivoD = "datos/Departamentos.txt";
        LecturaArchivoDepartamento lecturade = new LecturaArchivoDepartamento(nombreArchivoD);
        lecturade.establecerListaDepartamento();
        System.out.println(lecturade);
    }

}
