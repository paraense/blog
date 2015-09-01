package dao;

import banco.ConexaoJDBC;
import beans.Comentario;
import beans.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Formatadores;

/**
 *
 * @author john
 */
public class PostagemDao {

    private static Connection c = null;

    //Realiza busca da postagem por id
    public ResultSet buscaPostagemPorId(String id) throws SQLException {

        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from post where id=" + id).executeQuery();

        } catch (Exception e) {
        } finally {

        }
        return null;
    }

    //Lista todas as postagens
    public ResultSet buscaPostagens() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        c = ConexaoJDBC.getConexao();
        try {
            return c.prepareStatement("SELECT * FROM post").executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(HomeDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Busca com filtro
    public ResultSet buscaPorSimilaridade(String filtro) {

        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from post where titulo like '%" + filtro + "%' || texto like '%" + filtro + "%'").executeQuery();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public List listarPostagens(ResultSet r) {
        Post postagem;
        ComentarioDao cd = new ComentarioDao();
        List<Post> postagens = new ArrayList<>();

        try {
            while (r.next()) {
                postagem = new Post();
                postagem.setId(r.getInt("id"));
                postagem.setTitulo(r.getString("titulo"));
                postagem.setTexto(r.getString("texto"));
                postagem.setResumo(r.getString("resumo"));
                postagem.setData(r.getDate("data"));

                postagem.getComentarios().addAll(cd.listarComentariosPorPost(postagem.getId()));

                postagens.add(postagem);
            }
            r.close();
            return postagens;

        } catch (Exception e) {
        }
        return null;
    }

    public String incluirPost(String texto, String titulo, String resumo) {

        try {
            String data =Formatadores.getData();
            
            c = ConexaoJDBC.getConexao();
            c.prepareStatement("INSERT INTO post (id, texto, titulo, resumo, data) VALUES(NULL,'"+texto+"','"+titulo+"','"+resumo+"',"+data+")").execute();
            return "index.jsp";

        } catch (Exception e) {
        }

        return "erro";

    }

}
