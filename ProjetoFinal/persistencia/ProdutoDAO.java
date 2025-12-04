/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Produto;

/**
 *
 * @author USUARIO
 */
public class ProdutoDAO implements IProdutoDAO{
    // abre a conexão com o banco de dados
    private final Connection connection;
    
    // construtor
    public ProdutoDAO(){
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Produto produto) {
        String sql = "insert into produtos" +
                "(nome, descricao, quantidade, preco " +                
                "values (?,?,?,?)";
        
        try {
            // preparar comando para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // setando os atributos do objeto na cadeia sql
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());            
            stmt.setInt(3, produto.getQuantidade());
            stmt.setFloat(4, produto.getPreco());
            
            // executa
            stmt.execute();
            stmt.close();
        }
        
        catch (SQLException e){
            throw new RuntimeException(e);            
        }    
    }

    @Override
    public void altera(Produto produto) {
        String sql = "UPDATE produto SET "+
                "nome=? , descricao=?, quantidade=?, preco=? " +                
                "WHERE idProduto=?";
                
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setFloat(4, produto.getPreco());
            stmt.setInt(5, produto.getIdProduto()); // O ID do Produto

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            String sql = "DELETE FROM produto WHERE idProduto = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Produto> listarTodos() {
         try {
            List<Produto> produtos = new ArrayList<Produto>();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from produto");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                // criando o objeto Contto
                Produto p = new Produto();
                
                p.setIdProduto(rs.getInt("idProduto"));
                p.setNome(rs.getString("nome"));
                p.setDescricao(rs.getString("descricao"));
                p.setQuantidade(rs.getInt("quantidade"));
                p.setPreco(rs.getFloat("preco"));                      
                
                // adiciona o objeto à lista
                produtos.add(p);            
            }
            rs.close();
            stmt.close();
            return produtos;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }     
    }

    @Override
    public Produto getByID(int id) {
        String sql = "SELECT * FROM produto WHERE idProduto = ?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                Produto p = new Produto();

                if (rs.next()) {
                    p.setIdProduto(rs.getInt("idProduto"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setQuantidade(rs.getInt("quantidade"));
                    p.setPreco(rs.getFloat("preco"));
                }
                stmt.close();
                return p;

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }      
}
