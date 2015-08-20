package dao;

import banco.ConexaoJDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author john
 */
public class ComentarioDao {

    private Connection c = null;

    public String SalvarComentario(String nome, String email, String texto, String post) throws SQLException {
        try {
            c = ConexaoJDBC.getConexao();

            System.out.println("INSERT INTO comentario VALUES(null," + "'" + nome + "','" + texto + "'," + post + "," + getData() + ",'" + email + "');");
            c.prepareStatement("INSERT INTO comentario VALUES(null," + "'" + nome + "','" + texto + "'," + post + "," + getData() + ",'" + email + "');").execute();
            return new String("Comentario salvo com sucesso!");

        } catch (Exception e) {
            return new String("Infelizmente ocorreram erros ao salvar seu comentário =(");

        } finally {
            c.close();

        }

    }

    public String getData() {
        Calendar calendario = Calendar.getInstance();
        String dia = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));
        String mes = String.valueOf(calendario.get(Calendar.MONTH));
        String ano = String.valueOf(calendario.get(Calendar.YEAR));
        String hora = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY));
        String minuto = String.valueOf(calendario.get(Calendar.MINUTE));
        String seg = String.valueOf(calendario.get(Calendar.SECOND));

        return new String("'" + ano + "-" + mes + "-" + dia + " " + hora + ":" + minuto + ":" + seg + "'");

    }

}
