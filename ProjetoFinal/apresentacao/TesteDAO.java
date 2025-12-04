/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package apresentacao; // Ajuste o pacote se necessário

import java.util.List;
import negocio.Fornecedor;
import persistencia.FornecedorDAO;

public class TesteDAO {
    public static void main(String[] args) {
        System.out.println("Iniciando teste de listagem...");

        try {
            // 1. Tenta usar o DAO para buscar os dados
            FornecedorDAO dao = new FornecedorDAO();
            List<Fornecedor> lista = dao.listarTodos();

            // 2. Verifica o resultado
            if (lista.isEmpty()) {
                System.out.println("SUCESSO NA CONEXÃO, mas a tabela está VAZIA.");
                System.out.println("Aviso: Insira dados no banco para ver algo na tela.");
            } else {
                System.out.println("SUCESSO! Encontrei " + lista.size() + " fornecedor:");
                for (Fornecedor f : lista) {
                    System.out.println(" - " + f.getNome() + " (Telefone: " + f.getTelefone()+ ")");
                }
            }
        } catch (Exception e) {
            System.out.println("ERRO GRAVE:");
            e.printStackTrace();
        }
    }
}