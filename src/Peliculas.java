import java.sql.*;
import java.util.ArrayList;

public class Peliculas implements PeliculasInterface{

    private static Connection conn;

    static {
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica3", "root", "admin");
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void crearTabla() throws SQLException {
        Statement statement = conn.createStatement();
        statement.executeUpdate("CREATE TABLE peliculas (id INT PRIMARY KEY, titulo VARCHAR(50)," +
                "genero VARCHAR(20), estreno INT)");
        System.out.println("Tabla creada correctamente");
    }

    public void eliminarTabla() throws SQLException {
        Statement st = conn.createStatement();
        st.executeUpdate("DROP TABLE peliculas");
        System.out.println("Tabla eliminada correctamente");
    }

    public void crearPelicula(Pelicula p) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("INSERT INTO peliculas (id, titulo, genero, estreno)" +
                "VALUES (?, ?, ?, ?);");
        pst.setInt(1, p.getId());
        pst.setString(2, p.getTitulo());
        pst.setString(3, String.valueOf(p.getGenero()));
        pst.setInt(4, p.getEstreno());
        pst.executeUpdate();
        System.out.println("Película insertada correctamente");
    }

    public void eliminarPelicula(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("DELETE FROM peliculas WHERE id = ?");
        pst.setInt(1, id);
        pst.executeUpdate();
        System.out.println("Película eliminada correctamente");
    }
    public Pelicula buscarPelicula(int id) throws SQLException {
        PreparedStatement pst = conn.prepareStatement("SELECT * FROM peliculas WHERE id = ?");
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
    public ArrayList<Pelicula> buscarTodo() throws SQLException {
        Statement st = conn.createStatement();
        ResultSet resultSet = st.executeQuery("SELECT * FROM peliculas");
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            Genero genero = Genero.valueOf(resultSet.getString("genero"));
            int estreno = resultSet.getInt("estreno");
            peliculas.add(new Pelicula(id, titulo, String.valueOf(genero), estreno));
        }
        return peliculas;
    }


    public ArrayList<Pelicula> buscarPorGeneroOrdenarEstreno(String genero) throws SQLException {
        PreparedStatement st = conn.prepareStatement("SELECT * FROM peliculas WHERE genero = ?");
        st.setString(1, genero.toUpperCase());
        ResultSet resultSet = st.executeQuery();
        ArrayList<Pelicula> peliculas = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String titulo = resultSet.getString("titulo");
            Genero g = Genero.valueOf(resultSet.getString("genero"));
            int estreno = resultSet.getInt("estreno");
            peliculas.add(new Pelicula(id, titulo, String.valueOf(g), estreno));
        }
        return peliculas;
    }
}

