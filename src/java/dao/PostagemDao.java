package dao;

import banco.ConexaoJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author john
 */
public class PostagemDao {

    private static Connection c = null;

    public ResultSet getPostagem(String id) throws SQLException {

        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from post where id=" + id).executeQuery();

        } catch (Exception e) {
        } finally {
          
        }
        return null;
    }

    public ResultSet getComentarios(String id) {
        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from comentario where comentario.post_id =" + id).executeQuery();
        } catch (Exception e) {
        }
        return null;
    }

}
