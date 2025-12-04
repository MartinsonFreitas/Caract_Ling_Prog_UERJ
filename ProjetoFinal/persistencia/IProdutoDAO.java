/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Produto;

/**
 *
 * @author USUARIO
 */
public interface IProdutoDAO {
    public void adiciona(Produto produto);
    public void altera(Produto produto);
    public void remove(int id);
    public List<Produto> listarTodos();
    public Produto getByID(int id);
    
}
