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
import java.util.Calendar;
import java.util.List;
import negocio.Estoque;

/**
 *
 * @author USUARIO
 */
public class EstoqueDAO implements IEstoqueDAO{
    // abre a conexão com o banco de dados
    private final Connection connection;
    
    // construtor
    public EstoqueDAO(){
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Estoque estoque) {
        String sql = "insert into entradas_estoque" +
                "(idProduto, idFornecedor, idFuncionario, data, quantidade, custo_total)" +
                "values (?,?,?,?,?,?)";
        
        try {
            // preparar comando para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // setando os atributos do objeto na cadeia sql            
            stmt.setInt(1, estoque.getIdProduto());// chave estrangeira());            
            stmt.setInt(2, estoque.getIdFornecedor());
            stmt.setInt(3, estoque.getIdFuncionario());
            stmt.setDate(4, new Date(estoque.getData().getTimeInMillis()));
            stmt.setInt(5, estoque.getQuantidade());
            stmt.setFloat(6, estoque.getCusto_total());         
            
            // executa
            stmt.execute();
            stmt.close();
        }        
        catch (SQLException e){
            throw new RuntimeException(e);            
        }    
    }

    @Override
    public void altera(Estoque estoque) {
        // SQL para atualizar os dados
        String sql = "UPDATE entradas_estoque SET idProduto=?, idFornecedor=?, idFuncionario=?, " +
               "data=?, quantidade=?, custo_total=? WHERE idEntrada=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, estoque.getIdProduto());
            stmt.setInt(2, estoque.getIdFornecedor());
            stmt.setInt(3, estoque.getIdFuncionario());
            stmt.setDate(4, new Date(estoque.getData().getTimeInMillis()));
            stmt.setInt(5, estoque.getQuantidade());
            stmt.setFloat(6, estoque.getCusto_total());
            // O ID é fundamental para o WHERE
            stmt.setInt(7, estoque.getIdEstoque());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void remove(int id) {
        try {
            String sql = "DELETE FROM entradas_estoque WHERE idEntrada = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Estoque> listarTodos() {
        try {
            List<Estoque> estoque = new ArrayList<Estoque>();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from entradas_estoque");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                // Criando o objeto estoque                
                Estoque e = new Estoque();
                e.setIdEstoque(rs.getInt("idEntrada"));
                e.setIdProduto(rs.getInt("idProduto"));
                e.setIdFornecedor(rs.getInt("idFornecedor"));
                e.setIdFuncionario(rs.getInt("idFuncionario"));
                
                // montado a data através do Calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("data"));
                e.setData(data);
                
                //estoque.setData(rs.getDate("data"));
                e.setQuantidade(rs.getInt("quantidade"));
                e.setCusto_total(rs.getFloat("custo_total"));
                
                // adicionando o objeto à lista
                estoque.add(e);
            }
            rs.close();
            stmt.close();
            return estoque;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Estoque getByID(int id) {
        String sql = "SELECT * FROM entradas_estoque WHERE idEntrada = ?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();

                Estoque estoque = new Estoque();
                if (rs.next()) {
                    estoque.setIdEstoque(rs.getInt("idEntrada"));                   
                    estoque.setIdProduto(rs.getInt("idProduto"));
                    estoque.setIdFornecedor(rs.getInt("idFornecedor"));
                    estoque.setIdFuncionario(rs.getInt("idFuncionario"));

                    // montado a data através do Calendar
                    Calendar data = Calendar.getInstance();
                    data.setTime(rs.getDate("data"));
                    estoque.setData(data);
                    
                    estoque.setQuantidade(rs.getInt("quantidade"));
                    estoque.setCusto_total(rs.getFloat("custo_total"));
                }
                stmt.close();
                return estoque;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }    
    }
    
}
