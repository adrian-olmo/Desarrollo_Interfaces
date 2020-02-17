/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio06_GestionMultimedia;

import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Usuario DAM 2
 */
public class GestionMultimedia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salirprincipal = true;
        boolean salirsecundario = true;
        boolean ultimosalir = true;
        File fo = new File("src/documentos/biblioteca.obj");
        ObjectOutputStream oos = null;
        Listar listaelementos = new Listar();

        Hashtable<String, Multimedia> listaHash = new Hashtable();

        File ficheroObjeto = new File("src/documentos/Biblioteca.obj");
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(new FileInputStream(ficheroObjeto));
//            lista = (Hashtable<Integer, ElementoMultimedia>) ois.readObject();
//            Enumeration<ElementoMultimedia> elementos = lista.elements();
//            while (elementos.hasMoreElements()) {
//                ElementoMultimedia encontrado = elementos.nextElement();
//                listapro.put(encontrado.getCodigo(), encontrado);
//                System.out.println("Entontrado");
//            }
//            lista = listapro;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ois.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        while (salirprincipal) {
            System.out.println("1. Agregar elemento multimedia");
            System.out.println("2. Listar elemetos multimedia");
            System.out.println("3. Borrar elemetos multimedia");
            System.out.println("4. Salir");
            System.out.println("Elige una opcion: ");

            int opcionprimera = sc.nextInt();

            switch (opcionprimera) {
                case 1:
                    while (salirsecundario) {

                        System.out.println("Que elemento quieres agregar:  ");
                        System.out.println("1. Libro");
                        System.out.println("2. Musica");
                        System.out.println("3. Pelicula");
                        System.out.println("4. Salir al menu principal");

                        int opcionsegunda = sc.nextInt();

                        switch (opcionsegunda) {
                            case 1:
                                System.out.println("Titulo del libro: ");
                                String titulolibro = sc.next();
                                System.out.println("Autor del libro: ");
                                String autorlibro = sc.next();
                                System.out.println("Año de publicacion: ");
                                int aniopubli = sc.nextInt();
                                System.out.println("Codigo del libro: ");
                                int codigolibro = sc.nextInt();
                                System.out.println("Edicion del libro: ");
                                int edicion = sc.nextInt();
                                System.out.println("Soporte digital: ");
                                boolean soportedig = sc.nextBoolean();
                                System.out.println("Numero de paginas:  ");
                                int numpaginas = sc.nextInt();

                                Libro libro = new Libro(soportedig, numpaginas, edicion, titulolibro, autorlibro, edicion, edicion);
                                listaelementos.agregar(libro);

                                try {
                                    oos = new ObjectOutputStream(new FileOutputStream(fo));
                                    oos.writeObject(libro);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    // el archivo ha provocado el fallo
                                } finally {
                                    try {
                                        oos.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        // el cerrado ha provocado el fallo
                                    }
                                }
                                break;

                            case 2:
                                System.out.println("Titulo de la cancion: ");
                                String titulomusica = sc.next();
                                System.out.println("Autor de la cancion: ");
                                String autormusica = sc.next();
                                System.out.println("Año de publicacion: ");
                                int aniopublican = sc.nextInt();
                                System.out.println("Codigo de la cancion: ");
                                int codigomusica = sc.nextInt();
                                System.out.println("Soporte (MP3, MP4...): ");
                                String soporte = sc.next();
                                System.out.println("Duracion: ");
                                String duracion = sc.next();
                                System.out.println("Grabado en directo: (True/False)");
                                boolean directo = sc.nextBoolean();
                                
                           
                                Musica musica = new Musica(soporte, duracion, directo, titulomusica, autormusica, aniopublican, codigomusica);
                                listaelementos.agregar(musica);

                                try {
                                    oos = new ObjectOutputStream(new FileOutputStream(fo));
                                    oos.writeObject(musica);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    // el archivo ha provocado el fallo
                                } finally {
                                    try {
                                        oos.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        // el cerrado ha provocado el fallo
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("Titulo de la pelicula: ");
                                String titulopeli = sc.next();
                                System.out.println("Autor de la pelicula: ");
                                String autorpeli = sc.next();
                                System.out.println("Año de publicacion: ");
                                int aniopublipeli = sc.nextInt();
                                System.out.println("Codigo de la pelicula: ");
                                int codigopeli = sc.nextInt();
                                System.out.println("Actores: ");
                                String actores = sc.next();
                                System.out.println("Pais: ");
                                String pais = sc.next();
                                System.out.println("Duracion: ");
                                duracion = sc.next();

                                Pelicula pelicula = new Pelicula(actores, pais, duracion, titulopeli, autorpeli, aniopublipeli, codigopeli);
                                listaelementos.agregar(pelicula);

                                try {
                                    oos = new ObjectOutputStream(new FileOutputStream(fo));
                                    oos.writeObject(pelicula);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    // el archivo ha provocado el fallo
                                } finally {
                                    try {
                                        oos.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        // el cerrado ha provocado el fallo
                                    }
                                }
                                break;

                            case 4:
                                salirsecundario = false;
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Resultados: ");
                    listaelementos.listado();
                    break;

                case 3:
                    System.out.println("Elige el titulo que quieres borrar: ");
                    String tituloborrado = sc.next();
                    if (listaelementos.comprobar(tituloborrado)) {
                        listaelementos.eliminar(tituloborrado);
                        System.out.println("Titulo borrado con exito");
                    } else {
                        System.out.println("El titulo no se encuentra en la lista");
                    }
                    break;
                case 4:
                    salirprincipal = false;
                    System.out.println("Borja, he intentado la lectura de archivos pero no me ha salido 😢");
                    break;
            }

        }
    }
}
