/**
 *
 * @author IVAN LUCAS FERREIRA BORGES
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;


public class ProdutosDAO {
    
private final conectaDAO conexao;
    private final Connection conn;
    
 public ProdutosDAO(){
     this.conexao = new conectaDAO();
     this.conn = (Connection) this.conexao.conectaDAO();
}
 
    /**Método parar cadastrar produtos no banco de dados*/
    public void cadastrarProduto(ProdutosDTO produtos) throws SQLException {
    String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";
    
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        stmt.setString(1, produtos.getNome());
        stmt.setString(2, produtos.getValor() );
        stmt.setString(3, produtos.getStatus());
        
        stmt.execute();
}
    
     /**Método parar listar produtos, consultando no banco de dados*/
    public List<ProdutosDTO> getProdutos(){
     String sql = "SELECT * FROM produtos";
    try {
        PreparedStatement stmt = this.conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        List<ProdutosDTO> listaProdutos = new ArrayList<>();
        
        while (rs.next()) {
            
            ProdutosDTO produtosDTO = new ProdutosDTO();
            
            produtosDTO.setId(rs.getInt("id"));
            produtosDTO.setNome(rs.getString("nome"));
            produtosDTO.setValor(rs.getString("valor"));
            produtosDTO.setStatus(rs.getString("status"));
            
            listaProdutos.add(produtosDTO);
        }
        return listaProdutos;
    } catch (SQLException e) {
        return null;
    }
  }
    
    /**Método para alterar status de "A venda" para "Vendido"*/
    public void venderProdutos (int id) {
     
        String sql = "UPDATE produtos SET status=? WHERE id=?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            
            stmt.setString(1, "Vendido");
            stmt.setInt(2, id);
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
        
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao vender produto " + ex.getMessage());
        }
    }
}