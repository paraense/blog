package dao;

import banco.ConexaoJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class HomeDao {

    public static Connection c = null;

    public ResultSet listarPostagens() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        c = ConexaoJDBC.getConexao();

        try {
            return c.prepareStatement("SELECT * FROM post").executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(HomeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return null;
    }

    public static ResultSet listarComentarios(String id) {
        String comentarios = "SELECT * FROM comentario where comentario.id_post =" + id;
        try {
            return c.prepareStatement(comentarios).executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(HomeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet listarCategorias() {
        try {
            return c.prepareStatement("SELECT * FROM categoria").executeQuery();
        } catch (Exception e) {
        }
        return null;
    }

    public static void fechaConexao() {
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(HomeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
