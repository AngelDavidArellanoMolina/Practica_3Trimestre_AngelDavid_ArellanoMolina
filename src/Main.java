import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Peliculas peliculas = new Peliculas();

        int opcion;
        String titulo, genero;
        int id, estreno;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("======================================================================");
            System.out.println("0. Salir del programa");
            System.out.println("1. Crear Tabla Película");
            System.out.println("2. Eliminar Tabla Película");
            System.out.println("3. Crear película");
            System.out.println("4. Eliminar película por id");
            System.out.println("5. Buscar película por id e imprimir información");
            System.out.println("6. Buscar todas las películas e imprimir todas las películas");
            System.out.println("7. Buscar por género y por orden descendente de estreno e imprimir");
            System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
            System.out.print("Introduzca una opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 0:
                    System.out.println("\033[32m¡Gracias por usar el programa!");
                    break;
                case 1:
                    peliculas.crearTabla();
                    break;
                case 2:
                    peliculas.eliminarTabla();
                    break;
                case 3:
                    System.out.print("Indica el id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Indica el título: ");
                    titulo = sc.nextLine();
                    System.out.print("Indica el género (ROMANTICA, MIEDO, COMEDIA): ");
                    genero = sc.nextLine();
                    System.out.print("Indica el estreno: ");
                    estreno = sc.nextInt();
                    Pelicula p = new Pelicula(id, titulo, genero, estreno);
                    peliculas.crearPelicula(p);
                    break;
                case 4:
                    System.out.print("Escribe el id de la película que deseas borrar: ");
                    id = sc.nextInt();
                    peliculas.eliminarPelicula(id);
                    break;
                case 5:
                    System.out.print("Introduzca el id de la película: ");
                    id = sc.nextInt();
                    System.out.println(peliculas.buscarPelicula(id));
                    break;
                case 6:
                    ArrayList<Pelicula> todasLasPeliculas = peliculas.buscarTodo();
                    imprimir_arraylist(todasLasPeliculas);
                    break;
                case 7:
                    System.out.print("Indica el genero por el que quieras buscar (ROMANTICA, MIEDO, COMEDIA): ");
                    sc.nextLine();
                    String g = sc.nextLine();
                    ArrayList<Pelicula> peliculasPorGeneroYEstreno = peliculas.buscarPorGeneroOrdenarEstreno(g);
                    peliculasPorGeneroYEstreno.sort(Comparator.comparing(Pelicula::getEstreno).reversed());
                    imprimir_arraylist(peliculasPorGeneroYEstreno);
                    break;
                default:
                    System.out.println("\033[31mIntroduce una opción válida\n\033[0m");
            }
            } while (opcion != 0) ;
        }

        public static void imprimir_arraylist (ArrayList <Pelicula> listado_peliculas){
            Iterator <Pelicula> itr = listado_peliculas.iterator();
            while (itr.hasNext()) {
                System.out.println(itr.next().toString());
            }
        }
    }