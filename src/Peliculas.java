import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Peliculas implements PeliculasInterface{


    private static Connection conn = null;

    public Peliculas() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cine", "root", "admin");
    }


    public void crearTabla() throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("CREATE TABLE peliculas (id INT PRIMARY KEY, titulo VARCHAR(50)," +
                "genero VARCHAR(20), estreno INT)");
    }

    public void eliminarTabla() throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("DROP TABLE peliculas");
    }

    public void crearPelicula(Pelicula p) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO peliculas (id, titulo, genero, estreno)" +
                "VALUES (?, ?, ?, ?);");
        pst.setInt(1, p.getId());
        pst.setString(2, p.getTitulo());
        pst.setString(3, String.valueOf(p.getGenero()));
        pst.setInt(4, p.getEstreno());
        pst.executeUpdate();
    }

    public void eliminarPelicula(int id) throws SQLException {
        Scanner sc = new Scanner(System.in);
        PreparedStatement pst = conn.prepareStatement("DELETE FROM peliculas WHERE id = ?");
        pst.setInt(1, id);
        pst.executeUpdate();
    }


    public Pelicula buscarPelicula() throws SQLException {
        Scanner sc = new Scanner(System.in);
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM peliculas WHERE id = ?");
        System.out.print("Introduzca el id de la película: ");
        int id = sc.nextInt();
        pst.setInt(1, id);
        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            int peliculaId = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            String genero = resultSet.getString("genero");
            int estreno = resultSet.getInt("estreno");
            return new Pelicula(peliculaId, titulo, genero, estreno);
        }
        return null;
    }
    /*
    public ArrayList<Pelicula> buscarTodo() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM peliculas");
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            Genero genero = Genero.valueOf(resultSet.getString("genero"));
            int estreno = resultSet.getInt("estreno");
            peliculas.add(new Pelicula(id, titulo, genero, estreno));
        }
        return peliculas;
    }

    public ArrayList<Pelicula> buscarPorGeneroyEstreno(int estreno, String genero) throws SQLException {
        return null;
    }

    public ArrayList<Pelicula> buscarPorGeneroOrdenarEstreno(String genero) throws SQLException {
        PreparedStatement statement = conn.prepareStatement("SELECT * FROM peliculas WHERE genero = ? ORDER BY estreno DESC");
        statement.setString(1, genero);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            Genero g = Genero.valueOf(resultSet.getString("genero"));
            int estreno = resultSet.getInt("estreno");
            peliculas.add(new Pelicula(id, titulo, g, estreno));
        }
        return peliculas;
    } */
}

