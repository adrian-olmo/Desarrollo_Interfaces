/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionmultimedia1;

/**
 *
 * @author 34664
 */
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javax.swing.JOptionPane;

public class AplicacionMultimedia1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        

        while (salir) {

            do {
                int principal;
                String texto;
                try {
                    FileReader fr = new FileReader("titulo.gestionador.txt");
                    BufferedReader br = new BufferedReader(fr);
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                    System.out.println(br.readLine());
                } catch (Exception err) {
                    System.out.println(err.getMessage());
                }
                switch (principal = 1) {
                }

                System.out.println("\nMenu:");
                System.out.println(" [1] Peliculas");
                System.out.println(" [2] Musica");
                System.out.println(" [3] Libros");
                System.out.println(" [4] Listar Todos");
                System.out.println("\nElige una de las opciones:  ");

                int opcionmenu = sc.nextInt();

                switch (opcionmenu) {
                    case 1:
                        while (salir) {
                            String tecla = null;
                            System.out.println(" [1] Agregar Peliculas ");
                            System.out.println(" [2] Listar Peliculas ");
                            System.out.println(" [3] Eliminar Peliculas ");
                            System.out.println(" [4] Volver al menu principal");

                            int opcionpeliculas = sc.nextInt();

                            switch (opcionpeliculas) {

                                case 1:
                                    File archivo;
                                    FileWriter escribir;
                                    PrintWriter linea;

                                    String nombre = "",
                                     dir = "",
                                     ano = "",
                                     actor = "",
                                     pais = "",
                                     codigo = "";
                                    archivo = new File("peliculas.txt");
                                    if (!archivo.exists()) {
                                        try {
                                            archivo.createNewFile();
                                            nombre = JOptionPane.showInputDialog(null, "Introduce titulo de la pelicula:", "Solicitando datos" + 3);

                                            dir = JOptionPane.showInputDialog(null, "Introduce el director de la pelicula:", "Solicitando datos" + 3);

                                            ano = JOptionPane.showInputDialog(null, "Introduce el año de la pelicula:", "Solicitando datos" + 3);

                                            actor = JOptionPane.showInputDialog(null, "Introduce el actor protagonista de la pelicula:", "Solicitando datos" + 3);

                                            pais = JOptionPane.showInputDialog(null, "Introduce el pais de la pelicula:", "Solicitando datos" + 3);

                                            codigo = JOptionPane.showInputDialog(null, "Introduce el codigo de la pelicula:", "Solicitando datos" + 3);

                                            escribir = new FileWriter(archivo, true);
                                            linea = new PrintWriter(escribir);

                                            linea.println(nombre);
                                            linea.println(dir);
                                            linea.println(ano);
                                            linea.println(actor);
                                            linea.println(pais);
                                            linea.println(codigo);

                                            linea.close();
                                            escribir.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        try {

                                            nombre = JOptionPane.showInputDialog(null, "Introduce titulo de la pelicula:", "Solicitando datos" + 3);

                                            dir = JOptionPane.showInputDialog(null, "Introduce el director de la pelicula:", "Solicitando datos" + 3);

                                            ano = JOptionPane.showInputDialog(null, "Introduce el año de la pelicula:", "Solicitando datos" + 3);

                                            actor = JOptionPane.showInputDialog(null, "Introduce los actores de la pelicula:", "Solicitando datos" + 3);

                                            pais = JOptionPane.showInputDialog(null, "Introduce el pais de la pelicula:", "Solicitando datos" + 3);

                                            codigo = JOptionPane.showInputDialog(null, "Introduce el codigo de la pelicula:", "Solicitando datos" + 3);

                                            escribir = new FileWriter(archivo, true);
                                            linea = new PrintWriter(escribir);

                                            linea.println(nombre);
                                            linea.println(dir);
                                            linea.println(ano);
                                            linea.println(actor);
                                            linea.println(pais);
                                            linea.println(codigo);

                                            linea.close();
                                            escribir.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    }
                                    break;
 
                                case 2:
                                    int registros = 1;
                                    File archivo2;
                                    FileReader leer;
                                    BufferedReader almacenamiento;
                                    String cadena,
                                     nombre1 = "",
                                     dir1 = "",
                                     ano1 = "",
                                     actor1 = "",
                                     pais1 = "",
                                     codigo1 = "";
                                    archivo2 = new File("peliculas.txt");
                                    try {
                                        leer = new FileReader(archivo2);
                                        almacenamiento = new BufferedReader(leer);
                                        cadena = "";
                                        while (cadena != null) {
                                            try {
                                                cadena = almacenamiento.readLine();
                                                nombre1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                dir1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                ano1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                actor1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                pais1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                codigo1 = cadena;

                                                if (cadena != null) {
                                                    JOptionPane.showMessageDialog(null, "NOMBRE: " + nombre1
                                                            + "\nDIRECTOR: " + dir1 + "\nAÑO: " + ano1
                                                            + "\nACTOR/ES: " + actor1 + "\nPAIS: " + pais1
                                                            + "\nCODIGO: " + codigo1,
                                                            " Mostrando datos del registro #" + registros, 1);
                                                    registros++;
                                                }
                                            } catch (IOException ex) {
                                                Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        try {
                                            almacenamiento.close();
                                            leer.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                                case 3:
                                    

                                case 4:
                                    principal = 4;
                                    break;
                            }
                            break;
                        }
                        break;
                    case 2:

                        System.out.println(" [1] Agregar Musica ");
                        System.out.println(" [2] Listar Musica ");
                        System.out.println(" [3] Eliminar Musica ");
                        System.out.println(" [4] Volver al menu principal");

                        int opcionmusica = sc.nextInt();

                        switch (opcionmusica) {
                            case 1:
                                File archivo;
                                    FileWriter escribir;
                                    PrintWriter linea;

                                    String titulo = "",
                                     autor = "",
                                     ano = "",
                                     formato = "",
                                     directo = "",
                                    codigo = "",
                                    duracion="";
                                    archivo = new File("Musica.txt");
                                    if (!archivo.exists()) {
                                        try {
                                            archivo.createNewFile();
                                            titulo = JOptionPane.showInputDialog(null, "Introduce titulo de la cancion:", "Solicitando datos" + 3);

                                            autor = JOptionPane.showInputDialog(null, "Introduce el autor de la cancion:", "Solicitando datos" + 3);

                                            ano = JOptionPane.showInputDialog(null, "Introduce el año de la cancion:", "Solicitando datos" + 3);

                                            duracion = JOptionPane.showInputDialog(null, "Introduce la duracion de la cancion:", "Solicitando datos" + 3);

                                            formato = JOptionPane.showInputDialog(null, "Introduce el formato de la cancion:", "Solicitando datos" + 3);
                                            
                                            directo = JOptionPane.showInputDialog(null, "Introduce el lugar del proximo directo: ", "Solicitando datos" + 3);

                                            codigo = JOptionPane.showInputDialog(null, "Introduce el codigo de la cancion:", "Solicitando datos" + 3);

                                            escribir = new FileWriter(archivo, true);
                                            linea = new PrintWriter(escribir);

                                            linea.println(titulo);
                                            linea.println(autor);
                                            linea.println(ano);
                                            linea.println(formato);
                                            linea.println(directo);
                                            linea.println(duracion);
                                            linea.println(codigo);

                                            linea.close();
                                            escribir.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        try {
                                            
                                            titulo = JOptionPane.showInputDialog(null, "Introduce titulo de la cancion:", "Solicitando datos" + 3);

                                            autor = JOptionPane.showInputDialog(null, "Introduce el autor de la cancion:", "Solicitando datos" + 3);

                                            ano = JOptionPane.showInputDialog(null, "Introduce el año de la cancion:", "Solicitando datos" + 3);

                                            duracion = JOptionPane.showInputDialog(null, "Introduce la duracion de la cancion:", "Solicitando datos" + 3);

                                            formato = JOptionPane.showInputDialog(null, "Introduce el formato de la cancion:", "Solicitando datos" + 3);
                                            
                                            directo = JOptionPane.showInputDialog(null, "Introduce el lugar del proximo directo: ", "Solicitando datos" + 3);

                                            codigo = JOptionPane.showInputDialog(null, "Introduce el codigo de la cancion:", "Solicitando datos" + 3);

                                            escribir = new FileWriter(archivo, true);
                                            linea = new PrintWriter(escribir);

                                            linea.println(titulo);
                                            linea.println(autor);
                                            linea.println(ano);
                                            linea.println(formato);
                                            linea.println(directo);
                                            linea.println(duracion);
                                            linea.println(codigo);

                                            linea.close();
                                            escribir.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    }
                                    break;

                            case 2:

                                int registros = 2;
                                    File archivo2;
                                    FileReader leer;
                                    BufferedReader almacenamiento;
                                    String cadena,
                                     titulo1 = "",
                                     autor1 = "",
                                     ano1 = "",
                                     formato1 = "",
                                     directo1 = "",
                                     duracion1 = "",
                                     codigo1 = "";
                                    archivo2 = new File("Musica.txt");
                                    try {
                                        leer = new FileReader(archivo2);
                                        almacenamiento = new BufferedReader(leer);
                                        cadena = "";
                                        while (cadena != null) {
                                            try {
                                                cadena = almacenamiento.readLine();
                                                titulo1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                autor1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                ano1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                formato1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                duracion1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                directo1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                codigo1 = cadena;

                                                if (cadena != null) {
                                                    JOptionPane.showMessageDialog(null, "TITULO: " + titulo1
                                                            + "\nAUTOR: " + autor1 + "\nAÑO: " + ano1
                                                            + "\nFORMATO: " + formato1 + "\nDURACION" + duracion1 + "\nDIRECTO: " + directo1
                                                            + "\nCODIGO: " + codigo1,
                                                            " Mostrando datos del registro #" + registros, 2);
                                                    registros++;
                                                }
                                            } catch (IOException ex) {
                                                Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        try {
                                            almacenamiento.close();
                                            leer.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                            case 3:
                                
                            case 4:
                                    principal = 4;
                                    break;
                            }
                            break;
                        

                    case 3:

                        System.out.println(" [1] Agregar Libros ");
                        System.out.println(" [2] Listar Libros ");
                        System.out.println(" [3] Eliminar Libros ");
                        System.out.println(" [4] Volver al menu principal");
                        int opcionlibros = sc.nextInt();

                        switch (opcionlibros) {
                            case 1:
                                File archivo;
                                    FileWriter escribir;
                                    PrintWriter linea;

                                    String titulo = "",
                                     autor = "",
                                     ano = "",
                                     edicion = "",
                                     soporte = "",
                                    codigo = "",
                                    numeropaginas="";
                                    archivo = new File("Libros.txt");
                                    if (!archivo.exists()) {
                                        try {
                                            archivo.createNewFile();
                                            titulo = JOptionPane.showInputDialog(null, "Introduce titulo del libro:", "Solicitando datos" + 3);
                                            
                                            edicion = JOptionPane.showInputDialog(null, "Introduce la editorial: ", "Solicitando datos" + 3);

                                            autor = JOptionPane.showInputDialog(null, "Introduce el autor:", "Solicitando datos" + 3);

                                            ano = JOptionPane.showInputDialog(null, "Introduce el año de publicacion:", "Solicitando datos" + 3);

                                            numeropaginas = JOptionPane.showInputDialog(null, "Introduce el numero de paginas:", "Solicitando datos" + 3);

                                            soporte = JOptionPane.showInputDialog(null, "Introduce tipo de soporte digital:", "Solicitando datos" + 3);
                                            
                                            codigo = JOptionPane.showInputDialog(null, "Introduce el codigo del libro:", "Solicitando datos" + 3);

                                            escribir = new FileWriter(archivo, true);
                                            linea = new PrintWriter(escribir);

                                            linea.println(titulo);
                                            linea.println(autor);
                                            linea.println(ano);
                                            linea.println(soporte);
                                            linea.println(edicion);
                                            linea.println(numeropaginas);
                                            linea.println(codigo);

                                            linea.close();
                                            escribir.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        try {
                                            
                                            titulo = JOptionPane.showInputDialog(null, "Introduce titulo del libro:", "Solicitando datos" + 3);
                                            
                                            edicion = JOptionPane.showInputDialog(null, "Introduce la editorial: ", "Solicitando datos" + 3);

                                            autor = JOptionPane.showInputDialog(null, "Introduce el autor:", "Solicitando datos" + 3);

                                            ano = JOptionPane.showInputDialog(null, "Introduce el año de publicacion:", "Solicitando datos" + 3);

                                            numeropaginas = JOptionPane.showInputDialog(null, "Introduce el numero de paginas:", "Solicitando datos" + 3);

                                            soporte = JOptionPane.showInputDialog(null, "Introduce tipo de soporte digital:", "Solicitando datos" + 3);
                                            
                                            codigo = JOptionPane.showInputDialog(null, "Introduce el codigo del libro:", "Solicitando datos" + 3);

                                            escribir = new FileWriter(archivo, true);
                                            linea = new PrintWriter(escribir);

                                            linea.println(titulo);
                                            linea.println(autor);
                                            linea.println(ano);
                                            linea.println(soporte);
                                            linea.println(edicion);
                                            linea.println(numeropaginas);
                                            linea.println(codigo);

                                            linea.close();
                                            escribir.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    }
                                    break;

                            case 2:

                                int registros = 3;
                                    File archivo2;
                                    FileReader leer;
                                    BufferedReader almacenamiento;
                                    String cadena,
                                     titulo1 = "",
                                     autor1 = "",
                                     ano1 = "",
                                     soporte1 = "",
                                     edicion1 = "",
                                     numeropaginas1 = "",
                                     codigo1 = "";
                                    archivo2 = new File("Libros.txt");
                                    try {
                                        leer = new FileReader(archivo2);
                                        almacenamiento = new BufferedReader(leer);
                                        cadena = "";
                                        while (cadena != null) {
                                            try {
                                                cadena = almacenamiento.readLine();
                                                titulo1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                autor1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                ano1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                soporte1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                numeropaginas1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                edicion1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                codigo1 = cadena;

                                                if (cadena != null) {
                                                    JOptionPane.showMessageDialog(null, "TITULO: " + titulo1
                                                            + "\nEDITORIAL: " + edicion1 + "\nAUTOR: " + autor1
                                                            + "\nPUBLICACION: " + ano1 + "\nNUMERO DE PAGINAS: " + numeropaginas1 + "\nSOPORTE DIGITAL: " + soporte1
                                                            + "\nCODIGO: " + codigo1,
                                                            " Mostrando datos del registro #" + registros, 3);
                                                    registros++;
                                                }
                                            } catch (IOException ex) {
                                                Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        try {
                                            almacenamiento.close();
                                            leer.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                            case 3:
                                
                            case 4:
                                    principal = 4;
                                    break;
                            }
                            break;
                        

                    case 4:
                         int registros = 3;
                                    File archivo2;
                                    FileReader leer;
                                    BufferedReader almacenamiento;
                                    String cadena,
                                     titulo1 = "",
                                     autor1 = "",
                                     ano1 = "",
                                     soporte1 = "",
                                     edicion1 = "",
                                     numeropaginas1 = "",
                                     codigo1 = "";
                                    archivo2 = new File("Libros.txt");
                                    try {
                                        leer = new FileReader(archivo2);
                                        almacenamiento = new BufferedReader(leer);
                                        cadena = "";
                                        while (cadena != null) {
                                            try {
                                                cadena = almacenamiento.readLine();
                                                titulo1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                autor1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                ano1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                soporte1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                numeropaginas1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                edicion1 = cadena;
                                                cadena = almacenamiento.readLine();
                                                codigo1 = cadena;

                                                if (cadena != null) {
                                                    JOptionPane.showMessageDialog(null, "TITULO: " + titulo1
                                                            + "\nEDITORIAL: " + edicion1 + "\nAUTOR: " + autor1
                                                            + "\nPUBLICACION: " + ano1 + "\nNUMERO DE PAGINAS: " + numeropaginas1 + "\nSOPORTE DIGITAL: " + soporte1
                                                            + "\nCODIGO: " + codigo1,
                                                            " Mostrando datos del registro #" + registros, 3);
                                                    registros++;
                                                }
                                            } catch (IOException ex) {
                                                Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        }
                                        try {
                                            almacenamiento.close();
                                            leer.close();
                                        } catch (IOException ex) {
                                            Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(AplicacionMultimedia1.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    break;
                }

            } while (!salir);

        }
    }
}



