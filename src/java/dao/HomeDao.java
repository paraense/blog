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
    private static String postagens = "SELECT * FROM post";

    public ResultSet listarPostagens() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        c = ConexaoJDBC.getConexao();

        try {
            return c.prepareStatement(postagens).executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(HomeDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

        return null;
    }

    public ResultSet listarCategorias() {
        return null;

    }

    public ResultSet listarComentrários() {
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
