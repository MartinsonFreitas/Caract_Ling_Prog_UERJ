/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import negocio.Funcionario;

/**
 *
 * @author USUARIO
 */
public class FuncionarioDAO implements IFuncionarioDAO{
    // abre a conexão com o banco de dados
    private final Connection connection;
    
    // construtor
    public FuncionarioDAO(){
        this.connection = new ConFactory().getConnection();
    }

    @Override
    public void adiciona(Funcionario funcionario) {
        String sql = "insert into funcionario" +
                "(nome, usuario, senha)" +
                "values (?,?,?)";
        
        try {
            // preparar comando para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // setando os atributos do objeto na cadeia sql
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            
            // executa
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e){
            throw new RuntimeException(e);            
        }    
    }

    @Override
    public void altera(Funcionario funcionario) {
        // SQL para atualizar os dados
        String sql = "UPDATE funcionario SET nome=?, usuario=?, senha=? WHERE idFuncionario=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            
            // O ID é fundamental para o WHERE
            stmt.setInt(4, funcionario.getIdFuncionario());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(int id) {
        try {
            String sql = "DELETE FROM funcionario WHERE idFuncionario = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Funcionario> listarTodos() {
        try {
            List<Funcionario> funcionarios = new ArrayList<Funcionario>();
            PreparedStatement stmt = this.connection.prepareStatement("Select * from funcionario");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                // Criando o objeto funcionario
                //Psicologo funcionario = new Psicologo();
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));
                
                // adicionando o objeto à lista
                funcionarios.add(funcionario);
            }
            rs.close();
            stmt.close();
            return funcionarios;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
       
    @Override
    public Funcionario getByID(int id) {
        String sql = "SELECT * FROM funcionario WHERE idFuncionario = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Funcionario p = new Funcionario();
            if (rs.next()) {
                p.setIdFuncionario(rs.getInt("idFuncionario"));
                p.setNome(rs.getString("nome"));
                p.setUsuario(rs.getString("usuario"));
                p.setSenha(rs.getString("senha"));
            }
            stmt.close();
            return p;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método novo para validar Login (Item d da lista)
    public boolean autenticar(String usuario, String senha) {
        String sql = "SELECT * FROM funcionario WHERE usuario=? AND senha=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            // Se rs.next() for true, encontrou alguém com esse login e senha
            boolean logado = rs.next();
            
            rs.close();
            stmt.close();            
            return logado;
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Método para buscar por nome (filtro)
    public List<Funcionario> buscarPorNome(String nome) {
        try {
            List<Funcionario> lista = new ArrayList<>();
            String sql = "SELECT * FROM funcionario WHERE nome LIKE ?"; 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario p = new Funcionario();
                p.setIdFuncionario(rs.getInt("idFuncionario"));
                p.setNome(rs.getString("nome"));
                p.setUsuario(rs.getString("usuario"));
                p.setSenha(rs.getString("senha"));
                
                lista.add(p);
            }
            return lista;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }        
}
