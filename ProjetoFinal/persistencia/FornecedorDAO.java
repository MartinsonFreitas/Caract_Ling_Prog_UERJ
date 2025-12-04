/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import negocio.Fornecedor;

/**
 *
 * @author USUARIO
 */
public class FornecedorDAO implements IFornecedorDAO{
    
    // abre a conexão com o banco de dados
    private final Connection connection;
    
    // construtor
    public FornecedorDAO(){
        this.connection = new ConFactory().getConnection();
    }
    
    // métodos
    @Override
    public void adiciona(Fornecedor fornecedor){
        String sql = "insert into fornecedor " +
                "(nome, telefone, email, cidade)" +
                "values (?,?,?,?)";
        
        try {
            // preparar comando para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // setando os atributos do objeto na cadeia sql
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getCidade());
            
            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);           
        }
    }

    @Override
    public void altera(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET nome=?, telefone=?, email=?, cidade=?, "+
                "WHERE idFornecedor=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());            
            stmt.setString(3, fornecedor.getEmail());
            stmt.setString(4, fornecedor.getCidade());
            stmt.setInt(5, fornecedor.getIdFornecedor()); // O ID é usado no WHERE

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            String sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para buscar por nome (filtro)
    public List<Fornecedor> buscarPorNome(String nome) {
        try {
            List<Fornecedor> lista = new ArrayList<>();
            // O "%" serve para buscar qualquer coisa que contenha o texto
            String sql = "SELECT * FROM fornecedor WHERE nome LIKE ?"; 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setIdFornecedor(rs.getInt("idFornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));                
                f.setEmail(rs.getString("email"));
                f.setCidade(rs.getString("cidade"));
                                
                lista.add(f);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Fornecedor> listarTodos() {
        try {
            List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from fornecedor");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                // criando o objeto Contto
                Fornecedor fornecedor = new Fornecedor();
                
                fornecedor.setIdFornecedor(rs.getInt("idFornecedor"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTelefone(rs.getString("telefone"));                
                fornecedor.setEmail(rs.getString("email"));
                fornecedor.setCidade(rs.getString("cidade"));
                
                // adiciona o objeto à lista
                fornecedores.add(fornecedor);            
            }
            rs.close();
            stmt.close();
            return fornecedores;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }        
    }

    @Override
    public Fornecedor getByID(int id) {
        String sql = "SELECT * FROM fornecedor WHERE idFornecedor = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Fornecedor f = new Fornecedor();

            if (rs.next()) {
                f.setIdFornecedor(rs.getInt("idFornecedor"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setEmail(rs.getString("email"));
                f.setCidade(rs.getString("cidade"));
                
            }
            stmt.close();
            return f;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
