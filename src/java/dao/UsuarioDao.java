package dao;

import banco.ConexaoJDBC;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author John
 */
public class UsuarioDao {

    private static Connection c = null;

    public ResultSet validaUsuario(String login, String senha) throws SQLException {
        try {
            c = ConexaoJDBC.getConexao();
            System.out.println("SELECT * FROM usuario WHERE login ='" + login +"' AND senha ='" + senha+"'");
            return c.prepareStatement("SELECT * FROM usuario WHERE login ='" + login + "' AND senha ='" + senha+"'").executeQuery();
        } catch (Exception e) {
            System.out.println("Erro:"+ e.getMessage());
        }
        return null;
    }

}
