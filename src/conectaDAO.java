import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection conectaDAO() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/uc11?useSSL=false", 
                    "root", 
                    "118992923042003"
            );
            return conn;

        } catch (SQLException e) {
            System.out.println("Erro ao Conectar: " + e.getMessage());
            return null;
        }
    }
}