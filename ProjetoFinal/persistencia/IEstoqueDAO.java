/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import java.util.List;
import negocio.Estoque;

/**
 *
 * @author USUARIO
 */
public interface IEstoqueDAO {
    public void adiciona(Estoque estoque);
    public void altera(Estoque estoque);
    public void remove(int id);
    public List<Estoque> listarTodos();
    public Estoque getByID(int id);
}
