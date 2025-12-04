/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Fornecedor;

/**
 *
 * @author USUARIO
 */
public interface IFornecedorDAO {
    public void adiciona(Fornecedor fornecedor);
    public void altera(Fornecedor fornecedor);
    public void remove(int id);
    public List<Fornecedor> listarTodos();
    public Fornecedor getByID(int id);
}
