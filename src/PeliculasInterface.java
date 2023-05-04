import java.sql.SQLException;
import java.util.ArrayList;

public interface PeliculasInterface {
    void crearTabla() throws SQLException;
    void eliminarTabla() throws SQLException;
    void crearPelicula() throws SQLException;
    void eliminarPelicula() throws SQLException;
    Pelicula buscarPelicula() throws SQLException;
    /*ArrayList<Pelicula> buscarTodo() throws SQLException;
    ArrayList<Pelicula> buscarPorGeneroyEstreno(int estreno, String genero) throws SQLException; */
}
