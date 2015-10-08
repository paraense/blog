package dao;

import banco.ConexaoJDBC;
import entidades.Comentario;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author john
 */
public class ComentarioDao {

    private Connection c = null;

    public String inserirComentario(String nome, String email, String texto, String post) throws SQLException {
        try {
            c = ConexaoJDBC.getConexao();
            c.prepareStatement("INSERT INTO comentario VALUES(null," + "'" + nome + "','" + texto + "'," + post + "," + getData() + ",'" + email + "');").execute();
            return new String("Comentario salvo com sucesso!");

        } catch (Exception e) {
            return new String("Infelizmente ocorreram erros ao salvar seu comentário =(");

        } finally {
            c.close();

        }

    }

    public List listarComentariosPorPost(Integer id) {
        ResultSet r;
        r = getComentariosPorIdPost(String.valueOf(id));
        Comentario comentario;
        List<Comentario> comentarios = new ArrayList<>();

        try {
            while (r.next()) {
                comentario = new Comentario();
                comentario.setNome(r.getString("nome"));
                comentario.setTexto(r.getString("texto"));
                comentario.setDatahora(r.getDate("data"));

                comentarios.add(comentario);
            }
            r.close();
            return comentarios;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    //Lista comentários por postagens
    public ResultSet getComentariosPorIdPost(String id) {

        try {
            c = ConexaoJDBC.getConexao();
            return c.prepareStatement("select * from comentario where comentario.post_id =" + id).executeQuery();
        } catch (Exception e) {
        }
        return null;
    }

    public String getData() {
        Calendar calendario = Calendar.getInstance();
        String dia = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(calendario.get(Calendar.MONTH));
        String ano = String.valueOf(calendario.get(Calendar.YEAR));
        String hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(calendario.get(Calendar.MINUTE));
        String seg = String.valueOf(calendario.get(Calendar.SECOND));

        return new String("'"
                + ano + "-"
                + mes + "-"
                + dia + " "
                + hora + ":"
                + minuto + ":"
                + seg + "'");

    }

}
