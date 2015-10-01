package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John
 */
public class ConexaoJDBC {

    public static String URL = "jdbc:mysql://localhost:3306/blog_db";  
    public static String USER = "root";
    public static String SENHA = "root";

    public static Connection getConexao() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            return DriverManager.getConnection(URL, USER, SENHA);
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void fecharConexao(){
    
    }

}


