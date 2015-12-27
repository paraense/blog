/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import banco.ConexaoJDBC;
import entidades.Categoria;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author John
 */
public class CategoriaDao {

    private static Connection c;

    public ResultSet buscarPostagesPorCategoria(String id) {
        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from post INNER JOIN categoria_post "
                    + "ON categoria_post.id_post = "
                    + "post.id WHERE categoria_post.id_categoria =" + id).executeQuery();
        } catch (Exception e) {
        }
        return null;
    }

    public ResultSet buscarCategoriasPorPostagem(Integer id) {
        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from categoria INNER JOIN "
                    + "categoria_post on categoria_post.id_categoria = "
                    + "categoria.id WHERE categoria_post.id_post=" + id).executeQuery();
        } catch (Exception e) {
        }
        return null;
    }

    public ResultSet todasAsCategorias() {
        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from categoria").executeQuery();
        } catch (Exception e) {
        }
        return null;

    }

    public List getCategoriasList(ResultSet r) throws SQLException {
        List<Categoria> cs = new ArrayList<>();
        while (r.next()) {
            Categoria c = new Categoria();
            c.setId(r.getInt("id"));
            c.setNome(r.getString("nome"));
            cs.add(c);
        }
        r.close();
        return cs;
    }
    
 

}
