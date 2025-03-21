/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {
    
private final conectaDAO conexao;
    private final Connection conn;
    
 public ProdutosDAO(){
     this.conexao = new conectaDAO();
     this.conn = (Connection) this.conexao.conectaDAO();
}
    
    public void cadastrarProduto(ProdutosDTO produtos) throws SQLException {
    String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";
    
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, produtos.getNome());
        stmt.setString(2, produtos.getValor() );
        stmt.setString(3, produtos.getStatus());
        
        stmt.execute();
}

    public ArrayList<ProdutosDTO> listarProdutos(){
 
    return null;
}}