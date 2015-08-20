/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private Connection c = null;

    public ResultSet getPostagem(String id) throws SQLException {
        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from post where id=" + id).executeQuery();
        } catch (Exception e) {
        } finally {
            c.close();
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
