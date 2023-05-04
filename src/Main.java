import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Peliculas peliculas = new Peliculas();

        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        do{
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
            System.out.println("======================================================================");
            switch (opcion){
                case 0:
                    System.out.println("Gracias por usar el programa");
                    break;
                case 1:
                    peliculas.crearTabla();
                    break;
                case 2:
                    peliculas.eliminarTabla();
                    break;
                case 3:
                    peliculas.crearPelicula();
                    break;
                case 4:
                    peliculas.eliminarPelicula();
                    break;
                case 5:
                    System.out.println(peliculas.buscarPelicula());
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }
        }while (opcion != 0);




        /* // Creamos una película y la insertamos en la tabla
        Pelicula pelicula1 = new Pelicula(1, "El Padrino", Genero.MIEDO, 1972);
        peliculas.crearPelicula(pelicula1);

        // Creamos otra película y la insertamos en la tabla
        Pelicula pelicula2 = new Pelicula(2, "La La Land", Genero.COMEDIA, 2016);
        peliculas.crearPelicula(pelicula2); */

        /*

        // Buscamos una película por su ID
        Pelicula peliculaBuscada = peliculas.buscarPelicula(1);
        System.out.println(peliculaBuscada);

        // Buscamos todas las películas y las imprimimos
        ArrayList<Pelicula> todasLasPeliculas = peliculas.buscarTodo();
        for (Pelicula p : todasLasPeliculas) {
            System.out.println(p.toString());
        }

        // Buscamos todas las películas de un género específico y las ordenamos por fecha de estreno
        ArrayList<Pelicula> peliculasPorGeneroYEstreno = peliculas.buscarPorGeneroOrdenarEstreno("COMEDIA");
        for (Pelicula p : peliculasPorGeneroYEstreno) {
            System.out.println(p);
        }

        /* // Eliminamos una película por su ID
        peliculas.eliminarPelicula(2);


       */
    }
}